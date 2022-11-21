package errores;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Errores extends Application {
    
    interface MiValorPa{
        double getValor(double valor);
    }

    @Override
    public void start(Stage primaryStage) {
        MiValorPa mvp2 = (x) -> 60/x;
        
        Button btn1 = new Button("OP. 1");
        btn1.setTranslateX(0);
        btn1.setTranslateY(0);
        
        Label lbl1 = new Label();
        lbl1.setTranslateX(0);
        lbl1.setTranslateY(30);
        
        Button btn2 = new Button("OP. 2");
        btn2.setTranslateX(0);
        btn2.setTranslateY(60);
        
        Label lbl2 = new Label();
        lbl2.setTranslateX(0);
        lbl2.setTranslateY(90);
        
        btn1.setOnAction((ActionEvent event) -> lbl1.setText("El resultado es: " + mvp2.getValor(8.0)));
        btn2.setOnAction((ActionEvent event) -> lbl2.setText("El resultado es: " + mvp2.getValor(5.3)));
        
        StackPane root = new StackPane();
        root.getChildren().addAll(btn1,btn2,lbl1,lbl2);
        
        Scene escena = new Scene(root, 350, 270);
        
        primaryStage.setTitle("Lambda");
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
