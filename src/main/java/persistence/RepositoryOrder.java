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
        return em.createQuery("from Orders", Order.class).getResultList();
    }

    public List<Order> listAllRegisteredOrdersByStatus(String status) {
        Order order = new Order();
        order.setStatus(status);
        String hql = "FROM Order WHERE status = '" + order.getStatus() + "'";
        return em.createQuery(hql, Order.class).getResultList();

        /*
        String hql = "from Student student where student.studentName = '" + studentName+ "'";
        Query query = session.createQuery(hql);
        List result = query.list();
         */
    }
}
