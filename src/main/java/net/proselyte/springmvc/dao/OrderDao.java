package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Orders;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 09.06.16.
 */
public interface OrderDao {
void save(Orders order);
 List<Orders> findAllOrders();
 List<Orders> findOpenOrders();
 Orders findById(Long id);
 void updateDish(Orders orders);
 void setClose(Long id);
 public List<Orders> findCloseOrders();
 List<Orders> findByTableNumber(int table_number);
 List<Orders> findByWaiterId(int order_id);
 void remove(Long id) throws IOException;

}
