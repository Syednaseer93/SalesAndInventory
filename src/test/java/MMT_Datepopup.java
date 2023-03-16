import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_Datepopup {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// close noti popup
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();

		// from
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		WebElement from = driver.findElement(By.xpath("//label[@for='fromCity']"));
		from.click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();

		// to
		WebElement to = driver.findElement(By.xpath("//label[@for='toCity']"));
		to.click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//p[.='New Delhi, India']")).click();

		// Mon Mar 13 18:55:30 IST 2023
		//// div[@aria-label='Thu Apr 20 2023']
		Date date = new Date();
		String[] d = date.toString().split(" ");
		String dayWord = d[0];
		String month = d[1];
		String dateNum = d[2];
		String year = d[5];

		// select date
		driver.findElement(By.xpath("//div[@aria-label='"+dayWord+" " +month+ " "+dateNum+" "+year+"']")).click();

		// return date
		// Tue Apr 25 2023
		String rDayWord = "Mon";
		String rMonth = "Sep";
		String rDateNum = "11";
		String rYear = "2023";
		String returnDate = "";

		for(; ;) { 
			try {
				driver.findElement(By.xpath("//div[@aria-label='"+rDayWord+" "+rMonth+" "+rDateNum+" "+rYear+"']")).click(); 
				break; 
			} catch(Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}

		}
		//click on travellers
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		
		driver.findElement(By.xpath("//li[@data-cy='adults-7']")).click();
		driver.findElement(By.xpath("//button[@class='primaryBtn btnApply pushRight']")).click();
		
	}

}
