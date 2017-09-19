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
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import edu.lwjgl_fx_01.ui.controller.Controller;

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
	    this.primaryStage.setTitle("Hello world application");

    	Group root = new Group();

        Controller controller = new Controller();
        
        root.getChildren().addAll(controller);

        Scene scene = new Scene(root);
        
        this.primaryStage.setScene(scene);
        
        this.primaryStage.show();
    
	}



}
