/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import Entidades.Factura;
import Modelo.ClienteJpaController;
import Modelo.FacturaJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class FacturaDAO {
    private final FacturaJpaController FaC;
    private EntityManagerFactory emf=null;
    
    public FacturaDAO(){
        emf=Persistence.createEntityManagerFactory("Proyecto3ra_UnidadPU");
        FaC=new FacturaJpaController(emf);
    }
    
    public void AgregarFactura(Factura factura) throws Exception{
        FaC.create(factura);
    }
    
    public void ModificarFactura(Factura factura) throws Exception{
        FaC.edit(factura);
    }
    
    public void EliminarFactura(int IdFactura) throws Exception{
        FaC.destroy(IdFactura);
    }
    
    public List<Factura>getAllFacturas(){
        return FaC.findFacturaEntities();
    }
    
    public Factura getClientesById(int IdFactura){
        return FaC.findFactura(IdFactura);
    }
}
