package executionEngine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Automation {
	WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://macktesting.solverminds.net/main");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"NFR_LoginForm-nfr_login_authname\"]")).sendKeys("hkkha01");
		driver.findElement(By.xpath("//*[@id=\"NFR_LoginForm-nfr_login_authid\"]")).sendKeys("$vm@nYk20");
		driver.findElement(By.xpath("//*[@id=\"NFR_LoginForm-nfr_login_btnlogin\"]/span")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='nfr_topbar_autocomp1_input']")).sendKeys("Requisition");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"nfr_topbar_autocomp1_panel\"]/ul/li[1]/span")).click();
		Thread.sleep(3000);
		WebElement clickk = driver
				.findElement(By.xpath("(//span[@id='PRQ_LND_datagrid_records_pnl'])/div/following-sibling::img"));
		clickk.click();
		WebElement Distinct = driver.findElement(By.xpath("//*[@id='PRQ_LND_datagrid_toolpanel']/ul/li[5]/a/img"));

		Distinct.click();
		List<WebElement> beforeOrder = driver
				.findElements(By.xpath("//*[@id=\"PRQ_LND_datagrid_tbl\"]/div/div[2]/div[1]/div[1]"));

		driver.findElement(By.xpath("//*[@id='PRQ_LND_datagrid_tbl']/div/div[6]/div/div/div[1]/span[1]/span")).click();

		Actions action = new Actions(driver);
		WebElement element = driver
				.findElement(By.xpath("//*[@id='PRQ_LND_datagrid_tbl']/div/div[6]/div/div/div[2]/div/div[1]/span[2]"));
		action.moveToElement(element).build().perform();

		driver.findElement(By.xpath("//*[@id=\"PRQ_LND_datagrid_tbl\"]/div/div[7]/div/div/div[1]/span[2]")).click();

		List<WebElement> afterOrder = driver
				.findElements(By.xpath("//*[@id='PRQ_LND_datagrid_tbl']/div/div[2]/div[1]/div[1]/div[2]"));
		int beforeCount = 0;
		int afterCount = 0;
		for (WebElement webElement : beforeOrder) {
			if (webElement.getText().equals("Action")) {
				break;
			}
			beforeCount++;

		}
		for (WebElement webElement : afterOrder) {
			if (webElement.getText().equals("Action")) {
				break;
			}
			afterCount++;

		}
		if (beforeCount < afterCount) {
			System.out.println("Before count");
		} else {

			System.out.println("affter count");
		}

	}

	public void click(String locatorType, String locatorname) {

		try {
			By locator = locatorValue(locatorType, locatorname);
			WebElement element = driver.findElement(locator);
			element.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();

		}
	}

	private By locatorValue(String locatortype, String locatorvalue) {
		// TODO Auto-generated method stub
		return null;
	}
}
