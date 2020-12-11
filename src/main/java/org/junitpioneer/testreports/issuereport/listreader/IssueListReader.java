/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.testreports.issuereport.listreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junitpioneer.testreports.issuereport.config.IssueReportConfig;
import org.junitpioneer.testreports.issuereport.jaxb.IssueType;

/**
 * Reader to retrieve a list of issues.
 */
public class IssueListReader {

	public List<IssueType> readIssues() {

		IssueReaderProvider reader;

		// Switch by purpose for further types
		switch (SupportedListTypes.byConfig()) {
			case CSV:
			default:
				reader = new IssueReportCSVReader();
				break;
		}
		String fileName = buildFileName();
		Set<IssueType> issues = reader.readFile(fileName);

		return new ArrayList<>(issues);
	}

	/**
	 * Creates the full file name of the issue list based on the system properties.
	 *
	 * @return Full file name
	 */
	String buildFileName() {
		String subDir = (!IssueReportConfig.ISSUELIST_DIRECTORY.asString().trim().isEmpty())
				? IssueReportConfig.ISSUELIST_DIRECTORY.asString() + File.separator
				: "";

		return "." + File.separator + subDir + IssueReportConfig.ISSUELIST_FILENAME.asString() + "."
				+ IssueReportConfig.ISSUELIST_EXTENSION.asString().toLowerCase(Locale.ROOT);
	}

}
