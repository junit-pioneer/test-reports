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

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.junitpioneer.testreports.issuereport.config.IssueReportConfig;
import org.junitpioneer.testreports.issuereport.jaxb.IssueType;

/**
 * Provides a reader for an issue list in a CSV format.
 */
public class IssueReportCSVReader implements IssueReaderProvider {

	private static final Logger LOG = Logger.getAnonymousLogger();

	private final Set<IssueType> issues = new HashSet<>();

	private int lineNumber = 0;

	@Override
	public Set<IssueType> readFile(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();

		CSVReader reader = null;
		try (InputStreamReader isr = new InputStreamReader(
			Objects.requireNonNull(classLoader.getResourceAsStream(fileName)), StandardCharsets.UTF_8)) {

			reader = new CSVReader(isr);
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				processLine(nextLine);
			}
		}
		catch (NullPointerException e) {
			LOG.warning(String.format("Issue list not found at [%s]. Continue without using it.", fileName));
		}
		catch (IOException e) {
			LOG.severe(String.format("Error while accessing issue list: [%s]", e.getMessage()));
		}
		catch (CsvValidationException e) {
			LOG.severe(String.format("Issue list is not a valid CSV file: [%s]", e.getMessage()));
		}
		return issues;
	}

	/**
	 * Splits the line into it parts and converts it into an issue which is then added to the set.
	 *
	 * @param line
	 *          line read from file
	 */
	private void processLine(String[] line) {
		lineNumber++;
		// Maybe skip first line
		if (lineNumber == 1 && IssueReportConfig.ISSUELIST_CSV_SKIPFIRSTLINE.asBoolean()) {
			return;
		}

		if (line.length != 3) {
			throw new IllegalArgumentException(
				String.format("Line does not contain three elements, but [%s]", line.length));
		}

		issues.add(new IssueType(line[0], line[1], line[2]));
	}

}
