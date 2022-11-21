package expresionl1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ExpresionL1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Pulsar");
        
//        btn.setOnAction(event -> System.out.println("Funciones Lambda"));
//        btn.setOnAction((event) -> System.out.println("Funciones Lambda"));
//        btn.setOnAction((ActionEvent event) -> System.out.println("Funciones Lambda"));
        
//        btn.setOnAction(event -> System.out.println(6*95));
//        btn.setOnAction((event) -> System.out.println(6*95));
        String numCadena = "A0001";      
        int numEntero = Integer.parseInt(numCadena);
        String IdAutor2= String.valueOf(numEntero);

        btn.setOnAction((ActionEvent event) -> System.out.println(numEntero));
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Usando expresiones Lambda en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
