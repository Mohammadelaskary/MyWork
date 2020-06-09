/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zidAutomationTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




/**
 *
 * @author midom
 */
public class DataDriven {
        
   
  
    
    WebDriver driver;
    @Test 
        (dataProvider = "data")
    public void newTest(String name,String phoneNumber,String email,String password,
            String storeUsername,String storeName,String category,String decision,String destUrl) throws InterruptedException {
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.zid.sa/register");
        Registeration registeration = new Registeration(driver);
       registeration.typeName(name);
       registeration.typePhoneNumber(phoneNumber);
       registeration.typeEmail(email);
       registeration.typePassword(password);
       registeration.clickNext();
       registeration.typeStoreUsername(storeUsername);
       registeration.typeStoreName(storeName);
       registeration.selectCategory(category);
       if(decision.equals("yes"))
           registeration.clickYes();
       else
           registeration.clickNo();
       registeration.clickRegister();
       Thread.sleep(10000);
       Assert.assertEquals(driver.getCurrentUrl(), destUrl);
       driver.close();
    
    }
    
    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\midom\\Downloads\\chromedriver_win32(2)\\chromedriver.exe");
       
    }
    
    @DataProvider(name = "data")
    public static Object[][] dataSource () throws IOException, InvalidFormatException {
//  

        FileInputStream file = new FileInputStream("C:\\Users\\midom\\OneDrive\\Documents\\NetBeansProjects\\Calculator\\excel\\Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Iterator<Row>  row = sheet.iterator();
        Object [][] data = new Object[2][9];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                System.out.println(data[i][j]);
            }
        }
           

        return data;
    }
    
//    @AfterTest
//    public void afterTest(){
//        driver.quit();
//    }
    
    
        
    
}
