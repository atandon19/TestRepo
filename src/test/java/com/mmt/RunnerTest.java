package com.mmt;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features", tags = { "@MMT" },
		dryRun=false,
		format = { "pretty", "html:target/site/cucumber-report", "json:target/cucumber.json", })
public class RunnerTest {

}