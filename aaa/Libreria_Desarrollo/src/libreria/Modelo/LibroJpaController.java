/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Modelo;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import libreria.Persistence.Autor;
import libreria.Persistence.Venta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import libreria.Modelo.exceptions.IllegalOrphanException;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Modelo.exceptions.PreexistingEntityException;
import libreria.Persistence.Libro;

/**
 *
 * @author USUARIO
 */
public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) throws PreexistingEntityException, Exception {
        if (libro.getVentaCollection() == null) {
            libro.setVentaCollection(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autor idAutor = libro.getIdAutor();
            if (idAutor != null) {
                idAutor = em.getReference(idAutor.getClass(), idAutor.getIdAutor());
                libro.setIdAutor(idAutor);
            }
            Collection<Venta> attachedVentaCollection = new ArrayList<Venta>();
            for (Venta ventaCollectionVentaToAttach : libro.getVentaCollection()) {
                ventaCollectionVentaToAttach = em.getReference(ventaCollectionVentaToAttach.getClass(), ventaCollectionVentaToAttach.getIdVenta());
                attachedVentaCollection.add(ventaCollectionVentaToAttach);
            }
            libro.setVentaCollection(attachedVentaCollection);
            em.persist(libro);
            if (idAutor != null) {
                idAutor.getLibroCollection().add(libro);
                idAutor = em.merge(idAutor);
            }
            for (Venta ventaCollectionVenta : libro.getVentaCollection()) {
                Libro oldIdLibroOfVentaCollectionVenta = ventaCollectionVenta.getIdLibro();
                ventaCollectionVenta.setIdLibro(libro);
                ventaCollectionVenta = em.merge(ventaCollectionVenta);
                if (oldIdLibroOfVentaCollectionVenta != null) {
                    oldIdLibroOfVentaCollectionVenta.getVentaCollection().remove(ventaCollectionVenta);
                    oldIdLibroOfVentaCollectionVenta = em.merge(oldIdLibroOfVentaCollectionVenta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLibro(libro.getIdLibro()) != null) {
                throw new PreexistingEntityException("Libro " + libro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro persistentLibro = em.find(Libro.class, libro.getIdLibro());
            Autor idAutorOld = persistentLibro.getIdAutor();
            Autor idAutorNew = libro.getIdAutor();
            Collection<Venta> ventaCollectionOld = persistentLibro.getVentaCollection();
            Collection<Venta> ventaCollectionNew = libro.getVentaCollection();
            List<String> illegalOrphanMessages = null;
            for (Venta ventaCollectionOldVenta : ventaCollectionOld) {
                if (!ventaCollectionNew.contains(ventaCollectionOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaCollectionOldVenta + " since its idLibro field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idAutorNew != null) {
                idAutorNew = em.getReference(idAutorNew.getClass(), idAutorNew.getIdAutor());
                libro.setIdAutor(idAutorNew);
            }
            Collection<Venta> attachedVentaCollectionNew = new ArrayList<Venta>();
            for (Venta ventaCollectionNewVentaToAttach : ventaCollectionNew) {
                ventaCollectionNewVentaToAttach = em.getReference(ventaCollectionNewVentaToAttach.getClass(), ventaCollectionNewVentaToAttach.getIdVenta());
                attachedVentaCollectionNew.add(ventaCollectionNewVentaToAttach);
            }
            ventaCollectionNew = attachedVentaCollectionNew;
            libro.setVentaCollection(ventaCollectionNew);
            libro = em.merge(libro);
            if (idAutorOld != null && !idAutorOld.equals(idAutorNew)) {
                idAutorOld.getLibroCollection().remove(libro);
                idAutorOld = em.merge(idAutorOld);
            }
            if (idAutorNew != null && !idAutorNew.equals(idAutorOld)) {
                idAutorNew.getLibroCollection().add(libro);
                idAutorNew = em.merge(idAutorNew);
            }
            for (Venta ventaCollectionNewVenta : ventaCollectionNew) {
                if (!ventaCollectionOld.contains(ventaCollectionNewVenta)) {
                    Libro oldIdLibroOfVentaCollectionNewVenta = ventaCollectionNewVenta.getIdLibro();
                    ventaCollectionNewVenta.setIdLibro(libro);
                    ventaCollectionNewVenta = em.merge(ventaCollectionNewVenta);
                    if (oldIdLibroOfVentaCollectionNewVenta != null && !oldIdLibroOfVentaCollectionNewVenta.equals(libro)) {
                        oldIdLibroOfVentaCollectionNewVenta.getVentaCollection().remove(ventaCollectionNewVenta);
                        oldIdLibroOfVentaCollectionNewVenta = em.merge(oldIdLibroOfVentaCollectionNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = libro.getIdLibro();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIdLibro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Venta> ventaCollectionOrphanCheck = libro.getVentaCollection();
            for (Venta ventaCollectionOrphanCheckVenta : ventaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Libro (" + libro + ") cannot be destroyed since the Venta " + ventaCollectionOrphanCheckVenta + " in its ventaCollection field has a non-nullable idLibro field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Autor idAutor = libro.getIdAutor();
            if (idAutor != null) {
                idAutor.getLibroCollection().remove(libro);
                idAutor = em.merge(idAutor);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
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

    public Libro findLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
