/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.Modelo.AutorJpaController;
import libreria.Modelo.exceptions.IllegalOrphanException;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Persistence.Autor;

/**
 *
 * @author USUARIO
 */
public class AutorDAO {
    private final AutorJpaController auC;
    private EntityManagerFactory emf=null;
    
    public AutorDAO(){
        emf=Persistence.createEntityManagerFactory("Libreria_DesarrolloPU");
        auC=new AutorJpaController(emf);
    }
    
    public void AgregarAutor(Autor autor) throws Exception{
        auC.create(autor);
    }
    
    public void ModificarAutor(Autor autor) throws Exception{
        auC.edit(autor);
    }
    
    public void EliminarAutor(int IdAutor) throws NonexistentEntityException, IllegalOrphanException{
        auC.destroy(IdAutor);
    }
    
    public List<Autor>getAllAutores(){
        return auC.findAutorEntities();
    }
    
    public Autor getAutoresById(int IdAutor){
        return auC.findAutor(IdAutor);
    }
}
