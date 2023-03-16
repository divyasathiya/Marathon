package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver d = new ChromeDriver(option);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        d.get("https://in.bookmyshow.com/");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Hyderabad");
        d.findElement(By.xpath("//strong[text()='Hyderabad']")).click();
        String url = d.getCurrentUrl();
        System.out.println(url);
        Thread.sleep(2000);
        if (url.contains("hyderabad")) {
			
        	System.out.println("Yes, Hyderabad is present");
        	} 
        else {
        	System.out.println("No, Hyderabad is not present");
		}
		d.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
		d.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Sir");
		d.findElement(By.xpath("//span[@class='sc-jhaWeW ChCae']")).click();
		d.findElement(By.xpath("//div[@class='styles__CtaText-sc-1vmod7e-2 bBLrVT']")).click();
		System.out.println(d.findElement(By.xpath("//a[contains(text(),'Alankar (Pratap Theatre): Langer House')]")).getText());
		d.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
		String text = d.findElement(By.xpath("(//div[@class='venue-facility-item'])[2]")).getText();
		System.out.println(text);
		if (text.contains("Parking Facility")) {
			System.out.println("Yes, Parking facility is available");
		} else {
			System.out.println("No parking facility available");
		}
		Thread.sleep(3000);
        d.findElement(By.xpath("//div[@class='cross-container']")).click();
        d.findElement(By.xpath("(//div[@class='showtime-pill-container _available'])[1]//div[@class='__details']")).click();
        d.findElement(By.xpath("//ul[@id='popQty']/li[1]")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
        d.findElement(By.xpath("//a[@class='_available']")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("//a[@id='btmcntbook' and @class='bar-btn _primary']")).click();
        Thread.sleep(2000);
        String str = d.findElement(By.xpath("//span[@class='__sub-total']")).getText();
        System.out.println("Sub Total: " + str);
        d.close();
	}

}
