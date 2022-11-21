package pruebaall;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class PruebaAll extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group raiz = new Group();
        Scene escena = new Scene(raiz, 300, 300, Color.WHITE);
        
        Circle cir1 = new Circle(10,Color.BLACK);
        cir1.setCenterX(70);
        cir1.setCenterY(70);
        cir1.setRadius(10);
        cir1.setStroke(Color.BLACK);
        raiz.getChildren().add(cir1);
        
        Slider des1 = new Slider(0, 50, 0);
        des1.setTranslateY(200);
        des1.setTranslateX(15);
        des1.setMax(100);
        cir1.strokeWidthProperty().bind(des1.valueProperty());
        raiz.getChildren().add(des1);
        
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
