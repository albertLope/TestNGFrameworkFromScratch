package ReusableMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Hooks {

    /*
    Before and after method

     */

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser){

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");

            driver = new ChromeDriver();

        }else if(browser.equals("firefox")){

//            https://github.com/mozilla/geckodriver/releases
            System.setProperty("webdriver.gecko.driver", "D:\\Selenium dependency\\drivers\\geckodriver.exe");

            driver = new FirefoxDriver();

        }

        driver.get("https://www.demoblaze.com/index.html");

        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

//       Will add Firefox driver

    }

    @AfterMethod
    public void afterMethod(){

        driver.quit();

    }
}
