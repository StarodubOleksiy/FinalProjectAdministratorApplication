package net.proselyte.springmvc.service;

import net.proselyte.springmvc.dao.DishDao;
import net.proselyte.springmvc.dao.OrderDao;
import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Employee;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.model.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 08.09.16.
 */
public class OrderService {

    private OrderDao orderDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }



    @Transactional
    public List<Orders> getOrders() {
        LOGGER.info("====================Showing all orders====================================");
        return orderDao.findAllOrders();
    }


    @Transactional
    public List<Orders> getOrdersByTableNumber(int tableNumber) {
        LOGGER.info("====================Showing current order! tableNumber = "+tableNumber+" ====================================");

        return orderDao.findByTableNumber(tableNumber);
    }


    @Transactional
    public List<Orders> getOrdersByWaiterId(int waiterId) {
        LOGGER.info("====================Showing current order! waiterId = "+waiterId+" ====================================");
        return orderDao.findByWaiterId(waiterId);
    }

    @Transactional
    public Orders getOrderById(long orderId){
        LOGGER.info("====================Showing current order id = "+orderId+" ====================================");
        return orderDao.findById(orderId);
    }




}
