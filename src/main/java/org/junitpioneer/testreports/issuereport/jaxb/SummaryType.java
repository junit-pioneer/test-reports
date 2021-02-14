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
 * Type for statistics
 *
 *
 * <p>
 * Java class for summaryType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="summaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="total" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="successful" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="failed" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="aborted" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summaryType")
public class SummaryType {

	@XmlAttribute(name = "total", required = true)
	protected int total;
	@XmlAttribute(name = "successful", required = true)
	protected int successful;
	@XmlAttribute(name = "failed", required = true)
	protected int failed;
	@XmlAttribute(name = "aborted", required = true)
	protected int aborted;

	/**
	 * Gets the value of the total property.
	 *
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Sets the value of the total property.
	 *
	 */
	public void setTotal(int value) {
		this.total = value;
	}

	/**
	 * Gets the value of the successful property.
	 *
	 */
	public int getSuccessful() {
		return successful;
	}

	/**
	 * Sets the value of the successful property.
	 *
	 */
	public void setSuccessful(int value) {
		this.successful = value;
	}

	/**
	 * Gets the value of the failed property.
	 *
	 */
	public int getFailed() {
		return failed;
	}

	/**
	 * Sets the value of the failed property.
	 *
	 */
	public void setFailed(int value) {
		this.failed = value;
	}

	/**
	 * Gets the value of the aborted property.
	 *
	 */
	public int getAborted() {
		return aborted;
	}

	/**
	 * Sets the value of the aborted property.
	 *
	 */
	public void setAborted(int value) {
		this.aborted = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SummaryType that = (SummaryType) o;
		return total == that.total && successful == that.successful && failed == that.failed && aborted == that.aborted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(total, successful, failed, aborted);
	}

	@Override
	public String toString() {
		return "SummaryType{" + "total=" + total + ", successful=" + successful + ", failed=" + failed + ", aborted="
				+ aborted + '}';
	}

}
