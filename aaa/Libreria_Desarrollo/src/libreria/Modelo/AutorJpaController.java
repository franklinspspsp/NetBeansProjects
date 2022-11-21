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
import libreria.Persistence.Libro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import libreria.Modelo.exceptions.IllegalOrphanException;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Modelo.exceptions.PreexistingEntityException;
import libreria.Persistence.Autor;
import libreria.Persistence.Venta;

/**
 *
 * @author USUARIO
 */
public class AutorJpaController implements Serializable {

    public AutorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autor autor) throws PreexistingEntityException, Exception {
        if (autor.getLibroCollection() == null) {
            autor.setLibroCollection(new ArrayList<Libro>());
        }
        if (autor.getVentaCollection() == null) {
            autor.setVentaCollection(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Libro> attachedLibroCollection = new ArrayList<Libro>();
            for (Libro libroCollectionLibroToAttach : autor.getLibroCollection()) {
                libroCollectionLibroToAttach = em.getReference(libroCollectionLibroToAttach.getClass(), libroCollectionLibroToAttach.getIdLibro());
                attachedLibroCollection.add(libroCollectionLibroToAttach);
            }
            autor.setLibroCollection(attachedLibroCollection);
            Collection<Venta> attachedVentaCollection = new ArrayList<Venta>();
            for (Venta ventaCollectionVentaToAttach : autor.getVentaCollection()) {
                ventaCollectionVentaToAttach = em.getReference(ventaCollectionVentaToAttach.getClass(), ventaCollectionVentaToAttach.getIdVenta());
                attachedVentaCollection.add(ventaCollectionVentaToAttach);
            }
            autor.setVentaCollection(attachedVentaCollection);
            em.persist(autor);
            for (Libro libroCollectionLibro : autor.getLibroCollection()) {
                Autor oldIdAutorOfLibroCollectionLibro = libroCollectionLibro.getIdAutor();
                libroCollectionLibro.setIdAutor(autor);
                libroCollectionLibro = em.merge(libroCollectionLibro);
                if (oldIdAutorOfLibroCollectionLibro != null) {
                    oldIdAutorOfLibroCollectionLibro.getLibroCollection().remove(libroCollectionLibro);
                    oldIdAutorOfLibroCollectionLibro = em.merge(oldIdAutorOfLibroCollectionLibro);
                }
            }
            for (Venta ventaCollectionVenta : autor.getVentaCollection()) {
                Autor oldIdAutorOfVentaCollectionVenta = ventaCollectionVenta.getIdAutor();
                ventaCollectionVenta.setIdAutor(autor);
                ventaCollectionVenta = em.merge(ventaCollectionVenta);
                if (oldIdAutorOfVentaCollectionVenta != null) {
                    oldIdAutorOfVentaCollectionVenta.getVentaCollection().remove(ventaCollectionVenta);
                    oldIdAutorOfVentaCollectionVenta = em.merge(oldIdAutorOfVentaCollectionVenta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAutor(autor.getIdAutor()) != null) {
                throw new PreexistingEntityException("Autor " + autor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autor autor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autor persistentAutor = em.find(Autor.class, autor.getIdAutor());
            Collection<Libro> libroCollectionOld = persistentAutor.getLibroCollection();
            Collection<Libro> libroCollectionNew = autor.getLibroCollection();
            Collection<Venta> ventaCollectionOld = persistentAutor.getVentaCollection();
            Collection<Venta> ventaCollectionNew = autor.getVentaCollection();
            List<String> illegalOrphanMessages = null;
            for (Libro libroCollectionOldLibro : libroCollectionOld) {
                if (!libroCollectionNew.contains(libroCollectionOldLibro)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Libro " + libroCollectionOldLibro + " since its idAutor field is not nullable.");
                }
            }
            for (Venta ventaCollectionOldVenta : ventaCollectionOld) {
                if (!ventaCollectionNew.contains(ventaCollectionOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaCollectionOldVenta + " since its idAutor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Libro> attachedLibroCollectionNew = new ArrayList<Libro>();
            for (Libro libroCollectionNewLibroToAttach : libroCollectionNew) {
                libroCollectionNewLibroToAttach = em.getReference(libroCollectionNewLibroToAttach.getClass(), libroCollectionNewLibroToAttach.getIdLibro());
                attachedLibroCollectionNew.add(libroCollectionNewLibroToAttach);
            }
            libroCollectionNew = attachedLibroCollectionNew;
            autor.setLibroCollection(libroCollectionNew);
            Collection<Venta> attachedVentaCollectionNew = new ArrayList<Venta>();
            for (Venta ventaCollectionNewVentaToAttach : ventaCollectionNew) {
                ventaCollectionNewVentaToAttach = em.getReference(ventaCollectionNewVentaToAttach.getClass(), ventaCollectionNewVentaToAttach.getIdVenta());
                attachedVentaCollectionNew.add(ventaCollectionNewVentaToAttach);
            }
            ventaCollectionNew = attachedVentaCollectionNew;
            autor.setVentaCollection(ventaCollectionNew);
            autor = em.merge(autor);
            for (Libro libroCollectionNewLibro : libroCollectionNew) {
                if (!libroCollectionOld.contains(libroCollectionNewLibro)) {
                    Autor oldIdAutorOfLibroCollectionNewLibro = libroCollectionNewLibro.getIdAutor();
                    libroCollectionNewLibro.setIdAutor(autor);
                    libroCollectionNewLibro = em.merge(libroCollectionNewLibro);
                    if (oldIdAutorOfLibroCollectionNewLibro != null && !oldIdAutorOfLibroCollectionNewLibro.equals(autor)) {
                        oldIdAutorOfLibroCollectionNewLibro.getLibroCollection().remove(libroCollectionNewLibro);
                        oldIdAutorOfLibroCollectionNewLibro = em.merge(oldIdAutorOfLibroCollectionNewLibro);
                    }
                }
            }
            for (Venta ventaCollectionNewVenta : ventaCollectionNew) {
                if (!ventaCollectionOld.contains(ventaCollectionNewVenta)) {
                    Autor oldIdAutorOfVentaCollectionNewVenta = ventaCollectionNewVenta.getIdAutor();
                    ventaCollectionNewVenta.setIdAutor(autor);
                    ventaCollectionNewVenta = em.merge(ventaCollectionNewVenta);
                    if (oldIdAutorOfVentaCollectionNewVenta != null && !oldIdAutorOfVentaCollectionNewVenta.equals(autor)) {
                        oldIdAutorOfVentaCollectionNewVenta.getVentaCollection().remove(ventaCollectionNewVenta);
                        oldIdAutorOfVentaCollectionNewVenta = em.merge(oldIdAutorOfVentaCollectionNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autor.getIdAutor();
                if (findAutor(id) == null) {
                    throw new NonexistentEntityException("The autor with id " + id + " no longer exists.");
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
            Autor autor;
            try {
                autor = em.getReference(Autor.class, id);
                autor.getIdAutor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Libro> libroCollectionOrphanCheck = autor.getLibroCollection();
            for (Libro libroCollectionOrphanCheckLibro : libroCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Autor (" + autor + ") cannot be destroyed since the Libro " + libroCollectionOrphanCheckLibro + " in its libroCollection field has a non-nullable idAutor field.");
            }
            Collection<Venta> ventaCollectionOrphanCheck = autor.getVentaCollection();
            for (Venta ventaCollectionOrphanCheckVenta : ventaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Autor (" + autor + ") cannot be destroyed since the Venta " + ventaCollectionOrphanCheckVenta + " in its ventaCollection field has a non-nullable idAutor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(autor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Autor> findAutorEntities() {
        return findAutorEntities(true, -1, -1);
    }

    public List<Autor> findAutorEntities(int maxResults, int firstResult) {
        return findAutorEntities(false, maxResults, firstResult);
    }

    private List<Autor> findAutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autor.class));
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

    public Autor findAutor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autor.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autor> rt = cq.from(Autor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
