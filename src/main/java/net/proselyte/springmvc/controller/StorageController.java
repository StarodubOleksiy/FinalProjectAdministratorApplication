package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.exceptions.ElementNotFoundException;
import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.model.Storage;
import net.proselyte.springmvc.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Администратор on 07.09.16.
 */


@Controller
public class StorageController {
    private StorageService storageService;

    private String ingradientName;
    private long ingradientId;


    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }


    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    public String storage(Map<String, Object> model) {
        model.put("ingradients", storageService.getStorage() );
        return "/storage";
    }

    @RequestMapping(value = "newIngradient", method = RequestMethod.GET)
    public ModelAndView ingradient() {
        return new ModelAndView("/newIngradient", "command", new Storage());
    }


    @RequestMapping(value = "addIngradient", method = RequestMethod.POST)
    public String addIngradient(@ModelAttribute("mvc-dispatcher") Storage ingradient,
                          ModelMap model) throws  IOException{
        if(ingradient.getName().length() == 0 )
            throw new IOException("You have not entered ingradient name!!!");
        if(ingradient.getNumerosity() < 1 )
            throw new IOException("You have not entered valid numerosity of ingradients!!!");
     storageService.saveIngradient(ingradient);
     model.addAttribute("message", "New ingradient was added successfully");
       return "result";
    }

    @RequestMapping(value = "/ingradientInformation", method = RequestMethod.GET)
    public ModelAndView dish(@RequestParam("ingradientName")String ingradientName) {
        ModelAndView modelAndView = new ModelAndView();
        Storage ingradient = storageService.getIngradientByName(ingradientName);
        modelAndView.addObject("ingradient", ingradient);
        modelAndView.setViewName("ingradientInformation");
        this.ingradientName = ingradientName;
        this.ingradientId = ingradient.getId();
        return modelAndView;
    }




    @RequestMapping(value = "/findByWord", method = RequestMethod.GET)
    public ModelAndView findIngradient(@RequestParam("name") String name) throws ElementNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        Storage ingradient = storageService.getIngradientByName(name);
        if(ingradient == null) throw new ElementNotFoundException("There is no such ingradient");
        modelAndView.addObject("ingradient",ingradient);
        modelAndView.setViewName("storage");

        return modelAndView;
    }

    @RequestMapping(value = "/changeNumerosity", method = RequestMethod.GET)
    public String changeNumerosity(@RequestParam("name") String name, ModelMap model) {
        int numerosity = Integer.parseInt(name);
        storageService.changeNumerosity(ingradientId,numerosity);
        model.addAttribute("message", "Numerosity was changed successfully");
        return "result";
      }

    @RequestMapping(value = "/removeIngradient", method = RequestMethod.GET)
    public String removeIngradient(ModelMap model) {
        storageService.removeIngradient(ingradientId);
        model.addAttribute("message", "Ingradient was deleted successfully");
        return "result";
    }



}
