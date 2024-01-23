import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class GenerateRandomDataUsingFaker {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		
		//option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://uibank.uipath.com/register-account");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		Locale locale = Locale.FRENCH;
		Faker faker = new Faker(locale);
		String firstName = faker.name().firstName();
		String nameWithMiddle = faker.name().nameWithMiddle();
		String lastName = faker.name().lastName();
		Date birthday= faker.date().birthday();
		SimpleDateFormat sd = new SimpleDateFormat("MM/DD/YYYY");
		String age = sd.format(birthday);
		String username = faker.name().username();
		String emailAddress = faker.internet().emailAddress();
		String password = faker.internet().password();
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		WebElement titleEle = driver.findElement(By.id("title"));
		Select sec = new Select(titleEle);
		sec.selectByVisibleText("Mr");
		WebElement genderEle = driver.findElement(By.name("gender"));
		Select sec1 = new Select(genderEle);
		sec1.selectByVisibleText("Male");
//		WebElement employmentStatus = driver.findElement(By.id("employmentStatus"));
//		Select sec2 = new Select(employmentStatus);
//		sec2.selectByVisibleText(" Full-time");
		
		driver.findElement(By.id("middleName")).sendKeys(nameWithMiddle);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("age")).sendKeys(age);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("email")).sendKeys(emailAddress);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.xpath("//input[@id='agreeCheckbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		

		
		
		
	}

}
