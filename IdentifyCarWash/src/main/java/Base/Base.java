package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExtentReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class Base {

	//private static final String Screenshot = null;
	public static WebDriver driver;
	public static Properties prop;
	JavascriptExecutor js;
	public static WebDriverWait wait;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	// To call different browsers
	public void invokeBrowser() {
		prop = new Properties();

		try {
			prop.load(new FileInputStream(
					"src/main/java/Config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// To Open Chrome Browser
		if (prop.getProperty("browserName").matches("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\PROJECTS\\IdentifyCarWash\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
		     option.addArguments("--disable-blink-features=AutomationControlled");
		     option.addArguments("--disable-notifications");// Disabling any notifications
		        driver = new ChromeDriver(option);
		
		}

		// To Open Firefox Browser
		if (prop.getProperty("browserName").matches("firefox")) {
			driver = new FirefoxDriver();
		}

		// To maximize the Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	// To open the Main Page URL
	public void openURL(String websiteURLKey) {
		driver.get(prop.getProperty(websiteURLKey));
	}

	// Function to show the failed test cases in the report
	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
	}

	// Function to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	// Function to take Screenshot of screen
	public void Screenshoot(String fileName) throws IOException {
     	TakesScreenshot t=(TakesScreenshot)driver;
        File src=t.getScreenshotAs(OutputType.FILE);
        File dest=new File("C:\\Users\\HP\\Downloads\\Telegram Desktop\\IdentifyCarWash\\Screenshot\\"+fileName+".png");
        FileUtils.copyFile(src, dest);
	}

	// To input all data to the report
	public void endReport() {
		report.flush();
	}

	// To close the Browser
	public void closeBrowser() {
		driver.quit();
	}

}
