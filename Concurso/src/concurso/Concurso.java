package concurso;

import java.util.Scanner;

public class Concurso{
    public static void main(String[] args) {
        int a,b,c,d,x;
        do{
            Scanner sc = new Scanner(System.in);
            x=sc.nextInt();
        }
        while(x<1000&&x>9000);{
        for(int i=x+1;;i++){
            a=i%10;
            b=(i/10)%10;
            c=(i/100)%10;
            d=(i/1000)%10;
            if(a!=b&&b!=c&&c!=d&&a!=c&&b!=d&&a!=d){
                System.out.println(i);
                break;
            }
        }
    }
    }
}