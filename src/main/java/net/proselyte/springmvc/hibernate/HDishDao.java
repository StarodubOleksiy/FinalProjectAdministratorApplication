package net.proselyte.springmvc.hibernate;

import net.proselyte.springmvc.model.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import  net.proselyte.springmvc.dao.DishDao;
import  net.proselyte.springmvc.model.Dish;


import java.util.List;

/**
 * Created by Администратор on 09.06.16.
 */
public class HDishDao implements DishDao {
    @Override
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like:name");
        query.setParameter("name",name);
        return (Dish)query.uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public Dish findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return  (Dish) session.get(Dish.class, id);
      }

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    public void remove(Long id) {

        sessionFactory.getCurrentSession().delete(findById(id));
    }


    @Override
    public void changeWeight(Long id, float weight) {
        Session session = sessionFactory.getCurrentSession();
        Dish dish = session.get(Dish.class, id);
        dish.setWeight(weight);
        sessionFactory.getCurrentSession().update(dish);
    }

    @Override
    public void changePrice(Long id, float price) {
        Session session = sessionFactory.getCurrentSession();
        Dish dish = session.get(Dish.class, id);
        dish.setPrice(price);
        sessionFactory.getCurrentSession().update(dish);
    }


}
