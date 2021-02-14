/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.testreports.issuereport.jaxb;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.github.bukama.ir.jaxb package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.github.bukama.ir.jaxb
	 *
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link IssueReport }
	 *
	 */
	public IssueReport createIssueReport() {
		return new IssueReport();
	}

	/**
	 * Create an instance of {@link IssueType }
	 *
	 */
	public IssueType createIssueType() {
		return new IssueType();
	}

	/**
	 * Create an instance of {@link IssueReport.Issues }
	 *
	 */
	public IssueReport.Issues createIssueReportIssues() {
		return new IssueReport.Issues();
	}

	/**
	 * Create an instance of {@link TestCaseType }
	 *
	 */
	public TestCaseType createTestCaseType() {
		return new TestCaseType();
	}

	/**
	 * Create an instance of {@link SummaryType }
	 *
	 */
	public SummaryType createSummaryType() {
		return new SummaryType();
	}

	/**
	 * Create an instance of {@link IssueType.Tests }
	 *
	 */
	public IssueType.Tests createIssueTypeTests() {
		return new IssueType.Tests();
	}

}
