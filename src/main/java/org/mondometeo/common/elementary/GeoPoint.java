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
 * The Class GeoPoint.
 */
public class GeoPoint implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6600144639569401463L;
	
	/** The latitude. */
	private float latitude;
    
    /** The longitude. */
    private float longitude;
    
    /** The elevation. */
    private int elevation;
    
    /**
     * Gets the zero position.
     *
     * @return the zero position
     */
    public static GeoPoint getZeroPosition(){   return new GeoPoint(0f, 0f, 0); }

     
    /**
     * Instantiates a new geo referenced object.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     */
    public GeoPoint(final float latitude, final float longitude) {
        this(latitude, longitude, 0);
    }

    
    

    /**
     * Instantiates a new geo referenced object.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @param elevation the elevation
     */
    public GeoPoint(final float latitude, final float longitude, final int elevation) {
    	super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    /**
     * Gets the elevation.
     *
     * @return the elevation
     */
    public final int getElevation() {
        return elevation;
    }

    /**
     * Sets the elevation.
     *
     * @param elevation the new elevation
     */
    public void setElevation(final int elevation) {
        this.elevation = elevation;
    }

    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public final float getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     *
     * @param latitude the new latitude
     */
    public void setLatitude(final float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the longitude.
     *
     * @return the longitude
     */
    public final float getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     *
     * @param longitude the new longitude
     */
    public void setLongitude(final float longitude) {
        this.longitude = longitude;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GeoPoint other = (GeoPoint) obj;
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        if (this.elevation != other.elevation) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Float.floatToIntBits(this.latitude);
        hash = 37 * hash + Float.floatToIntBits(this.longitude);
        hash = 37 * hash + this.elevation;
        return hash;
    }

  


    

}
