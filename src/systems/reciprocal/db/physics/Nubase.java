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
 *
 * @author Bruce Peret
 */
public class Nubase extends Physics {

    public static final String TABLE = SCHEMA + ".nubase";

    /**
     * Atomic mass number (protons + neutrons)
     */
    public int a;
    /**
     * Atomic number
     */
    public int z;
    /**
     * Atomic number modifier?
     */
    public int x1;
    /**
     * Code
     */
    public String x2;
    /**
     * Nuclide Symbol
     */
    public String symbol;
    /**
     * State
     */
    public String state;
    /**
     * Mass excess
     */
    public double mass_excess;
    /**
     * Mass excess uncertainty
     */
    public double mass_excess_uncertainty;
    /**
     * Excitation energy
     */
    public double excitation_energy;
    /**
     * Excitation energy uncertainty
     */
    public double excitation_energy_uncertainty;
    /**
     * Origin Code
     */
    public String origin_code;
    /**
     * Half-life (seconds)
     */
    public double half_life;
    /**
     * Production ratio
     */
    public double production_ratio;
    /**
     * Spin
     */
    public String spin;
    /**
     * Unknown
     */
    public String x3;
    /**
     * Unknown
     */
    public String x4;
    /**
     * Year of discovery
     */
    public int year;
    /**
     * Decay modes (uninterpreted)
     */
    public String decay_modes;
}
