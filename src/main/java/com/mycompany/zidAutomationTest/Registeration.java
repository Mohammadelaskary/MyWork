/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zidAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author midom
 */


public class Registeration {

    WebDriver driver;
    By name = By.id("name");
    By phoneNumber = By.id("mobile");
    By email = By.id("registration_email");
    By password = By.id("registration_password");
    By next = By.xpath("/html/body/div/div[1]/div[1]/div[3]/div[1]/form/div/div/div/div[1]/div/div/div[5]/button");
    By storeUsername = By.id("store_username");
    By storeName = By.id("store_name");
    By category = By.id("store_category_id");
    By yes = By.xpath("/html/body/div/div[1]/div[1]/div[3]/div[1]/form/div/div/div/div[2]/div/div/div[5]/div/label[1]");
    By no = By.xpath("/html/body/div/div[1]/div[1]/div[3]/div[1]/form/div/div/div/div[2]/div/div/div[5]/div/label[2]");
    By register = By.xpath("/html/body/div/div[1]/div[1]/div[3]/div[1]/form/div/div/div/div[2]/div/div/div[7]/div/button");


    public Registeration(WebDriver driver) {
        this.driver = driver;
    }
    
    public void typeName(String name){
        driver.findElement(this.name).sendKeys(name);
    }
    public void typePhoneNumber(String phoneNumber){
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
    }
    public void typeEmail(String email){
        driver.findElement(this.email).sendKeys(email);
    }
    public void typePassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }
    public void clickNext(){
        driver.findElement(this.next).click();
    }
    public void typeStoreUsername(String storeUsername){
        driver.findElement(this.storeUsername).sendKeys(storeUsername);
    }
    public void typeStoreName(String storeName){
        driver.findElement(this.storeName).sendKeys(storeName);
    }
    public void selectCategory(String i){
        Select select = new Select(driver.findElement(this.category));
        select.selectByVisibleText(i);
    }
    public void clickYes(){
        driver.findElement(this.yes).click();
    }
    public void clickNo(){
        driver.findElement(this.no).click();
    }
    public void clickRegister(){
        driver.findElement(this.register).click();
    }
    
    
    
    
}
