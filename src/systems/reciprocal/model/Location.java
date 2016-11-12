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
package systems.reciprocal.model;

/**
 *
 * @author Bruce Peret
 */
public class Location {

    Dual space;
    Dual time;

    /**
     * Generic constructor.
     * 
     * @param space Location in 3D space.
     * @param time Location in 3D time.
     */
    public Location(Dual space, Dual time) {
        this.space = space;
        this.time = time;
    }
    
    /**
     * Constructor that returns (0,0,0) locations for space and time.
     */
    public Location() {
        this.space = new Dual(new Tuple(4,0),new Tuple(4,0));
        this.time = new Dual(new Tuple(4,0),new Tuple(4,0));
    }
    
    /**
     * Set space-time locations.
     * 
     * @param space
     * @param time
     * @return 
     */
    public Location set (Dual space, Dual time) {
        this.space = space;
        this.time = time;
        return this;
    }
    
    /**
     * Set spatial location.
     * 
     * @param space Principal and subordinate spatial coordinates.
     * @return 
     */
    public Location setSpace (Dual space) {
        this.space = space;
        return this;
    }
    
    /**
     * Set temporal location.
     * 
     * @param time Principal and subordinate temporal coordinates.
     * @return 
     */
    public Location setTime(Dual time) {
        this.time = time;
        return this;
    }
}
