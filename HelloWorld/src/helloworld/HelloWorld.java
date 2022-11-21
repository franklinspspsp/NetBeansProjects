package helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root,300,250);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Press Here");
        
        btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent Event){
                System.out.println("Hello World");
            }            
        });
        
        root.getChildren().add(btn);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
