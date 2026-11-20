package com.revature;



import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

/*
    To run our Cucumber tests we can create a test runner. This is where we tell Junit and Cucumber to work together
 */

@Suite // this tells JUnit this class is used as the entry point for our test suite
@IncludeEngines("cucumber") // this tells JUnit Cucumber will be running one or more of these tests
@SelectPackages("features") // this tells JUnit where to find our tests
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.revature.steps") // this tells Cucumber where to find our glue steps
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") // this plugin makes the CLI test report much nicer to read
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:reports/cucumber-report.html") // this plugin makes Cucumber generate an HTML report
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "junit:reports/cucumber-report.xml") // this plugin makes Cucumber generate an XML report
public class CucumberRunner {}
