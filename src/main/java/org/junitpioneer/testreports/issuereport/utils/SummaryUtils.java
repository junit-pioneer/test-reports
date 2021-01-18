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

import java.util.ArrayList;
import java.util.List;

import org.junit.platform.engine.TestExecutionResult;
import org.junitpioneer.testreports.issuereport.jaxb.IssueType;
import org.junitpioneer.testreports.issuereport.jaxb.TestCaseType;

public class SummaryUtils {

	public static List<IssueType> createSummaries(List<IssueType> allIssues) {

		List<IssueType> returnList = new ArrayList<>(allIssues.size());

		for (IssueType issue : allIssues) {
			int successful = 0;
			int failed = 0;
			int aborted = 0;

			for (TestCaseType test : issue.getTests().getTestCase()) {
				if (TestExecutionResult.Status.SUCCESSFUL.toString().equals(test.getResult())) {
					successful++;
				} else if (TestExecutionResult.Status.FAILED.toString().equals(test.getResult())) {
					failed++;
				} else {
					aborted++;
				}
			}
			issue.getSummary().setAborted(aborted);
			issue.getSummary().setFailed(failed);
			issue.getSummary().setSuccessful(successful);
			issue.getSummary().setTotal(issue.getTests().getTestCase().size());

			returnList.add(issue);
		}

		return returnList;
	}

}
