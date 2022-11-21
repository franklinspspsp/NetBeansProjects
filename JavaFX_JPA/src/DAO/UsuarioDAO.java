
package DAO;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaController.UsuariosJpaController;
import javafx_jpa.*;
import jpaController.exceptions.NonexistentEntityException;

public class UsuarioDAO {
    private final UsuariosJpaController usuarioController;
    private EntityManagerFactory emf = null;

    public UsuarioDAO() {
        emf=Persistence.createEntityManagerFactory("JavaFX_JPAPU");
        usuarioController = new UsuariosJpaController(emf);
    }
    
    public void AgregarUsuario(Usuarios usuario) throws Exception{
        usuarioController.create(usuario);
    }
    
    public void ModificarUsuario(Usuarios usuario) throws Exception{
        usuarioController.edit(usuario);
    }
    
    public void EliminarUsuario(int IdUsuario) throws NonexistentEntityException{
        usuarioController.destroy(IdUsuario);
    }
    
    public List<Usuarios> getAllUsuarios(){
        return usuarioController.findUsuariosEntities();
    }
    
    public Usuarios getUsuariosById(int IdUsuario){
        return usuarioController.findUsuarios(IdUsuario);
    }
}
