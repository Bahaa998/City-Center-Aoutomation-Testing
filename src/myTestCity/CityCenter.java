package myTestCity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CityCenter {
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void beforeMyTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://citycenter.jo/pc-and-laptops/pc-and-laptops-laptops?sort=p.price&order=ASC&limit=75&bfilter=s0:7;");
	}

	@Test()
	public void cityCenterCount() {
		driver.findElement(By.xpath("//*[@id=\"ProductsSystem_YD9pMDOx\"]/nav/div/div[1]/a[2]")).click();
		List<WebElement> laptops =driver.findElements(By.className("price-regular"));  //40 Items
		List<WebElement> newlaptops =driver.findElements(By.className("price-new"));   //35	Items == 75 items == all items in the page;
		
		int Allitem = laptops.size() + newlaptops.size();
		System.out.println("Size of List : " + Allitem); //== 75
		
		String price20thItem=laptops.get(20).getText(); //JOD 60900
		String withoutJOD=price20thItem.replace("JOD ", ""); //60900
		double finall = Double.parseDouble(withoutJOD);
		System.out.println("The price of the twentieth item : " + finall/100);  //609.0
	
		
	}
	
	@AfterTest
	public void afterMyTest() {
		driver.quit();
	}
}
