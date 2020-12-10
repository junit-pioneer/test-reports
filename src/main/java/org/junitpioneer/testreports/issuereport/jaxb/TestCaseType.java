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

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A specific test case with its properties and the execution result
 *
 *
 * <p>
 * Java class for testCaseType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="testCaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="testId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="result" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "testCaseType")
public class TestCaseType {

	@XmlAttribute(name = "testId", required = true)
	protected String testId;
	@XmlAttribute(name = "result", required = true)
	protected String result;

	public TestCaseType() {
	}

	public TestCaseType(String testId, String result) {
		this.testId = testId;
		this.result = result;
	}

	/**
	 * Gets the value of the testId property.
	 *
	 * @return
	 *         possible object is
	 *         {@link String }
	 *
	 */
	public String getTestId() {
		return testId;
	}

	/**
	 * Sets the value of the testId property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link String }
	 *
	 */
	public void setTestId(String value) {
		this.testId = value;
	}

	/**
	 * Gets the value of the result property.
	 *
	 * @return
	 *         possible object is
	 *         {@link String }
	 *
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the value of the result property.
	 *
	 * @param value
	 *          allowed object is
	 *          {@link String }
	 *
	 */
	public void setResult(String value) {
		this.result = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TestCaseType that = (TestCaseType) o;
		return Objects.equals(testId, that.testId) && Objects.equals(result, that.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(testId, result);
	}

	@Override
	public String toString() {
		return "TestCaseType{" + "testId='" + testId + '\'' + ", result='" + result + '\'' + '}';
	}

}
