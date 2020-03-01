package entry;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;

public class DataEenter {
	static WebDriver driver;
	static File file;
	static FileWriter writer;
	static PageObj page=new PageObj();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		
		ChromeOptions option= new ChromeOptions();
		//option.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		option.addArguments("disable-infobars");
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		option.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		option.setCapability(CapabilityType.TAKES_SCREENSHOT,true );
		option.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT,true );
		
		driver= new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.automobiledatafilling.com/");
		
		Thread.sleep(5000);
		
		driver.findElement(page.login_username).sendKeys("7995990309");
		driver.findElement(page.login_userpwd).sendKeys("nice@123");
		driver.findElement(page.login_buton).click();		
		Thread.sleep(4000);
		select_form();
		/*
		Date date = Calendar.getInstance().getTime();  
	    DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");  
	    String strDate = dateFormat.format(date); 
	    
	    
	    file = new File(".\\"+strDate+".txt");
	    
		System.out.println(file.getAbsolutePath());
		if (file.createNewFile())
		{	
		    System.out.println("File is created : "+strDate);
		   
		    select_form();
		    
		} else {
		    System.out.println("File already exists."+strDate);
		}
		*/
	}
	
	public static void select_form() throws Exception {
		Thread.sleep(2000);
		driver.findElement(page.workld_tab).click();
		Thread.sleep(4000);
		driver.findElement(page.work_selForm).click();
		Thread.sleep(3000);	
		
		Select form= new Select(driver.findElement(page.work_selForm));
		List<WebElement> list_form=form.getOptions();
		if(list_form.size()>1) {
			form.selectByIndex(1);
		
			
			form_filling();
		    
			select_form();
		}
		else {
			System.out.println("All Done");
		}
		
	}
	
	public static void form_filling() throws Exception {
		Thread.sleep(2000);
		String input_details=driver.findElement(page.work_field_input).getText();
		String[] items_input= input_details.replace("\n", "").split(Pattern.quote("//"));
		List<String> input_val=Arrays.asList(items_input);
		
		System.out.println(Arrays.toString(items_input));
		if(input_val.size()==10) {
			driver.findElement(page.work_field_name).clear();
			driver.findElement(page.work_field_name).sendKeys(input_val.get(0));
			driver.findElement(page.work_field_father).clear();
			driver.findElement(page.work_field_father).sendKeys(input_val.get(1));
			driver.findElement(page.work_field_unique).clear();
			driver.findElement(page.work_field_unique).sendKeys(input_val.get(2));
			driver.findElement(page.work_field_dov).clear();
			
			driver.findElement(page.work_field_dov).sendKeys(input_val.get(3).toString());
			Thread.sleep(1000);
			driver.findElement(page.work_field_regdno).clear();
			driver.findElement(page.work_field_regdno).sendKeys(input_val.get(4));
			driver.findElement(page.work_field_chassis).clear();
			driver.findElement(page.work_field_chassis).sendKeys(input_val.get(5));
			driver.findElement(page.work_field_engine).clear();
			driver.findElement(page.work_field_engine).sendKeys(input_val.get(6));
			driver.findElement(page.work_field_model).clear();
			driver.findElement(page.work_field_model).sendKeys(input_val.get(7));
			driver.findElement(page.work_field_broker).clear();
			driver.findElement(page.work_field_broker).sendKeys(input_val.get(8));
			driver.findElement(page.work_field_anuualincome).clear();
			driver.findElement(page.work_field_anuualincome).sendKeys(input_val.get(9));
			
			driver.findElement(page.work_field_category).click();
			Select category= new Select(driver.findElement(page.work_field_category));
			
			
			String[] split_rs=input_val.get(9).split("lacs");
			if(split_rs.length>1) {
				String[] spit_num=split_rs[0].split("Rs.");
				float fl_num=Float.parseFloat(spit_num[1].trim());
				long rs_inlakh=(long) (fl_num*100000);
				if(rs_inlakh<500000) {
					category.selectByValue("No Category");
				}
				else if(rs_inlakh>=500000 && rs_inlakh<700000) {
					category.selectByValue("Silver Category");
				}
				else if(rs_inlakh>=700000 && rs_inlakh<900000) {
					category.selectByValue("Gold Category");
				}
				else if(rs_inlakh>=900000) {
					category.selectByValue("Diamond Category");
				}
				else
					return;
			}
			else {
				System.out.println("Check Income");
				return;
			}
			
			
			driver.findElement(page.work_field_save).click();
			
			Thread.sleep(2000);
		}		
	}
}
