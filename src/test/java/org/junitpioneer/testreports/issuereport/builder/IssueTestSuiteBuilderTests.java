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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.IssueTestSuite;

public class IssueTestSuiteBuilderTests {

	@Test
	void withThreeFixedNamesTests() {
		IssueTestSuite expected = new IssueTestSuite("req-123",
			IssueTestCaseBuilder.listWithThreeTestsFixedNameAndAllResults());

		IssueTestSuite actual = IssueTestSuiteBuilder.withThreeFixedNamesTests("req-123");
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void withThreeRandomNamesTests() {
		IssueTestSuite actual = IssueTestSuiteBuilder.withThreeRandomNamesTests("req-123");
		assertAll(() -> assertThat(actual.tests().size()).isEqualTo(3),
			() -> assertThat(actual.issueId()).isEqualTo("req-123"));

	}

	@Test
	void withRandomIssueIdsTest() {
		List<IssueTestSuite> actual = IssueTestSuiteBuilder.withRandomIssueIds(2);

		assertAll(() -> assertThat(actual.size()).isEqualTo(2),
			() -> assertThat(actual.get(0).tests().size()).isEqualTo(3),
			() -> assertThat(actual.get(1).tests().size()).isEqualTo(3));

	}

}
