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
    String name;
    /**
     * Symbol for Element.
     */
    String symbol;
    /**
     * Atomic number.
     */
    int z;
    /**
     * Relative atomic mass.
     */
    double mass;
    /**
     * Density.
     */
    double density;
    /**
     * Conditions determining density.
     */
    String density_condition;
    /**
     * Melting point.
     */
    double melting_point;
    /**
     * Boiling point.
     */
    double boiling_point;
    /**
     * Atomic radius.
     */
    double atomic_radius;
    /**
     * Covalent radius.
     */
    double covalent_radius;
    /**
     * Specific volume.
     */
    double specific_volume;
    /**
     * Specific heat.
     */
    double specific_heat;
    /**
     * Bond condition for specific heat.
     */
    String specific_heat_bond;
    /**
     * Heat of fusion.
     */
    double heat_fusion;
    /**
     * Bond condition for heat of fusion.
     */
    String heat_fusion_bond;
    /**
     * Heat of evaporation.
     */
    double heat_evaporation;
    /**
     * Bond condition for heat of evaporation.
     */
    String heat_evaporation_bond;
    /**
     * Thermal conductivity.
     */
    double thermal_conductivity;
    /**
     * Pauling electronegativity.
     */
    double pauling_electronegativity;
    /**
     * First ionization energy.
     */
    double first_ionization_energy;
    /**
     * Known Oxidation states.
     */
    Integer[] oxidation_state;
    /**
     * Electronic configuration (triples, in hexadecimal).
     */
    String electronic_configuration;
    /**
     * Crystal lattice.
     */
    String lattice;
    /**
     * Lattice constant.
     */
    double lattice_constant;
    /**
     * Reciprocal System displacements.
     */
    Integer[] displacement;
    /**
     * Electronic configuration base Element atomic number.
     */
    int ec_base;
    /**
     * RS displacements, positive electric.
     */
    Integer[] abcp;
    /**
     * RS displacements, negative electric.
     */
    Integer[] abcn;
    /**
     * Number of electrons in outer s orbital.
     */
    Integer[] s;
    /**
     * Number of electrons in outer p orbital.
     */
    Integer[] p;
    /**
     * Number of electrons in outer d orbital.
     */
    Integer[] d;
    /**
     * Number of electrons in outer f orbital.
     */
    Integer[] f;
    /**
     * Magnetic orientation.
     */
    String magnetic;
    /**
     * Critical temperature.
     */
    double critical_temperature;
    /**
     * Critical pressure.
     */
    double critical_pressure;
}
