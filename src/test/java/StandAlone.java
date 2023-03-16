import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.name("user")).sendKeys("unguardable");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		driver.switchTo().alert().accept();
		WebElement employeeModule=driver.findElement(By.xpath("//span[.='Employee']"));
		//wait.until(ExpectedConditions.elementToBeClickable(employeeModule));
		
		//employeeModule.click();
		
		driver.findElement(By.xpath("//a/i[@class='fas fa-fw fa-plus']")).click();
		WebElement addEmployee=driver.findElement(By.xpath("//h5[.='Add Employee']"));
		WebElement firstName=driver.findElement(By.name("firstname"));
		//wait.until(ExpectedConditions.elementToBeClickable(firstName));
		//Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@name='firstname'])[3]")).sendKeys("Syed");
		driver.findElement(By.name("lastname")).sendKeys("Naseer");
		
		Select gender = new Select(driver.findElement(By.xpath("//option[.='Select Gender']")));
		gender.selectByVisibleText("Male");
		
		

		
	}
}