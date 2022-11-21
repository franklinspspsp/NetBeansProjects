package expresionl5;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExpresionL5 extends Application {
    
    interface Cadena{
        boolean cadena1(String c1, String c2);
    }

    @Override
    public void start(Stage primaryStage) {
        Cadena parte = (x1,x2) -> x1.indexOf(x2) != -1;
        String str = " es una muestra";
        
        System.out.println("probando cadenas" + str);
        if(parte.cadena1(str,"una")){
            System.out.println("una, pertenece a la cadena");
        }
        else{
            System.out.println("una, no pertenece a la cadena");
        }
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
