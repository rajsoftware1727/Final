package TEST_CASE;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.LoginPage;
import UTILITIES.Base;
import UTILITIES.DataProvider1;

public class LoginTest extends Base{
	
 	
	@Test(dataProvider="v",dataProviderClass=DataProvider1.class)
	public static void Login_With_Valid_Input(String s[]) throws IOException
	{
 		LoginPage login=new LoginPage(Base.getDriver());
		login.enterUserName(s[0]);
		login.enterPassword(s[1]);
		login.clicksignIn();
		Assert.assertEquals(Base.getDriver().getTitle(),login.pageTitle(),"title mismatch");
		Assert.assertEquals(login.getWelcomePageMsg().getText(),login.pageMessage());
	}

}
