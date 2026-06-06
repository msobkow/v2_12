/*
 *  MSS Code Factory CFLib 2.12
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	These files are part of MSS Code Factory Version 2.12.
 *
 *	MSS Code Factory is available under the terms of the GNU General Public License,
 *	Version 3 or later.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 */

package org.msscf.msscf.cflib.CFLib.JavaFX;

import org.msscf.msscf.cflib.CFLib.*;

/**
 *	Any Node being set as a display form must be castable to ICFForm.
 *
 *	The form manager makes calls through this interface to ensure
 *	that forms are cleaned up when an application logs out or resets
 *	to the root form for a facet.
 */
public interface ICFForm
{
	/**
	 *	Get the form manager associated with this form.
	 */
	ICFFormManager getCFFormManager();

	/**
	 *	Force the form to cancel and close.  The form should invoke
	 *	ICFFormManager.closeCurrentForm(), but if it doesn't, the
	 *	form manager will force the form off the stack after
	 *	invoking this callback.
	 */
	void forceCancelAndClose();
}
