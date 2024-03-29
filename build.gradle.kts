plugins {
    java
    jacoco
    checkstyle
    `maven-publish`
    id("com.diffplug.spotless") version "6.4.2"
    id("org.shipkit.java") version "2.3.5"
    id("at.zierler.yamlvalidator") version "1.5.0"
    //id("org.sonarqube") version "3.0"
}

plugins.withType<JavaPlugin>().configureEach {
    configure<JavaPluginExtension> {
        modularity.inferModulePath.set(true)
    }
}

group = "org.junit-pioneer"
description = "Additional test reports for JUnit Jupiter and its extensions"


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

val junitVersion: String by project

dependencies {
    implementation(platform("org.junit:junit-bom:$junitVersion"))

    implementation(group = "org.junit-pioneer", name = "junit-pioneer", version = "1.7.0")
    implementation(group = "org.junit.jupiter", name = "junit-jupiter-engine")

    implementation(group = "com.opencsv", name = "opencsv", version = "5.3")
    implementation(group = "javax.xml.bind", name = "jaxb-api", version = "2.3.1")
    implementation(group = "com.sun.xml.bind", name = "jaxb-impl", version = "2.3.3")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api")

    testImplementation(group = "org.assertj", name = "assertj-core", version = "3.22.0")
    testImplementation(group = "org.mockito", name = "mockito-core", version = "4.5.1")
    testImplementation(group = "com.google.jimfs", name = "jimfs", version = "1.2")

    testRuntimeOnly(group = "org.apache.logging.log4j", name = "log4j-core", version = "2.17.1")
    testRuntimeOnly(group = "org.apache.logging.log4j", name = "log4j-jul", version = "2.17.1")
}

spotless {
    val headerFile = file(".infra/spotless/eclipse-public-license-2.0.java")

    java {
        licenseHeaderFile(headerFile, "(package|import) ")
        importOrderFile(file(".infra/eclipse/junit-eclipse.importorder"))
        eclipse().configFile(".infra/eclipse/junit-eclipse-formatter-settings.xml")

        trimTrailingWhitespace()
        endWithNewline()
    }
}

checkstyle {
    toolVersion = "7.8.2"
    configDirectory.set(rootProject.file(".infra/checkstyle"))
}

yamlValidator {
    searchPaths = listOf("docs")
    isSearchRecursive = true
}

jacoco {
    toolVersion = "0.8.8"
}

// Until project is created
//sonarqube {
//	// If you want to use this logcally a sonarLogin has to be provide, either via Username and Password
//	// or via token, https://docs.sonarqube.org/latest/analysis/analysis-parameters/
//	properties {
//		// Default properties if somebody wants to execute it locally
//		property("sonar.projectKey", "junit-pioneer_test-reports") // needs to be changed
//		property("sonar.organization", "junit-pioneer-xp") // needs to be changed
//		property("sonar.host.url", "https://sonarcloud.io")
//	}
//}


tasks {

    sourceSets {
        main {

        }
    }

    compileJava {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-Werror")
        options.compilerArgs.add("-Xlint:all")
    }

    compileTestJava {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-Werror")
        options.compilerArgs.add("-Xlint:all")
    }

    test {
        testLogging {
            setExceptionFormat("full")
        }
        useJUnitPlatform()
        filter {
            includeTestsMatching("*Tests")
        }
        systemProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager")

        jvmArgs(
            "-XX:+IgnoreUnrecognizedVMOptions",
            "--add-opens=java.base/java.util=ALL-UNNAMED"
        )
    }

    javadoc {
        // of all the javadoc checks (accessibility, html, missing, reference, syntax; see
        // https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html#BEJEFABE)
        // disable the warning for missing comments and tags because they spam the output
        // (it does often not make sense to comment every tag; e.g. the @return tag on annotations)
        (options as CoreJavadocOptions).addStringOption("Xdoclint:accessibility,html,syntax,reference", "-quiet")
        options.encoding = "UTF-8"
        shouldRunAfter(test)
    }

    jacocoTestReport {
        reports {
            xml.isEnabled = true
            xml.destination = file("${buildDir}/reports/jacoco/report.xml")
        }
    }

    check {
        // to find Javadoc errors early, let "javadoc" task run during "check"
        dependsOn(javadoc, validateYaml)
    }

    withType<Jar>().configureEach {
        from(projectDir) {
            include("LICENSE.md")
            into("META-INF")
        }
    }

}
