package UI;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTest {

    public WebDriver driver;


    @BeforeClass
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void checkTextBox(){

        driver.get("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("Stepan");

        WebElement userEmailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmailInput.sendKeys("test@ya.ru");

        WebElement currentAdressTextArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAdressTextArea.sendKeys("NN");

        WebElement permanentAdressTextArea = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdressTextArea.sendKeys("NN");


        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", buttonSubmit);
        buttonSubmit.click();

        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));

        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));

        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));

        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String currAddress = currentAddressOutput.getText();
        String permAddress = permanentAddressOutput.getText();

        System.out.println("Name : " + name + " , email : " + email + " , current Address : "
                + currAddress + " , permanent Adress : " + permAddress);

//        Assert.assertTrue(name.contains("Stepan"), "Message");

//        Assert.assertEquals(email, "email");


//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException((e));
//        }

    }

    @Test
    public void checkTitleTextBox(){

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
}
