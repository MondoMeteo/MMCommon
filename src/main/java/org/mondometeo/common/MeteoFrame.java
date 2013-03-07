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
package org.mondometeo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import org.mondometeo.common.elementary.GeoSector;
import org.mondometeo.common.elementary.MeteoData;

// TODO: Auto-generated Javadoc
/**
 * The Class MeteoFrame.
 */
public class MeteoFrame implements Serializable {

    private static final long serialVersionUID = 2793381309080932805L;
    /**
     * Descriptions of frame.
     */
    private String descriptions;
    /**
     * The date.
     */
    private long date;
    /**
     * The sector.
     */
    private GeoSector sector;
    /**
     * The meteo data.
     */
    private ArrayList<MeteoData> meteoData = new ArrayList<MeteoData>();
    private int nrows;
    private int ncols;

    /**
     * Instantiates a new meteo frame.
     *
     * @param date the date
     * @param sector the sector
     */
    public MeteoFrame(long timeOfFrame, GeoSector sector) {
        this(timeOfFrame, sector, 0, 0);
    }

    public MeteoFrame(long timeOfFrame, GeoSector sector, int nrows, int ncols) {
        this.date = timeOfFrame;
        this.sector = sector;
        this.nrows = nrows;
        this.ncols = ncols;
    }

    /**
     * Gets the descriptions.
     *
     * @return the descriptions
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * Sets the descriptions.
     *
     * @param descriptions the new descriptions
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     * Gets the sector.
     *
     * @return the sector
     */
    public GeoSector getSector() {
        return sector;
    }

    /**
     * Sets the sector.
     *
     * @param sector the new sector
     */
    public void setSector(GeoSector sector) {
        this.sector = sector;
    }

    /**
     * List iterator.
     *
     * @param index the index
     * @return the list iterator
     */
    public ListIterator<MeteoData> listIterator(int index) {
        return meteoData.listIterator(index);
    }

    /**
     * List iterator.
     *
     * @return the list iterator
     */
    public ListIterator<MeteoData> listIterator() {
        return meteoData.listIterator();
    }

    /**
     * Iterator.
     *
     * @return the iterator
     */
    public Iterator<MeteoData> iterator() {
        return meteoData.iterator();
    }

    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return meteoData.size();
    }

    /**
     * Removes the.
     *
     * @param o the o
     * @return true, if successful
     */
    public boolean remove(MeteoData o) {
        return meteoData.remove(o);
    }

    /**
     * Removes the.
     *
     * @param index the index
     * @return the meteo data
     */
    public MeteoData remove(int index) {
        return meteoData.remove(index);
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return meteoData.isEmpty();
    }

    /**
     * Clear.
     */
    public void clear() {
        meteoData.clear();
    }

    /**
     * Adds the all.
     *
     * @param index the index
     * @param c the c
     * @return true, if successful
     */
    public boolean addAll(int index, Collection<? extends MeteoData> c) {
        return meteoData.addAll(index, c);
    }

    /**
     * Adds the all.
     *
     * @param c the c
     * @return true, if successful
     */
    public boolean addAll(Collection<? extends MeteoData> c) {
        return meteoData.addAll(c);
    }

    /**
     * Adds the.
     *
     * @param index the index
     * @param element the element
     */
    public void add(int index, MeteoData element) {
        meteoData.add(index, element);
    }

    /**
     * Adds the.
     *
     * @param e the e
     * @return true, if successful
     */
    public boolean add(MeteoData e) {
        return meteoData.add(e);
    }

    public int getNrows() {
        return nrows;
    }

    public void setNrows(int nrows) {
        this.nrows = nrows;
    }

    public int getNcols() {
        return ncols;
    }

    public void setNcols(int ncols) {
        this.ncols = ncols;
    }
}
