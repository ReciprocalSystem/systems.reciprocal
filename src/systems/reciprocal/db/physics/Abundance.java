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
package systems.reciprocal.db.physics;

import systems.reciprocal.db.Physics;

/**
 * Abundance of elements in the crust, sea water, sun and solar system. In kg/kg
 * or kg/L for water.
 *
 * @author Bruce Peret
 */
public class Abundance extends Physics {

    public static final String TABLE = SCHEMA + ".abundance";
    /**
     * Atomic number
     */
    int z;
    /**
     * Crust: CRC Handbook.
     */
    double crust_crc;
    /**
     * Crust: Kaye & Laby.
     */
    double crust_kl;
    /**
     * Crust: Greenwood.
     */
    double crust_g;
    /**
     * Crust: Ahrens (Taylor).
     */
    double crust_at;
    /**
     * Crust: Ahrens (Wanke).
     */
    double crust_awa;
    /**
     * Crust: Ahrens (Weaver).
     */
    double crust_awe;
    /**
     * Upper crust: Ahrens (Taylor).
     */
    double upper_crust_at;
    /**
     * Upper crust: Ahrens (Shaw).
     */
    double upper_crust_as;
    /**
     * Sea water: CRC Handbook.
     */
    double sea_crc;
    /**
     * Sea water: Kaye & Laby.
     */
    double sea_kl;
    /**
     * Sun: Kaye & Laby.
     */
    double sun_kl;
    /**
     * Solar System: Kaye & Laby.
     */
    double solar_system_kl;
    /**
     * Solar System: Ahrens.
     */
    double solar_system_a;
}
