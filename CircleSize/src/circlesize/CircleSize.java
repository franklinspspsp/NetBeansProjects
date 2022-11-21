package circlesize;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Abraham Arteaga Lopez
 * Franklin Soto Pacco
 */

public class CircleSize extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group raiz = new Group();
        Scene escena = new Scene(raiz,350,300,Color.WHITE);
        
        Circle cir1 = new Circle(10, Color.BLACK);
        cir1.setCenterX(10);
        cir1.setCenterY(10);
        raiz.getChildren().add(cir1);
        
        Slider des1 = new Slider(0,150,0);
        des1.setLayoutX(0);
        des1.setLayoutY(150);
        cir1.strokeDashOffsetProperty().bind(des1.valueProperty());
        raiz.getChildren().add(des1);
        
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
