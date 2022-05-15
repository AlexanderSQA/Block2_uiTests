package com.otus;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/com/otus/courseCategory.feature",
    glue= {"com.otus.steps"})
public class Runner_Test {
}
