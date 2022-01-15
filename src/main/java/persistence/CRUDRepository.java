package persistence;

import org.hibernate.Session;
import util.DBUtil;

import javax.persistence.EntityManager;

public class CRUDRepository<T> {

    private final EntityManager em;

    public CRUDRepository() {
        em = DBUtil.getEntityManager();
    }

    public void create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public void update(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public void delete(T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }
}
