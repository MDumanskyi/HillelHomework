package it.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class DeleteUserTest {
    private String url;
    private WebDriver driver;
    private String name;
    private String phone;

    @BeforeClass
    public void beforeMethod() {
        url = "http://37.59.228.229:3000/";
        name = "Cadaver";
        phone = "9379992";
        driver = new ChromeDriver();
    }

    @Test
    public void testMethodRemove() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.cssSelector("i.mdi-content-add")).click();
        driver.findElement(By.cssSelector("div.col.s9.main-content input#icon_prefix")).clear();
        driver.findElement(By.cssSelector("div.col.s9.main-content input#icon_prefix")).sendKeys(name);
        driver.findElement(By.cssSelector("div.col.s9.main-content input#icon_telephone.validate")).clear();
        driver.findElement(By.cssSelector("div.col.s9.main-content input#icon_telephone.validate")).sendKeys(phone);
        driver.findElement(By.cssSelector("div.col a.save-btn")).click();
        Thread.sleep(5000);

        List<WebElement> users = driver.findElements(By.cssSelector("ul#user-list li"));
        int numbUser;
        for (numbUser = 0; numbUser < users.size(); numbUser++){}
        driver.findElement(By.cssSelector("div.list li.waves-effect.waves-orange:nth-child(" + numbUser + ") a")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        List<WebElement> elements = driver.findElements(By.cssSelector("ul#user-list li"));
        boolean switcher = true;
        for (WebElement user : elements) {
            if (user.findElement(By.cssSelector("h4")).getText().equals(name)
                    && user.findElement(By.cssSelector("p")).getText().equals(phone)) {
                switcher = false;
            }
        }
        Assert.assertTrue(switcher);
    }
    @AfterClass
    public void afterMethod(){
        driver.quit();
    }

}