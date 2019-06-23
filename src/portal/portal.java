package portal;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mom
 */
import com.google.common.io.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class portal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
// Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
//Launch the some site
        String url = ("https://portal.aait.edu.et/");
        driver.get(url);
// Print a Log In message to the screen
        System.out.println("Successfully opened the website localhost");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement id = driver.findElement(By.xpath("//input[@id='UserName']"));
        id.sendKeys("ate/5164/09");

        WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
        WebDriverWait wait = new WebDriverWait(driver, 18);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("9969");
        driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/div[2]/div[2]/form/div[4]/div/button")).click();
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"ml2\"]")).click();
       

        String content = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]")).getText();

        try {
            FileWriter grade = new FileWriter("result.doc");
            grade.write(content);
            grade.close();

        } catch (IOException e) {

        }

    }
}
