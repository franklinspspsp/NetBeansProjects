/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_checkerboard;

import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.GridPane;
    import javafx.stage.Stage;


    public class SD_Checkerboard extends Application {
    @Override
    public void start(Stage s) {
     //Create the integers for creating the grid.
    int n=5;
    int row;
    int column;



    //Create the gridpane.
    GridPane grid = new GridPane();

     for(row=0; row<n; row++) {
     for(column=0; column<n; column++) {
   TextField box = new TextField();
   box.setEditable(false);

   if(row + column % 2== 1){
     box.setStyle("-fx-background-color: black");
     grid.add(box,column,row);
   }
   else {
    box.setStyle("-fx-background-color: white");
    grid.add(box,column,row);
   }

   }
   }
     s.setScene(new Scene(grid));
     s.setTitle("Checkerboard");
      s.show();

    }

    public static void main(String[] args) {
      launch(args); 
      }

     }