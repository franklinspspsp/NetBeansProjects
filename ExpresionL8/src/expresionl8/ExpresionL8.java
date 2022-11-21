package expresionl8;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExpresionL8 extends Application {
    
    interface funcion1{
        int operacion1(int a, int b);
    }
    
    interface funcion2{
        void mensaje(String mensaje);
    }
    
    private int operador(int a, int b, funcion1 funcion0){
        return funcion0.operacion1(a, b);
    }

    @Override
    public void start(Stage primaryStage) {
        funcion1 sumar = (x,y) -> x+y;
        funcion1 multiplicar = (x,y) -> x*y;
        
        ExpresionL8 prueba1 = new ExpresionL8();
        System.out.println("La suma es: " + prueba1.operador(3, 10, sumar));
        System.out.println("La multiplicacion es: " + prueba1.operador(64, -3, multiplicar));
        
        funcion2 f2 = (mensaje) -> System.out.println("Lambda JavaFX" + mensaje);;
        f2.mensaje(" Sorpresa!!!...");
        
        //resta y division
        
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
