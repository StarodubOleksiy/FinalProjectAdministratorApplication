package net.proselyte.springmvc.service;

import net.proselyte.springmvc.dao.StorageDao;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.model.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 05.09.16.
 */
public class StorageService {
    private StorageDao storageDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Transactional
    public List<Storage> getStorage() {
        LOGGER.info("====================Showing all ingradients in the storage====================================");
        return storageDao.findAll();
    }


    @Transactional
    public void saveIngradient(Storage ingradient){
        LOGGER.info("====================Adding new ingradient====================================");
        storageDao.save(ingradient);
    }

    @Transactional
    public Storage getIngradientByName(String ingradientName){
        LOGGER.info("====================Adding new ingradient to storage! ingradientName = "+ingradientName+" ====================================");
        return storageDao.findByName(ingradientName);
    }

    @Transactional
    public void changeNumerosity(long id, int numerosity)
    {
        LOGGER.info("====================Changing numerosity  of current ingradient====================================");
        storageDao.changeNumerosity(id, numerosity);
    }

    @Transactional
    public void removeIngradient(long id)
    {
        LOGGER.info("====================Removing currnet ingradient====================================");
        storageDao.remove(id);
    }

}
