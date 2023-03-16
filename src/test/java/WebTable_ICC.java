import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_ICC {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		
		//for total teams and matches played
		List<WebElement> teams = driver.findElements(By.xpath("//tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tr/td[3]"));
		List<WebElement> position = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> rating = driver.findElements(By.xpath("//tr/td[5]"));
		for(int i=0;i<teams.size();i++) {
			String teamNames=teams.get(i).getText();
			String matchesPlayed = matches.get(i).getText();
			String rank=position.get(i).getText();
			String rate = rating.get(i).getText();
			System.out.println(rank+" | "+teamNames+" | "+matchesPlayed+" | "+rate);
			boolean flag=false;
			if(teamNames.contains("Australia")) {
				flag=true;
				break;
			}
			if(flag==true) {
				System.out.println("present");
			}
			else {
				System.out.println("not present");
			}
		}
		//if team is Pakistan what is rating
		String team="Pakistan";
		String x="//span[.='"+team+"']/../following-sibling::td[3]";
		
		System.out.println(driver.findElement(By.xpath(x)).getText());
	
		
	}			
}
