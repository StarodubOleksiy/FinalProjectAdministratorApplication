package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.exceptions.ElementNotFoundException;
import net.proselyte.springmvc.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import net.proselyte.springmvc.service.MenuService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Администратор on 30.08.16.
 */

@Controller
public class MenuController {
    private MenuService menuService;
    private String menuName;
    private long menuId;


    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }



    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Map<String, Object> model) {
        model.put("menu", menuService.getMenu() );
        return "/menu";
    }


    @RequestMapping(value = "/dishToMenu", method = RequestMethod.GET)
    public String addDish() {
        return "/dishToMenu";
    }


    @RequestMapping(value = "/dishFromMenu", method = RequestMethod.GET)
    public String removeDish() {
        return "/dishFromMenu";
    }


    @RequestMapping(value = "newMenu", method = RequestMethod.GET)
    public ModelAndView menu() {
        return new ModelAndView("/newMenu", "command", new Menu());
    }


    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public String addMenu(@ModelAttribute("mvc-dispatcher") Menu menu,
                             ModelMap model) throws IOException{
         if(menu.getName().length() == 0)
             throw new IOException("You have not entered menu name");
        menuService.saveMenu(menu);
        model.addAttribute("message", "New menu was added successfully");
        return "result";
    }

    @RequestMapping(value = "/removeMenu", method = RequestMethod.GET)
    public String removeMenu(ModelMap model) {
        menuService.removeMenu(menuId);
        model.addAttribute("message", "Menu was deleted successfully");
        return "result";
    }




    @RequestMapping(value = "/addDishToMenu", method = RequestMethod.POST)
    public String addDish(@RequestParam("name") String name, ModelMap model) throws ElementNotFoundException {
        System.out.println("menu name = "+menuName);
        menuService.addDish(menuName,name);
             model.addAttribute("message", "New dish was added to menu successfully");
             return "result";
    }


    @RequestMapping(value = "/removeDishFromMenu", method = RequestMethod.POST)
    public String removeDish(@RequestParam("name") String name, ModelMap model) throws ElementNotFoundException  {
        menuService.removeDish(menuName,name);
        model.addAttribute("message", "Dish was deleted from menu successfully");
        return "result";
    }



    @RequestMapping(value = "/menuDishes", method = RequestMethod.GET)
    public String dishes(@RequestParam("menuName")String menuName, Map<String, Object> model) {
        Menu menu =  menuService.getMenuByName(menuName);
        this.menuName = menuName;
        this.menuId = menu.getId();
        model.put("menu", menu.getName());
        model.put("dishes", menu.getDishes() );
        return "/menuDishes";
    }



}
