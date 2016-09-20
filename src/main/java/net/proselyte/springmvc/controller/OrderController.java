package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Orders;
import net.proselyte.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 08.09.16.
 */

@Controller
public class OrderController {
private OrderService orderService;
private long orderId;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Map<String, Object> model) {
        model.put("orders",orderService.getOrders() );
        return "orders";
    }


    @RequestMapping(value = "/findByTableNumber", method = RequestMethod.GET)
    public String ordersByTableNumber(@RequestParam("name") String name, ModelMap model) throws IOException {
        List<Orders> orders = orderService.getOrdersByTableNumber(Integer.parseInt(name));
        if(orders.size() ==0) throw new IOException("There are not such orders");
        model.put("orders",orders );
        return "orders";
    }


    @RequestMapping(value = "/findByWaiterId", method = RequestMethod.GET)
    public String ordersByWaiterId(@RequestParam("name") String name, ModelMap model) throws IOException {
        List<Orders> orders = orderService.getOrdersByWaiterId(Integer.parseInt(name));
        if(orders.size() ==0) throw new IOException("There are not such orders");
        model.put("orders",orders);
        return "orders";
    }


    @RequestMapping(value = "/orderInformation", method = RequestMethod.GET)
    public ModelAndView orderInformation(@RequestParam("orderId") long orderId) {
        System.out.println("method orderInformation orderId = " + orderId);
        ModelAndView modelAndView = new ModelAndView();
        Orders order = orderService.getOrderById(orderId);
        modelAndView.addObject("orderInformation", order);
        modelAndView.addObject("orderDishes",/*new ArrayList() */order.getDishes());
        modelAndView.setViewName("orderInformation");
       // this.dishName = dishName;
        this.orderId = orderId;
        return modelAndView;
    }

    @RequestMapping(value = "/dishToOrder", method = RequestMethod.GET)
    public String addDish() {
        return "/dishToOrder";
    }




}
