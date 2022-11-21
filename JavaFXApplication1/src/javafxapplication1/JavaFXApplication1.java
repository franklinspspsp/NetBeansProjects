/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author EPIS
 */
public class JavaFXApplication1 extends Application {

    private Parent grid;
    
    @Override
    public void start(Stage primaryStage) {
        
        Image imagen = new Image(getClass().getResource("icono-candado.png" + "").toExternalForm());
        ImageView VImage = new ImageView();
        VImage.setImage(imagen);
        
        Button boton1 = new Button();
        boton1.setText("Aceptar");
        boton1.setGraphic(VImage);
        boton1.setDefaultButton(true);
        boton1.setContentDisplay(ContentDisplay.TOP);
        
        Image imagen2 = new Image(getClass().getResource("icono-candado.png" + "").toExternalForm());
        ImageView VImage2 = new ImageView();
        VImage2.setImage(imagen2);

        Image imagen3 = new Image(getClass().getResource("anime-girl-writing.gif"+ "").toExternalForm());
        ImageView VImage3 = new ImageView();
        VImage3.setImage(imagen3);
        
        Button boton2 = new Button();
        boton2.setGraphic(VImage2);
        boton2.setText("Cancelar");
        boton2.setContentDisplay(ContentDisplay.TOP);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setId("pane");
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
                
        Text TituloScene = new Text("JavaFX");
        TituloScene.setId("TituloId");
        TituloScene.setFont(Font.font("Verdana", FontWeight.LIGHT,20));
        grid.add(TituloScene, 0, 0);
        
        Label usuario = new Label("NombreU: ");
        usuario.setId("label1");
        grid.add(usuario, 0, 1);
        
        TextField txtUsuario = new  TextField();
        grid.add(txtUsuario, 1, 1);
      
        Label contraseña = new Label("Password: ");
        contraseña.setId("label2");
        grid.add(contraseña, 0, 2);
        
        PasswordField pwConstraseña = new PasswordField();
        grid.add(pwConstraseña, 1, 2);
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(boton1);
        grid.add(boton1, 1, 3);
        
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().addAll(boton1,boton2);
        grid.add(hbtn, 1, 3);
    
        final Text ejecucion = new Text();
        grid.add(ejecucion, 1, 4);boton1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Bienvenidos");
                ejecucion.setFill(Color.CHOCOLATE);
                ejecucion.setText("Usuario Aceptado");
            
            }
        });
 //       StackPane root = new StackPane();
 //       root.getChildren().add(boton1);
        
        //Scene scene = new Scene(root, 300, 250);
        
        Scene scene = new Scene(grid, 300, 275);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(JavaFXApplication1.class.getResource("npcascade.css"+"").toExternalForm());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}