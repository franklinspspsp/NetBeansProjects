/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Celulares;
import Modelo.CelularesJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class CelularesDAO {
    private final CelularesJpaController celC;
    private EntityManagerFactory emf=null;
    
    public CelularesDAO(){
        emf=Persistence.createEntityManagerFactory("Proyecto3ra_UnidadPU");
        celC=new CelularesJpaController(emf);
    }
    
    public void AgregarCelular(Celulares celulares) throws Exception{
        celC.create(celulares);
    }
    
    public void ModificarCelular(Celulares celulares) throws Exception{
        celC.edit(celulares);
    }
    
    public void EliminarCelular(int IdCelular) throws Exception{
        celC.destroy(IdCelular);
    }
    
    public List<Celulares>getAllCelulares(){
        return celC.findCelularesEntities();
    }
    
    public Celulares getCelularesById(int IdCelular){
        return celC.findCelulares(IdCelular);
    }
}
