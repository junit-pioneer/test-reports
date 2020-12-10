/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.testreports.issuereport.config;

public enum IssueReportConfig {

	/**
	 * Subdirectory of the issue list.
	 * The directory will be prefixed with "." and the the value of File.separator, together e.g "./".
	 * Default: ""
	 */
	ISSUELIST_DIRECTORY("com.github.bukama.ir.issuelist.directory", ""),
	/**
	 * Filename of the issue list without extension or path.
	 * Default: "issuelist"
	 */
	ISSUELIST_FILENAME("com.github.bukama.ir.issuelist.filename", "issuelist"),
	/**
	 * File extension of the issue list.
	 * Default: "csv"
	 */
	ISSUELIST_EXTENSION("com.github.bukama.ir.issuelist.extension", "csv"),
	/**
	 * Skip first line of the issue list, when it's an csv file.
	 * Default: "false"
	 */
	ISSUELIST_CSV_SKIPFIRSTLINE("com.github.bukama.ir.issuelist.csv.skipfirstline", "false"),
	/**
	 * Directory where the report is generated (without trailing slash).
	 * The directory will be prefixed with "." and the the value of File.separator, together e.g "./".
	 * Default: "target/reports"
	 */
	REPORT_DIRECTORY("com.github.bukama.ir.report.directory", "target/reports");

	private final String key;
	private final String defaultValue;

	IssueReportConfig(String key, String defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
	}

	/**
	 * Reads the configuration from the system properties.
	 *
	 * @return String value or default value if not set
	 */
	public String asString() {
		return System.getProperty(this.key, this.defaultValue);
	}

	/**
	 * Returns the value or its default as boolean.
	 *
	 * @return Boolean value or default value if not set
	 */
	public boolean asBoolean() {
		return Boolean.parseBoolean(asString());
	}

}
