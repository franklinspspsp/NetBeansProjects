/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listado1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Listado1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
        ColumnConstraints columna1 = new ColumnConstraints(150,150,Double.MAX_VALUE);
        ColumnConstraints columna2 = new ColumnConstraints(50);
        ColumnConstraints columna3 = new ColumnConstraints(150,150,Double.MAX_VALUE);
        
        columna1.setHgrow(Priority.ALWAYS);
        columna3.setHgrow(Priority.ALWAYS);
        
        gridpane.getColumnConstraints().addAll(columna1,columna2,columna3);
                
        Label lblCandidato = new Label("Candidatos");
        GridPane.setHalignment(lblCandidato, HPos.CENTER);
        gridpane.add(lblCandidato,0,0);
     
                
        Label lblVotante = new Label("Candidatos");
        GridPane.setHalignment(lblVotante, HPos.CENTER);
        gridpane.add(lblVotante,2,0);
        
        final ObservableList<String> candidatos = FXCollections.observableArrayList("Steff","Jhon");
        final ListView<String> lstvCandidatos = new ListView<>(candidatos);
        gridpane.add(lstvCandidatos,0,1);

        final ObservableList<String> votantes = FXCollections.observableArrayList();
        final ListView<String> lstvVotantes = new ListView<>(votantes);
        gridpane.add(lstvCandidatos,2,1);
        
        Button btnDerecha = new Button(">");
        btnDerecha.setOnAction((event) -> {
            String traslado = lstvCandidatos.getSelectionModel().getSelectedItem();
            if(traslado!=null){
                lstvCandidatos.getSelectionModel().clearSelection();
                candidatos.remove(traslado);
                votantes.add(traslado);
            }
        });
        
        Button btnIzquierda = new Button("<");
        btnDerecha.setOnAction((event) -> {
            String traslado1 = lstvVotantes.getSelectionModel().getSelectedItem();
            if(traslado1!=null){
                lstvVotantes.getSelectionModel().clearSelection();
                votantes.remove(traslado1);
                candidatos.add(traslado1);
            }
        });
        
        VBox vbContenedor = new VBox();
        vbContenedor.getChildren().addAll(btnDerecha,btnIzquierda);
        
        gridpane.add(vbContenedor, 1, 1);
        
        BorderPane root = new BorderPane();
        root.getChildren().add(gridpane);
        
        Scene scene = new Scene(root,300,250);
        
        primaryStage.setTitle("Usando Columnas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
