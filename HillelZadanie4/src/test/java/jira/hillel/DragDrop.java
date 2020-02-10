package jira.hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragDrop {
    private String url;
    private WebDriver driver;
    private String username;
    private String password;

    @BeforeClass
    public void beforeMethod(){
        url = "https://jira.hillel.it/";
        username = "";
        password = "";
        driver = new ChromeDriver();
    }
    @Test
    public void testMethodDragAndDrop()throws InterruptedException{
        driver.get(url);
        driver.findElement(By.cssSelector("div.field-group input#login-form-username")).sendKeys(username);
        driver.findElement(By.cssSelector("div.field-group input#login-form-password")).sendKeys(password);
        driver.findElement(By.cssSelector("div.buttons input#login")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.aui-header-primary ul.aui-nav #greenhopper_menu")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a#rapidb_lnk_636_lnk")).click();
        Thread.sleep(3000);

        String beforeDrag = driver.findElement(By.cssSelector("ul.ghx-columns li:nth-child(1)")).findElement(By.cssSelector("div.js-detailview")).getAttribute("data-issue-key");
        WebElement From = driver.findElement (By.cssSelector("ul.ghx-columns li:nth-child(1) > div:nth-child(1)"));
        WebElement To = driver.findElement (By.cssSelector("ul.ghx-columns li:nth-child(2)"));
        Actions act = new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
        String afterDrag = driver.findElement(By.cssSelector("ul.ghx-columns li:nth-child(2)")).findElement(By.cssSelector("div.js-detailview.ghx-selected")).getAttribute("data-issue-key");
        Assert.assertEquals(beforeDrag,afterDrag);

    }
    @AfterClass
    public void afterMethod() {
        driver.quit();
    }
}
