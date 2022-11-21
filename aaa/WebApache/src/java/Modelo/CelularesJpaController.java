/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Celulares;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Factura;
import Modelo.exceptions.IllegalOrphanException;
import Modelo.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class CelularesJpaController implements Serializable {

    public CelularesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Celulares celulares) {
        if (celulares.getFacturaList() == null) {
            celulares.setFacturaList(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Factura> attachedFacturaList = new ArrayList<Factura>();
            for (Factura facturaListFacturaToAttach : celulares.getFacturaList()) {
                facturaListFacturaToAttach = em.getReference(facturaListFacturaToAttach.getClass(), facturaListFacturaToAttach.getIdFactura());
                attachedFacturaList.add(facturaListFacturaToAttach);
            }
            celulares.setFacturaList(attachedFacturaList);
            em.persist(celulares);
            for (Factura facturaListFactura : celulares.getFacturaList()) {
                Celulares oldIdcelularOfFacturaListFactura = facturaListFactura.getIdcelular();
                facturaListFactura.setIdcelular(celulares);
                facturaListFactura = em.merge(facturaListFactura);
                if (oldIdcelularOfFacturaListFactura != null) {
                    oldIdcelularOfFacturaListFactura.getFacturaList().remove(facturaListFactura);
                    oldIdcelularOfFacturaListFactura = em.merge(oldIdcelularOfFacturaListFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Celulares celulares) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Celulares persistentCelulares = em.find(Celulares.class, celulares.getIdcelular());
            List<Factura> facturaListOld = persistentCelulares.getFacturaList();
            List<Factura> facturaListNew = celulares.getFacturaList();
            List<String> illegalOrphanMessages = null;
            for (Factura facturaListOldFactura : facturaListOld) {
                if (!facturaListNew.contains(facturaListOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaListOldFactura + " since its idcelular field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Factura> attachedFacturaListNew = new ArrayList<Factura>();
            for (Factura facturaListNewFacturaToAttach : facturaListNew) {
                facturaListNewFacturaToAttach = em.getReference(facturaListNewFacturaToAttach.getClass(), facturaListNewFacturaToAttach.getIdFactura());
                attachedFacturaListNew.add(facturaListNewFacturaToAttach);
            }
            facturaListNew = attachedFacturaListNew;
            celulares.setFacturaList(facturaListNew);
            celulares = em.merge(celulares);
            for (Factura facturaListNewFactura : facturaListNew) {
                if (!facturaListOld.contains(facturaListNewFactura)) {
                    Celulares oldIdcelularOfFacturaListNewFactura = facturaListNewFactura.getIdcelular();
                    facturaListNewFactura.setIdcelular(celulares);
                    facturaListNewFactura = em.merge(facturaListNewFactura);
                    if (oldIdcelularOfFacturaListNewFactura != null && !oldIdcelularOfFacturaListNewFactura.equals(celulares)) {
                        oldIdcelularOfFacturaListNewFactura.getFacturaList().remove(facturaListNewFactura);
                        oldIdcelularOfFacturaListNewFactura = em.merge(oldIdcelularOfFacturaListNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = celulares.getIdcelular();
                if (findCelulares(id) == null) {
                    throw new NonexistentEntityException("The celulares with id " + id + " no longer exists.");
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
            Celulares celulares;
            try {
                celulares = em.getReference(Celulares.class, id);
                celulares.getIdcelular();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The celulares with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Factura> facturaListOrphanCheck = celulares.getFacturaList();
            for (Factura facturaListOrphanCheckFactura : facturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Celulares (" + celulares + ") cannot be destroyed since the Factura " + facturaListOrphanCheckFactura + " in its facturaList field has a non-nullable idcelular field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(celulares);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Celulares> findCelularesEntities() {
        return findCelularesEntities(true, -1, -1);
    }

    public List<Celulares> findCelularesEntities(int maxResults, int firstResult) {
        return findCelularesEntities(false, maxResults, firstResult);
    }

    private List<Celulares> findCelularesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Celulares.class));
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

    public Celulares findCelulares(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Celulares.class, id);
        } finally {
            em.close();
        }
    }

    public int getCelularesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Celulares> rt = cq.from(Celulares.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
