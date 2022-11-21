/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entidades.Cliente;
import Modelo.ClienteJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class JavaBeanCliente {
 
    private EntityManagerFactory emf;
    private ClienteJpaController clienteControl;
    
    public JavaBeanCliente(){
        emf=Persistence.createEntityManagerFactory("WebApachePU");
        clienteControl= new ClienteJpaController(emf);
    }   
    
    public void Guardar(Cliente cliente){
        try {
            clienteControl.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(JavaBeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cliente> ListarTodo(){
        return clienteControl.findClienteEntities();
    }
    
    public void Buscar(Integer dniCliente){
        clienteControl.findCliente(dniCliente);
    }
}
