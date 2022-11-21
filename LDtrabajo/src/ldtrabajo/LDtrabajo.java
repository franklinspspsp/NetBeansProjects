package ldtrabajo;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LDtrabajo extends Application {
    
    interface MVP{
        int getValor(int x, int y);
    }

    @Override
    public void start(Stage stage) {
        Random aleatorio = new Random(System.currentTimeMillis());
        int a = aleatorio.nextInt(100);
        int b = aleatorio.nextInt(100);
        
        MVP opermas = (x,y) -> x+y;
        
        Image Isuma = new Image(getClass().getResource("Isuma.png" + "").toExternalForm());
        ImageView IVsuma = new ImageView(Isuma);
        
        Button btn1 = new Button("SUMAR");
        btn1.setTranslateX(0);
        btn1.setTranslateY(0);
        btn1.setId("Boperar");
        btn1.setGraphic(IVsuma);
        btn1.setContentDisplay(ContentDisplay.TOP);
        btn1.setDefaultButton(true);
        
        Label lbl1 = new Label(a + "+" + b);
        lbl1.setTranslateX(0);
        lbl1.setTranslateY(60);
        lbl1.setId("Lsuma");
        
        Label lbl2 = new Label("Suma");
        lbl2.setTranslateX(0);
        lbl2.setTranslateY(90);
        lbl2.setId("Loper");
        btn1.setOnAction((ActionEvent event) -> lbl2.setText("Suma: " + opermas.getValor(a, b)));
        
        Button btn2 = new Button("Cerrar");
        btn2.setTranslateX(0);
        btn2.setTranslateY(120);
        btn2.setId("Bclose");
        
        btn2.setOnAction((ActionEvent event) -> {Stage Bye = (Stage) btn2.getScene().getWindow();Bye.close();});
        
        StackPane root = new StackPane();
        root.setId("pane");
        root.getChildren().addAll(btn1,btn2,lbl1,lbl2);
        
        Scene escena = new Scene(root, 350, 270);
        
        escena.getStylesheets().add(LDtrabajo.class.getResource("cascada.css" + "").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Lambda");
        stage.setScene(escena);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}