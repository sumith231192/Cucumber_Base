package World;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class World implements BeforeWorld

{
	 private static final int TIMEOUT = 5;
	    private static final int POLLING = 100;

	    protected WebDriver driver;
	    private WebDriverWait wait;
//RemoteWebDriver driver;
	
	
	
	//For snapshot name 
//	
//	@Override
//	public void startApp(String browser, String url) {
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"./drivers/chromedriver.exe");		
//			driver = new ChromeDriver();			
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"./drivers/geckodriver.exe");		
//			driver = new FirefoxDriver();		
//		}		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get(url);		
//		System.out.println("The Browser "+browser+" launched Successfully");
//		takeSnap();
//		
//	}
//		

	    public void BasePage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	    }

	    protected void waitForElementToAppear(By locator) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    protected void waitForElementToDisappear(By locator) {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }

	    protected void waitForTextToDisappear(By locator, String text) {
	        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
	    }
	

//	@Override
//	public WebElement locateElement(String locator, String locValue) {
//		
//		switch(locator) {		
//		case "id": return driver.findElementById(locValue);
//		case "name": return driver.findElementByName(locValue);
//		case "link": return driver.findElementByLinkText(locValue);
//		case "class": return driver.findElementByClassName(locValue);
//		case "xpath": return driver.findElementByXPath(locValue);		
//		}		
//		return null;
//	}

//	@Override
//	public WebElement locateElement(String locValue) {
//		return driver.findElementById(locValue);	
//	}

	@Override
	public void type(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);
		System.out.println("The Element "+ele+" is entered with "+data);		
		takeSnap();
	}

	@Override
	public void click(WebElement ele) {
		ele.click();
		System.out.println("The Element "+ele+" is clicked");
		takeSnap();
	}

	@Override
	public void clickWithoutSnap(WebElement ele) {
		// TODO Auto-generated method stub
		ele.click();
		System.out.println("The Element "+ele+" is clicked");
	}

	@Override
	public String getText(WebElement ele) {
		String text=ele.getText();
		System.out.println("The element "+text+"text retreieved");
		return text;
		
		
		
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select element =new Select(ele);
		element.selectByVisibleText(value);
		System.out.println("Select Value from"+ele+"from visible text"+value);
		takeSnap();
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select element =new Select(ele);
		element.selectByIndex(index);
		System.out.println("Selected Value from"+ele+"from index"+index);
		takeSnap();
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		String actualtitle=driver.getTitle();
		if(actualtitle.equals(expectedTitle))
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated methodD
		String actualText = ele.getText();
		if(actualText.equals(expectedText))
		{
			System.out.println("Actual and Expected Text Matched");
		}
		else
		{
			System.out.println("Actual and Expected Text not Matched");
		}
		
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String partialtext= ele.getText();
		if(partialtext.contains(expectedText))
		{
			System.out.println("Partial Text matched");
		}
		else
		{
			System.out.println("Partial Text not matched");
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		String attributevalue=ele.getAttribute(attribute);
		if (attributevalue.equals(value))
		{
			System.out.println("Attirbute Matched");
		}
		else
		{
			System.out.println("Attirbute didnot Match"); 
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		String attributepvalue=ele.getAttribute(attribute);
		if (attributepvalue.contains(value))
		{
			System.out.println("partial Attirbute Matched");
		}
		else
		{
			System.out.println("partial Attirbute didnot Match"); 
		}
	}
	

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		ele.isSelected();
		System.out.println("Element"+ele+"selected");
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		ele.isDisplayed();
		System.out.println("Element"+ele+"displayed");

	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		
		Set <String> allwin = driver.getWindowHandles();
		List <String> list = new ArrayList<String>();
		list.addAll(allwin);
		driver.switchTo().window(list.get(index));
		
	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(ele);
	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		String alerttext = driver.switchTo().alert().getText();
		return alerttext;
	}

	@Override
	public void takeSnap() {
		int i=1;
		// TODO Auto-generated method stub
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des =new File("./snapshot/img"+i+".png");
		try {
			FileUtils.copyFile(src,des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	public String getAttributetext(WebElement ele, String value)
	{
		String attribute = ele.getAttribute(value);
	
		return attribute;
	}




	@Override
	public WebElement locateElement(String locator, String locValue) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startApp(String browser, String url) {
		// TODO Auto-generated method stub
		
	}

}