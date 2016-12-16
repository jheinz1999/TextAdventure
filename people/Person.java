package people;

import items.Inventory;
import items.Item;
import main.Main;

import java.util.HashMap;

public class Person {
	
	public Person() {
		
		this.inv = new Inventory();

		this.inv = new Inventory();
		
		this.isAttackable = false;
		
	}

	public void sayPhrase(Player player) {
		
		System.out.println(phrase);
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setPhrase(String phrase) {
		
		this.phrase = phrase;
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public void sayDescription() {
		
		System.out.println(description);
		
	}
	
	public Inventory getInventory() {
		
		return inv;
		
	}
	
	public boolean takeItem(Item i, Player player) {
		
		return false;
		
	};
	
	public boolean isAttackable() {
		
		return isAttackable;
		
	}
	
	public void makeAttackable() {
		
		this.isAttackable = true;
		
	}
	
	private String name;
	private String description;
	private String phrase;
	private Inventory inv;
	private boolean isAttackable;
	
	private int health, maxHealth;
	
}
