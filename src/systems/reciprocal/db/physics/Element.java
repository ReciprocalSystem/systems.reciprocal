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
public class Element extends Physics {

    public static final String TABLE = SCHEMA + ".element";
    /**
     * Name of Element.
     */
    public String name;
    /**
     * Symbol for Element.
     */
    public String symbol;
    /**
     * Atomic number.
     */
    public int z;
    /**
     * Relative atomic mass.
     */
    public double mass;
    /**
     * Density.
     */
    public double density;
    /**
     * Conditions determining density.
     */
    public String density_condition;
    /**
     * Melting point.
     */
    public double melting_point;
    /**
     * Boiling point.
     */
    public double boiling_point;
    /**
     * Atomic radius.
     */
    public double atomic_radius;
    /**
     * Covalent radius.
     */
    public double covalent_radius;
    /**
     * Specific volume.
     */
    public double specific_volume;
    /**
     * Specific heat.
     */
    public double specific_heat;
    /**
     * Bond condition for specific heat.
     */
    public String specific_heat_bond;
    /**
     * Heat of fusion.
     */
    public double heat_fusion;
    /**
     * Bond condition for heat of fusion.
     */
    public String heat_fusion_bond;
    /**
     * Heat of evaporation.
     */
    public double heat_evaporation;
    /**
     * Bond condition for heat of evaporation.
     */
    public String heat_evaporation_bond;
    /**
     * Thermal conductivity.
     */
    public double thermal_conductivity;
    /**
     * Pauling electronegativity.
     */
    public double pauling_electronegativity;
    /**
     * First ionization energy.
     */
    public double first_ionization_energy;
    /**
     * Known Oxidation states.
     */
    public Integer[] oxidation_state;
    /**
     * Electronic configuration (triples, in hexadecimal).
     */
    public String electronic_configuration;
    /**
     * Crystal lattice.
     */
    public String lattice;
    /**
     * Lattice constant.
     */
    public double lattice_constant;
    /**
     * Reciprocal System displacements.
     */
    public Integer[] displacement;
    /**
     * Electronic configuration base Element atomic number.
     */
    public int ec_base;
    /**
     * RS displacements, positive electric.
     */
    public Integer[] abcp;
    /**
     * RS displacements, negative electric.
     */
    public Integer[] abcn;
    /**
     * Number of electrons in outer s orbital.
     */
    public Integer[] s;
    /**
     * Number of electrons in outer p orbital.
     */
    public Integer[] p;
    /**
     * Number of electrons in outer d orbital.
     */
    public Integer[] d;
    /**
     * Number of electrons in outer f orbital.
     */
    public Integer[] f;
    /**
     * Magnetic orientation.
     */
    public String magnetic;
    /**
     * Critical temperature.
     */
    public double critical_temperature;
    /**
     * Critical pressure.
     */
    public double critical_pressure;
}
