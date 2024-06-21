package Stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHrm {
	public static WebDriver driver;
	String empid;
	@Given("i open browser with url {string}")
	public void i_open_browser_with_url(String url) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().deleteAllCookies();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    driver.get(url);
	}
	

	@Then("i should see login page")
	public void i_should_see_login_page() 
	{
	if(driver.findElement(By.id("btnLogin")).isDisplayed()) {
		System.out.println("system displayed login page");
	}
		
	}
	@When("i enter username as {string}")
	public void i_enter_username_as(String uid) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
	    
		
	}
	@And("i enter password as {string}")
	public void i_enter_password_as(String pwd) 
	{
	   driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		
	}
	
	@And("i click login")
	public void i_click_login() 
	{
	 
		driver.findElement(By.id("btnLogin")).click();
	}



	@When("i should see Admin Module") 
	public void i_should_see_admin_module() 
	{
	    if (driver.findElement(By.linkText("Admin")).isDisplayed()) 
	    {
			System.out.println("***************admin module displyed****************");
		}
		
	}

	@When("i click logout")
	public void i_click_logout() 
	{
	    driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
		
	}
	@When("i close Browser")
	public void i_close_browser() 
	{
	    driver.close();
	}

	@Then("i should see err message")
	public void i_should_see_err_message() 
	{
		String errmsg;
	errmsg=	driver.findElement(By.id("spanMessage")).getText();
	if (errmsg.toLowerCase().contains("Invalid")||errmsg.toLowerCase().contains("Empty")) 
	{
		System.out.println("Invalid credentials .****************testpass************");
	}
	    
	}	
	
	@When("i goto add employee page")
	public void i_goto_add_employee_page() 
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
	    
	}

	@When("i enter firstname as {string}")
	public void i_enter_firstname_as(String fname)
	{
	  driver.findElement(By.id("firstName")).sendKeys(fname);  
		
	}

	@When("i enter lastname as {string}")
	public void i_enter_lastname_as(String lname) 
	{
	    driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("i click save")
	public void i_click_save() 
	{
	empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	    
	}

	@Then("i should see new employee registed in employee list")
	public void i_should_see_new_employee_registed_in_employee_list() 
	{
		
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
	WebElement emptable=driver.findElement(By.id("resultTable"));
	  List<WebElement> rows=emptable.findElements(By.tagName("tr"));
	  
	  for(int i=1;i<rows.size();i++) 
	  {
	List<WebElement> cols =rows.get(i).findElements(By.tagName("td"));
	if (cols.get(i).getText().equals(empid))
	{
		System.out.println("system should displayed registered details");
		
	}
		  
		  
	  }
	    
	}



		
	}
	


