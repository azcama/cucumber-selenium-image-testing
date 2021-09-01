package pages;

import java.awt.image.BufferedImage;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

public class MapamundiPage extends HomePage {

	public void doCheckpoint() {
		Shutterbug.shootPage(getDriver(), Capture.FULL_SCROLL).withName("original").save();
	}

	public void moveMouseToMap(String element) {
		WebElement location = getDriver().findElement(By.cssSelector(".highcharts-name-"+element.toLowerCase()));
		moveMouseTo(location);
	}

	public void moveMouseToList(String country) {
		WebElement location = getDriver().findElement(By.xpath("//div[contains(text(),'"+country+"')]"));
		moveMouseTo(location);
	}

	public boolean isEqualToPreviousStatus() {

		Shutterbug.shootPage(getDriver(), Capture.FULL_SCROLL).withName("current").save();
	    
	    BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("./screenshots/original.png");
	    BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("./screenshots/current.png");
	    
	    File resultDestination = new File("./screenshots/result.png");
	    
	    //Create ImageComparison object for it.
	    ImageComparison imageComparison = new ImageComparison(expectedImage, actualImage, resultDestination);

	    //DifferenceRectangleFilling — Fill the inside the difference rectangles with a transparent fill. By default it’s false and 20.0% opacity.
	    imageComparison.setDifferenceRectangleFilling(true, 20.0);

	    //ExcludedRectangleFilling — Fill the inside the excluded rectangles with a transparent fill. By default it’s false and 20.0% opacity.
	    imageComparison.setExcludedRectangleFilling(true, 20.0);

	    //Destination. Before comparing also can be added destination file for result image.
	    imageComparison.setDestination(resultDestination);

	    //After configuring the ImageComparison object, can be executed compare() method:
	    ImageComparisonResult imageComparisonResult = imageComparison.compareImages();

	    //And Result Image
	    BufferedImage resultImage = imageComparisonResult.getResult();
	    
	    //Image can be saved after comparison, using ImageComparisonUtil.
	    if (imageComparisonResult.getDifferencePercent()>0.0) {
	    	ImageComparisonUtil.saveImage(resultDestination, resultImage);
	    	return false;
	    }
	    
	    return true;
	}
	
	
	private void moveMouseTo(WebElement location) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(location).perform();
	}
}
