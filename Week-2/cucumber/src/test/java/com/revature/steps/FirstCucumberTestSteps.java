package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.en.*;

public class FirstCucumberTestSteps {

    /*
        Cucumber uses annotations to map code execution with the steps of a scenario in a feature file. This code is
        called "glue" code, the methods inside "glue steps". Something to keep in mind: the key word of the glue
        annotation does not need to match the key word used in the feature file.
     */

    @Given("some starting condition")
    public void thisCan() {
        System.out.println("Given statement executed");
    }
    @When("one or more actions are performed")
    public void beCalled() {
        System.out.println("When statement executed");
    }
    @Then("some outcome should be achieved")
    public void whatever() {
        System.out.println("Then statement executed");
    }

    // Note we are using "Given" here for the * steps in the feature file

    // to tell Cucumber we are parameterizing the step we replace the parameter placeholder from the feature step text with
    // {} and an indicator for the type of data that is being injected. String will be very common, but there are other
    // supported types as well
    @Given("we use test data {string}")
    public void we_use_test_data_second(String data) {
        System.out.println("We injected the following data into our step: " + data);
    }
    @Given("the data should actually be used")
    public void the_data_should_actually_be_used() {
        System.out.println("Second given statement executed");
    }

}
