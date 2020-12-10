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

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

public class SupportedListTypesTests {

	@Test
	@SetSystemProperty(key = "com.github.bukama.ir.issuelist.extension", value = "csv")
	void supportedTypeLowercase() {
		SupportedListTypes expected = SupportedListTypes.CSV;
		SupportedListTypes actual = SupportedListTypes.byConfig();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@SetSystemProperty(key = "com.github.bukama.ir.issuelist.extension", value = "CSV")
	void supportedTypeUppercase() {
		SupportedListTypes expected = SupportedListTypes.CSV;
		SupportedListTypes actual = SupportedListTypes.byConfig();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@SetSystemProperty(key = "com.github.bukama.ir.issuelist.extension", value = " CSV ")
	void supportedTypeTrimmed() {
		SupportedListTypes expected = SupportedListTypes.CSV;
		SupportedListTypes actual = SupportedListTypes.byConfig();

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@SetSystemProperty(key = "com.github.bukama.ir.issuelist.extension", value = "NotSupported")
	void notSupportedType() {
		assertThatThrownBy(SupportedListTypes::byConfig)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(
					"No enum constant org.junitpioneer.testreports.issuereport.listreader.SupportedListTypes.NOTSUPPORTED");

	}

}
