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

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IssueListReaderTests {

	IssueListReader sut;

	@BeforeEach
	void setUp() {
		sut = new IssueListReader();
	}

	@Test
	void buildFileNameCorrect() {
		String expected = "." + File.separator + "issuelist.csv";
		String actual = sut.buildFileName();

		assertThat(actual).isEqualTo(expected);
	}

}
