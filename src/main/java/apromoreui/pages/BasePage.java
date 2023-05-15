package apromoreui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import locators.BasePageLocators;
import util.InitiateDriver;

public class BasePage extends BasePageLocators{

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	WebDriver driver= InitiateDriver.getDriver();
	InitiateDriver id = new InitiateDriver();
	BasePageLocators bl=new BasePageLocators(driver);

	
	public SearchResultPage performSearch()
	{
		bl.inputValue.sendKeys("rego");
		bl.inputValue.sendKeys(Keys.ENTER);
		return new SearchResultPage(this.driver);
	}
}
