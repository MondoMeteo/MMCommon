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

/**
 * The Class MeteoData.
 */
public class MeteoData extends GeoPoint {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8111636829653557807L;

	/** The Constant INVALID_VALUE. */
    public static final float INVALID_VALUE = Float.NaN;
    
    /** The lst. */
    private float lst;
    
    /** The rain. */
    private float rain;
    
    /** The temp. */
    private float temp;
    
    /** The cloud type. */
    private int cloudType;


    /**
     * Instantiates a new meteo data.
     *
     * @param lst the lst
     * @param rain the rain
     * @param temp the temp
     * @param cloudType the cloud type
     */
    public MeteoData(final float lst, final float rain, final float temp, final int cloudType) {
        this(0f, 0f, 0, lst, rain, temp, cloudType);
    }

    /**
     * Instantiates a new meteo data.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @param elevation the elevation
     * @param lst the lst
     * @param rain the rain
     * @param temp the temp
     * @param cloudType the cloud type
     */
    public MeteoData(final float latitude, final float longitude, final int elevation, final float lst, final float rain, final float temp, final int cloudType) {
        super(latitude, longitude, elevation);
        this.lst = lst;
        this.rain = rain;
        this.temp = temp;
        this.cloudType = cloudType;
    }

    /**
     * Gets the cloud type.
     *
     * @return the cloud type
     */
    public int getCloudType() {
        return cloudType;
    }

    /**
     * Sets the cloud type.
     *
     * @param cloudType the new cloud type
     */
    public void setCloudType(final int cloudType) {
        this.cloudType = cloudType;
    }



    /**
     * Gets the lst.
     *
     * @return the lst
     */
    public final float getLst() {
        return lst;
    }

    /**
     * Sets the lst.
     *
     * @param lst the new lst
     */
    public void setLst(final float lst) {
        this.lst = lst;
    }

    /**
     * Gets the rain.
     *
     * @return the rain
     */
    public final float getRain() {
        return rain;
    }

    /**
     * Sets the rain.
     *
     * @param rain the new rain
     */
    public void setRain(final float rain) {
        this.rain = rain;
    }

    /**
     * Gets the temp.
     *
     * @return the temp
     */
    public final float getTemp() {
        return temp;
    }

    /**
     * Sets the temp.
     *
     * @param temp the new temp
     */
    public void setTemp(final float temp) {
        this.temp = temp;
    }

    /* (non-Javadoc)
     * @see org.mondometeo.common.elementary.GeoReferencedObject#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MeteoData other = (MeteoData) obj;
        if (Float.floatToIntBits(this.lst) != Float.floatToIntBits(other.lst)) {
            return false;
        }
        if (Float.floatToIntBits(this.rain) != Float.floatToIntBits(other.rain)) {
            return false;
        }
        if (Float.floatToIntBits(this.temp) != Float.floatToIntBits(other.temp)) {
            return false;
        }
        if (this.cloudType != other.cloudType) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see org.mondometeo.common.elementary.GeoReferencedObject#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Float.floatToIntBits(this.lst);
        hash = 59 * hash + Float.floatToIntBits(this.rain);
        hash = 59 * hash + Float.floatToIntBits(this.temp);
        hash = 59 * hash + this.cloudType;
        return hash;
    }




}
