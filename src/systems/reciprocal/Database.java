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
package systems.reciprocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Functions common to all database activity.
 *
 * The physical database connection is from the parent Rs class.
 *
 * @author Bruce Peret
 */
public class Database extends Rs {

    /**
     * Database connection
     */
    public static Connection db;

    public static void connect(String uri, String user, String password) throws SQLException {
        db = DriverManager.getConnection(uri, user, password);
    }

    /**
     * Retrieve the last serial key insert value for a prepared statement.
     *
     * @param ps Prepared statement
     * @return The integer serial number, or zero.
     * @throws SQLException
     */
    public static int lastkey(PreparedStatement ps) throws SQLException {
        int key = 0;
        ResultSet rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            key = rs.getInt(1);
        }
        return key;
    }
}
