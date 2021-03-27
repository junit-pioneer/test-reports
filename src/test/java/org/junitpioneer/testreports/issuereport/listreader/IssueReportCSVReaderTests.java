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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;
import org.junitpioneer.testreports.issuereport.jaxb.IssueType;

@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.directory", value = "examples")
public class IssueReportCSVReaderTests {

	IssueReportCSVReader sut;
	IssueListReader issueListReader = new IssueListReader();

	@BeforeEach
	void setUp() {
		sut = new IssueReportCSVReader();
	}

	@Test
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.filename", value = "oneLine")
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.csv.skipfirstline", value = "false")
	void processFileWithOneLine() {
		IssueType expected = new IssueType("req-123", "description with spaces", "HIGH");

		String fileName = issueListReader.buildFileName();

		List<IssueType> actual = new ArrayList<>(sut.readFile(fileName));

		assertAll(() -> assertThat(actual.size()).isEqualTo(1), () -> assertThat(actual.get(0)).isEqualTo(expected));
	}

	@Test
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.filename", value = "threeLines")
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.csv.skipfirstline", value = "false")
	void processFileWithThreeLines() {
		List<IssueType> expectedIssues = new ArrayList<>();
		expectedIssues.add(new IssueType("req-123", "description with spaces", "HIGH"));
		expectedIssues.add(new IssueType("req-222", "second", "2"));
		expectedIssues.add(new IssueType("req-333", "third", "LOW"));

		String fileName = issueListReader.buildFileName();

		List<IssueType> actual = new ArrayList<>(sut.readFile(fileName));

		assertAll(() -> assertThat(actual.size()).isEqualTo(3),
			() -> assertThat(actual).containsExactlyInAnyOrderElementsOf(expectedIssues));
	}

	@Test
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.filename", value = "oneLine")
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.csv.skipfirstline", value = "true")
	void processLineSkipFirstLine() {
		String fileName = issueListReader.buildFileName();
		List<IssueType> actual = new ArrayList<>(sut.readFile(fileName));

		assertThat(actual.size()).isEqualTo(0);
	}

	@Test
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.filename", value = "tooMuchElements")
	void tooMuchElementsInLine() {
		String fileName = issueListReader.buildFileName();

		assertThatThrownBy(() -> sut.readFile(fileName))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Line does not contain three elements, but [4]");
	}

	@Test
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.filename", value = "tooLessElements")
	void tooLessElementsInLine() {
		String fileName = issueListReader.buildFileName();

		assertThatThrownBy(() -> sut.readFile(fileName))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Line does not contain three elements, but [2]");
	}

	@Test
	@SetSystemProperty(key = "org.junitpioneer.testreports.issuereport.issuelist.filename", value = "nonexisting")
	void FileNotFound() {
		String fileName = issueListReader.buildFileName();

		List<IssueType> actual = new ArrayList<>(sut.readFile(fileName));
		assertThat(actual.size()).isEqualTo(0);
	}

}
