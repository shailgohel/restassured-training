package Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(features = {"features"},
glue = "stepdef",
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"})

public class TestRunner {



}
