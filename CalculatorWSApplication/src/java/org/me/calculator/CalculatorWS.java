package org.me.calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "CalculatorWS")
@Stateless()
public class CalculatorWS { 
    /**
     * Web service operation
     * @param i
     * @param j
     * @return 
     */
    @WebMethod(operationName = "Suma")
    public double Suma(@WebParam(name = "i") double i, @WebParam(name = "j") double j) {
        //TODO write your implementation code here:
        double k = i + j;
        return k;
    }

    /**
     * Web service operation
     * @param i
     * @param j
     * @return 
     */
    @WebMethod(operationName = "Resta")
    public double Resta(@WebParam(name = "i") double i, @WebParam(name = "j") double j) {
        //TODO write your implementation code here:
        double k = i - j;
        return k;
    }

    /**
     * Web service operation
     * @param i
     * @param j
     * @return 
     */
    @WebMethod(operationName = "Multiplicacion")
    public double Multiplicacion(@WebParam(name = "i") double i, @WebParam(name = "j") double j) {
        //TODO write your implementation code here:
        double k = i * j;
        return k;
    }

    /**
     * Web service operation
     * @param i
     * @param j
     * @return 
     */
    @WebMethod(operationName = "Division")
    public double Division(@WebParam(name = "i") double i, @WebParam(name = "j") double j) {
        //TODO write your implementation code here:
        double k = i / j;
        return k;
    }
}