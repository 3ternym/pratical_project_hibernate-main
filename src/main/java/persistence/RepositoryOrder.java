package persistence;

import model.Order;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryOrder extends CRUDRepository<Order> {

    private EntityManager em;

    public RepositoryOrder() {
        em = DBUtil.getEntityManager();
    }

    public List<Order> listAllRegisteredOrders() {
        return em.createQuery("from Order", Order.class).getResultList();
    }
}
