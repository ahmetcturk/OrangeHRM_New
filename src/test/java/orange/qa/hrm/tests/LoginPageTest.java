package orange.qa.hrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.Constants;
import com.qa.orangehrm.util.Credentials;

@Listeners({com.qa.orangehrm.listeners.ExtentReportListener.class})

public class LoginPageTest extends BasePage{
	
	// fields, driver, properties, basepageObj, LoginpageObj, 
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	Credentials cred;
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		cred = new Credentials(properties.getProperty("username")
				, properties.getProperty("password"));
	}
	
	@Test(priority = 1, description = "Check login page title")
	public void verifyTitle(){
		
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE.concat("!"));
	}
	
	@Test(priority = 2, description = "Verify login with correct credentials")
	public void loginTest(){
		loginPage.doLogin(cred.getUsername(),
				cred.getPassword());
	}
	
	@Test(priority = 3, description = "Verify login with incorrect credentials")
	public void loginTest2(){
		loginPage.doLogin(cred.getUsername(),
				cred.getPassword());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	
}
