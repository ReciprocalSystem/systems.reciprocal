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

import systems.reciprocal.db.Astronomy;

/**
 * Hygv3 stellar data, imported from the GitHub HYG-Database
 * https://github.com/astronexus/HYG-Database
 *
 * @author Bruce Peret
 */
public class Hygv3 extends Astronomy {

    public static final String TABLE = "astronomy.hygv3";

    /**
     * Database primary key.
     */
    int id;
    /**
     * The star's ID in the Hipparcos catalog, if known.
     */
    int hipparcos_catalog;
    /**
     * The star's ID in the Henry Draper catalog, if known.
     */
    int henry_draper_catalog;
    /**
     * The star's ID in the third edition of the Gliese Catalog of Nearby Stars.
     */
    String gliese_catalog;
    /**
     * The Bayer / Flamsteed designation, primarily from the Fifth Edition of
     * the Yale Bright Star Catalog. This is a combination of the two
     * designations. The Flamsteed number, if present, is given first; then a
     * three-letter abbreviation for the Bayer Greek letter; the Bayer
     * superscript number, if present; and finally, the three-letter
     * constellation abbreviation. Thus Alpha Andromedae has the field value
     * "21Alp And", and Kappa1 Sculptoris (no Flamsteed number) has "Kap1Scl".
     */
    String bayer_flamsteed_designation;
    /**
     * The star's right ascension for epoch and equinox 2000.0.
     */
    double right_ascension;
    /**
     * The star's declination for epoch and equinox 2000.0.
     */
    double declination;
    /**
     * A common name for the star, such as "Barnard's Star" or "Sirius". I have
     * taken these names primarily from the Hipparcos project's web site, which
     * lists representative names for the 150 brightest stars and many of the
     * 150 closest stars. I have added a few names to this list. Most of the
     * additions are designations from catalogs mostly now forgotten (e.g.,
     * Lalande, Groombridge, and Gould ["G."]) except for certain nearby stars
     * which are still best known by these designations.
     */
    String name;
    /**
     * The star's distance in parsecs, the most common unit in astrometry. To
     * convert parsecs to light years, multiply by 3.262. A value >= 10000000
     * indicates missing or dubious (e.g., negative) parallax data in Hipparcos.
     */
    double distance;
    /**
     * The star's proper motion in right ascension, in milliarcseconds per year.
     */
    double proper_motion_right_ascension;
    /**
     * The star's proper motion in declination, in milliarcseconds per year.
     */
    double proper_motion_declination;
    /**
     * The star's radial velocity in km/sec, where known.
     */
    double radial_velocity;
    /**
     * The star's apparent visual magnitude.
     */
    double apparent_magnitude;
    /**
     * The star's absolute visual magnitude (its apparent magnitude from a
     * distance of 10 parsecs).
     */
    double absolute_magnitude;
    /**
     * The star's spectral type, if known.
     */
    String spectral_type;
    /**
     * The star's color index (blue magnitude - visual magnitude), where known.
     */
    String color_index;
    /**
     * The Cartesian coordinates of the star, in a system based on the
     * equatorial coordinates as seen from Earth. +X is in the direction of the
     * vernal equinox (at epoch 2000), +Z towards the north celestial pole, and
     * +Y in the direction of R.A. 6 hours, declination 0 degrees.
     */
    double x;
    /**
     * The Cartesian coordinates of the star, in a system based on the
     * equatorial coordinates as seen from Earth. +X is in the direction of the
     * vernal equinox (at epoch 2000), +Z towards the north celestial pole, and
     * +Y in the direction of R.A. 6 hours, declination 0 degrees.
     */
    double y;
    /**
     * The Cartesian coordinates of the star, in a system based on the
     * equatorial coordinates as seen from Earth. +X is in the direction of the
     * vernal equinox (at epoch 2000), +Z towards the north celestial pole, and
     * +Y in the direction of R.A. 6 hours, declination 0 degrees.
     */
    double z;
    /**
     * The Cartesian velocity components of the star, in the same coordinate
     * system described immediately above. They are determined from the proper
     * motion and the radial velocity (when known). The velocity unit is parsecs
     * per year; these are small values (around 1 millionth of a parsec per
     * year), but they enormously simplify calculations using parsecs as base
     * units for celestial mapping.
     */
    double vx;
    /**
     * The Cartesian velocity components of the star, in the same coordinate
     * system described immediately above. They are determined from the proper
     * motion and the radial velocity (when known). The velocity unit is parsecs
     * per year; these are small values (around 1 millionth of a parsec per
     * year), but they enormously simplify calculations using parsecs as base
     * units for celestial mapping.
     */
    double vy;
    /**
     * The Cartesian velocity components of the star, in the same coordinate
     * system described immediately above. They are determined from the proper
     * motion and the radial velocity (when known). The velocity unit is parsecs
     * per year; these are small values (around 1 millionth of a parsec per
     * year), but they enormously simplify calculations using parsecs as base
     * units for celestial mapping.
     */
    double vz;
    /**
     * The positions in radians, and proper motions in radians per year.
     */
    double right_ascension_radians;
    /**
     * The positions in radians, and proper motions in radians per year.
     */
    double declination_radians;
    /**
     * The positions in radians, and proper motions in radians per year.
     */
    double proper_motion_right_ascension_radians;
    /**
     * The positions in radians, and proper motions in radians per year.
     */
    double proper_motion_declination_radians;
    /**
     * The Bayer designation as a distinct value
     */
    String bayer_designation;
    /**
     * The Flamsteed number as a distinct value
     */
    int flamsteed_number;
    /**
     * The standard constellation abbreviation
     */
    String constellation;
    /**
     * Identifies a star in a multiple star system. comp = ID of companion star,
     * comp_primary = ID of primary star for this component, and base = catalog
     * ID or name for this multi-star system. Currently only used for Gliese
     * stars.
     */
    int companion_star_id;
    /**
     * Identifies a star in a multiple star system. comp = ID of companion star,
     * comp_primary = ID of primary star for this component, and base = catalog
     * ID or name for this multi-star system. Currently only used for Gliese
     * stars.
     */
    int companion_primary_id;
    /**
     * Identifies a star in a multiple star system. comp = ID of companion star,
     * comp_primary = ID of primary star for this component, and base = catalog
     * ID or name for this multi-star system. Currently only used for Gliese
     * stars.
     */
    String base_catalog_id;
    /**
     * Star's luminosity as a multiple of Solar luminosity.
     */
    double luminosity;
    /**
     * Star's standard variable star designation, when known.
     */
    String variable_star_designation;
    /**
     * Star's approximate magnitude range, for variables. This value is based on
     * the Hp magnitudes for the range in the original Hipparcos catalog,
     * adjusted to the V magnitude scale to match the "mag" field.
     */
    double variable_min;
    /**
     * Star's approximate magnitude range, for variables. This value is based on
     * the Hp magnitudes for the range in the original Hipparcos catalog,
     * adjusted to the V magnitude scale to match the "mag" field.
     */
    double variable_max;
}
