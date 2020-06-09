package com.mycompany.zidAutomationTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author midom
 */
public class PageObject {

    WebDriver driver;

    @Test
    public void verifyValidRegisteration() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.zid.sa/register");
        Registeration registeration = new Registeration(driver);
        registeration.typeName("mohammad elaskary");
        registeration.typePhoneNumber("0112228855");
        registeration.typeEmail("khjfkasdadsbdf@yahoo.com");
        registeration.typePassword("123456789");
        registeration.clickNext();
        registeration.typeStoreUsername("samehelnabawytestcase");
        registeration.typeStoreName("سامح");
        registeration.selectCategory("ألعاب");
        registeration.clickYes();
        registeration.clickRegister();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://web.zid.sa/home");
        driver.close();
    }
    @Test
    public void verifyInvalidRegisteration() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.zid.sa/register");
        Registeration registeration = new Registeration(driver);
        registeration.typeName("mohammad elaskary");
        registeration.typePhoneNumber("0112228855");
        registeration.typeEmail("khjfkasdadsbdf");
        registeration.typePassword("123456789");
        registeration.clickNext();
        registeration.typeStoreUsername("samehelnabawytestcase");
        registeration.typeStoreName("سامح");
        registeration.selectCategory("ألعاب");
        registeration.clickYes();
        registeration.clickRegister();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://web.zid.sa/register");
                driver.close();

    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\midom\\Downloads\\chromedriver_win32(2)\\chromedriver.exe");
       
    }

    @AfterTest
    public void afterTest() {
         driver.quit();
    }
}
