package com.eplapp.cucumber;

import org.junit.runner.RunWith;

import com.eplapp.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")
public class EplAppRunner extends TestBase {

}
