package edu.lwjgl_fx_01.ui.controller;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.lwjgl_fx_01.basic.om.MainFx;
import edu.lwjgl_fx_01.ui.view.MainWindow;
import edu.lwjgl_fx_01.ui.view.NavigationWindow;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.RotateIcon;
import jfxtras.labs.scene.control.window.Window;
import jfxtras.labs.scene.control.window.WindowIcon;

@SuppressWarnings({ "unused", "restriction" })
public class Controller extends AnchorPane
{
	@FXML
	AnchorPane mainAnchorPane;	
	
	private MainFx App;
	
	final static Logger logger = LogManager.getLogger(Controller.class);
	
	public Controller(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("edu/lwjgl_fx_01/ui/view/Main.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		getStyleClass().add("main-window");

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		
		
	}
	
	@FXML
    private void initialize() {
		NavigationWindow navWindow = new NavigationWindow();
		mainAnchorPane.getChildren().add(navWindow);
		MainWindow mainWindow = new MainWindow();
		mainAnchorPane.getChildren().add(mainWindow);
	
	}

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleNewWindow() {
 
    	    // now we add our custom icon
    	    
    	
    	
    	
    	Window w = new Window("My MDI Window");
    	   WindowIcon customIcon = new WindowIcon();
   	    
    	   customIcon.setOnAction(new EventHandler<ActionEvent>() {
   	        @Override
   	        public void handle(ActionEvent t) {
   	        	w.setPrefSize(1024, 740);
   	        }
   	    	});
		// define the initial window size
		w.setPrefSize(1024, 740);
		// either to the left
		w.getLeftIcons().add(new CloseIcon(w));
		// .. or to the right
		w.setMovable(true);
		w.setResizableWindow(true);
		w.prefWidth(1024);
		w.getRightIcons().add(new MinimizeIcon(w));
		w.getRightIcons().add(new RotateIcon(w));
		w.getRightIcons().add(customIcon);
		
		// add some content
		/*
		Label l1 = new Label("New label");
		Label l2 = new Label("Label 2");
		
		l1.setTranslateX(0);
		l1.setTranslateY(0);
		
		l2.setTranslateX(30);
		l2.setTranslateY(50);
		
		
		
		AnchorPane iAP = new AnchorPane();
		ImageView iIV = new ImageView();
		
		
		iAP.setPrefWidth(100);
		iAP.setPrefHeight(100);

		iIV.setFitWidth(100);
		iIV.setFitHeight(100);

		iAP.getChildren().addAll(iIV);
		w.getContentPane().getChildren().addAll(l1,l2,iAP);
		//w.getContentPane().getChildren().add(iAP);
		
		// add the window to the canvas
		*/
		w.getContentPane().getChildren().add(new Label("Hello world!"));
		w.getContentPane().getChildren().add(w);
		mainAnchorPane.getChildren().add(w);
		
		//Stage stg = (Stage) w.getScene().getWindow();
		
		final CountDownLatch runningLatch = new CountDownLatch(1);
		/* 
		new Thread("LWJGL Renderer") {
				public void run() {
					runGears(runningLatch, iIV);
					Platform.runLater(new Runnable() {
						public void run() {
							
							w.close();
							System.exit(0);
						}
					});
				}
			}.start();
		*/
        
    }

	public void setApp(MainFx App) {
        this.App = App;
    }

}