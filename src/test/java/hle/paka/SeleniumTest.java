package hle.paka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class SeleniumTest
{
	
  private WebDriver driver;

  @BeforeMethod
  public void beforeTest(){
      System.setProperty("webdriver.ie.driver", "D:/HLE_IntelliJ/driver/IEdriver/IEDriverServer.exe");
      driver = new InternetExplorerDriver();
      driver.navigate().to("https://zt002dcl.centrala.bzwbk/web/guest/home");
  }

  @Test
  public void typingIntoWebElementTest(){
      WebElement userName = driver.findElement(By.id("userID-value"));
      userName.sendKeys("401503");
      WebElement pass = driver.findElement(By.id("userPassword-value"));
      pass.sendKeys("test");
      //WebElement button =  driver.findElement(By.className("button"));
      //button.click();
      WebElement button2 = driver.findElement(By.xpath("//input[@class='button' and @type='button']"));
      System.out.println(button2.getTagName());
      
      button2.click();
      sleep();
      sleep();
      assertEquals("Selenium Start","Selenium Start");
  }

  @AfterTest
  public void afterTest(){
      driver.close();
      driver.quit();
  }

  private void sleep() {
      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}
