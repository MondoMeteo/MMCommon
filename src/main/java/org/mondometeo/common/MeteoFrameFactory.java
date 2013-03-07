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

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import org.mondometeo.common.elementary.GeoSector;
import org.mondometeo.common.elementary.MeteoData;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating MeteoFrame objects.
 */
public class MeteoFrameFactory {

    /**
     * Make meteo frame.
     *
     * @param sector the sector
     * @param timeOfFrame the time of frame
     * @param nrows the nrows
     * @param ncols the ncols
     * @param cloudTypes the cloud types
     * @param lstValues the lst values
     * @param rainValues the rain values
     * @param tempValues the temp values
     * @return the meteo frame
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static MeteoFrame makeMeteoFrame(
            final GeoSector sector,
            final long timeOfFrame,
            final int nrows,
            final int ncols,
            final BufferedReader cloudTypes,
            final BufferedReader lstValues,
            final BufferedReader rainValues,
            final BufferedReader tempValues) throws IOException {

        double latGrid;
        double lonGrid;
        latGrid = Math.abs((sector.getNorth() - sector.getSouth()) / (double) nrows);
        lonGrid = Math.abs((sector.getWest() - sector.getEast()) / (double) ncols);

        latGrid = trunkToSixDecimal(latGrid);
        lonGrid = trunkToSixDecimal(lonGrid);

        String cloudLine = null;
        String lstLine = null;
        String rainLine = null;
        String tempLine = null;
        final MeteoFrame out = new MeteoFrame(timeOfFrame, sector, nrows,ncols);

        double lat = sector.getNorth();
        while ((cloudLine = cloudTypes.readLine()) != null
                && (lstLine = lstValues.readLine()) != null
                && (rainLine = rainValues.readLine()) != null
                && (tempLine = tempValues.readLine()) != null) {

            final StringTokenizer tokenizerVal = new StringTokenizer(cloudLine);
            final StringTokenizer tokenizerLst = new StringTokenizer(lstLine);
            final StringTokenizer tokenizerRain = new StringTokenizer(rainLine);
            final StringTokenizer tokenizerTemp = new StringTokenizer(tempLine);

            double lon = sector.getWest();
            while (tokenizerVal.hasMoreTokens() && tokenizerLst.hasMoreTokens()
                    && tokenizerRain.hasMoreTokens()
                    && tokenizerTemp.hasMoreTokens()) {

                Float dd = Float.parseFloat(tokenizerVal.nextToken());
                final int cloud = dd.intValue();
                final float rain = Float.parseFloat(tokenizerRain.nextToken());
                final float lst = Float.parseFloat(tokenizerLst.nextToken());
                final float temp = Float.parseFloat(tokenizerTemp.nextToken());

                out.add(new MeteoData((float) lat, (float) lon, 0, lst, rain,
                        temp, cloud));

                lon += lonGrid;
                lon = trunkToSixDecimal(lon);
            }
            lat -= latGrid;
            lat = trunkToSixDecimal(lat);
        }

        return out;
    }

    /**
     * Make meteo frame.
     *
     * @param north the north
     * @param south the south
     * @param east the east
     * @param west the west
     * @param timeOfFrame the time of frame
     * @param nrows the nrows
     * @param ncols the ncols
     * @param cloudTypes the cloud types
     * @param lstValues the lst values
     * @param rainValues the rain values
     * @param tempValues the temp values
     * @return the meteo frame
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static MeteoFrame makeMeteoFrame(
            final float north, final float south, final float east, final float west,
            final long timeOfFrame,
            final int nrows, final int ncols,
            final BufferedReader cloudTypes,
            final BufferedReader lstValues,
            final BufferedReader rainValues,
            final BufferedReader tempValues)
            throws IOException {
        return makeMeteoFrame(new GeoSector(north, south, east, west), timeOfFrame, nrows, ncols, cloudTypes, lstValues, rainValues, tempValues);
    }

    /**
     * Trunk to six decimal.
     *
     * @param value the value
     * @return the double
     */
    private static double trunkToSixDecimal(final double value) {
        BigDecimal bd = new BigDecimal(value);
        return bd.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();

    }
}
