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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;
import systems.reciprocal.db.Physics;

/**
 * NIST Physical Measurements laboratory, Atomic Weights and Isotopic
 * Compositions with Relative Atomic Masses.
 *
 * https://www.nist.gov/pml/atomic-weights-and-isotopic-compositions-relative-atomic-masses
 *
 * @author Bruce Peret
 */
public class Isotope extends Physics {

    public static final String TABLE = SCHEMA + ".isotope";
    /**
     * Atomic number.
     */
    public int z;
    /**
     * Atomic symbol.
     */
    public String symbol;
    /**
     * Isotope number.
     */
    public int isotope;
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
    public double relative_atomic_mass;
    /**
     * Uncertainty in the relative atomic mass.
     */
    public double relative_atomic_mass_uncertainty;
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
    public double isotopic_composition;
    /**
     * Uncertainty in the isotopic composition.
     */
    public double isotopic_composition_uncertainty;
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
    public double standard_atomic_weight;
    /**
     * Uncertainty in standard atomic weight.
     */
    public double standard_atomic_weight_uncertainty;
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
    public String notes;
    // The data here has been added to the NIST data table
    /**
     * Abundance of isotope in decimal percent (0.00-1.00).
     */
    public double abundance;

    /**
     * Constructor to create an Isotope instance from a DB ResultSet.
     *
     * @param rs ResultSet containing row of isotope data.
     * @throws SQLException
     */
    public Isotope(ResultSet rs) throws SQLException {
        z = rs.getInt("z");
        symbol = rs.getString("symbol");
        isotope = rs.getInt("isotope");
        relative_atomic_mass = rs.getDouble("relative_atomic_mass");
        relative_atomic_mass_uncertainty = rs.getDouble("relative_atomic_mass_uncertainty");
        isotopic_composition = rs.getDouble("isotopic_composition");
        isotopic_composition_uncertainty = rs.getDouble("isotopic_composition_uncertainty");
        standard_atomic_weight = rs.getDouble("standard_atomic_weight");
        standard_atomic_weight_uncertainty = rs.getDouble("standard_atomic_weight_uncertainty");
        notes = rs.getString("notes");
        abundance = rs.getDouble("abundance");
    }

    /**
     * Display "(n,p)Symbol" for class string.
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + isotope + "," + z + ")" + symbol;
    }

    /**
     * Get a single isotope from the database.
     *
     * @param z Atomic number.
     * @param n Isotope number.
     * @return Isotope or null if combination not found.
     * @throws SQLException
     */
    public static Isotope get(int z, int n) throws SQLException {
        Isotope i = null;
        PreparedStatement ps = db.prepareStatement(
            "SELECT * FROM " + TABLE + " WHERE z=? AND isotope=?"
        );
        ps.setInt(1, z);
        ps.setInt(2, n);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                i = new Isotope(rs);
            }
        }
        return i;
    }

    /**
     * Retrieve an ArrayList of Isotope instances based on an SQL query.
     *
     * @param ps Query with parameters resolved.
     * @return ArrayList of Isotope instances.
     * @throws SQLException
     */
    public static ArrayList<Isotope> query(PreparedStatement ps) throws SQLException {
        ArrayList<Isotope> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Isotope(rs));
            }
        }
        return result;
    }

}
