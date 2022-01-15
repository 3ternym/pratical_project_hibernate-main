package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class CRUDRepository<T> {

    private EntityManager em = DBUtil.getEntityManager();

    public void create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
    }

}