package expresionl6;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

public class ExpresionL6 extends Application {

    @Override
    public void start(Stage primaryStage) {
        List<String> lista = new ArrayList<String>();
        lista.add("Mario");
        lista.add("Miurka");
        lista.add("Thomas");
        lista.add("Tom");
        
        lista.forEach((l1) -> System.out.println(l1));
        
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(6);
        
        numeros.forEach(n -> System.out.println(n));
        numeros.forEach(n -> {if(n%2==0)System.out.println("Multiplo de 2: " + n);});
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
