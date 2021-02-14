module testreports {
	// Must be set up after initial source code
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.engine;
	requires org.junitpioneer;
	requires java.logging;
	requires java.xml.bind;

	// opencsv is no module, so modlar build won't work
}
