/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Modelo.ClienteJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class ClienteDAO {
    private final ClienteJpaController cliC;
    private EntityManagerFactory emf=null;
    
    public ClienteDAO(){
        emf=Persistence.createEntityManagerFactory("Proyecto3ra_UnidadPU");
        cliC=new ClienteJpaController(emf);
    }
    
    public void AgregarCliente(Cliente cliente) throws Exception{
        cliC.create(cliente);
    }
    
    public void ModificarCelular(Cliente cliente) throws Exception{
        cliC.edit(cliente);
    }
    
    public void EliminarCelular(int IdCliente) throws Exception{
        cliC.destroy(IdCliente);
    }
    
    public List<Cliente>getAllClientes(){
        return cliC.findClienteEntities();
    }
    
    public Cliente getClientesById(int IdCliente){
        return cliC.findCliente(IdCliente);
    }
}
