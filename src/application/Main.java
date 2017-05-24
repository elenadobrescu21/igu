package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.image.*;


		public class Main extends Application {
		
			@Override
			public void start(Stage primaryStage) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
					Scene scene = new Scene(root);
					primaryStage.setTitle("Aplicatie pentru procesare de imagine");
					primaryStage.setScene(scene);	
					primaryStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
			
			public static void main(String[] args) {
				launch(args);
			}
		}
		
		
		

