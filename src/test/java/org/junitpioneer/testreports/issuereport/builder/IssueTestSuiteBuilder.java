/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.testreports.issuereport.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junitpioneer.jupiter.IssueTestCase;
import org.junitpioneer.jupiter.IssueTestSuite;

public class IssueTestSuiteBuilder {

	public static IssueTestSuite withThreeFixedNamesTests(String issueId) {
		List<IssueTestCase> tests = IssueTestCaseBuilder.listWithThreeTestsFixedNameAndAllResults();
		return new IssueTestSuite(issueId, tests);
	}

	public static IssueTestSuite withThreeRandomNamesTests(String issueId) {
		List<IssueTestCase> tests = IssueTestCaseBuilder.listWithThreeTestsRandomNameAndAllResults();
		return new IssueTestSuite(issueId, tests);
	}

	public static List<IssueTestSuite> withRandomIssueIds(int numberOfSuites) {
		List<IssueTestSuite> suite = new ArrayList<>(numberOfSuites);

		for (int i = 1; i <= numberOfSuites; i++) {
			suite
					.add(new IssueTestSuite(UUID.randomUUID().toString(),
						IssueTestCaseBuilder.listWithThreeTestsRandomNameAndAllResults()));
		}

		return suite;
	}

}
