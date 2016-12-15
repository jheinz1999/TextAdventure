package items;

import java.util.ArrayList;

public class Inventory {
	
	public Inventory() {
		
		items = new ArrayList<Item>();
		itemCounts = new ArrayList<Integer>();
		
	}

	public void listInventory() {
		
		System.out.println("Inventory:");
		
		System.out.println();
		
		for (Item i : items) {
			
			System.out.printf("%-20s\t\t%s\n", i.getName(), "x" + itemCounts.get(items.indexOf(i)));
			
		}
		
	}
	
	public Item getItem(String item) {
		
		for (Item i : items) {
			
			if (i.getName().equalsIgnoreCase(item))
				return i;
			
		}
		
		return new Item();
		
	}
	
	public void addItem(Item i, int quantity) {
		
		boolean hasItem = false;
		
		for (Item it : items) {
			
			if (it.getName().equals(i.getName()) && !hasItem) {
				
				int pos = items.indexOf(it);
				
				itemCounts.set(pos, itemCounts.get(pos) + 1);
				
				hasItem = true;
				
			}
			
		}
		
		if (!hasItem) {
			
			items.add(i);
			itemCounts.add(quantity);
			
		}
		
	}
	
	public void removeItem(String item) {
		
		int pos = items.indexOf(getItem(item));
		int count = itemCounts.get(pos);
		
		if (count > 1) {
			
			count--;
			itemCounts.set(pos, count);
			
		}
		
		else {
			
			itemCounts.remove(pos);
			items.remove(pos);
			
		}
			
		
	}
	
	public boolean hasItem(String item) {
		
		for (Item i : items) {
			
			if (i.getName().equalsIgnoreCase(item))
				return true;
			
		}
		
		return false;
		
	}
	
	private ArrayList<Item> items;
	private ArrayList<Integer> itemCounts;
	
}
