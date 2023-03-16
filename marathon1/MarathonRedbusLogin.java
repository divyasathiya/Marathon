package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MarathonRedbusLogin {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("src")).sendKeys("Chennai");
        driver.findElement(By.xpath("//li[@class='selected']")).click();
        driver.findElement(By.id("dest")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//li[@class='selected']")).click();
        driver.findElement(By.id("onward_cal")).click();
        driver.findElement(By.xpath("//td[@class='wd day']")).click();
        driver.findElement(By.id("search_btn")).click();
        String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        System.out.println(text);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='close-primo']")).click();
        WebElement clickButton = driver.findElement(By.xpath("//label[text()='SLEEPER']"));
        driver.executeScript("arguments[0].click()", clickButton);
        String text4 = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        System.out.println(text4);
        String text2 = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
        System.out.println(text2);
        String text3 = driver.getTitle();
        System.out.println(text3);
        driver.close();
	}

}
