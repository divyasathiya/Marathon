package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AmazonLogin {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver d = new ChromeDriver(option);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
        d.get("https://www.amazon.in/");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
        d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
        d.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
        String text = d.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(text);
        d.findElement(By.xpath("//li[@aria-label='American Tourister']//span//a//div//label//i")).click();
        d.findElement(By.xpath("//li[@aria-label='Skybags']//span//a//div//label//i")).click();
        Thread.sleep(5000);
        d.findElement(By.xpath("//span[@aria-label='Sort by:']")).click();
        d.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
        String text2 = d.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])")).getText();
        System.out.println(text2);
        System.out.println(d.findElement(By.xpath("//span[@class='a-price-whole']")).getText());
        String title = d.getTitle();
        System.out.println(title);
        Thread.sleep(2000);
        d.close();
	}

}
