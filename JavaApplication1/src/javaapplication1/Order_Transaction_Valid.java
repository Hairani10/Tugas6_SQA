
package javaapplication1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order_Transaction_Valid {
    
      public static void main(String[] args) {
       
         // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Saucedemo login page
        driver.get("https://www.saucedemo.com/");

        // Login
        loginToSauceDemo(driver, "standard_user", "secret_sauce");

        // Select a product
        selectProduct(driver);

        // Proceed to checkout
        proceedToCheckout(driver);

        // Complete the order
        completeOrder(driver);

        // Close the WebDriver
       // driver.quit();
    }

    private static void loginToSauceDemo(WebDriver driver, String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    private static void selectProduct(WebDriver driver) {
        WebElement product = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button"));
        product.click();
    }

    private static void proceedToCheckout(WebDriver driver) {
        WebElement cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout_button"));
        checkoutButton.click();
    }

    private static void completeOrder(WebDriver driver) {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit']"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        zipCodeField.sendKeys("12345");
        continueButton.click();

        WebElement finishButton = driver.findElement(By.cssSelector(".cart_button"));
        finishButton.click();
    }
}
