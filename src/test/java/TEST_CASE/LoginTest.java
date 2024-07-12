package TEST_CASE;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.LoginPage;
import UTILITIES.Base;
import UTILITIES.DataProvider1;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class LoginTest extends Base{
	
 	
	@Test(dataProvider="v",dataProviderClass=DataProvider1.class,enabled=true)
	public static void Login_With_Valid_Input(String s[]) throws IOException
	{
		
 		LoginPage login=new LoginPage(Base.getDriver());
		login.enterUserName(s[0]);
		login.enterPassword(s[1]);
		login.clicksignIn();
   	}
	
	@Test(enabled=false)
	public static void verifyLinks() throws IOException
	{
		List<WebElement> anchorTag=Base.getDriver().findElements(By.tagName("a"));
		int workinglink=0;
		int nonworkinglink=0;
		for(WebElement t:anchorTag)
		{
			String href=t.getAttribute("href");
			System.out.println(href);
			URL url=new URL(href);
			HttpURLConnection http=(HttpURLConnection)url.openConnection();
			http.connect();
			int resCode=http.getResponseCode();
			 

			
			if(resCode>=400)
			{
				System.out.println("link is broken");
				nonworkinglink++;
 
			}
			else
			{
				System.out.println("link is working fine");
				workinglink++;
			}
 		}
		
		System.out.println("total nonworking links are "+"="+nonworkinglink);
		System.out.println("total working links are "+"="+workinglink);


		
	}
	
	
	@Test(enabled=false)
	public void getScreenShot() throws IOException
	{
		WebElement t=Base.getDriver().findElement(By.xpath("//img[@alt='Guru99 Demo Sites']"));
		 
 		TakesScreenshot shot=(TakesScreenshot)Base.getDriver();
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File desFile=new File("D:\\Images\\200.jpg");
		FileUtils.copyFile(srcFile, desFile);
				
	}
	
	@Test(enabled=false)
	public void particularElement() throws IOException
	{
		TakesScreenshot shot=(TakesScreenshot)Base.getDriver();
		File srcFile=shot.getScreenshotAs(OutputType.FILE);
		WebElement t=Base.getDriver().findElement(By.xpath("//img[@alt='Guru99 Demo Sites']"));
        Point p=t.getLocation();
        int width=t.getSize().getWidth();
        int height=t.getSize().getHeight();
        BufferedImage image=ImageIO.read(srcFile);
        BufferedImage h=image.getSubimage(p.getX(),p.getY(),width,height);
        ImageIO.write(h,"jpg",new File("D:\\Images\\2000.jpg"));
		
   }
	
	@Test(enabled=false)
	public void compareImages() throws IOException
	{
		BufferedImage eImage=ImageIO.read(new File("D:\\Images\\200.jpg"));
		BufferedImage aImage=ImageIO.read(new File("D:\\Images\\2000.jpg"));
        ImageDiffer differ=new ImageDiffer();
        ImageDiff di=differ.makeDiff(eImage, aImage);
        if(di.hasDiff())
        {
        	System.out.println("images are not same");
        }
        else
        {
        	System.out.println("images are same");
        }
	}

	
}
