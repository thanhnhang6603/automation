package com.example.tests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Topic03XPathCssBaiTap1 {
    static WebDriver driver;



    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
    }

    @Test
    void Register_TC_01_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        // JUnit 5: expected trước, actual sau
        Assertions.assertEquals("Vui lòng nhập họ tên",
                driver.findElement(By.id("txtFirstname-error")).getText());
    }

    @Test
    public void Register_TC_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Anna Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("123@345@789");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@345@789");
        driver.findElement(By.id("txtPassword")).sendKeys("annanguyen");
        driver.findElement(By.id("txtCPassword")).sendKeys("annanguyen");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
        driver.findElement(By.id("chkRight")).click();

        driver.findElement(By.xpath("//button[@type='submit']"));

        //Assertions, JUnit 5: expected trước, actual sau
        Assertions.assertEquals("Vui lòng nhập email hợp lệ",driver.findElement(By.id("txtEmail-error")).getText());
        //Email nhập lại không đúng: theo requirement
        Assertions.assertEquals("Email nhập lại không đúng",driver.findElement(By.id("txtCEmail-error")).getText());


    }

    @Test
    public void Register_TC_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Anna Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("annanguyen123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("annanguyen");
        driver.findElement(By.id("txtCPassword")).sendKeys("annanguyen");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
        driver.findElement(By.id("chkRight")).click();

        //Assertions, JUnit 5: expected trước, actual sau
        //Email nhập lại không đúng: theo requirement
        Assertions.assertEquals("Email nhập lại không đúng",driver.findElement(By.id("txtCEmail-error")).getText());
    }
    @Test
    public void Register_TC_04_Incorrect_Password_LESS_THAN_6_Characters() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Anna Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("anna");
        driver.findElement(By.id("txtCPassword")).sendKeys("anna");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
        driver.findElement(By.id("chkRight")).click();

        //Assertions, JUnit 5: expected trước, actual sau
        Assertions.assertEquals("Mật khẩu phải có ít nhất 6 ký tự",driver.findElement(By.id("txtPassword-error")).getText());
        //Email nhập lại không đúng: theo requirement
        Assertions.assertEquals("Mật khẩu phải có ít nhất 6 ký tự",driver.findElement(By.id("txtCPassword-error")).getText());
    }
    @Test
    public void Register_TC_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Anna Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("annanguyen");
        driver.findElement(By.id("txtCPassword")).sendKeys("annanguyen12");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
        driver.findElement(By.id("chkRight")).click();

        //Assertions, JUnit 5: expected trước, actual sau
        Assertions.assertEquals("Mật khẩu bạn nhập không khớp",
                driver.findElement(By.id("txtCPassword-error")).getText());
    }

    @Test
    public void Register_TC_06_Invalid_Phone_Number () {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Anna Nguyen");
        driver.findElement(By.id("txtEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("annanguyen12@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("annanguyen");
        driver.findElement(By.id("txtCPassword")).sendKeys("annanguyen12");
        driver.findElement(By.id("txtPhone")).sendKeys("098765432111");


        // >11 numbers
        driver.findElement(By.id("txtPhone")).sendKeys("098765432111");
        driver.findElement(By.id("chkRight")).click();
        Assertions.assertEquals("Số điện thoại phải từ 10-11 số.",
                driver.findElement(By.id("txtPhone-error")).getText());

        //<10 numbers
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("09876541");
        driver.findElement(By.id("chkRight")).click();
        Assertions.assertEquals("Số điện thoại phải từ 10-11 số.",
                driver.findElement(By.id("txtPhone-error")).getText());


        // No Start with 09 07
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("568235499876541");
        driver.findElement(By.id("chkRight")).click();
        Assertions.assertEquals("Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08",
                driver.findElement(By.id("txtPhone-error")).getText());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
