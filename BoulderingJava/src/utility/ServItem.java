package utility;

import classes.*;

import java.util.ArrayList;
import java.util.List;

public class ServItem {
    private static List<Item> items = new ArrayList<>();

    public static Item addItem(String name, double cost) {
        Item item = new Item(name, cost);
        items.add(item);
        System.out.println("Item '" + name + "' added. Cost: $" + cost);
        return item;
    }

    public static Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) return item;
        }
        return null;
    }

    public static List<Item> getItems() {
        return items;
    }
}