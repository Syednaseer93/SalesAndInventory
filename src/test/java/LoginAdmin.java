import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAdmin {
	static String getProperty(WebDriver driver, String key) throws FileNotFoundException, IOException {

		Properties pro = new Properties();
		pro.load(new FileInputStream("./data/loginData.properties"));
		String value = pro.getProperty(key);
		return value;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		getProperty(driver,"username");
		driver.findElement(By.name("user")).sendKeys(getProperty(driver,"username"));
		driver.findElement(By.name("password")).sendKeys(getProperty(driver,"password"));
		driver.findElement(By.name("btnlogin")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.close();
	}

}
