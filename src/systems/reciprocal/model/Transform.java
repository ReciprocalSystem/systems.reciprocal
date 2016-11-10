/*
 * Copyright (C) 2016 Bruce Peret
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package systems.reciprocal.model;

import java.util.Arrays;

/**
 * Transformation matrix operations.
 *
 * The coordinate system is assumed to be X to the right, Y up and Z going into
 * the screen (Standard computer graphics convention). Rotation is by the
 * right-hand rule. The X axis is coincident with the "real" axis for rotational
 * operators, I is the vertical plane, J is orthogonal to the real axis and K is
 * the horizontal plane.
 *
 * @author Bruce Peret
 */
public class Transform {

    /**
     * Rotational Axis vectors
     */
    public static final Tuple I = new Tuple(1, 0, 0, Math.PI/2);
    public static final Tuple J = new Tuple(1, Math.PI/2, 0, 0);
    public static final Tuple K = new Tuple(1, 0, Math.PI/2, 0);
    /**
     * Translational Axis vectors
     */
    public static final Tuple X = new Tuple(1, 1, 0, 0);
    public static final Tuple Y = new Tuple(1, 0, 1, 0);
    public static final Tuple Z = new Tuple(1, 0, 0, 1);
    /**
     * Transformation matrix as xform[row][col]. Java stores row-wise, so
     * contiguous elements are a vertical column. Tuples are treated as column
     * vectors.
     */
    public double[][] xform;

    /**
     * Construct a new identity Transformation Matrix.
     *
     * @param n The dimensions (rows and columns) of the matrix.
     * @param scale The scale to set the matrix to.
     */
    public Transform(int n, double scale) {
        xform = new double[n][n];
        for (int i = 0; i < xform.length; i++) {
            Arrays.fill(xform[i], 0);
            xform[i][i] = scale;
        }
    }

    /**
     * Default to a 3D transformation matrix.
     */
    public Transform() {
        this(4, 1);
    }

    /**
     * Identity matrix of any dimension.
     *
     * @param n The dimension of the matrix.
     */
    public Transform(int n) {
        this(n, 1);
    }

    /**
     * Convert the matrix to a textual representation.
     *
     * @return Textual representation of matrix.
     */
    @Override
    public String toString() {
        String r = "";
        for (int row = 0; row < xform.length; row++) {
            String rtext = "";
            for (double[] xform1 : xform) {
                rtext += "," + xform1[row];
            }
            r += rtext.substring(1) + "\n";
        }
        return r;
    }

    /**
     * Return a scaling matrix with the same scale in all dimensions.
     *
     * @param s Scale factor
     * @return Identity Transformation matrix.
     */
    public Transform scale(double s) {
        Transform t = new Transform(this.xform.length, s);
        return this.multiply(t);
    }

    /**
     * Scale each axis independently via a Tuple.
     *
     * @param v The Vector containing the scales for each axis.
     * @return Scaling transformation matrix.
     */
    public Transform scale(Tuple v) {
        Transform t = new Transform(v.e.length);
        for (int i = 0; i < v.e.length; i++) {
            t.xform[i][i] = v.e[i];
        }
        return this.multiply(t);
    }

    /**
     * Add a translation to the transformation by Tuple.
     *
     * @param v Tuple containing translation vector.
     * @return Updated transformation.
     */
    public Transform translate(Tuple v) {
        Transform t = new Transform(xform.length);
        System.arraycopy(v.e, 0, t.xform[0], 0, xform.length);
        return this.multiply(t);
    }

    /**
     * Add a translation to the transformation by array of doubles.
     *
     * @param v List or array of doubles.
     * @return Updated transformation.
     */
    public Transform translate(double... v) {
        return translate(new Tuple(v));
    }

    /**
     * Add a rotation transformation. Only works in 4D.
     *
     * None of these rotations can rotate about the projective plane, the "real"
     * axis (the first element of a tuple), so skip that possibility. Octonian
     * rotation is not yet supported.
     *
     * @param v Tuple defining rotation for various axes.
     * @return Updated transformation.
     */
    public Transform rotate(Tuple v) {
        switch (v.e.length) {
            /*
             * 1D rotation does not exist, but is not invalid.
             */
            case 1:
                break;
            /*
             * 2D rotation is just a cosine wave. 
             */
            case 2:
                if (v.e[1] != 0) {  // Don't do unnecessary work
                    Transform t = new Transform(v.e.length);
                    t.xform[1][1] = Math.cos(v.e[1]);
                    this.multiply(t);
                }
                break;
            /*
             * 4D rotation cannot rotate about projective plane,
             * so only run rotation from 1-3 (x,y,z).
             */
            case 4:
                int[][] loc = {{0, 0}, {3, 2}, {1, 3}, {2, 1}};
                for (int axis = 1; axis < v.e.length; axis++) {
                    if (v.e[axis] != 0) {
                        Transform t = new Transform(v.e.length);
                        t.xform[loc[axis][0]][loc[axis][0]] = Math.cos(v.e[axis]);
                        t.xform[loc[axis][1]][loc[axis][1]] = Math.cos(v.e[axis]);
                        t.xform[loc[axis][0]][loc[axis][1]] = Math.sin(v.e[axis]);
                        t.xform[loc[axis][1]][loc[axis][0]] = -Math.sin(v.e[axis]);
                        this.multiply(t);
                    }
                }
                break;
            default:
                throw new Error("Unsupported dimensions for rotation.");
        }
        return this;
    }

    /**
     * Multiply two transformation matrices.
     *
     * @param t Matrix to multiply by.
     * @return Product of matrices.
     */
    public Transform multiply(Transform t) {
        Transform product = new Transform(xform.length, 0);
        for (int i = 0; i < xform.length; i++) {
            for (int j = 0; j < t.xform.length; j++) {
                for (int k = 0; k < xform.length; k++) {
                    product.xform[i][j] += xform[i][k] * t.xform[k][j];
                }
            }
        }
        this.xform = product.xform;
        return this;
    }

    /**
     * Multiple a transformation by a Tuple. Tuple is assumed to be one column
     * of n rows.
     *
     * @param t Tuple to send through execute.
     * @return Transformed Tuple.
     */
    public Tuple execute(Tuple t) {
        Tuple product = new Tuple(t.e.length);
        for (int i = 0; i < xform.length; i++) {
            for (int k = 0; k < t.e.length; k++) {
                product.e[i] += xform[k][i] * t.e[k];
            }
        }
        return product;
    }

}
