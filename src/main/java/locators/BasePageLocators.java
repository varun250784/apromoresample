package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePageLocators {
	
	WebDriver driver;
	
	public BasePageLocators(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}


@FindBy(how = How.CSS, using = "div#homeautosuggestbRMEfYbmp6c>input")
@CacheLookup
public WebElement inputValue;

}
