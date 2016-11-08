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

/**
 * Zodiac signs and their attributes.
 *
 * @author Bruce Peret
 */
public class Zodiac {

    public static final String TABLE = "astronomy.zodiac";
    /**
     * IAC abbreviation for constellation (references constellation).
     */
    String abbr;
    /**
     * Numerical order of sign.
     */
    int number;
    /**
     * UTF-8 symbol of sign.
     */
    String symbol;
    /**
     * Longitude in degrees.
     */
    int longitude;
    /**
     * Interval from start of year to start of sign.
     */
    String begins;
    /**
     * Interval of duration in days of sign.
     */
    String duration;
    /**
     * Zodiac sign element (Fire, Water, Earth, Air).
     */
    String element;
    /**
     * Zodiac sign season (Spring, Summer, Autumn, Winter).
     */
    String season;
    /**
     * Zodiac sign mobility (Cardinal, Fixed, Mutable).
     */
    String mobility;
}
