package Selenium_Concepts;

 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Selenium_Concepts_Demo {
	
	WebDriver driver;
	
	@Test(enabled=false)
	public void fileUpload() throws FindFailed
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.filestack.com/");
		System.out.println("reached");
		driver.findElement(By.className("fsp-select-labels")).click();
  		System.out.println("find the element");
		//now sikuli starts
		
		String resumepath="C:\\Users\\AKILA RAJESH\\Downloads\\a.pdf";
		String filepath="C:\\Users\\AKILA RAJESH\\Downloads\\path.png";
		String open="C:\\Users\\AKILA RAJESH\\Downloads\\open.png";
		
		Pattern p=new Pattern(filepath);
		Pattern p1=new Pattern(open);
		
		Screen s=new Screen();
		s.wait(p,20);
		s.type(p,filepath);
		s.click(p1);
		
		System.out.println("file upload successfully");

		}
	
	@Test(enabled=true)
	public void fileUploadByRobot() throws AWTException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.filestack.com/");
		System.out.println("reached");
		driver.findElement(By.className("fsp-select-labels")).click();
  		System.out.println("find the element");
		String resumepath="C:\\Users\\AKILA RAJESH\\Downloads\\a.pdf";

  		StringSelection s=new StringSelection(resumepath);
  		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
  		Robot r=new Robot();

		r.delay(300);

   		r.keyPress(KeyEvent.VK_ENTER);
  		r.keyRelease(KeyEvent.VK_ENTER);
  		r.keyPress(KeyEvent.VK_CONTROL);
  		r.keyPress(KeyEvent.VK_V);

  		r.keyRelease(KeyEvent.VK_CONTROL);
  		r.keyRelease(KeyEvent.VK_V);
  		
  		r.keyPress(KeyEvent.VK_ENTER);
  		r.keyRelease(KeyEvent.VK_ENTER);
  		
  		System.out.println("success");


		
	}
	
	@Test
	public void imageCompare() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement t=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		
		File d=t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(d,new File("D:\\Images\\first.jpg"));
		/*File f=new File("D:\\Images\\200.jpg");
		File f1=new File("D:\\Images\\2000.jpg");

		BufferedImage i1=ImageIO.read(f);
		BufferedImage i2=ImageIO.read(f1);
		
		ImageDiffer differ=new ImageDiffer();
		ImageDiff diff=differ.makeDiff(i1, i2);
		if(diff.hasDiff())
		{
			System.out.println("images are different");
		}
		else
		{
			System.out.println("images are same");
		}*/

	}
	
	
	
	

}
