package qa.hsf.tool.core.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridConnectionTest {

    @Test
    public void shouldBeAbleToConnectToSeleniumGrid() throws MalformedURLException, InterruptedException {
        //Given
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "edge");
        URL url = new URL("http://192.168.100.95:4444");
        WebDriver driver = new RemoteWebDriver(url, capabilities);
        //When
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        //Then
        Thread.sleep(1000);
        driver.quit();

    }
}
