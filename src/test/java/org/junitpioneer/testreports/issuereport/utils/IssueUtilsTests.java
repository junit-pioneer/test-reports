/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.testreports.issuereport.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.IssueTestCase;
import org.junitpioneer.jupiter.IssueTestSuite;
import org.junitpioneer.testreports.issuereport.builder.IssueTestCaseBuilder;
import org.junitpioneer.testreports.issuereport.builder.IssueTestSuiteBuilder;
import org.junitpioneer.testreports.issuereport.jaxb.IssueType;
import org.junitpioneer.testreports.issuereport.jaxb.TestCaseType;

public class IssueUtilsTests {

	static final TestCaseType TEST1 = new TestCaseType("test1", "SUCCESSFUL");
	static final IssueType ISSUE1 = new IssueType("req-123", "description", "1");
	static final IssueType ISSUE2 = new IssueType("req-222", "another one", "2");

	@Test
	void convertToTestCaseTypeCorrectly() {
		List<IssueTestCase> testCases = IssueTestCaseBuilder.listWithThreeTestsFixedNameAndAllResults();
		List<TestCaseType> actual = IssueUtils.convertToTestCaseType(testCases);
		assertAll(() -> assertThat(actual.size()).isEqualTo(3), () -> assertThat(actual.get(0)).isEqualTo(TEST1));
	}

	@Test
	void convertToTestCaseTypeEmptyList() {
		List<TestCaseType> actual = IssueUtils.convertToTestCaseType(new ArrayList<>());
		assertThat(actual.size()).isEqualTo(0);
	}

	@Test
	void mergeListEmptyList() {
		List<IssueType> actual = IssueUtils.mergeLists(new ArrayList<>(), new ArrayList<>());
		assertThat(actual.size()).isEqualTo(0);
	}

	@Test
	void mergeListNoIssueList() {
		List<IssueTestSuite> testSuites = new ArrayList<>();
		testSuites.add(IssueTestSuiteBuilder.withThreeFixedNamesTests("req-123"));

		List<IssueType> actual = IssueUtils.mergeLists(new ArrayList<>(), testSuites);

		assertAll(() -> assertThat(actual.size()).isEqualTo(1),
			() -> assertThat(actual.get(0).getIssueId()).isEqualTo("req-123"),
			() -> assertThat(actual.get(0).getDescription()).isNull(),
			() -> assertThat(actual.get(0).getTests().getTestCase().size()).isEqualTo(3));
	}

	@Test
	void mergeListNoIssueTestSuiteList() {
		List<IssueType> issues = new ArrayList<>();
		issues.add(ISSUE1);
		issues.add(ISSUE2);

		List<IssueType> actual = IssueUtils.mergeLists(issues, new ArrayList<>());

		assertAll(() -> assertThat(actual.size()).isEqualTo(2),
			() -> assertThat(actual.get(0).getIssueId()).isEqualTo("req-123"),
			() -> assertThat(actual.get(0)).isEqualTo(ISSUE1), () -> assertThat(actual.get(1)).isEqualTo(ISSUE2));
	}

	@Test
	void mergeListBothPresentList() {
		List<IssueType> issues = new ArrayList<>();
		issues.add(ISSUE1);
		issues.add(ISSUE2);

		List<IssueTestSuite> testSuites = new ArrayList<>();
		testSuites.add(IssueTestSuiteBuilder.withThreeFixedNamesTests("req-123"));

		List<IssueType> actual = IssueUtils.mergeLists(issues, testSuites);

		assertAll(() -> assertThat(actual.size()).isEqualTo(2),
			() -> assertThat(actual.get(0).getIssueId()).isEqualTo("req-123"),
			() -> assertThat(actual.get(0).getTests().getTestCase().size()).isEqualTo(3),
			() -> assertThat(actual.get(0).getTests().getTestCase().get(0).getTestId()).isEqualTo("test1"),
			() -> assertThat(actual.get(1)).isEqualTo(ISSUE2));
	}

}
