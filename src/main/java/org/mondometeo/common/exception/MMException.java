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
package org.mondometeo.common.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class MMException.
 */
public class MMException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 54703957024666225L;

	/**
	 * Instantiates a new mM exception.
	 */
	public MMException() {
       super();
    }

	/**
	 * Instantiates a new mM exception.
	 *
	 * @param message the message
	 */
	public MMException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new mM exception.
	 *
	 * @param cause the cause
	 */
	public MMException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new mM exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public MMException(String message, Throwable cause) {
		super(message, cause);
	}

}
