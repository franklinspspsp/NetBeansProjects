/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.Modelo.LibroJpaController;
import libreria.Modelo.exceptions.IllegalOrphanException;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Persistence.Libro;

/**
 *
 * @author USUARIO
 */
public class LibroDAO {
    private final LibroJpaController lC;
    private EntityManagerFactory emf=null;
    
    public LibroDAO(){
        emf=Persistence.createEntityManagerFactory("Libreria_DesarrolloPU");
        lC=new LibroJpaController(emf);
    }
    
    public void AgregarLibro(Libro libro) throws Exception{
        lC.create(libro);
    }
    
    public void ModificarLibro(Libro libro) throws Exception{
        lC.edit(libro);
    }
    
    public void EliminarLibro(int IdLibro) throws IllegalOrphanException, NonexistentEntityException{
        lC.destroy(IdLibro);
    }
    
    public List<Libro>getAllLibros(){
        return lC.findLibroEntities();
    }
    
    public Libro getLibrosById(int IdLibro){
        return lC.findLibro(IdLibro);
    }
}
