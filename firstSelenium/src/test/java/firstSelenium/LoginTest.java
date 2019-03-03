package firstSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTest {
	WebDriver driver;
	
	@Before
	public void InitTestCase() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\driver2\\chromedriver.exe");
		//Khởi tạo driver
		this.driver = new ChromeDriver();
		//Mở maiden.vn homepage
		this.driver.get("http://maiden.vn/");
		//Chờ popup show
		Thread.sleep(1000);
		//Đóng popu lại
		this.driver.findElement(By.cssSelector("a.close-tannm-modal")).click();
		//Chờ popup đóng lại
		Thread.sleep(1000);
		
		//Given: The user is staying at Login form
		WebElement btnShowLogin = this.driver.findElement(By.cssSelector("div.header-user"));
		btnShowLogin.click();
	}
	
	@After
	public void CloseTestCase()
	{
		this.driver.quit();
	}
	
	@Test
	public void Should_show_tooltip_error_with_blank_value() throws InterruptedException
	{
		//When: The user leaves username field is blank
		WebElement txtUserName = this.driver.findElement(By.cssSelector("input#inputEmail"));
		txtUserName.click();
		//And the user submit form
		WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-signin"));
		btnLogin.click();
		
		//Then: The user should show the message "Tên đăng nhâp/Email không thể để trống."
		String errorMessage = txtUserName.getAttribute("data-original-title");
		Assert.assertEquals(errorMessage, "Tên đăng nhâp/Email không thể để trống.");
		
	}
	
	@Test
	public void Should_show_popup_message_with_not_existed_user() throws InterruptedException
	{
		//When: User input not existed user
		WebElement txtUserName = this.driver.findElement(By.cssSelector("input#inputEmail"));
		txtUserName.sendKeys("khanh123456@gmail.com");
		//And Valid password value
		WebElement txtPassword = this.driver.findElement(By.cssSelector("input#inputPassword"));
		txtPassword.sendKeys("abc123@");
		//And click Login
		WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-signin"));
		btnLogin.click();
		//Then the user should see the error popup "Tên đăng nhập hoặc mật khẩu không hợp lệ. Vui lòng kiểm tra lại"
		Thread.sleep(1000);
		WebElement txtPopupText = this.driver.findElement(By.cssSelector("span.notify-text"));
		Assert.assertEquals("Tên đăng nhập hoặc mật khẩu không hợp lệ. Vui lòng kiểm tra lại", txtPopupText.getText());
	}
	
	@Test
	public void Should_show_popup_message_with_wrong_password()
	{
		
	}
	
	@Test
	public void Should_profile_with_valid_credential()
	{
		
	}
}
