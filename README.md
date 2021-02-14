# Pioneer test reports
Providing additional test reports for JUnit Jupiter and its extensions.

This is a side project of [JUnit Pioneers](https://junit-pioneer.org/) extension pack.
Check out [junit-pioneer.org](http://junit-pioneer.org), particularly [the documentation section](http://junit-pioneer.org/docs).

If you are interested, there are several ways [how you can contribute](https://github.com/junit-pioneer/junit-pioneer/blob/master/CONTRIBUTING.md).

## Usage
As this is early development there's not deployment to Maven's central repository yet.
This said, you have to download the repo, build the project and install it into your local repository.

After that you can add the dependency to your POM:

```xml
<dependency>
	<groupId>org.junit-pioneer</groupId>
	<artifactId>test-reports</artifactId>
	<version><!--...--></version>
	<scope>test</scope>
</dependency>
```

For Gradle:

```groovy
testCompile group: 'org.junit-pioneer', name: 'test-reports', version: /*...*/
```