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
package systems.reciprocal.db.astronomy;

import systems.reciprocal.db.Astronomy;

/**
 * Reference material on constellations.
 *
 * @author Bruce Peret
 */
public class Constellation extends Astronomy {

    public static final String TABLE = "astronomy.constellation";
    /**
     * IAC abbreviation for constellation.
     */
    String abbr;
    /**
     * Name of constellation.
     */
    String name;
    /**
     * Genitive name.
     */
    String genitive;
    /**
     * Pronunciation key.
     */
    String pronunciation;
    /**
     * Meaning of constellation name.
     */
    String meaning;
    /**
     * Solid Angle of region covered by constellation, in millisteradians.
     */
    double solid_angle;
    /**
     * Percentage of sky occupied by constellation.
     */
    double percentage;
    /**
     * Historical description of constellation.
     */
    String description;
    /**
     * Hemisphere located in (N or S).
     */
    String hemisphere;
    /**
     * Quadrant located in (1-4, 6h increments).
     */
    int quadrant;
    /**
     * Right ascension to center of constellation, decimal degrees.
     */
    double right_ascension;
    /**
     * Declination to center of constellation, decimal degrees.
     */
    double declination;
}
