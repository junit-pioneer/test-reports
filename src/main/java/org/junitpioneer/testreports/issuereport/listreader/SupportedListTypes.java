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

import java.util.Locale;

import org.junitpioneer.testreports.issuereport.config.IssueReportConfig;

/**
 * Enumeration which defines the supported file extensions for an issue list.
 */
public enum SupportedListTypes {

	/**
	 * Comma separated value.
	 */
	CSV();

	SupportedListTypes() {
	}

	/**
	 * Retrieves the instance by the value configured in {@link IssueReportConfig#ISSUELIST_EXTENSION}.
	 *
	 * @return Retrieved instance for the format
	 * @throws IllegalArgumentException
	 *           when configured value is not a valid entry of the enumeration
	 */
	public static SupportedListTypes byConfig() throws IllegalArgumentException {
		// This throws an {@link IllegalArgumentException} if value is not in enum, so no need to check this manually.
		return SupportedListTypes
				.valueOf(IssueReportConfig.ISSUELIST_EXTENSION.asString().trim().toUpperCase(Locale.ROOT));
	}

}
