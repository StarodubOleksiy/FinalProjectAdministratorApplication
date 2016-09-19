package net.proselyte.springmvc.service;

import net.proselyte.springmvc.dao.StorageDao;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.model.Storage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 05.09.16.
 */
public class StorageService {
    private StorageDao storageDao;


    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Transactional
    public List<Storage> getStorage() {
        return storageDao.findAll();
    }


    @Transactional
    public void saveIngradient(Storage ingradient){
       storageDao.save(ingradient);
    }

    @Transactional
    public Storage getIngradientByName(String ingradientName){
        return storageDao.findByName(ingradientName);
    }

    @Transactional
    public void changeNumerosity(long id, int numerosity)
    {
        storageDao.changeNumerosity(id, numerosity);
    }

    @Transactional
    public void removeIngradient(long id)
    {
        storageDao.remove(id);
    }

}
