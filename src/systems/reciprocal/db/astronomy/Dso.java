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
 * DSO (Deep Sky Object) stellar data, imported from the GitHub HYG-Database
 * https://github.com/astronexus/HYG-Database
 *
 * @author Bruce Peret
 */
public class Dso extends Astronomy {

    public static final String TABLE = "astronomy.dso";

    /**
     * The object's right ascension, for epoch 2000.0 and equinox 2000.0.
     */
    double right_ascension;
    /**
     * The object's declination, for epoch 2000.0 and equinox 2000.0.
     */
    double declination;
    /**
     * The object's type, as in the Historically Corrected NGC (see
     * "dso_source"). A full list of types is in
     * http://www.ngcicproject.org/public_HCNGC/The_HCNGC_intro.pdf, p. 19. This
     * is the canonical list of types for objects in this catalog, regardless of
     * source.
     */
    String type;
    /**
     * The object's constellation, if known.
     */
    String constellation;
    /**
     * The object's visual magnitude.
     */
    double apparent_magnitude;
    /**
     * A common name for the object.
     */
    String name;
    /**
     * The object's right ascension, in radians.
     */
    double right_ascension_radians;
    /**
     * The object's declination, in radians.
     */
    double declination_radians;
    /**
     * Database unique ID.
     */
    int id;
    /**
     * Semi-major axis of the object, in arcminutes.
     */
    double radius_major;
    /**
     * Semi-minor axis of the object, in arcminutes. If radius_minor is
     * undefined, radius_major is interpreted as the object's radius.
     */
    double radius_minor;
    /**
     * Position angle of the semimajor axis of the object, in degrees. Only
     * defined if radii are present.
     */
    double angle;
    /**
     * Source identifier for the object's position, size, and magnitude. Valid
     * values are: "0": miscellaneous, limited detail (e.g. Wikipedia). "1": NGC
     * 2000 (Sinott, 1988). "2": Historically Corrected New General Catalogue
     * from the NGC/IC project (http://www.ngcicproject.org). "3": PGC galaxy
     * catalog (http://leda.univ-lyon1.fr/). "4": Collinder open cluster
     * catalog, items not already in Messier,Caldwell,NGC,IC and with defined
     * size and magnitude (http://www.cloudynights.com/item.php?item_id=2544).
     * "5": Perek-Koh
     */
    int dso_source;
    /**
     * Primary (most commonly used) ID number/designation and catalog name for
     * this object.
     */
    String primary_id;
    /**
     * Primary (most commonly used) ID number/designation and catalog name for
     * this object.
     */
    String primary_catalog;
    /**
     * Additional, frequently-used ID and catalog name for this object (e.g., an
     * NGC or IC number for Messier objects).
     */
    String common_id;
    /**
     * Additional, frequently-used ID and catalog name for this object (e.g., an
     * NGC or IC number for Messier objects).
     */
    String common_catalog;
    /**
     * Duplicate ID number+catalog name. Unlike id2 and cat2, a duplicate ID
     * normally means this object is better known by the duplicate ID, and
     * should be excluded from display.
     */
    String duplicate_id;
    /**
     * Duplicate ID number+catalog name. Unlike id2 and cat2, a duplicate ID
     * normally means this object is better known by the duplicate ID, and
     * should be excluded from display.
     */
    String duplicate_catalog;
    /**
     * For objects whose actual magnitude is either not known or is not
     * representative of their visibility (such as very large diffuse nebulas
     * like the Veil or North America Nebula), this is a suggested magnitude
     * cutoff for chart drawing software. This field can be safely ignored for
     * other purposes.
     */
    double display_magnitude;
}
