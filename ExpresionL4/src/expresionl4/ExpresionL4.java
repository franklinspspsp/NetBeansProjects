package expresionl4;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExpresionL4 extends Application {
    
    interface Numero{
        boolean pruebaNumero(int n, int m);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Numero esDivisor = (n,d) -> (n%d)==0;
        if(esDivisor.pruebaNumero(10, 2)){
            System.out.println("El valor 2 es divisor de 10");
        }    
        else{
            System.out.println("No existe divisor");
        }
        
        Numero mayorque = (n,m) -> (n>m);
        if(mayorque.pruebaNumero(7, 6)){
            System.out.println("7 es mayor que 6");
        }
        
        if(mayorque.pruebaNumero(10, 100)){
            System.out.println("10 no es mayor que 100");
        }
        
        Numero valorAbs = (a,b) -> (a<0 ? -a:a)==(b<0 ? -b:b);
        if(valorAbs.pruebaNumero(4, -4)){
            System.out.println("Los valores absolutos de 4 y -4 son iguales");
        }
        
        if(valorAbs.pruebaNumero(4, -6)){
            System.out.println("Los valores absolutos de 4 y -6 no son iguales");
        }
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
