package random;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WoodenStreetAddAndDelete {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.get("https://www.woodenstreet.com/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginclose1")));
		driver.findElement(By.id("loginclose1")).click();
		Actions actions=new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		actions.moveToElement(driver.findElement(By.xpath("//li/a[contains(text(),'Study & Office')]"))).perform();
		driver.findElement(By.linkText("Gaming Chairs")).click();
		jse.executeScript("window.scrollTo(0,500)");
		driver.findElement(By.xpath("(//div[contains(@id,'article')])[1]//span[@class='cart-tooltip']")).click();
		ArrayList<String> brandList=new ArrayList<>();
		brandList.add(driver.findElement(By.xpath("(//div[contains(@id,'article')])[1]//a[@class='by-brand']")).getText());
		int itemsInCart=1;
		for (int i = 2;; i++) {
			if(itemsInCart==3)
				break;
			String xpath="(//div[contains(@id,'article')])["+i+"]//a[@class='by-brand']";
			String brandName=driver.findElement(By.xpath(xpath)).getText();
			if(brandList.contains(brandName)) {
				continue;
			}
			else {
				brandList.add(brandName);
				driver.findElement(By.xpath("(//div[contains(@id,'article')])["+i+"]//span[@class='cart-tooltip']")).click();
				itemsInCart++;
			}
			//System.out.println(itemsInCart);
		}
		jse.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.xpath("//a[@title='Cart']")).click();
		int price[]=new int[3];
		for(int i =1; i<4;i++) {
			String temp = driver.findElement(By.xpath("(//div[@class='product-detail'])["+i+"]//strong")).getText().replace("Rs ", "").replace(",", "");
			int tempPrice=Integer.valueOf(temp);
			price[i-1]=tempPrice;
			System.out.println(price[i-1]);
		}
		if(price[0]>price[1] && price[0]<price[1])
			driver.findElement(By.xpath("(//p[contains(text(),'Remove')])[1]")).click();
		else if(price[1]>price[0] && price[1]<price[2])
			driver.findElement(By.xpath("(//p[contains(text(),'Remove')])[2]")).click();
		else if(price[2]>price[0] && price[2]<price[1])
			driver.findElement(By.xpath("(//p[contains(text(),'Remove')])[3]")).click();
		//driver.quit();
	}
}
