/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Persistence.Usuario;
import libreria.Persistence.Libro;
import libreria.Persistence.Autor;
import libreria.Persistence.Venta;

/**
 *
 * @author USUARIO
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario dni = venta.getDni();
            if (dni != null) {
                dni = em.getReference(dni.getClass(), dni.getDni());
                venta.setDni(dni);
            }
            Libro idLibro = venta.getIdLibro();
            if (idLibro != null) {
                idLibro = em.getReference(idLibro.getClass(), idLibro.getIdLibro());
                venta.setIdLibro(idLibro);
            }
            Autor idAutor = venta.getIdAutor();
            if (idAutor != null) {
                idAutor = em.getReference(idAutor.getClass(), idAutor.getIdAutor());
                venta.setIdAutor(idAutor);
            }
            em.persist(venta);
            if (dni != null) {
                dni.getVentaCollection().add(venta);
                dni = em.merge(dni);
            }
            if (idLibro != null) {
                idLibro.getVentaCollection().add(venta);
                idLibro = em.merge(idLibro);
            }
            if (idAutor != null) {
                idAutor.getVentaCollection().add(venta);
                idAutor = em.merge(idAutor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdVenta());
            Usuario dniOld = persistentVenta.getDni();
            Usuario dniNew = venta.getDni();
            Libro idLibroOld = persistentVenta.getIdLibro();
            Libro idLibroNew = venta.getIdLibro();
            Autor idAutorOld = persistentVenta.getIdAutor();
            Autor idAutorNew = venta.getIdAutor();
            if (dniNew != null) {
                dniNew = em.getReference(dniNew.getClass(), dniNew.getDni());
                venta.setDni(dniNew);
            }
            if (idLibroNew != null) {
                idLibroNew = em.getReference(idLibroNew.getClass(), idLibroNew.getIdLibro());
                venta.setIdLibro(idLibroNew);
            }
            if (idAutorNew != null) {
                idAutorNew = em.getReference(idAutorNew.getClass(), idAutorNew.getIdAutor());
                venta.setIdAutor(idAutorNew);
            }
            venta = em.merge(venta);
            if (dniOld != null && !dniOld.equals(dniNew)) {
                dniOld.getVentaCollection().remove(venta);
                dniOld = em.merge(dniOld);
            }
            if (dniNew != null && !dniNew.equals(dniOld)) {
                dniNew.getVentaCollection().add(venta);
                dniNew = em.merge(dniNew);
            }
            if (idLibroOld != null && !idLibroOld.equals(idLibroNew)) {
                idLibroOld.getVentaCollection().remove(venta);
                idLibroOld = em.merge(idLibroOld);
            }
            if (idLibroNew != null && !idLibroNew.equals(idLibroOld)) {
                idLibroNew.getVentaCollection().add(venta);
                idLibroNew = em.merge(idLibroNew);
            }
            if (idAutorOld != null && !idAutorOld.equals(idAutorNew)) {
                idAutorOld.getVentaCollection().remove(venta);
                idAutorOld = em.merge(idAutorOld);
            }
            if (idAutorNew != null && !idAutorNew.equals(idAutorOld)) {
                idAutorNew.getVentaCollection().add(venta);
                idAutorNew = em.merge(idAutorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venta.getIdVenta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Usuario dni = venta.getDni();
            if (dni != null) {
                dni.getVentaCollection().remove(venta);
                dni = em.merge(dni);
            }
            Libro idLibro = venta.getIdLibro();
            if (idLibro != null) {
                idLibro.getVentaCollection().remove(venta);
                idLibro = em.merge(idLibro);
            }
            Autor idAutor = venta.getIdAutor();
            if (idAutor != null) {
                idAutor.getVentaCollection().remove(venta);
                idAutor = em.merge(idAutor);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
