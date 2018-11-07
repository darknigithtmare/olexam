package me.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by DarKnightMare on 11/6/2018.
 */

@RestController
public class AppController {
    //ItemMockedData itemMockedData = ItemMockedData.getInstance();

    @Autowired
    private ItemDAO itemDAO;

    @GetMapping("/items")
    public List<Item> index(){
        //return itemMockedData.fetchItems();

        Iterable<Item> all = itemDAO.findAll();
        return (List<Item>) all;
    }

    @GetMapping("/item/{id}")
    public Item show(@PathVariable String id){
        int itemId = Integer.parseInt(id);
        return itemDAO.findById(itemId).get(0);
    }

    @PostMapping("/item/search")
    public List<Item> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return itemDAO.findByName(searchTerm);
    }

    @PostMapping("/item")
    public Item create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        int amount = Integer.parseInt(body.get("amount"));
        String code = body.get("name");
        Item i = new Item(id, name, amount, code);
        return itemDAO.save(i);
    }

    @PutMapping("/item/{id}")
    public Item update(@PathVariable int id, @RequestBody Map<String, String> body){
        int itemid = id;
        String name = body.get("name");
        int itemamount = Integer.parseInt(body.get("amount"));
        String code = body.get("code");
        Item i = new Item(itemid, name, itemamount, code);
        return itemDAO.save(i);

    }

    @DeleteMapping("item/{id}")
    public void delete(@PathVariable String id){
        Item i = show(id);
        itemDAO.delete(i);
    }

}
