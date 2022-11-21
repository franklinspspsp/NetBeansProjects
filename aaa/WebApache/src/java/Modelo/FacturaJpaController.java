/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Cliente;
import Entidades.Celulares;
import Entidades.Factura;
import Modelo.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente dniCliente = factura.getDniCliente();
            if (dniCliente != null) {
                dniCliente = em.getReference(dniCliente.getClass(), dniCliente.getDniCliente());
                factura.setDniCliente(dniCliente);
            }
            Celulares idcelular = factura.getIdcelular();
            if (idcelular != null) {
                idcelular = em.getReference(idcelular.getClass(), idcelular.getIdcelular());
                factura.setIdcelular(idcelular);
            }
            em.persist(factura);
            if (dniCliente != null) {
                dniCliente.getFacturaList().add(factura);
                dniCliente = em.merge(dniCliente);
            }
            if (idcelular != null) {
                idcelular.getFacturaList().add(factura);
                idcelular = em.merge(idcelular);
            }
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Cliente dniClienteOld = persistentFactura.getDniCliente();
            Cliente dniClienteNew = factura.getDniCliente();
            Celulares idcelularOld = persistentFactura.getIdcelular();
            Celulares idcelularNew = factura.getIdcelular();
            if (dniClienteNew != null) {
                dniClienteNew = em.getReference(dniClienteNew.getClass(), dniClienteNew.getDniCliente());
                factura.setDniCliente(dniClienteNew);
            }
            if (idcelularNew != null) {
                idcelularNew = em.getReference(idcelularNew.getClass(), idcelularNew.getIdcelular());
                factura.setIdcelular(idcelularNew);
            }
            factura = em.merge(factura);
            if (dniClienteOld != null && !dniClienteOld.equals(dniClienteNew)) {
                dniClienteOld.getFacturaList().remove(factura);
                dniClienteOld = em.merge(dniClienteOld);
            }
            if (dniClienteNew != null && !dniClienteNew.equals(dniClienteOld)) {
                dniClienteNew.getFacturaList().add(factura);
                dniClienteNew = em.merge(dniClienteNew);
            }
            if (idcelularOld != null && !idcelularOld.equals(idcelularNew)) {
                idcelularOld.getFacturaList().remove(factura);
                idcelularOld = em.merge(idcelularOld);
            }
            if (idcelularNew != null && !idcelularNew.equals(idcelularOld)) {
                idcelularNew.getFacturaList().add(factura);
                idcelularNew = em.merge(idcelularNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            Cliente dniCliente = factura.getDniCliente();
            if (dniCliente != null) {
                dniCliente.getFacturaList().remove(factura);
                dniCliente = em.merge(dniCliente);
            }
            Celulares idcelular = factura.getIdcelular();
            if (idcelular != null) {
                idcelular.getFacturaList().remove(factura);
                idcelular = em.merge(idcelular);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
