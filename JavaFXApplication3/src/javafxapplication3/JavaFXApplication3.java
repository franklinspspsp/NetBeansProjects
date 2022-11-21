package javafxapplication3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text TituloScene = new Text("Crear Cuenta");
        TituloScene.setFont(Font.font("Verdana", FontWeight.LIGHT,20));
        grid.add(TituloScene, 0, 0);
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("Nuevo Proyecto");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Label usuario = new Label("Correo Electronico ");
        grid.add(usuario, 0, 1);
        
        TextField txtUsuario = new  TextField();
        grid.add(txtUsuario, 0, 2);
        
        Label contraseña = new Label("Contraseña: ");
        grid.add(contraseña, 0, 3);
        
        PasswordField pwConstraseña = new PasswordField();
        grid.add(pwConstraseña, 0, 4);
        
        Button boton1 = new Button();
        boton1.setText("Registrarse");
        boton1.setDefaultButton(true);
        boton1.setContentDisplay(ContentDisplay.TOP);
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(boton1);
        grid.add(boton1, 0, 5);
        
        Separator sepVert1 = new Separator();
        sepVert1.setOrientation(Orientation.VERTICAL);
        sepVert1.setValignment(VPos.CENTER);
        sepVert1.setPrefHeight(80);
        GridPane.setConstraints(sepVert1, 2, 2);
        GridPane.setRowSpan(sepVert1, 2);
        grid.getChildren().add(sepVert1);
        
        Label usa = new Label("O usa trivago de otra forma");
        
        usa.setFont(Font.font("Verdana", 18));
        GridPane.setConstraints(usa, 3, 1);
        GridPane.setColumnSpan(usa, 2);
        grid.getChildren().add(usa);
        
        Button boton2 = new Button();
        boton2.setText("Continuar con Google");
        boton2.setContentDisplay(ContentDisplay.RIGHT);
        
        Button boton3 = new Button();
        boton3.setText("Continuar con Google");
        boton3.setContentDisplay(ContentDisplay.RIGHT);
        
        Button boton4 = new Button();
        boton4.setText("Continuar con Google");
        boton4.setContentDisplay(ContentDisplay.RIGHT);
        
        Button boton5 = new Button();
        boton5.setText("Continuar con Google");
        boton5.setContentDisplay(ContentDisplay.RIGHT);
        
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_CENTER);
        hbtn.getChildren().addAll(boton2);
        grid.add(hbtn, 3, 2);
        
        HBox hbtn1 = new HBox(10);
        hbtn1.setAlignment(Pos.BOTTOM_CENTER);
        hbtn1.getChildren().addAll(boton3);
        grid.add(hbtn1, 3, 3);
        
        HBox hbtn2 = new HBox(10);
        hbtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbtn2.getChildren().addAll(boton4);
        grid.add(hbtn2, 3, 4);
        
        HBox hbtn3 = new HBox(10);
        hbtn3.setAlignment(Pos.BOTTOM_CENTER);
        hbtn3.getChildren().addAll(boton5);
        grid.add(hbtn3, 3, 5);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
