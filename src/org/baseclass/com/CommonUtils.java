package org.baseclass.com;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	
	
	public static WebDriver google = null;
	
	public static void browserLaunch(String key) {
		
		switch(key) {
		
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", "./Sources/chromedriver.exe");
			google = new ChromeDriver();
			break;
		
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./Sources/geckodriver.exe");
			google = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./Sources/msedgedriver.exe");
			google = new EdgeDriver();
			break;
			
		default :
			System.out.println("The given browser is not find. please update correct browser name");
			break;
		}
	}
		
	public static void openUrl(String url) {
		google.get(url);
	}
	
	public static void fullscreenView() {
		google.manage().window().maximize();
	}
	
	
	public static WebElement FindingElement(By locator) {
		return google.findElement(locator);
	}
	
	public static By locatebyId(String element) {
		return By.id(element);
	}
	
	public static By locatebyName(String element) {
		return By.name(element);
	}
	
	public static By locatebyclassName(String element) {
		return By.className(element);
	}
	
	public static By locatebyXpath(String input) {
		return By.xpath(input);
	}
	
	public static void typeValue(WebElement element, String input) {
		try {
		element.sendKeys(input);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clickValueof(WebElement element) {
		try {
			element.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	public static WebElement selectOptionbyValue(WebElement element, String input) {
		
		Select s = new Select(element);
		s.selectByValue(input);
		return element;	
	}
	
	public static WebElement selectOptionbyIndex(WebElement element, int input) {
		try {
		Select s= new Select(element);
		s.selectByIndex(input);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return element;
	}
	
	public static String textValue(WebElement element) {
		return element.getText();
		
	}
	
	public static WebDriverWait browserWait(long number) {
		
		WebDriverWait explicitwait = null;
		
		try {
		explicitwait = new WebDriverWait(google, number);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return explicitwait;
	}
	
	public static WebElement jselementClick(String element) {
		
		WebElement elem = null;
		try {
		JavascriptExecutor js= (JavascriptExecutor)google;
		Object executorscript = js.executeScript(element);
		elem = (WebElement)executorscript;
		elem.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return elem;	
	}
	
	
	public static WebElement jselementFinder(String element) {
		
		WebElement ele = null;
		
		try {
		JavascriptExecutor js = (JavascriptExecutor)google;
		Object executorExecutor = js.executeScript(element);
		ele = (WebElement)executorExecutor;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ele;
		
	}
	
	public static WebElement movetoHover(WebElement element) {
		
		Actions acc = new Actions(google);
		acc.moveToElement(element).build().perform();
		return element;
		
	}
	
	public static void browserClose() {
		google.quit();
	}
	
	
}
