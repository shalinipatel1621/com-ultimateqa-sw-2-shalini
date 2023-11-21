package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find and click on sign in
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        //verify text 'Welcome Back'
        String expectedMessage = "Welcome Back!";
        String actualMessage = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the signIn link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");
        //invalid password
        driver.findElement(By.id("user[password]")).sendKeys("147852");
        //click on login button
        driver.findElement(By.xpath("(//button [@type='submit'])")).click();
        //verify the error message
        String expectedError = "Invalid email or password";
        String actualError = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedError, actualError);
    }

    @After
    public void tearDown() {
        closeBrowser();


    }


}
