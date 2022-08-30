package random;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloDragAndDrop {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		Actions actions=new Actions(driver);
		driver.get("https://trello.com/login");
		driver.findElement(By.id("user")).sendKeys("peoplefortiptur@gmail.com");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("password"))));
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("password")).sendKeys("9886947924");
		driver.findElement(By.id("login-submit")).submit();
		driver.findElement(By.xpath("//span[text()='Create new board']")).click();
		driver.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).sendKeys("Charlie");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Create']"))));
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		driver.switchTo().activeElement().sendKeys("Manual",Keys.ENTER);
		driver.findElement(By.xpath("//a[.='Add a card']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("SDLC",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Functionality",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Integration",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("System",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Performance",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("smoke",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Defect Tracking",Keys.ENTER);
		driver.findElement(By.name("name")).sendKeys("Java",Keys.ENTER);
		driver.findElement(By.xpath("/h2[.='Java']/../..//a[.='Add a card']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Encapsulation",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Inheritance",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Polymorphism",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Abstraction",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Arrays",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Collection",Keys.ENTER);
		driver.findElement(By.xpath("//a[.='Add another list']")).click();
		driver.switchTo().activeElement().sendKeys("Selenium",Keys.ENTER);
		driver.findElement(By.xpath("//h2[.='Selenium']/../..//a[.='Add a card']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Architecture",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Webdriver",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Webelment",Keys.ENTER);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']\"")).sendKeys("Synchronization",Keys.ENTER);
		actions.clickAndHold(driver.findElement(By.xpath("//span[text()='Funtionality']"))).perform();
		actions.dragAndDropBy(driver.findElement(By.xpath("//span[text()='Funtionality']")), 853, 358).perform();
		actions.release();
		driver.findElement(By.xpath("//a[.='Show menu']")).click();
		driver.findElement(By.xpath("//a[contains(.,'More')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Close board…')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Close board…')]")).click();
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		driver.findElement(By.xpath("//button[text()='Permanently delete board']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
}
