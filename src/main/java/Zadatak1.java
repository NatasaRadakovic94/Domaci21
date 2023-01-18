import com.github.javafaker.Faker;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver", "C:\\bootcamp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("https://automationexercise.com");

        driver.manage().window().maximize();

        WebElement signupLogin = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"));
        signupLogin.click();

        Faker faker = new Faker();
        WebElement nameField = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]"));
        String name = faker.name().name();
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]"));
        String email = faker.internet().emailAddress();
        emailField.sendKeys(email);

        WebElement signup = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/button"));
        signup.click();

        WebElement selectDay = driver.findElement(By.id("days"));
        Select dayOfBirth = new Select(selectDay);
        dayOfBirth.selectByIndex(5);

        WebElement selectMonth = driver.findElement(By.id("months"));
        Select month = new Select(selectMonth);
        month.selectByIndex(2);

        WebElement selectYear = driver.findElement(By.id("years"));
        Select year = new Select(selectYear);
        year.selectByIndex(30);

        WebElement title = driver.findElement(By.id("id_gender2"));
        title.click();

        WebElement specialOffers = driver.findElement(By.id("optin"));
        specialOffers.click();

        WebElement country = driver.findElement(By.id("country"));
        Select countrybutton = new Select(country);
        countrybutton.selectByVisibleText("Canada");

        WebElement passwordField = driver.findElement(By.id("password"));
        String password1 = "sifra";
        passwordField.sendKeys(password1);

        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));

        WebElement firstNameField = driver.findElement(By.id("first_name"));
        String firstName = "Ime";
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys("Prezime");

       WebElement companyField = driver.findElement(By.id("company"));
       companyField.sendKeys("Kompanija");

       WebElement addressField = driver.findElement(By.id("address1"));
       addressField.sendKeys("Neka Adresa");

       WebElement stateField = driver.findElement(By.id("state"));
       stateField.sendKeys("ABC");

       WebElement cityField = driver.findElement(By.id("city"));
       cityField.sendKeys("Grad123");

       WebElement zipField = driver.findElement(By.id("zipcode"));
       zipField.sendKeys("789");

       WebElement mobileNumberField = driver.findElement(By.id("mobile_number"));
       mobileNumberField.sendKeys("555222");

       WebElement createAccount = driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/button"));
       createAccount.click();

       WebElement continueBtn = driver.findElement(By.xpath("/html/body/section/div/div/div/div/a"));
       continueBtn.click();

       WebElement deleteAccount = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a"));
       deleteAccount.click();

       WebElement continueClick = driver.findElement(By.id("/html/body/section/div/div/div/div/a"));
       continueClick.click();

       driver.quit();

    }
}

/* URADJENO Automatizovati navodjenje na sajtu https://automationexercise.com.
   URADJENO Otici na pocetnu stranu, kliknuti na "Signup / Login.
   URADJENO Unesite u polja za "New User Signup!" pomocu faker-a - ime i email.
   URADJENO Kliknuti dugme Signup.
   URADJENO Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i "Receive special offers from our partners!".
   URADJENO Country staviti na "Canada".
   URADJENO Docekace vas ekran Account created, kliknuti "Continue".
   URADJENO ratice vas na pocetnu stranicu.
   URADJENO Za kraj kliknuti Delete Account, opet kliknuti Continue.

Waitere po potrebi dodavati. */