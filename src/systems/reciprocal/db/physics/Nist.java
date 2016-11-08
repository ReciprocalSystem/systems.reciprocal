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
 * NIST Physical Measurements laboratory, Atomic Weights and Isotopic
 * Compositions with Relative Atomic Masses.
 *
 * https://www.nist.gov/pml/atomic-weights-and-isotopic-compositions-relative-atomic-masses
 *
 * @author Bruce Peret
 */
public class Nist extends Physics {

    public static final String TABLE = "physics.nist";
    /**
     * Atomic number.
     */
    int z;
    /**
     * Atomic symbol.
     */
    String symbol;
    /**
     * Isotope number.
     */
    int isotope;
    /**
     * Relative Atomic Mass (of the isotope): A_r(X), where X is an isotope
     * [formerly called atomic weight; see Standard Atomic Weight below)]
     *
     * These values are scaled to A_r(12C) = 12, where 12C is a neutral atom in
     * its nuclear and electronic ground state. Thus, the relative atomic mass
     * of entity X is given by: A_r(X) = m(X) / [m(12C) / 12. If # is present,
     * the value and error were derived not from purely experimental data, but
     * at least partly from systematic trends.
     */
    double relative_atomic_mass;
    /**
     * Uncertainty in the relative atomic mass.
     */
    double relative_atomic_mass_uncertainty;
    /**
     * In the opinion of the Subcommittee for Isotopic Abundance Measurements
     * (SIAM), these values represent the isotopic composition of the chemicals
     * and/or materials most commonly encountered in the laboratory. They may
     * not, therefore, correspond to the most abundant natural material. The
     * uncertainties listed in parenthesis cover the range of probable
     * variations of the materials as well as experimental errors. These values
     * are consistent with the values published in Isotopic Compositions of the
     * Elements 2009.
     */
    double isotopic_composition;
    /**
     * Uncertainty in the isotopic composition.
     */
    double isotopic_composition_uncertainty;
    /**
     * Standard Atomic Weight (common usage): A_r(X), where X is an element
     * [more appropriately called relative atomic mass of the element]
     *
     * The relative atomic mass of an element is derived by averaging the
     * relative atomic masses of the isotopes of that element. These values are
     * scaled to A_r(12C) = 12, where 12C is a neutral atom in its nuclear and
     * electronic ground state. These values are dependent on the origin and
     * treatment of the material.
     */
    double standard_atomic_weight;
    /**
     * Uncertainty in standard atomic weight.
     */
    double standard_atomic_weight_uncertainty;
    /**
     * g Geological materials are known in which the element has an isotopic
     * composition outside the limits for normal material. The difference
     * between the atomic weight of the element in such materials and that given
     * in the table may exceed the stated uncertainty.
     *
     * m Modified isotopic compositions may be found in commercially available
     * material because the material has been subjected to an undisclosed or
     * inadvertent isotopic fractionation. Substantial deviations in atomic
     * weight of the element from that given in the table can occur.
     *
     * r Range in isotopic composition of normal terrestrial material prevents a
     * more precise standard atomic weight being given; the tabulated
     * atomic-weight value and uncertainty should be applicable to normal
     * materials.
     */
    String notes;
}
