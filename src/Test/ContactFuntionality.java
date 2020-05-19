package Test;

import ReusableMethods.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFuntionality extends Hooks {


    @Test
    public void Contact(){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement buttonContact = driver.findElement(By.xpath("//a[text()='Contact']"));

        buttonContact.click();

        WebElement contactEmail = driver.findElement(By.id("recipient-email"));

        wait.until(ExpectedConditions.visibilityOf(contactEmail));

        contactEmail.sendKeys("Techno");

        WebElement contactName = driver.findElement(By.id("recipient-name"));

        contactName.sendKeys("Study");

        WebElement contactMessage = driver.findElement(By.id("message-text"));

        contactMessage.sendKeys("Hello world");

        WebElement buttonSendMessage = driver.findElement(By.xpath("//button[text()='Send message']"));

        buttonSendMessage.click();

        String alertText = driver.switchTo().alert().getText();

        Assert.assertEquals(alertText,"Thanks for the message!!");

    }

}
