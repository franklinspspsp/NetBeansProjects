package or;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OR extends Application {
    
    interface AddVal{
        double getValor(double nro1, double nro2);
    }

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        root.setId("pane");
        
        Random aleatorio = new Random(System.currentTimeMillis());
        double a = aleatorio.nextInt(100);
        double b = aleatorio.nextInt(100); 
        
        Label nro1 = new Label("" + a);
        nro1.setId("nro1");
        
        Label nro2 = new Label("" + b);
        nro2.setId("nro2");
        
        VBox cajaV1 = new VBox(10);///////primera caja
        cajaV1.setAlignment(Pos.TOP_LEFT);
        
        Image Isuma = new Image(getClass().getResource("Isuma.png" + "").toExternalForm());
        ImageView IVsuma = new ImageView(Isuma);
        
        Button Bsuma = new Button();
        Bsuma.setId("Bsuma");
        Bsuma.setGraphic(IVsuma);
        Bsuma.setContentDisplay(ContentDisplay.CENTER);
        Bsuma.setDefaultButton(true);
        
        Image Iresta = new Image(getClass().getResource("Iresta.png" + "").toExternalForm());
        ImageView IVresta = new ImageView(Iresta);
        
        Button Bresta = new Button();
        Bresta.setId("Bresta");
        Bresta.setGraphic(IVresta);
        Bresta.setContentDisplay(ContentDisplay.CENTER);
        Bresta.setDefaultButton(true);
        
        cajaV1.getChildren().addAll(Bsuma, nro1, Bresta);
        
        VBox cajaV2 = new VBox(10);////////segunda caja
        cajaV2.setAlignment(Pos.TOP_RIGHT);
        
        Image Imult = new Image(getClass().getResource("Imult.png"+"").toExternalForm());
        ImageView IVmult = new ImageView(Imult);
        
        Button Bmult = new Button();
        Bmult.setId("Bmult");
        Bmult.setGraphic(IVmult);
        Bmult.setContentDisplay(ContentDisplay.CENTER);
        Bmult.setDefaultButton(true);
        
        Image Idiv = new Image(getClass().getResource("Idiv.png" + "").toExternalForm());
        ImageView IVdiv = new ImageView(Idiv);
        
        Button Bdiv = new Button();
        Bdiv.setId("Bdiv");
        Bdiv.setGraphic(IVdiv);
        Bdiv.setContentDisplay(ContentDisplay.CENTER);
        Bdiv.setDefaultButton(true);
        
        cajaV2.getChildren().addAll(Bmult, nro2, Bdiv);
        
        VBox cajaV3 = new VBox(50);//////tercera caja
        cajaV3.setAlignment(Pos.TOP_CENTER);
        
        Label lblrpta = new Label("");
        lblrpta.setTranslateY(20);
        lblrpta.setId("Lrpta");
        
        AddVal Hsuma = (x, y) -> x + y;
        AddVal Hresta = (x, y) -> x - y;
        AddVal Hmult = (x, y) -> x * y;
        AddVal Hdiv = (x, y) -> x / y;
        
        Bsuma.setOnAction((ActionEvent event) -> lblrpta.setText("" + Hsuma.getValor(a, b)));
        Bresta.setOnAction((ActionEvent event) -> lblrpta.setText("" + Hresta.getValor(a, b)));
        Bmult.setOnAction((ActionEvent event) -> lblrpta.setText("" + Hmult.getValor(a, b)));
        Bdiv.setOnAction((ActionEvent event)-> lblrpta.setText("" + Hdiv.getValor(a, b)));
        
        Button close = new Button("CERRAR");
        close.setId("Bclose");
        close.setTranslateY(290);
        
        close.setOnAction((ActionEvent event) -> {Stage Bye = (Stage) close.getScene().getWindow();Bye.close();});
        
        cajaV3.getChildren().addAll(lblrpta, close);
        
        root.getChildren().addAll(cajaV1, cajaV2, cajaV3);//////poner cajas
        Scene escene = new Scene(root, 450, 400);
        
        stage.initStyle(StageStyle.UNDECORATED);
        escene.getStylesheets().add(OR.class.getResource("cascada.css" + "").toExternalForm());
        stage.setScene(escene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
