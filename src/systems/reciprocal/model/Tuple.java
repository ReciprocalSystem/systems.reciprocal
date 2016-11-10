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

/**
 * Generic handling of a multidimensional tuple (vector).
 *
 * Using "tuple" from database concepts to avoid confusion with graphic vectors
 * and matrices, which express things differently. The tuple can be used for:
 * real, complex, quaternion or octonian rotations, or as homogeneous
 * coordinates in the form [w x y z] (not [x y z w]), which is the proper way to
 * express the vector.
 *
 * @author Bruce Peret
 */
public class Tuple {

    /**
     * The magnitudes of each element in the tuple.
     */
    double[] e;

    /**
     * Empty constructor creates a 1-dimensional unit tuple.
     */
    public Tuple() {
        this(1);
    }

    /**
     * Constructor to create an n-dimensional tuple.
     *
     * @param n The number of dimensions in the tuple.
     */
    public Tuple(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 4 || n == 8) {
            e = new double[n];
        } else {
            throw new Error("Unsupported tuple length: " + n);
        }
    }

    /**
     * Constructor from an argument list of coordinates or double array.
     *
     * @param c List of magnitudes for each e, or array of doubles.
     */
    public Tuple(double... c) {
        this(c.length);
        System.arraycopy(c, 0, e, 0, c.length);
    }

    /**
     * Copy constructor from another Vector.
     *
     * @param v The tuple to copy.
     */
    public Tuple(Tuple v) {
        this(v.e.length);
        System.arraycopy(v.e, 0, e, 0, v.e.length);
    }

    /**
     * Internal command to format the Tuple as a String.
     *
     * @return Tuple formatted as {@code <#,...>}
     */
    @Override
    public String toString() {
        if (e.length == 0) {
            return "<>";
        } else {
            String r = "";
            for (double x : e) {
                r = r.concat(String.format(",%.3f", x));
            }
            return "<" + r.substring(1).concat(">");
        }
    }

    /**
     * Set the values of a Aspect by a list of doubles, safely.
     *
     * @param values A list of double values to set the Aspect tuple to.
     * @return this;
     */
    public Tuple set(double... values) {
        System.arraycopy(values, 0, e, 0, Math.min(e.length, values.length));
        return this;
    }

    /**
     * Set the values of this instance from another Tuple. Only the minimum
     * length is copied. If the v tuple is smaller than the existing tuple, the
     * remaining values will be unchanged. If larger, they extra will be
     * dropped.
     *
     * @param v The tuple to copy.
     * @return
     */
    public Tuple set(Tuple v) {
        System.arraycopy(v.e, 0, e, 0, Math.min(e.length, v.e.length));
        return this;
    }

    /**
     * Return a Normalized the tuple to a scaled length.
     *
     * @param scale The length to normalize to.
     * @return Normalized tuple
     */
    public Tuple normalize(double scale) {
        Tuple v = new Tuple(this);
        double len = length();
        for (int i = 0; i < v.e.length; i++) {
            v.e[i] /= len / scale;
        }
        return v;
    }

    /**
     * Normalize the tuple to unit length.
     *
     * @return this
     */
    public Tuple normalize() {
        return normalize(1.0);
    }

    /**
     * Project the tuple onto the specific W plane.
     *
     * @param w The numerical value of the projective plane.
     * @return The projected tuple.
     */
    public Tuple project(double w) {
        Tuple v = new Tuple(this);
        for (int i = 1; i < v.e.length; i++) {
            v.e[i] /= v.e[0] / w;
        }
        v.e[0] = w;
        return v;
    }

    /**
     * Project the Aspect tuple onto the unit plane (unitize).
     *
     * @return The tuple projected onto the unit plane.
     */
    public Tuple project() {
        return project(1.0);
    }

    /**
     * Return the square of the tuple length.
     *
     * @return Tuple length squared
     */
    public double length2() {
        double sum = 0;
        for (double x : e) {
            sum += x * x;
        }
        return sum;
    }

    /**
     * Return the length of the tuple
     *
     * @return Tuple length
     */
    public double length() {
        return Math.sqrt(length2());
    }

    /**
     * Return an identity tuple [1, 0, ...]
     *
     * @return Identity tuple.
     */
    public Tuple identity() {
        Tuple id = new Tuple(this.e.length);
        id.e[0] = 1;
        return id;
    }
}
