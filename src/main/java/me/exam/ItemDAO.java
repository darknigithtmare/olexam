package me.exam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by DarKnightMare on 11/6/2018.
 */
@Repository
public interface ItemDAO extends CrudRepository<Item,Long> {

    public List<Item>findByName(String name);

    public List<Item>findById(int id);
}
