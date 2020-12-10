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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

public class ConfigTests {

	@Test
	void readDefaultStringValue() {
		String expected = "csv";
		String actual = IssueReportConfig.ISSUELIST_EXTENSION.asString();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@SetSystemProperty(key = "com.github.bukama.ir.issuelist.extension", value = "xml")
	void readProvidedStringValue() {
		String expected = "xml";
		String actual = IssueReportConfig.ISSUELIST_EXTENSION.asString();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@SetSystemProperty(key = "com.github.bukama.ir.issuelist.csv.skipfirstline", value = "true")
	void readBooleanValue() {
		boolean actual = IssueReportConfig.ISSUELIST_CSV_SKIPFIRSTLINE.asBoolean();

		assertThat(actual).isTrue();
	}

}
