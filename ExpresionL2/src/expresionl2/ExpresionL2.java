package expresionl2;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExpresionL2 extends Application {
    
    interface Ecuacion{
        double operacion(double x1, double x2);
    }

    @Override
    public void start(Stage primaryStage) {
        Ecuacion areaTriangulo = (base, altura) -> (base*altura)/2;
        Ecuacion areaCuadrado = (base, altura) -> base*altura;
        
        System.out.println("Area del triangulo " + areaTriangulo.operacion(12, 5));
        System.out.println("Area del cuadrado " + areaCuadrado.operacion(12, 5));
        
        System.exit(0);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}