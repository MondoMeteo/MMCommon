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
package org.mondometeo.common.formatter;

import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.mondometeo.common.MeteoFrame;
import org.mondometeo.common.elementary.GeoSector;
import org.mondometeo.common.elementary.MeteoData;

/**
 * The Class MeteoFormatter.
 */
public class MeteoFormatter {

    /**
     * Format temp.
     *
     * @param meteodata the meteodata
     * @return the string
     */
    public static String formatTemp(final MeteoData meteodata) {
        return formatTemp(meteodata.getLst());
    }

    /**
     * Format temp.
     *
     * @param temp the temp
     * @return the string
     */
    public static String formatTemp(final float temp) {
        String tempClass;
        if (temp > -273 && temp < -2) {
            tempClass = "Freezing";
        } else if (temp >= -2 && temp < 10) {
            tempClass = "Cold";
        } else if (temp >= 10 && temp < 15) {
            tempClass = "Warm";
        } else if (temp >= 15 && temp < 25) {
            tempClass = "Nice";
        } else if (temp >= 25 && temp < 30) {
            tempClass = "Hot";
        } else if (temp >= 30) {
            tempClass = "Very Hot";
        } else {
            tempClass = "N.A.";
        }
        return tempClass;
    }

    /**
     * Format cloud.
     *
     * @param meteodata the meteodata
     * @return the string
     */
    public static String formatCloud(final MeteoData meteodata) {
        return formatCloud(meteodata.getCloudType());
    }

    /**
     * Format cloud.
     *
     * @param cloud the cloud
     * @return the string
     */
    public static String formatCloud(final int cloud) {
        if (cloud == 1) {
            return "Covered";
        } else {
            return "Clean";
        }
    }

    /**
     *
     * @param e
     * @return [nome]_[minlat]_[minlng]_[maxlat]_[maxlng]_[date].txt
     */
    public static String getFileName(MeteoFrame e, String name) {
        String pattern = "yyyyMMddHHmm";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        Date d = new Date(e.getDate());
        String date = format.format(d);
        String sector = +e.getSector().getSouth()
                + "_" + e.getSector().getWest()
                + "_" + e.getSector().getNorth()
                + "_" + e.getSector().getEast();

        return date + "_" + name + "_" + sector.replace('.', '-');
    }
    

    public static float[][] getLSTMatrix(final MeteoFrame e, final int nrows, final int ncols) {
        float[][] matrix = new float[nrows][ncols];
        int col = -1;
        int row = 0;
        int tot = 0;


        for (Iterator<MeteoData> it = e.iterator(); it.hasNext();) {
            MeteoData meteoData = it.next();
            float lst = meteoData.getLst();
            col++;
            
            if (col >= ncols) {
                col = 0;
                row++;
            }
            //tot++;
            //System.out.println("--" + tot + "------" + row + " " + col + " " + lst);
            matrix[row][col] = lst;
        }
        return matrix;
    }
}
