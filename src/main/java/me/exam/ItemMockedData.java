package me.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarKnightMare on 11/6/2018.
 */
public class ItemMockedData {
    //list of items
    private List<Item> items;

    private static ItemMockedData instance = null;
    public static ItemMockedData getInstance(){
        if(instance == null){
            instance = new ItemMockedData();
        }
        return instance;
    }


    public ItemMockedData(){
        items = new ArrayList<Item>();
        items.add(new Item(1, "Item1",1,"I001"));
        items.add(new Item(2, "Item2",10,"I002"));
        items.add(new Item(3, "Item3",100,"I003"));
        items.add(new Item(4, "Item4",1000,"I004"));
        items.add(new Item(5, "Item5",10000,"I005"));
        items.add(new Item(6, "Item6",100000,"I006"));
        items.add(new Item(7, "Item7",1000000,"I007"));
        items.add(new Item(8, "Item8",10000000,"I008"));
        items.add(new Item(9, "Item9",100000000,"I009"));
        items.add(new Item(10, "Item10",100000000,"I010"));
    }

    // return all ietems
    public List<Item> fetchItems() {
        return items;
    }

    // return item by id
    public Item getItemById(int id) {
        for(Item b: items) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // search item by text
    public List<Item> searchItems(String searchTerm) {
        List<Item> searchedItems = new ArrayList<Item>();
        for(Item b: items) {
            if(b.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    b.getCode().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedItems.add(b);
            }
        }

        return searchedItems;
    }

    // create item
    public Item createItem(int id, String name, int amount, String code) {
        Item newItem = new Item(id, name, amount, code);
        items.add(newItem);
        return newItem;
    }

    // update intem
    public Item updateItem(int id, String name, int amount, String code) {
        for(Item b: items) {
            if(b.getId() == id) {
                int itemIndex = items.indexOf(b);
                b.setName(name);
                b.setAmount(amount);
                items.set(itemIndex, b);
                return b;
            }

        }

        return null;
    }

    // delete item by id
    public boolean delete(int id){
        int itemIndex = -1;
        for(Item b: items) {
            if(b.getId() == id) {
                itemIndex = items.indexOf(b);
                continue;
            }
        }
        if(itemIndex > -1){
            items.remove(itemIndex);
        }
        return true;
    }
}
