package me.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by DarKnightMare on 11/6/2018.
 */
@Component
public class DataInitializer implements ApplicationRunner {

    ItemMockedData itemMockedData = ItemMockedData.getInstance();
    private ItemDAO itemDAO;

    @Autowired
    public DataInitializer(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        long count = itemDAO.count();

        if (count == 0)
            for (Item i : itemMockedData.fetchItems()) {
                itemDAO.save(i);
            }

    }
}
