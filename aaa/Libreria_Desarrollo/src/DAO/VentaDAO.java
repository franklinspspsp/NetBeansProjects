/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.Modelo.VentaJpaController;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Persistence.Venta;

/**
 *
 * @author USUARIO
 */
public class VentaDAO {
    private final VentaJpaController vC;
    private EntityManagerFactory emf=null;
    
    public VentaDAO(){
        emf=Persistence.createEntityManagerFactory("Libreria_DesarrolloPU");
        vC=new VentaJpaController(emf);
    }
    
    public void AgregarVenta(Venta venta) throws Exception{
        vC.create(venta);
    }
    
    public void ModificarVenta(Venta venta) throws Exception{
        vC.edit(venta);
    }
    
    public void EliminarVenta(int IdVenta) throws NonexistentEntityException{
        vC.destroy(IdVenta);
    }
    
    public List<Venta>getAllVentas(){
        return vC.findVentaEntities();
    }
    
    public Venta getVentasById(int IdVenta){
        return vC.findVenta(IdVenta);
    }
}
