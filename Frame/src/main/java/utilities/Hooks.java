//package utilities;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import World.World;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//
//public class Hooks extends World
//{
//  
//	@Before
//	public void startApp(String browser, String url) {
//        System.out.println("This will run before the Scenario");
//    	
//    	
//    		if(browser.equalsIgnoreCase("chrome")) 
//    		{
//    			System.setProperty("webdriver.chrome.driver",
//    					"./drivers/chromedriver.exe");		
//    			driver = new ChromeDriver();			
//    		}
//    		else if(browser.equalsIgnoreCase("firefox")) 
//    		{
//    			System.setProperty("webdriver.gecko.driver",
//    					"./drivers/geckodriver.exe");		
//    			driver = new FirefoxDriver();		
//    		}		
//    		driver.manage().window().maximize();
//    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    		driver.get(url);		
//    		System.out.println("The Browser "+browser+" launched Successfully");
//    		takeSnap();
//    		
//    	}
//    	
//	
//	@After
//    public void afterScenario(){
//        System.out.println("This will run after the Scenario");
//        takeSnap();
//        driver.quit();
//        
//    }
//}