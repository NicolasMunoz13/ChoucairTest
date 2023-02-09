package SecondTestCase.Pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    WebDriver driver = null;
    String user = "9897";
    String companyName = "Company Name";
    String getSelectedText = "";

    @Given("^Create a new customer$")
    public void create_a_new_customer() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver109.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://serenity.is/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.id("LoginPanel0_Username")).clear();
        driver.findElement(By.id("LoginPanel0_Username")).sendKeys("admin");
        driver.findElement(By.id("LoginPanel0_Password")).clear();
        driver.findElement(By.id("LoginPanel0_Password")).sendKeys("serenity");

        driver.findElement(By.id("LoginPanel0_LoginButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav_menu1_2\"]/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"nav_menu1_2\"]/li[1]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[1]/a/span")));
        driver.findElement(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[1]/a/span")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div/div[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Serenity_Demo_Northwind_CustomerDialog9_CustomerID")));
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_CustomerID")).click();
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_CustomerID")).sendKeys(user);

        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_CompanyName")).click();
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_CompanyName")).sendKeys(companyName);

        driver.findElement(By.xpath("//*[@id=\"Serenity_Demo_Northwind_CustomerDialog9_Toolbar\"]/div/div/div/div[1]")).click();
    }

    @When("^Create a new order$")
    public void create_a_new_order() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[2]/a")));
        driver.findElement(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[2]/a")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div[1]/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div[1]/div[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"select2-chosen-8\"]")).click();
        driver.findElement(By.id("s2id_autogen8_search")).sendKeys(user);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-results-8\"]/li")));
        getSelectedText = driver.findElement(By.xpath("//*[@id=\"select2-results-8\"]/li")).getText();

    }

    @Then("^The new customer should be available$")
    public void the_new_customer_should_be_available() {
        System.out.println(getSelectedText);
        Assert.assertEquals("Customer found must be " + "'"+companyName + " " + "[" + user + "]" + "'", companyName + " " + "[" + user + "]", getSelectedText);
    }
}
