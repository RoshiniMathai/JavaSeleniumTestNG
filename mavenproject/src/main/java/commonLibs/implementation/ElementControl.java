package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {

	WebDriver driver;
	
	public ElementControl(WebDriver driver) {
		this.driver = driver;
	}
	
	//Wrapper methods
	//Click element
	public void clickElement(WebElement element) {
		element.click();
	}
	
	//SendKeys 
	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	//Clear text
	public void clear(WebElement element) {
		element.clear();
	}
	
	//IsDisplyed
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	//IsEnabled
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	//Accept alert
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	//GetText from alert
	public void getTextFromAlert() {
		driver.switchTo().alert().getText();
	}
	//Select from drop down with visible text
	public void selectViaVisibleText(WebElement element, String text) {
		Select selDropdown = new Select(element);
		selDropdown.selectByVisibleText(text);
	}
}
