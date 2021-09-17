package steps;

import base.PageInitiliazer;

import io.cucumber.java.*;

import io.cucumber.java.Scenario;

import utils.CommonMethods;

public class Hooks extends CommonMethods {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting scenario" + scenario.getName());
		setUp();
		PageInitiliazer.initializeAllPage();
	}

	@After
	public void end(Scenario scenario) {
		System.out.println("Ending scenario" + scenario.getName());
//		if (scenario.isFailed()) {
//			byte[] picture = takeScreenshot("/failed/" + scenario.getName());
//			scenario.attach(picture, "image/png", null);
//		}else {
//			byte[] picture = takeScreenshot("/passed/"+scenario.getName());
//		scenario.attach(picture, "image/png", null );
//		}

		tearDown();
		}
	}

