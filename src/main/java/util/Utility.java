package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.awt.Color;
import java.awt.image.BufferedImage;


public class Utility {
	
	public boolean provideComparisonResult(File file1, File file2) throws IOException
	{
		 BufferedImage img1 = ImageIO.read(file1);
	      BufferedImage img2 = ImageIO.read(file2);
	      int w1 = img1.getWidth();
	      int w2 = img2.getWidth();
	      int h1 = img1.getHeight();
	      int h2 = img2.getHeight();
	      if ((w1!=w2)||(h1!=h2)) {
	         System.out.println("Dimensions are not same");
	         return false;
	      } else {
	         long diff = 0;
	         for (int j = 0; j < h1; j++) {
	            for (int i = 0; i < w1; i++) {
	               //Getting the RGB values of a pixel
	               int pixel1 = img1.getRGB(i, j);
	               Color color1 = new Color(pixel1, true);
	               int r1 = color1.getRed();
	               int g1 = color1.getGreen();
	               int b1 = color1.getBlue();
	               int pixel2 = img2.getRGB(i, j);
	               Color color2 = new Color(pixel2, true);
	               int r2 = color2.getRed();
	               int g2 = color2.getGreen();
	               int b2= color2.getBlue();
	               //sum of differences of RGB values of the two images
	               long data = Math.abs(r1-r2)+Math.abs(g1-g2)+ Math.abs(b1-b2);
	               diff = diff+data;
	            }
	         }
	         double avg = diff/(w1*h1*3);
	         double percentage = (avg/255)*100;
		if(percentage==0)
			return true;
		else
			return false;
	}
}
	
	public File takeScreesnshot(WebDriver driver) throws IOException
	{
		 String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
				 +"test" + File.separator+"resources" + File.separator+"images"
				 + File.separator +new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+".png";
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		File finalFile=new File(path);
		FileUtils.copyFile(imageFile, new File(path));
		String a="";
		return finalFile;
		
	}

}
