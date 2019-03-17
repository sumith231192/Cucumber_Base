package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			
			features = "C:\\Users\\Sumith\\Classroomeclipse-workspace\\Frame\\src\\main\\java\\Feature",
//			features = "src/main/java/Feature",
			glue = {"Stepdef"},
			monochrome = true, //display the console output in a proper readable format
			strict = true, //it will check if any step is not defined in step definition file
			dryRun = false //to check the mapping is proper between feature file and step def file
			//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}	
			)
	

public class TestRunner {

}
//https://www.youtube.com/watch?v=vHzMJuc9Zuk