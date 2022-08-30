package random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WoodenStreetIconicChairsThirdItem {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.woodenstreet.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Dining"))).perform();
		driver.findElement(By.partialLinkText("Iconic Chairs")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		String priceOfChair = driver.findElement(By.xpath("(//div[contains(@id,'article')])[4]//strong")).getText().replace(",", "").replace("Rs ", "");
		if(Integer.valueOf(priceOfChair)>5000)
			System.out.println(priceOfChair+"  Very Costly!");
		else {
			//driver.findElement(By.xpath("(//div[@class=' col '])[3]//span[contains(@class,'cart')]")).click();
			//action.click(driver.findElement(By.xpath("(//div[@class=' col '])[3]//span[contains(@class,'cart')]"))).perform();
			//driver.findElement(By.xpath("(//div[@class=' col '])[3]")).click();
			//Set<String> windows = driver.getWindowHandles();
			//jse.executeScript("window.scrollBy(0,200)");
			driver.findElement(By.xpath("(//div[contains(@id,'article')])[4]//span[@class='cart-tooltip']")).click();
		}
		//Thread.sleep(3000);
		//driver.quit();
	}
}
