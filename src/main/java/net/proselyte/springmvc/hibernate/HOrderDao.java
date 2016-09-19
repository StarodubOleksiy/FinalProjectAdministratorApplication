package net.proselyte.springmvc.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  net.proselyte.springmvc.model.Dish;
import  net.proselyte.springmvc.model.Orders;
import  net.proselyte.springmvc.dao.OrderDao;
import  net.proselyte.springmvc.model.Storage;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 09.06.16.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }


    @Override
    public List<Orders> findByTableNumber(int table_number) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders  where table_number = :tableNumber");
        query.setParameter("tableNumber",table_number);
        List<Orders> ordersByTableNumber = query.list();
        return ordersByTableNumber;
    }


    @Override
    public List<Orders> findByWaiterId(int waiterId)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders  where employee_id = :waiterId");
        query.setParameter("waiterId",waiterId);
        List<Orders> ordersByWaiterId = query.list();
        return ordersByWaiterId;

    }


    @Override
    public List<Orders> findOpenOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o where state = 'open'").list();
    }


    @Override
    public List<Orders> findCloseOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o where state = 'close'").list();
    }

    @Override
    public void save(Orders order) {
     sessionFactory.getCurrentSession().save(order);
    }


    @Override
    public Orders findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return  (Orders) session.get(Orders.class, id);
    }

    @Override
    public void updateDish(Orders orders)
    {
       sessionFactory.getCurrentSession().update(orders);
    }

    @Override
    public void setClose(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Orders orders = session.get(Orders.class, id);
        orders.setState("close");
        sessionFactory.getCurrentSession().update(orders);
    }

    @Override
    public void remove(Long id) throws  IOException{

        if(findById(id).getState().equals("close"))
            throw new IOException("Delete close order is forbidden");
        sessionFactory.getCurrentSession().delete(findById(id));
    }


}
