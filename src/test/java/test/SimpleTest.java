/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.Issue;

public class SimpleTest {

	@Test
	@Issue("req123")
	void simpleTest() {
		Assertions.assertThat(true).isEqualTo(true);
	}

	@Test
	@Issue("req222")
	void anotherTest() {
		Assertions.assertThat(true).isEqualTo(true);
	}

}
