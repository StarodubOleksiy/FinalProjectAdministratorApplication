package net.proselyte.springmvc.service;

import net.proselyte.springmvc.exceptions.ElementNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import net.proselyte.springmvc.dao.DishDao;
import net.proselyte.springmvc.dao.MenuDao;
import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 30.08.16.
 */
public class MenuService {

    private MenuDao menuDao;
    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }



    @Transactional
    public List<Menu> getMenu() {
        return menuDao.showAll();
    }


    @Transactional
    public void saveMenu(Menu menu) {
        Set<Menu> allMenues = new HashSet<Menu>(menuDao.showAll());
        if (!allMenues.contains(menu))
        menuDao.save(menu);
    }


    @Transactional
    public void removeMenu(long menuId) {
        menuDao.remove(menuId);
    }


    @Transactional
    public void addDish(String menuName, String dishName) throws ElementNotFoundException {

        List<String> allDishes = new ArrayList<String>();
        Menu menu = menuDao.findByName(menuName);
        for(int  i = 0; i < menu.getDishes().size(); ++i )
            allDishes.add(menu.getDishes().get(i).getName());
        if(!allDishes.contains(dishName))
        allDishes.add(dishName);
        menu.setDishes(createDishes(allDishes));
    }

    private List<Dish> createDishes(List<String> dishes )throws ElementNotFoundException {
        List<Dish> result = new ArrayList<Dish>();
        for (String dishName: dishes) {
            Dish dish = dishDao.findByName(dishName);
            if (dish == null) throw new ElementNotFoundException("This dish had not found");
            result.add(dishDao.findByName(dishName));
        }

        return result;
    }

    @Transactional
    public void removeDish(String menuName, String dishName) throws ElementNotFoundException
    {
         Menu menu = menuDao.findByName(menuName);
        Dish dish = dishDao.findByName(dishName);
        if (dish == null) throw new ElementNotFoundException("This dish had not found");
            for(int i = 0; i < menu.getDishes().size(); ++i)
                if(menu.getDishes().get(i).getName().equals(dishName))
                {
                    menu.getDishes().remove(i);
               }
    }

    @Transactional
    public Menu getMenuByName(String menuName){
        return menuDao.findByName(menuName);
    }

}
