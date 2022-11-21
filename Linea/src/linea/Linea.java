package linea;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Linea extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dibujando Lineas");
        
        Group raiz = new Group();
        Scene escena = new Scene(raiz,350,300,Color.WHITE);
        
        Line linearoja = new Line(10,10,200,10);
        linearoja.setStroke(Color.RED);
        linearoja.setStrokeWidth(5);
        linearoja.setStrokeLineCap(StrokeLineCap.SQUARE);
        linearoja.getStrokeDashArray().addAll(10d,5d,15d,5d,20d);
        linearoja.setStrokeDashOffset(0);
        raiz.getChildren().add(linearoja);
        
        Line Lineaazul = new Line();
        Lineaazul.setStartX(170);
        Lineaazul.setStartY(30);
        Lineaazul.setEndX(20);
        Lineaazul.setEndY(140);
        Lineaazul.setFill(Color.BLUE);
        Lineaazul.setStrokeWidth(10.0f);
        raiz.getChildren().add(Lineaazul);
        
        Line lineaverde = new Line(10,30,200,30);
        lineaverde.setStartX(200);
        lineaverde.setStartY(80);
        lineaverde.setStroke(Color.GREEN);
        lineaverde.setStrokeWidth(10);
        lineaverde.setStrokeLineCap(StrokeLineCap.ROUND);
        lineaverde.setStrokeDashOffset(10);
        raiz.getChildren().add(lineaverde);
        
        Slider deslizador1 = new Slider(0,150,0);
        deslizador1.setLayoutX(20);
        deslizador1.setLayoutY(150);
        linearoja.strokeDashOffsetProperty().bind(deslizador1.valueProperty());
        raiz.getChildren().add(deslizador1);
        
        Text texto1 = new Text("Obteniendo Valor:  0.0");
        texto1.setX(10);
        texto1.setY(200);
        texto1.setStroke(Color.VIOLET);
        deslizador1.valueProperty().addListener(e -> texto1.setText("Valor: "+deslizador1.getValue()));
        raiz.getChildren().add(texto1);
        
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
