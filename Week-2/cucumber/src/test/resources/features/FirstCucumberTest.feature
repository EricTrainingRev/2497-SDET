# All Cucumber tests are facilitated by feature files. These feature files utilize Gherkin syntax (just a collection of
# key words) to control the flow of your test executions.
Feature: Example Feature
  # features can have a description added after their declaration
  The Feature is the reason for your file's existence. It is the overall user story/feature you are actually testing.
  Every test scenario you add to this file should, in theory, relate the given feature

  # Background should be used when the scenarios in your feature file all share one or more starting conditions. Those
  # shared steps to produce the starting condition are declared in the background section, and then they are the first
  # steps executed for each scenario in the file. Any one-off setup actions must go in their specific scenario
  Background:
    Given some starting condition

  # Scenarios are your actual test cases: these resources are used to determine how many tests you run for each Feature
  # file you have. If you have one Scenario you have one test case, two scenarios means 2 test caes, etc.
  Scenario: Example scenario
    # Cucumber scenarios are facilitated by their steps: these are typically mapped to acceptance criteria
    # Given is meant to indicate a starting condition, When is meant to indicate an action performed, and Then is
    # meant to indicate an achieved result, Keep in mind this meaning behind the key words is for us: Cucumber only
    # uses these key words to know that a new step has been reached
    When  one or more actions are performed
    Then  some outcome should be achieved

  # Whenever you have a scenario you need to run multiple times just changing the test data you use as inputs, you can
  # make a Scenario Outline with associated Examples data. These scenarios will run for each row of associated test
  # data you provide
  Scenario Outline: Example parameterized scenario
    # * is a useful indicator when you need to list out sub actions for a previous statement, but again, Cucumber only
    # sees it as an indicator of a new step
    # <data> tells Cucumber to inject the associated "data" into the code at runtime
    *  we use test data "<data>"
    *  the data should actually be used

  # The data you want to inject into your steps goes in an Examples table. For each row of data the associated Scenario
  # Outline will execute
  Examples:
    | data |
    | first|
    |second|