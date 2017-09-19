package edu.lwjgl_fx_01.basic.om;


import java.io.IOException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.lwjgl_fx_01.ui.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;


import edu.lwjgl_fx_01.ui.controller.Controller;
import edu.lwjgl_fx_01.ui.controller.RootLayoutController;

@SuppressWarnings({ "restriction", "unused" })
public class MainFx extends Application
{
	private Stage primaryStage;
	final static Logger logger = LogManager.getLogger(MainFx.class);
	
	public static void main( String[] args )
    {
		try{
			
			logger.log(Level.INFO, "Application runnig ...");

			launch(args);
		
		}catch(ArithmeticException ex){
			logger.error("Sorry, something wrong!", ex);
		}
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
	    
		this.primaryStage = primaryStage;
	    
	    this.primaryStage.setTitle("Game modeling system");

	    
	    
	    
	    Group root = new Group();

	    RootLayoutController rlController = new RootLayoutController();
	    
	    rlController.getBorderPane().prefWidthProperty().bind(primaryStage.widthProperty());
	    
	    Controller controller = new Controller();
        
	    
	    rlController.setCenter(controller);
        root.getChildren().addAll(rlController);

        Scene scene = new Scene(root, 1040, 770);
        
        scene.getStylesheets().add(getClass().getClassLoader().getResource("edu/lwjgl_fx_01/ui/view/Main.css").toExternalForm());
        
        //scene.setFill(Color.TRANSPARENT);
        
        root.getStyleClass().add("modal-dialog-content");
        	
        this.primaryStage.setScene(scene);
        //this.primaryStage.getIcons().add(new Image("file:resources/images/engine.png"));
        this.primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("image/engine.png").toString()));
        this.primaryStage.setResizable(true);
        this.primaryStage.centerOnScreen();
        this.primaryStage.show();
        //util.setScene(scene);
        //util.show();
    }
		



	 private Pane createShadowPane() {
	        Pane shadowPane = new Pane();
	        /*
	        int shadowSize = 3;
	        // a "real" app would do this in a CSS stylesheet.
	        shadowPane.setStyle(
	                "-fx-background-color: white;" +
	                "-fx-effect: dropshadow(gaussian, red, " + shadowSize + ", 0, 0, 0);" +
	                "-fx-background-insets: " + shadowSize + ";"
	        );

	        Rectangle innerRect = new Rectangle();
	        Rectangle outerRect = new Rectangle();
	        shadowPane.layoutBoundsProperty().addListener(
	                (observable, oldBounds, newBounds) -> {
	                    innerRect.relocate(
	                            newBounds.getMinX() + shadowSize,
	                            newBounds.getMinY() + shadowSize
	                    );
	                    innerRect.setWidth(newBounds.getWidth() - shadowSize * 2);
	                    innerRect.setHeight(newBounds.getHeight() - shadowSize * 2);

	                    outerRect.setWidth(newBounds.getWidth());
	                    outerRect.setHeight(newBounds.getHeight());

	                    Shape clip = Shape.subtract(outerRect, innerRect);
	                    shadowPane.setClip(clip);
	                }
	        );
*/
	        Window w = new Window("My MDI Window");
	        w.getLeftIcons().add(new CloseIcon(w));
	        w.getRightIcons().add(new MinimizeIcon(w));
	        w.getContentPane().getChildren().add(new Label("Hello world!"));
	        shadowPane.getChildren().add(w);
	        return shadowPane;
	    }
}
