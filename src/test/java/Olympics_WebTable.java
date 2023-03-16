import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics_WebTable {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	//	String country = "Japan";
		List<WebElement> countryNames = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		
		for(int i=0;i<countryNames.size();i++) {
			 if(countryNames.get(i).getText().equals("Italy")) {
				 String text=countryNames.get(i).findElement(By.xpath("//div[@title='Gold']/span[@data-cy='medal-main']")).getText();
				 System.out.println(text);
			 }
		}
		
	/*	List<WebElement> medals = driver.findElements(By.xpath("//span[.='"+country+"']/../../descendant::div[@title='Gold']"));
		for(int i=0;i<countryNames.size();i++) {
			if(countryNames.get(i).getText().equals("Japan")) {
				driver.findElements(By.xpath("//span[.='"+country+"']/../../descendant::div[@title='Gold']"));
			}
			
		}*/
	}

}
