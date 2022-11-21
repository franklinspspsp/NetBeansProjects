/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.Modelo.UsuarioJpaController;
import libreria.Modelo.exceptions.IllegalOrphanException;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Persistence.Usuario;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO {
    private final UsuarioJpaController uC;
    private EntityManagerFactory emf=null;
    
    public UsuarioDAO(){
        emf=Persistence.createEntityManagerFactory("Libreria_DesarrolloPU");
        uC=new UsuarioJpaController(emf);
    }
    
    public void AgregarUsuario(Usuario usuario) throws Exception{
        uC.create(usuario);
    }
    
    public void ModificarUsuario(Usuario usuario) throws Exception{
        uC.edit(usuario);
    }
    
    public void EliminarUsuario(String DNI) throws IllegalOrphanException, NonexistentEntityException{
        uC.destroy(DNI);
    }
    
    public List<Usuario>getAllUsuarios(){
        return uC.findUsuarioEntities();
    }
    
    public Usuario getUsuariosById(String DNI){
        return uC.findUsuario(DNI);
    }
}
