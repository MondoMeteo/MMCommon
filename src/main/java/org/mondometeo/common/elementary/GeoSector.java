/*  
    Copyright 2012  Alessandro Staniscia ( alessandro@staniscia.net )

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License, version 2, as
    published by the Free Software Foundation.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/
package org.mondometeo.common.elementary;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class GeoSector.
 */
public class GeoSector implements Serializable {
	
	/** The point up sx. */
	private GeoPoint pointUpSX;
	
	/** The point down dx. */
	private GeoPoint pointDownDX;

	/**
	 * Instantiates a new geo sector.
	 *
	 * @param north the north
	 * @param south the south
	 * @param east the east
	 * @param west the west
	 */
	public GeoSector(	final float north, final float south, final float east, final float west) {
		pointUpSX = new GeoPoint( north , west );
		pointDownDX = new GeoPoint(south, east);
	}

	/**
	 * Gets the north.
	 *
	 * @return the north
	 */
	public float getNorth() {
		return pointUpSX.getLatitude();
	}

	/**
	 * Gets the south.
	 *
	 * @return the south
	 */
	public float getSouth() {
		return pointDownDX.getLatitude();
	}


	/**
	 * Gets the east.
	 *
	 * @return the east
	 */
	public float getEast() {
		return pointDownDX.getLongitude();
	}

	/**
	 * Gets the west.
	 *
	 * @return the west
	 */
	public float getWest() {
		return pointUpSX.getLongitude();
	}

	/**
	 * Gets the point up sx.
	 *
	 * @return the point up sx
	 */
	public GeoPoint getPointUpSX() {
		return pointUpSX;
	}


	/**
	 * Gets the point down dx.
	 *
	 * @return the point down dx
	 */
	public GeoPoint getPointDownDX() {
		return pointDownDX;
	}


	
	
	


}
