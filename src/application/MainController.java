package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

public class MainController {
	
	private BufferedImage bufferedImageOriginal;
	
	private BufferedImage bufferedImageModified;
	
	private Image imageOriginal;
	
	@FXML
	private Button uploadBtn;
	
	@FXML
	private Button saveBtn;
	
	@FXML
	private Button clearBtn;
	
	@FXML
	private ImageView imageViewOriginal;
	
	@FXML
	private ImageView imageViewModified;
	
	
	@FXML
	private Slider increaseBrightness;
	
	@FXML
	private Slider decreaseBrightness;
	
	
	@FXML
	public void buttonOneAction(ActionEvent event) {
		
		 FileChooser fileChooser = new FileChooser();
         
         //Set extension filter
         FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
         FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
         FileChooser.ExtensionFilter extFilterBMP = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
         fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterBMP);
           
         //Show open file dialog
         File file = fileChooser.showOpenDialog(null);
                    
         try {
             this.bufferedImageOriginal = ImageIO.read(file);
             this.bufferedImageModified = ImageIO.read(file);
             this.imageOriginal = SwingFXUtils.toFXImage(bufferedImageOriginal, null);
             imageViewOriginal.setImage(imageOriginal);
             Image imageModified = SwingFXUtils.toFXImage(bufferedImageModified, null);
             imageViewModified.setImage(imageModified);
         } catch (IOException ex) {
             ex.printStackTrace();
         }
	}
	
	@FXML
	public void buttonClearAction(ActionEvent event) {
		imageViewModified.setImage(imageOriginal);
		increaseBrightness.setValue(0);
		decreaseBrightness.setValue(0);
		
	}
	
	@FXML
	public void saveModifiedImage(ActionEvent event) {
	 FileChooser fileChooser = new FileChooser();
         
         //Set extension filter
         FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
         FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
         FileChooser.ExtensionFilter extFilterBMP = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
         fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterBMP);
         fileChooser.setTitle("Save image");
           
         File file = fileChooser.showSaveDialog(null);
         
         if (file != null) {
             try {
                 ImageIO.write(SwingFXUtils.fromFXImage(imageViewModified.getImage(),null),
                          "bmp", file);
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         }
     }
		
		
	
	
	@FXML
	public void increaseBrightnessDrag(Event event) {
		BrightnessModifier bm = new BrightnessModifier(bufferedImageModified.getHeight(), bufferedImageModified.getWidth());
		bm.adjustBrightness(bufferedImageModified, (int)increaseBrightness.getValue());
		Image imageModified = SwingFXUtils.toFXImage(bufferedImageModified, null);
        imageViewModified.setImage(imageModified);
	
	}
	
	@FXML
	public void decreaseBrightnessDrag(Event event) {
		System.out.println("hello");
		BrightnessModifier bm = new BrightnessModifier(bufferedImageModified.getHeight(), bufferedImageModified.getWidth());
		bm.adjustBrightness(bufferedImageModified, -(int)decreaseBrightness.getValue());
		Image imageModified = SwingFXUtils.toFXImage(bufferedImageModified, null);
        imageViewModified.setImage(imageModified);
	
	}
	
	

}
