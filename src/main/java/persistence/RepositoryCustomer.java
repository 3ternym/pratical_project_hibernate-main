package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import model.Customer;
import util.DBUtil;

public class RepositoryCustomer extends CRUDRepository<Customer>{

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select f from Customer as f order by f.firstName asc")
                .getResultList();
    }

    public List<Customer> listAllCustomersByUserName() {
        return em.createQuery("SELECT c.username FROM Customer c order by c.username", Customer.class).getResultList();
    }
}
