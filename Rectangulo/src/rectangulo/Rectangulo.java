/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangulo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Abraham Arteaga Lopez
 * Franklin Soto Pacco
 */
public class Rectangulo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       primaryStage.setTitle("Rectagulo - Circulo");
       Group raiz = new Group();
       Scene scene = new Scene(raiz, 350, 300,Color.WHITE );
       

       Rectangle recta=new Rectangle();
       recta.setX(50);
       recta.setY(50);
       recta.setWidth(100);
       recta.setHeight(70);
       recta.setArcHeight(20);
       recta.setArcWidth(20);
      
       LinearGradient lineaG=new LinearGradient(0, 0, 0, 1, true,CycleMethod.NO_CYCLE,
               new Stop(0.1f,Color.rgb(255, 0, 0,.784)),new Stop(1.0f,Color.rgb(0, 0, 0,.784)));                   
       recta.setFill(lineaG);;
       raiz.getChildren().add(recta);
       
       Rectangle recta2=new Rectangle();
       recta2.setArcHeight(20);
       recta.setArcWidth(20);
      
       LinearGradient lineaG2=new LinearGradient(50, 70, 70, 70, false,CycleMethod.NO_CYCLE,
               new Stop(0f,Color.rgb(255, 0, 0,.784)),new Stop(1.0f,Color.rgb(0, 0, 0,.784)));
       recta2.setFill(lineaG2);
       raiz.getChildren().add(recta2);
       HBox caja=new HBox();
       Button btnColor=new Button();
       btnColor.setText("Cambiar de color a verde");
       btnColor.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                LinearGradient lineaG=new LinearGradient(0, 0, 0, 1, true,CycleMethod.NO_CYCLE,
               new Stop(0.1f,Color.rgb(0, 204, 0,.784)),new Stop(1.0f,Color.rgb(0, 0, 0,.784)));                   
       recta.setFill(lineaG);
                LinearGradient lineaG2=new LinearGradient(0, 0, 0, 1, false,CycleMethod.NO_CYCLE,
               new Stop(0f,Color.rgb(0, 204, 0,.784)),new Stop(1.0f,Color.rgb(0, 0, 0,.784)));
       recta2.setFill(lineaG2);
            }
        });
       Circle circulo=new Circle(100,300,75);
       Slider slider=new Slider();
       slider.setMax(100);
       slider.setValue(20);
       slider.setTranslateY(180);
       slider.setMajorTickUnit(10);
       circulo.radiusProperty().bind(slider.valueProperty());
       caja.getChildren().add(btnColor);
       raiz.getChildren().addAll(caja,circulo,slider);
       primaryStage.setScene(scene);
       primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
