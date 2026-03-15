
package com.example.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic_02_Selenium_Locator {
    static WebDriver driver;

    @BeforeAll
    public static void initialBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);
    }
    @Test
    public void TC_02_CLass() throws InterruptedException {
        //Nó ko lấy toàn bộ giá trị nếu có khoảng trắng
        driver.findElement(By.className("register-next-step-button")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Name() throws InterruptedException {
        driver.findElement(By.name("customerCurrency")).click();
        Thread.sleep(3000);
    }
    @Test
    public void TC_04_LinkText() throws InterruptedException {
        // chỉ làm việc với element là link, thẻ a và có thuộc tính là href
        //phải lấy tòan bộ text ko chừa cái nào hết (tuyệt đối)
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
        driver.findElement(By.linkText("Shopping cart"));

    }
    @Test
    public void TC_05_Partial_Link_Text() {
        //Chỉ làm việc với element là link
        //có thể lấy toàn bộ text hoặc 1 phần  (hay dùng)
        driver.findElement(By.partialLinkText("Digital downloads"));
    }
    @Test
    public void TC_06_tagname() {
        // tên thẻ html
        // tìm tất cả các element giống nhau(thẻ của component giống nhau)
        // tìm tất các textbox/ radio/ checkbox/ link/ button
        driver.findElements(By.tagName("button"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("label"));
    }
    @Test
    public void TC_07_css(){
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));


        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));

        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));


    }

    @Test
    public void TC_08_XPath(){
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));


    }
    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}


