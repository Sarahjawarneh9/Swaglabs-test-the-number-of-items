import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestSwag {

	public static void main(String[] args) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");

		String user_name ="standard_user";
		String password="secret_sauce";
		//send user_name
		driver.findElement (By.xpath("//div/input[@id='user-name']")).sendKeys (user_name);
		Thread.sleep(3000);
		//send email
		driver.findElement (By.xpath("//div/input[@id='password']")).sendKeys (password);
		//click on login
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
		
//		//add the items to card
//    	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//    	driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
//    	driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
//    	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
//    	driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
//    	driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

		
		//add the items to card
		 List <WebElement> addCart = driver.findElements(By.xpath("//div/button[.='Add to cart']"));
			for(int i=0 ; i<addCart.size(); i++ ) {
				addCart.get(i).click();
				Thread.sleep(5000);
			}
		    //System.out.println("The number of item that i added to card : "+ addCart.size());
				
//	    List <WebElement> items = driver.findElements(By.className("inventory_item"));
//	    System.out.println("The number of item that i added to card : "+ items.size());
	
	    //click on shopping cart icon then get the number of items in the card
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//div/a[@class='shopping_cart_link']")).click();
	    Thread.sleep(3000);
	    
	    List <WebElement> cartItems = driver.findElements(By.xpath(" //div/div[@class='cart_item']"));
	    //System.out.println("The number of item that i have in the card : "+ cartItems.size());
	    
	    //get the number of items in the card
		int actualItems= cartItems.size();
	    int expectedItems= 6;
	    
	    //Compare between actualItems and expectedItems
	    Assert.assertEquals(actualItems, expectedItems);
	}

}
