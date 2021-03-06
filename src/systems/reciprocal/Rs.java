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

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

/**
 * Rs class is a container for many things used in the system, such as
 * configuration, locale, timezone, and database connectivity. This is a static
 * class designed for use with applications.
 *
 * @author Bruce Peret
 */
public class Rs {

    public static final String CONFIGFILE = "configuration.ini";
    /**
     * Larson's Inter-Regional Ratio (electric, 1D)
     */
    public static final double IRR1D = 128. * (1 + 1. / 9.);
    /**
     * Larson's Inter-Regional Ratio (magnetic, 2D)
     */
    public static final double IRR = 128 * (1. + 2. / 9.);
    /**
     * Limit to atomic numbers.
     */
    public static final int Z_LIMIT = 118;
    /**
     * Mass limit.
     */
    public static final int MASS_LIMIT = Z_LIMIT * 2;

    public static Properties config;
    public static Locale locale;
    public static TimeZone timezone;

    /**
     * Manufacture the basic setup used for RS applications.
     *
     * @throws IOException
     * @throws SQLException
     */
    public static void factory() throws IOException, SQLException {
        /*
        * Load and parse configuration.ini
         */
        config = new Properties();
        config.load(
            new FileReader(
                System.getProperty("user.dir") + "/" + CONFIGFILE
            )
        );
        /*
        * Set up Locale language and region
         */
        locale = new Locale(
            config.getProperty("language", "en"),
            config.getProperty("region", "US")
        );
        /*
        * Define time zone
         */
        timezone = TimeZone.getTimeZone(
            config.getProperty("timezone", "UTC")
        );
        /*
        * Connect to the model database
         */

        String uri = "jdbc:postgresql:";
        String host = config.getProperty("host");
        if (host != null) {
            uri += "//" + host + ":" + config.getProperty("port", "5432") + "/";
        }
        uri += config.getProperty("database", "rsrs");
        Database.connect(
            uri,
            config.getProperty("user", "username"),
            config.getProperty("password", "password")
        );
    }

    /**
     * Calculate the standard atomic mass for an element and ionization level.
     *
     * @param z Atomic number.
     * @param ion Magnetic ionization level.
     * @return Standard atomic mass in u.
     */
    public static double standard_mass(int z, int ion) {
        return 2. * z + ion * z * z / IRR;
    }

    /**
     * Determine the first unstable element given a magnetic ionization level.
     *
     * @param magnetic_ionization_level The magnetic ionization level.
     * @return Atomic number.
     */
    public static int unstable_element(int magnetic_ionization_level) {
        if (magnetic_ionization_level < 1) {
            return Z_LIMIT;
        } else {
            return (int) Math.ceil(Math.sqrt(Z_LIMIT * 2 * IRR / magnetic_ionization_level
                    + (IRR * IRR) / (magnetic_ionization_level * magnetic_ionization_level)
                )
                - IRR / magnetic_ionization_level
            );
        }
    }
}
