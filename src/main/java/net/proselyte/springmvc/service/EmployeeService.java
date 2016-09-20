package net.proselyte.springmvc.service;

import net.proselyte.springmvc.dao.*;
import net.proselyte.springmvc.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 31.07.16.
 */


public class EmployeeService {

    private EmployeeDao employeeDao;
    private OrderDao orderDao;
    private DishDao dishDao;
    private CookedDishDao cookedDishDao ;
    private StorageDao storageDao ;


    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setCookedDishDao(CookedDishDao cookedDishDao) {
        this.cookedDishDao = cookedDishDao;
    }

    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }


    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName){
        return employeeDao.findByName(employeeName);
    }

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }


    @Transactional
    public Employee getEmployeeById(long employeeId){
        return employeeDao.findById(employeeId);
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }


    @Transactional
    public void createOrder(int tableNumber, long waiterId)
    {
        Orders order = new Orders();
        order.setTableNumber(tableNumber);
        Waiter waiter = (Waiter)getEmployeeById(waiterId);
        order.setWaiter(waiter);
        orderDao.save(order);
    }


    @Transactional
    public void addCookedDish(String dishName, long orderNumber, long cookId) throws  IOException
    {
        Cooked_Dish cooked_dish = new Cooked_Dish();
        Dish dish = dishDao.findByName(dishName);
        System.out.println("Current dish = " + dish);
        if (dish == null) throw new IOException("This dish have not found");
        cooked_dish.setDish(dish);
        Orders order = orderDao.findById(orderNumber);
        if (order == null) throw new IOException("This order have not found");
        cooked_dish.setOrder(order);
        Cook cook = (Cook)getEmployeeById(cookId);
        cooked_dish.setCook(cook);
       // order.getDishes().add(cooked_dish);
        System.out.println("Current cooked_dish = "+cooked_dish);
        for(int i = 0; i < cooked_dish.getDish().getIngradients().size(); ++i)
        storageDao.decreaseNumerosity(cooked_dish.getDish().getIngradients().get(i), 10);
        cookedDishDao.save(cooked_dish);
    }

}
