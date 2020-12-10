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

import org.junit.platform.engine.TestExecutionResult;
import org.junitpioneer.jupiter.IssueTestCase;

public class IssueTestCaseBuilder {

	public static List<IssueTestCase> listWithThreeTestsFixedNameAndAllResults() {
		List<IssueTestCase> tests = new ArrayList<>();
		tests.add(new IssueTestCase("test1", TestExecutionResult.Status.SUCCESSFUL));
		tests.add(new IssueTestCase("test2", TestExecutionResult.Status.FAILED));
		tests.add(new IssueTestCase("test3", TestExecutionResult.Status.ABORTED));

		return tests;
	}

	public static List<IssueTestCase> listWithThreeTestsRandomNameAndAllResults() {
		List<IssueTestCase> tests = new ArrayList<>();
		tests.add(new IssueTestCase(UUID.randomUUID().toString(), TestExecutionResult.Status.SUCCESSFUL));
		tests.add(new IssueTestCase(UUID.randomUUID().toString(), TestExecutionResult.Status.FAILED));
		tests.add(new IssueTestCase(UUID.randomUUID().toString(), TestExecutionResult.Status.ABORTED));

		return tests;
	}

	public static List<IssueTestCase> listWithResult(int numberOfTests, TestExecutionResult.Status status) {
		List<IssueTestCase> tests = new ArrayList<>();

		for (int i = 0; i < numberOfTests; i++) {
			tests.add(new IssueTestCase(UUID.randomUUID().toString(), status));
		}
		return tests;
	}

}
