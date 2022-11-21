package personatableview;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PersonaTableView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TableView<Persona> tableView = new TableView();
        TableColumn<Persona, String> colNombre = new TableColumn<>("Nombre"); 
        TableColumn<Persona, String> colApellido = new TableColumn<>("Apellido"); 
        TableColumn<Persona, LocalDate> colFechaNacimiento = new TableColumn<>("Fecha de Nacimiento"); 
        tableView.getColumns().addAll(colNombre, colApellido, colFechaNacimiento);
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        Persona p1 = new Persona("Juan", "Perez", LocalDate.parse("2012-11-01"));
        Persona p2 = new Persona("Maria", "Loza", LocalDate.parse("2013-01-15"));
        Persona p3 = new Persona("Adriana", "Mendez", LocalDate.parse("2014-07-20"));
        tableView.getItems().addAll(p1, p2, p3);
        
        Label lbl1 = new Label("Este es un label CSS = .label");
        Label lbl2 = new Label("Este es un label CSS = .label");
        Label lbl3 = new Label("Este es un label ID = texto, CSS = #texto");
        lbl3.setId("texto");
        
//        VBox root = new VBox();
//        root.setStyle("-fx-alignment: CENTER; -fx-background-color: gray;");
//        root.getChildren().addAll(lbl1, lbl2, lbl3);
//        root.getStyleClass().add("vertical-box");
        
        Scene scene = new Scene(tableView, 380, 280);
        
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
                
//        // Switch to JavaFX 2.x's CASPIAN Look and Feel.
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
//        // Switch to JavaFX 8's Modena Look and Feel.
        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
