/*
 * Copyright 2011 Brian Matthews
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btmatthews.maven.plugins.inmemdb;

import java.io.File;

import org.apache.maven.plugin.MojoFailureException;

public interface Loader {

	/**
	 * The message key for the error reported when a source file cannot be read.
	 */
	String CANNOT_READ_SOURCE_FILE = "cannot_read_source_file";

	/**
	 * The message key for the error reported when a source file cannot be
	 * processed.
	 */
	String ERROR_PROCESSING_SOURCE_FILE = "error_processing_source_file";

	/**
	 * Determine whether or not the data or script can be loaded or executed.
	 * 
	 * @param source
	 *            The source file containing the data or script.
	 * @return <ul>
	 *         <li><code>true</code> if the data or script can be loaded or
	 *         executed.</li>
	 *         <li><code>false</code>if the data or script cannot be loaded or
	 *         executed.</li>
	 *         </ul>
	 */
	boolean isSupported(File source);

	/**
	 * Load data into or execute a script against the in-memory database.
	 * 
	 * @param logger
	 *            Used to report errors and raise exceptions.
	 * @param dataSource
	 *            The data source used to connect to the in-memory database.
	 * @param source
	 *            The source file containing the data or script.
	 * @throws MojoFailureException
	 *             If there was an error loading data or executing the script.
	 */
	void load(Logger logger, Database database, File source)
			throws MojoFailureException;
}