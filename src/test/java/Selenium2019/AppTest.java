package Selenium2019;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    /*
     * WebDriver là một Interface cung cấp bởi thư viện Selenium, bao gồm các method
     * cho phép chúng ta xây dựng các testscript tương tác với webpage
     */
    /*
     * WebDriver là interface nên không có khả năng tạo object. Sử dụng các driver 
     * tương ứng với từng trình duyệt để tạo driver thao tác với trình duyệt đó.
     */
    @Test
    @Ignore
    public void shouldAnswerWithTrue()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\driver2\\chromedriver.exe");
    	//Mở chrome
    	this.driver = new ChromeDriver();
    	//this.driver.get("http://www.google.com.vn/");
    	
        
        //Given
        //The User is staying at google.com.vn
        this.driver.get("http://www.google.com.vn/");
        //this.driver.manage().window().maximize();
        this.driver.manage().window().fullscreen();
        Dimension size = new Dimension(500,500);
        this.driver.manage().window().setSize(size);
        
        this.driver.navigate().refresh();
        
        List<WebElement> lstReulst = this.driver.findElements(By.cssSelector("li.product-item"));
        Assert.assertEquals(lstReulst.size(), 20);
        
        boolean isContain = true;
        for(WebElement hehe: lstReulst)
        {
        	if(!hehe.getText().toLowerCase().contains("giấy"))
        	{
        		isContain=false;
        		break;
        	}
        }
        
        
        Assert.assertEquals(isContain, true);
        
        //When
        //The User input "Testmaster.vn" keyword into Searchbox
        //WebElement txtSearchBox = this.driver.findElement(By.cssSelector(""));
        //txtSearchBox.sendKeys("Testmaster.vn");
        //After that the User press Enter
        //txtSearchBox.sendKeys(Keys.ENTER);
        
        WebElement lnkGmail = this.driver.findElement(By.linkText("Gmail"));
        lnkGmail.click();
        
        //Then
        //The User should see the text "Testmaster.vn: Trung tâm đào tạo Tester, Học automation test ở Hà nội"
        //on result page
        //WebElement lbResult = this.driver.findElement(By.cssSelector("h3:contains('Testmaster.vn: Trung tâm đào tạo Tester, Học automation test ở Hà nội')"));
        //Assert.assertEquals(lbResult!=null, true);
        String webTitle = this.driver.getTitle();
        Assert.assertEquals(webTitle, "Gmail");
        
        this.driver.close();
    }
    
    @Test
    public void TestSearchMaiden()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\driver2\\chromedriver.exe");
    	//Mở chrome
    	this.driver = new ChromeDriver();
    	//this.driver.get("http://www.google.com.vn/");
    	
        
        //Given
        //The User is staying at google.com.vn
        this.driver.get("http://www.maiden.vn/");
        
        //When
        WebElement txtSearchBox = this.driver.findElement(By.cssSelector("input#txtSearchInput"));
        txtSearchBox.sendKeys("giấy");
        txtSearchBox.sendKeys(Keys.ENTER);
        
    	 List<WebElement> lstReulst = this.driver.findElements(By.cssSelector("li.product-item"));
         Assert.assertEquals(lstReulst.size(), 20);
         
         boolean isContain = true;
         for(WebElement hehe: lstReulst)
         {
         	if(!hehe.getText().toLowerCase().contains("giấy"))
         	{
         		isContain=false;
         		break;
         	}
         }
         
         
         Assert.assertEquals(isContain, true);
    }
}
