package items;

import java.util.HashMap;

public class ItemList {
    
    public ItemList() {
        
        itemList = new HashMap<Integer, Item>();
        
        Item sandwich = new Item();
		sandwich.setName("Sandwich");
		sandwich.setDescription("A fresh peanut butter sandwich."); 
		sandwich.setID(1);
		itemList.put(1, sandwich);
		
		Item sword = new Item();
		sword.setName("Sword of Destiny");
		sword.setDescription("A frail toothpick from the Dark Ages"); 
		sword.setID(2);
		sword.setEquippable();
		itemList.put(2, sword);
        
    }
    
    public static Item getItem(int id) {
        
        return itemList.get(id);
        
    }
    
    private static HashMap<Integer, Item> itemList;
    
}