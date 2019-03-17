package Stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Page.Login_page;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Login_page

{
	public WebDriver driver;
	
//	 WebDriver driver;
	

	@Given("^The user users '\"([^\"]*)\"' browser to log in to '\"([^\"]*)\"'$")
public void the_user_users_browser_to_log_in_to(String arg1, String arg2) throws Throwable {
	String browser = arg1;
	String url = arg2;
	System.out.println(browser);
	if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--enable-automation");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.get(url);	
	}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"./drivers/geckodriver.exe");		
			driver = new FirefoxDriver();		
	}	
	
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	driver.get(url);		
//	System.out.println("The Browser "+browser+" launched Successfully");
	takeSnap();
		
		
	    throw new PendingException();
	}
	
	
	
	@When("^The user try to enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_try_to_enter_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User try to log in the  his gmail id$")
	public void user_try_to_log_in_the_his_gmail_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The user should be able to log in to the web page$")
	public void the_user_should_be_able_to_log_in_to_the_web_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
