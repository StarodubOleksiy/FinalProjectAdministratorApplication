package net.proselyte.springmvc.dao;

import net.proselyte.springmvc.model.Menu;

import java.util.List;

/**
 * Created by Администратор on 20.08.16.
 */
public interface MenuDao {
    void save(Menu menu);
    void remove(Long id);
    List<Menu> showAll();
    Menu findById(Long id);
    Menu findByName(String name);
}
