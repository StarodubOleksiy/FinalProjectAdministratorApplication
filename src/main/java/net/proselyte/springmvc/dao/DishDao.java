package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Dish;

import java.util.List;

/**
 * Created by Администратор on 09.06.16.
 */
public interface DishDao {
    void save(Dish dish);
    void remove(Long id);
     List<Dish> findAll();
    Dish findById(Long id);
    Dish findByName(String name);
    public void changePrice(Long id, float price);
    public void changeWeight(Long id, float weight);

}
