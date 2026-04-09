package com.example.tests;


import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic03XPathCssBaiTap2 {
    //demo khi làm việc với text()
        // text()=' '
        //contains[text(),' ']
        //contains[..,'..']
        //contains[string(),'..'] như nhau
        //concat()
        // dùng and, or

    WebDriver driver;

    @BeforeClass
    public void beforeClass (){
        driver = new ChromeDriver();
    }

    @Test
    //Ví dụ text nằm ở index
    public void TC_01_ID() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//h5[@id='six' and text()='Michael Jackson']"));

    }
    //Ví dụ Text basic
    @Test
    public void TC_02_ID() throws InterruptedException {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//p[text()='Đăng ký tài khoản mới']"));
    }
    //Text nằm trực tiếp trong node cha chứa nó
    @Test
    public void TC_03_ID() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//h5[contains(text(),'Michael Jackson')]"));

    }
    //Dùng Starts-with
    @Test
    public void TC_04_ID() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//span[starts-with(text(),'Hello')]"));
    }
    //Dùng concat()
    @Test
    public void TC_05_ID() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What', \"'s happened?\")]"));

    }
    //Dùng And: chỉ A, B đều đúng thì ra đúng
    @Test
    public void TC_06_ID() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//input[@type='email' and @id='mail']"));
    }



    //Dùng or: chỉ A,B đều Sai thì ra Sai
    // ví dụ cho ra kết quả faild
    @Test
    public void TC_07_ID() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/");
        driver.findElement(By.xpath("//input[@type='password' and @id='number']"));

    }
}
