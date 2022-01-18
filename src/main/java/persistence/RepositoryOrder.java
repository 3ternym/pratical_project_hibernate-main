package persistence;

import model.Order;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RepositoryOrder extends CRUDRepository<Order> {

    Scanner sc = new Scanner(System.in);

    private EntityManager em;

    public RepositoryOrder() {
        em = DBUtil.getEntityManager();
    }

    public List<Order> listAllRegisteredOrders() {
        return em.createQuery("from Orders", Order.class).getResultList();
    }

    public List<Order> listAllRegisteredOrdersByStatus(String status) {
        status = sc.nextLine();
        String hql = "FROM Order WHERE status = '" + status + "'";
        return em.createQuery(hql, Order.class).getResultList();
    }
}
