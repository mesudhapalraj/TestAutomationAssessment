package stepdefinition;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	static String appUnderTest = "";

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		appUnderTest = prop.getProperty("Test");
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		if (appUnderTest.contains("WEB")) {
			driverFactory = new DriverFactory();
			driver = driverFactory.init_driver(browserName);
		} else {
			System.out.println("No Need to initiate driver for API");
		}

	}

	@After(order = 0)
	public void quitBrowser() {
		if (appUnderTest.contains("WEB")) {
			driver.quit();
		} else {
			System.out.println("No Need to initiate driver for API");
		}
	}

}
