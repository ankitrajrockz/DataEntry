package entry;

import org.openqa.selenium.By;

public class PageObj {

	
	public By login_username= By.xpath("//input[@id='txtUserName']");
	public By login_userpwd= By.xpath("//input[@id='txtPassword']");
	public By login_buton= By.xpath("(//div/a[contains(text,Login)])[1]");
	
	public By workld_tab= By.xpath("//*[@id='liworkload']/a");
	public By work_selForm= By.xpath("//*[@id='ddlForms']");
	
	public By work_field_name=By.xpath("//input[@placeholder='Name']");
	public By work_field_father=By.xpath("//input[@placeholder='Father Name']");
	public By work_field_unique=By.xpath("//input[@placeholder='Unique Number']");
	public By work_field_dov=By.xpath("//input[@placeholder='Date of Validation']");
	public By work_field_regdno=By.xpath("//input[@placeholder='Regd. No.']");
	public By work_field_chassis=By.xpath("//input[@placeholder='Chassis Number']");
	public By work_field_engine=By.xpath("//input[@placeholder='Engine Number']");
	public By work_field_model=By.xpath("//input[@placeholder='Model Name']");
	public By work_field_broker=By.xpath("//input[@placeholder='Broker Name']");
	public By work_field_anuualincome=By.xpath("//input[@placeholder='Annual Income']");
	
	public By work_field_input= By.xpath("//*[@id='divformcontnent']/pre");
	
	public By work_field_category= By.xpath("//*[@id='txtBox11']");
	
	public By work_field_save= By.xpath("//*[@id='btnSave']");
	
}
