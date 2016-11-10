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
 * Tuple Transformation Matrix. Normally used with coordinate locations. Not
 * precluding rotational functions.
 *
 * @author Bruce Peret
 */
public class Transform {

    /**
     * Transformation matrix as xform[col][row]. This way Tuples can be used as
     * columns, like a normal transform.
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

    public Transform set(double... v) {
        int r=0;
        int c=0;
        for(int i=0; i<v.length; i++) {
            this.xform[c][r] = v[i];
            if (++c >= this.xform[0].length) {
                c=0;
                r++;
            }
        }
        return this;
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
        return t;
    }

    public Transform translate(Tuple v) {
        Transform t = new Transform(xform.length);
        for(int i=0; i<xform.length; i++) {
            t.xform[0][i] = v.e[i];
        }
        return this.multiply(t);
    }

    /**
     * Return an identity matrix.
     *
     * @return
     */
    public Transform identity() {
        return scale(1.0);
    }

    /**
     * Multiply two transformation matrices.
     *
     * @param t Matrix to multiply by.
     * @return Product of matrices.
     */
    public Transform multiply(Transform t) {
        Transform product = new Transform(xform.length,0);
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
     * Multiple a transformation by a Tuple.
     * Tuple is assumed to be one column of n rows.
     *
     * @param t Tuple to send through transform.
     * @return Transformed Tuple.
     */
    public Tuple multiply(Tuple t) {
        Tuple product = new Tuple(t.e.length);
        for (int i = 0; i < xform.length; i++) {
            for (int k = 0; k < t.e.length; k++) {
                product.e[i] += xform[k][i] * t.e[k];
            }
        }
        return product;
    }

}
