package application;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class BrightnessModifier {
;
	
	private int height;
	
	private int width;
	
	
	public BrightnessModifier(int height, int width){

		this.height = height;
		this.width = width;
	}
	
	
	
	public void adjustBrightness(BufferedImage image, int brightnessAdjust) {
			
		for(int i=0; i<height; i++ ) {
			for(int j=0; j<width; j++) {
				Color color = new Color(image.getRGB(j, i));
				int red = (int)(color.getRed());
				int green = (int)(color.getGreen());
				int blue = (int)(color.getBlue());
				
				int newRed = truncate(red+brightnessAdjust);
				int newGreen = truncate(green+brightnessAdjust);
				int newBlue = truncate(blue+brightnessAdjust);
				
				Color newColor = new Color(newRed, newGreen, newBlue);
				
				image.setRGB(j,i, newColor.getRGB());
							
			}
		}
			
	}
	
	public int truncate(int value) {
		if(value < 0) {
			return 0;
		}
		
		if(value > 255) {
			return 255;
		}
		
		return value;
	}
}
