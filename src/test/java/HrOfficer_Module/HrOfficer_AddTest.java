package HrOfficer_Module;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.ReadExcelDataUtility;
import com.hrm.GenericUtility.WebDriverUtility;
import com.hrm.ObjectPage.AddHrOfficerEmployee;
import com.hrm.ObjectPage.HomePage;
import com.hrm.ObjectPage.LoginPage;
import com.hrm.ObjectPage.LogoutPage;

public class HrOfficer_AddTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
        ReadExcelDataUtility rLib=new ReadExcelDataUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        JavaUtility jLib=new JavaUtility();
        HashMap<String, String> fields=new HashMap<String, String>();
        wLib.forPageLoad(driver);
        wLib.maximizeWindow(driver);
        {
        	driver.get("http://rmgtestingserver/domain/HRM_System/");
        	LoginPage lp=new LoginPage(driver);
        	lp.HROfficerLogin(wLib, driver); 
        	
        	HomePage hp=new HomePage(driver);
        	hp.clickOfficerEmployee();
        	
        	AddHrOfficerEmployee aOp=new AddHrOfficerEmployee(driver);
        	aOp.AddHrOfficerEmployee(rLib, driver, wLib);
        	
        	LogoutPage lo=new LogoutPage(driver);
        	lo.getLogout();
	}

}}
