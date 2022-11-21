/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entidades.Factura;
import Modelo.FacturaJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class JavaBeanFactura {
    private EntityManagerFactory emf;
    private EntityManager em; 
    private FacturaJpaController facturaControl;
    
    public JavaBeanFactura(){
        emf=Persistence.createEntityManagerFactory("WebApachePU");
        facturaControl= new FacturaJpaController(emf);
    }   
    
    public void Guardar(Factura factura){
        facturaControl.create(factura);
    }
    
    public List<Factura> ListarTodo(){
        return facturaControl.findFacturaEntities();
    } 

}
