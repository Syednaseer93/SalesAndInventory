import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGYantra_CreateProject extends LoginWithExcelData {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("usernmae")).sendKeys(getCellData("Sheet1","./data/rmgy.xlsx",1,0));
		driver.findElement(By.id("inputPassword")).sendKeys(getCellData("Sheet1","./data/rmgy.xlsx",1,1));
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		
		
	
		
		
}

}
