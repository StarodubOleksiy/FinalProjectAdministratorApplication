package net.proselyte.springmvc.service;

import net.proselyte.springmvc.dao.StorageDao;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.model.Storage;
import org.springframework.transaction.annotation.Transactional;
import net.proselyte.springmvc.dao.DishDao;
import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 06.08.16.
 */
public class DishService {

    private DishDao dishDao;

    private StorageDao storageDao;

    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public Dish getDishByName(String dishName){
        return dishDao.findByName(dishName);
    }

    @Transactional
    public List<Dish> getDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public void saveDish(Dish dish) {
       dishDao.save(dish);
    }


    @Transactional
    public void addIngradient(String dishName, String ingradientName) throws IOException {

        List<String> allIngradients = new ArrayList<String>();
        Dish dish = dishDao.findByName(dishName);
        for(int  i = 0; i < dish.getIngradients().size(); ++i )
            allIngradients.add(dish.getIngradients().get(i).getName());
        if(!allIngradients.contains(ingradientName))
            allIngradients.add(ingradientName);
              dish.setIngradients(createIngradients(allIngradients));
    }


    private List<Storage> createIngradients(List<String> ingradients) throws IOException {
        List<Storage> result = new ArrayList<Storage>();
        for (int i = 0; i < ingradients.size(); ++i) {
           Storage ingradient = storageDao.findByName(ingradients.get(i));
            if(ingradient == null) throw new IOException("You have entered invalid name of ingradient");
             result.add(storageDao.findByName(ingradients.get(i)));
        }
          return result;
    }


    @Transactional
    public void removeIngradient(String dishName, String ingradientName) throws IOException
    {
        Dish dish = dishDao.findByName(dishName);
        Storage ingradient = storageDao.findByName(ingradientName);
        if(ingradient == null) throw new IOException("You have entered invalid name of ingradient");
        for(int i = 0; i < dish.getIngradients().size(); ++i)
            if(dish.getIngradients().get(i).getName().equals(ingradientName))
            {
                dish.getIngradients().remove(i);
            }
    }

    @Transactional
    public void removeDish(long dishId) {
        dishDao.remove(dishId);
    }

}
