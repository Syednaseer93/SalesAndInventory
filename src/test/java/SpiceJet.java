import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//select round trip
		driver.findElement(By.xpath("//div[.='round trip']")).click();
		//from
		driver.findElement(By.xpath("//div[.='From']")).click();
		WebElement from = driver.findElement(By.xpath("//div[.='From']/div/input"));
		from.sendKeys("Mumbai");
		//to
		WebElement to = driver.findElement(By.xpath("//div[.='To']/div/input"));
		to.clear();
		to.sendKeys("Delhi");


		while(true) 
		{
			WebElement monthYearWE = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));

			String monthYear=monthYearWE.getText();
			String month =monthYear.split(" ")[0];
			String year=monthYear.split(" ")[1];
			if(month.equals("June") && year.equals("2023")) {
				break;
			}
			else {
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle' and contains(@cx,'24.5')]")).click();
			}
		}
		driver.findElement(By.xpath("//div[7]/div[1]/div[3]/div[5]/div[1]/div[1]")).click();
	}
	//click date
}


