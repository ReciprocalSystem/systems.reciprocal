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

    /**
     * Constructor to create an Isotope instance from a DB ResultSet.
     *
     * @param rs ResultSet containing row of isotope data.
     * @throws SQLException
     */
    public Nubase(ResultSet rs) throws SQLException {
        a = rs.getInt("a");
        z = rs.getInt("z");
        x1 = rs.getInt("x1");
        x2 = rs.getString("x2"); 
        symbol = rs.getString("symbol");
        state = rs.getString("state");
        mass_excess = rs.getDouble("mass_excess");
        mass_excess_uncertainty = rs.getDouble("mass_excess_uncertainty");
        excitation_energy = rs.getDouble("excitation_energy");
        excitation_energy_uncertainty = rs.getDouble("excitation_energy_uncertainty");
        origin_code = rs.getString("origin_code");
        half_life = rs.getDouble("half_life");
        production_ratio = rs.getDouble("production_ratio");
        spin = rs.getString("spin");
        x3 = rs.getString("x3");
        x4 = rs.getString("x4");
        year = rs.getInt("year");
        decay_modes = rs.getString("decay_modes");
    }

    /**
     * Display "(n,p)Symbol" for class string.
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + a + "," + z + ")" + symbol;
    }
    
    /**
     * Retrieve an ArrayList of Isotope instances based on an SQL query.
     *
     * @param ps Query with parameters resolved.
     * @return ArrayList of Isotope instances.
     * @throws SQLException
     */
    public static ArrayList<Nubase> query(PreparedStatement ps) throws SQLException {
        ArrayList<Nubase> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Nubase(rs));
            }
        }
        return result;
    }
}
