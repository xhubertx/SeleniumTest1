package hle.paka;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SeleniumTest
{

  private WebDriver driver;

  
@SuppressWarnings("deprecation")
@BeforeMethod
  public void beforeTest(){
      System.setProperty("webdriver.ie.driver", "D:/HLE_IntelliJ/driver/IEdriver/IEDriverServer.exe");
      DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
      caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
      driver = new InternetExplorerDriver(caps);
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
      
      button2.click();
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
