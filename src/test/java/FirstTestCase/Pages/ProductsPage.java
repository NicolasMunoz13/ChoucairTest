package FirstTestCase.Pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver = null;

    @Given("^Open products cheatsheet$")
    public void open_products_cheatsheet() {
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[3]/a")));
        driver.findElement(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[3]/a")).click();

    }

    @When("^Wait sheet to appear$")
    public void wait_sheet_to_appear() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GridDiv\"]/div[3]")));

    }

    @Then("^click on discount checkbox$")
    public void click_on_discount_checkbox() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"GridDiv\"]/div[3]/div[5]/div/div[2]/div[3]/span")));
        driver.findElement(By.xpath("//*[@id=\"GridDiv\"]/div[3]/div[5]/div/div[2]/div[3]/span")).click();
        Boolean checkboxIsSelected= driver.findElement(By.xpath("//*[@id=\"GridDiv\"]/div[3]/div[5]/div/div[2]/div[3]/span")).isSelected();
        Assert.assertTrue("Checkbox is not enable. it should be on edit mode", checkboxIsSelected);
    }

}