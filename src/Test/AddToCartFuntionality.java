package Test;

import ReusableMethods.Hooks;
import ReusableMethods.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddToCartFuntionality extends Hooks {

    Utilities utilities = new Utilities();

    @Test
    public void AddToCart(){

        WebDriverWait wait = new WebDriverWait(driver , 10);

        List<WebElement> itemList =new ArrayList<>();

//        try{
//            wait.until(ExpectedConditions.visibilityOfAllElements(itemList));
//        }catch (Exception e){
//
//            System.out.println(e.getMessage());
//        }

//        option 2
//        implicit wait

        do{
            itemList = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
        }while(itemList.size()==0);

        itemList.get(utilities.randomNumber(itemList.size())).click();

        By itemName = By.xpath("//h2[@class='name']");

//        waiting for item name to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));

        String itemNameStr = driver.findElement(itemName).getText();

        WebElement buttonAddToCart = driver.findElement(By.xpath("//a[text()='Add to cart']"));

        buttonAddToCart.click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        WebElement buttonCart = driver.findElement(By.id("cartur"));

        buttonCart.click();

        By itemNameInCartPage = By.xpath("//tbody//td[2]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(itemNameInCartPage));

        String itemNameCartStr = driver.findElement(itemNameInCartPage).getText();

        Assert.assertEquals(itemNameStr ,itemNameCartStr );

        WebElement buttonDelete = driver.findElement(By.xpath("//a[text()='Delete']"));

        buttonDelete.click();



        /*
            Stale element exception:
                    Element was in the page but it is not in the page anymore.

            isDisplayed
                    If the element is displayed it is returning true
                    If the element is NOT displayed it is throwing an error

         */

        boolean b1 = true;

        wait.until(ExpectedConditions.invisibilityOfElementLocated(itemNameInCartPage));

        try {
             driver.findElement(itemNameInCartPage).isDisplayed();
        }catch (Exception e){
            b1 = false;
        }

        Assert.assertFalse(b1);

    }


}
