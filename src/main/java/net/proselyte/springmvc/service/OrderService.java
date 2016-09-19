package net.proselyte.springmvc.service;

import net.proselyte.springmvc.dao.DishDao;
import net.proselyte.springmvc.dao.OrderDao;
import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Employee;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 08.09.16.
 */
public class OrderService {

    private OrderDao orderDao;


    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }



    @Transactional
    public List<Orders> getOrders() {
        return orderDao.findAllOrders();
    }


    @Transactional
    public List<Orders> getOrdersByTableNumber(int tableNumber) {
        return orderDao.findByTableNumber(tableNumber);
    }


    @Transactional
    public List<Orders> getOrdersByWaiterId(int waiterId) {
        return orderDao.findByWaiterId(waiterId);
    }

    @Transactional
    public Orders getOrderById(long orderId){
        return orderDao.findById(orderId);
    }




}
