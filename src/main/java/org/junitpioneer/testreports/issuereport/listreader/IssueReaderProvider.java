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

import java.util.Set;

import org.junitpioneer.testreports.issuereport.jaxb.IssueType;

/**
 * An implementing class provides a reader for import a list of issues.
 */
public interface IssueReaderProvider {

	/**
	 * Read the issue list file
	 *
	 * @param fileName
	 *          Name of the issue list
	 * @return Set with all issues read from the file
	 */
	Set<IssueType> readFile(String fileName);

}
