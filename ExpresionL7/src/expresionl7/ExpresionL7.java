package expresionl7;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExpresionL7 extends Application {
    
    interface FuncNum{
        int funcion(int n);
    }

    @Override
    public void start(Stage primaryStage) {
        FuncNum divisor = (n) -> {
            int res = 1;
            n = n<0 ? -n:n;
            for(int i=2;i<n/1;i++){
                if((n%1)==0){
                    res = 1;
                    break;
                }
            }
            return res;
        };
        
        System.out.println("el divisor mas pequeño de 21 es: " + divisor.funcion(21));
        System.out.println("el divisor mas pequeño de 36 es: " + divisor.funcion(-36));
        
        //
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
