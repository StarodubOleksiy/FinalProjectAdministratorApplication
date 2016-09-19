package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.exceptions.ElementNotFoundException;
import net.proselyte.springmvc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import net.proselyte.springmvc.service.EmployeeService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Администратор on 31.07.16.
 */
@Controller
public class EmployeeController {



    private EmployeeService employeeService;
    private long employeeId;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {
        model.put("employees", employeeService.getEmployees());
        return "employees";
    }

   @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employee(@RequestParam("employeeId")long employeeId) {
       ModelAndView modelAndView = new ModelAndView();
       Employee employee = employeeService.getEmployeeById(employeeId);
       this.employeeId = employeeId;
        modelAndView.addObject("employee", employee);
       if(employee.getPosition() == Position.WAITER) {
            Waiter waiter = (Waiter)employee;

           modelAndView.addObject("orders", waiter.getOrders());
       }

       if(employee.getPosition() == Position.COOK) {
             Cook cook = (Cook)employee;
           modelAndView.addObject("cooked_Dishes", cook.getDishes());
       }
       modelAndView.setViewName("employee");
        return modelAndView;
    }

    @RequestMapping(value = "addWaiter", method = RequestMethod.GET)
    public ModelAndView waiter() {
        return new ModelAndView("/addWaiter", "command", new Waiter());

    }

    @RequestMapping(value = "/newWaiter", method = RequestMethod.POST)
    public String addWaiter(@ModelAttribute("mvc-dispatcher") Waiter waiter,
                          ModelMap model) {
        employeeService.saveEmployee(waiter);
        model.addAttribute("message", "New waiter was added successfully");
        return "result";
    }

    @RequestMapping(value = "addCook", method = RequestMethod.GET)
    public ModelAndView cook() {
        return new ModelAndView("/addCook", "command", new Cook());

    }

    @RequestMapping(value = "/newCook", method = RequestMethod.POST)
    public String addCook(@ModelAttribute("mvc-dispatcher") Cook cook,
                            ModelMap model) {
        employeeService.saveEmployee(cook);
        model.addAttribute("message", "New cook was added successfully");
        return "result";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestParam("name") String name, ModelMap model) {
       System.out.println("waiterId = "+ employeeId);
        employeeService.createOrder(Integer.parseInt(name),employeeId);
        model.addAttribute("message", "New order was added successfully");
        return "result";
    }


    @RequestMapping(value = "/addCookedDish", method = RequestMethod.POST)
    public String addCookedDish(@RequestParam("dishname") String dishname, @RequestParam("ordernumber") long ordernumber ,ModelMap model) throws ElementNotFoundException, IOException {
        employeeService.addCookedDish(dishname, ordernumber,employeeId);
        model.addAttribute("message", "New dish was added for cooking successfully");
        return "result";
    }






}
