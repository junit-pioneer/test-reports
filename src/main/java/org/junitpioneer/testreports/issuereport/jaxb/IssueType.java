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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Single issue with its properties, tests and a summary of the test results
 *
 *
 * <p>
 * Java class for issueType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="issueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="summary" type="{https://com.github.bukama.ir/01.00}summaryType"/&gt;
 *         &lt;element name="tests"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="testCase" type="{https://com.github.bukama.ir/01.00}testCaseType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="issueId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "issueType", propOrder = { "summary", "tests" })
public class IssueType {

	@XmlElement(required = true)
	protected SummaryType summary;
	@XmlElement(required = true)
	protected Tests tests;
	@XmlAttribute(name = "issueId", required = true)
	protected String issueId;
	@XmlAttribute(name = "description")
	protected String description;
	@XmlAttribute(name = "priority")
	protected String priority;

	/**
	 * Default constructor.
	 */
	public IssueType() {
		this.tests = new Tests();
	}

	/**
	 * Constructor with attributes only.
	 *
	 * @param issueId
	 *          Id of the issue
	 */
	public IssueType(String issueId) {
		this.issueId = issueId;
		this.tests = new Tests();
		this.summary = new SummaryType();
	}

	/**
	 * Constructor with attributes only.
	 *
	 * @param issueId
	 *          Id of the issue
	 * @param description
	 *          Description of the issue
	 * @param priority
	 *          Priority of the issue
	 */
	public IssueType(String issueId, String description, String priority) {
		this.issueId = issueId;
		this.description = description;
		this.priority = priority;
		this.tests = new Tests();
		this.summary = new SummaryType();
	}

	/**
	 * Gets the value of the summary property.
	 *
	 * @return
	 *         possible object is
	 *         {@link SummaryType }
	 *
	 */
	public SummaryType getSummary() {
		return summary;
	}

	/**
	 * Sets the value of the summary property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link SummaryType }
	 *
	 */
	public void setSummary(SummaryType value) {
		this.summary = value;
	}

	/**
	 * Gets the value of the tests property.
	 *
	 * @return
	 *         possible object is
	 *         {@link Tests }
	 *
	 */
	public Tests getTests() {
		return tests;
	}

	/**
	 * Sets the value of the tests property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link Tests }
	 *
	 */
	public void setTests(Tests value) {
		this.tests = value;
	}

	/**
	 * Gets the value of the issueId property.
	 *
	 * @return
	 *         possible object is
	 *         {@link String }
	 *
	 */
	public String getIssueId() {
		return issueId;
	}

	/**
	 * Sets the value of the issueId property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link String }
	 *
	 */
	public void setIssueId(String value) {
		this.issueId = value;
	}

	/**
	 * Gets the value of the description property.
	 *
	 * @return
	 *         possible object is
	 *         {@link String }
	 *
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link String }
	 *
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the priority property.
	 *
	 * @return
	 *         possible object is
	 *         {@link String }
	 *
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link String }
	 *
	 */
	public void setPriority(String value) {
		this.priority = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 *
	 * <p>
	 * The following schema fragment specifies the expected content contained within this class.
	 *
	 * <pre>
	 * &lt;complexType&gt;
	 *   &lt;complexContent&gt;
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *       &lt;sequence&gt;
	 *         &lt;element name="testCase" type="{https://com.github.bukama.ir/01.00}testCaseType" maxOccurs="unbounded" minOccurs="0"/&gt;
	 *       &lt;/sequence&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 *
	 *
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "testCase" })
	public static class Tests {

		protected List<TestCaseType> testCase;

		/**
		 * Gets the value of the testCase property.
		 *
		 * <p>
		 * This accessor method returns a reference to the live list,
		 * not a snapshot. Therefore any modification you make to the
		 * returned list will be present inside the JAXB object.
		 * This is why there is not a <CODE>set</CODE> method for the testCase property.
		 *
		 * <p>
		 * For example, to add a new item, do as follows:
		 *
		 * <pre>
		 * getTestCase().add(newItem);
		 * </pre>
		 *
		 *
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link TestCaseType }
		 *
		 *
		 */
		public List<TestCaseType> getTestCase() {
			if (testCase == null) {
				testCase = new ArrayList<TestCaseType>();
			}
			return this.testCase;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Tests tests = (Tests) o;
			return Objects.equals(testCase, tests.testCase);
		}

		@Override
		public int hashCode() {
			return Objects.hash(testCase);
		}

		@Override
		public String toString() {
			return "Tests{" + "testCase=" + testCase + '}';
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		IssueType issueType = (IssueType) o;
		return Objects.equals(summary, issueType.summary) && Objects.equals(tests, issueType.tests)
				&& Objects.equals(issueId, issueType.issueId) && Objects.equals(description, issueType.description)
				&& Objects.equals(priority, issueType.priority);
	}

	@Override
	public int hashCode() {
		return Objects.hash(summary, tests, issueId, description, priority);
	}

	@Override
	public String toString() {
		return "IssueType{" + "summary=" + summary + ", tests=" + tests + ", issueId='" + issueId + '\''
				+ ", description='" + description + '\'' + ", priority='" + priority + '\'' + '}';
	}

}
