package uitests;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apromoreui.pages.BasePage;
import apromoreui.pages.SearchResultPage;
import util.InitiateDriver;
import util.Utility;


public class ImageCompareTests {

	Utility ut = new Utility();
	BasePage bp;
	SearchResultPage sp;
	 
private WebDriver driver;
	@BeforeTest
	public void initDriver() throws Exception {
		InitiateDriver.setDriver();
		driver = InitiateDriver.getDriver();
		driver.get("https://www.service.nsw.gov.au/");
		driver.manage().window().maximize();
	}

	@Test
	public void comparisonTests () throws IOException {
		bp = new BasePage(this.driver);
		File freshFile = ut.takeScreesnshot(driver);
		File sampleFile1 = new File(System.getProperty("user.dir")  + File.separator + "src" + File.separator
				 +"test" + File.separator+"resources" + File.separator+"images"+ File.separator+"img1.png");
		
		Assert.assertEquals(true,ut.provideComparisonResult(freshFile, sampleFile1));

		System.out.println("Homepage screenshot compared successfully");
		sp=bp.performSearch();
		freshFile = ut.takeScreesnshot(driver);
		File sampleFile2 = new File(System.getProperty("user.dir")  + File.separator + "src" + File.separator
				 +"test" + File.separator+"resources" + File.separator+"images"+ File.separator+"img2.png");
		Assert.assertEquals(true,ut.provideComparisonResult(freshFile, sampleFile2));

		System.out.println("search result page screenshot compared successfully");
		
		//Negative Test Expected to fail
		
		Assert.assertEquals(true,ut.provideComparisonResult(sampleFile1, freshFile));
		
	}

	@AfterTest
	public void tearDown() {
	 driver.quit();
	}

	}
