package people;

import items.Inventory;
import items.Item;
import main.Main;

import java.util.HashMap;

public class Person {
	
	public Person() {
		
		this.inv = new Inventory();

		this.inv = new Inventory();
		this.phrases = new HashMap<Integer, String>();
		
		this.isAttackable = false;
		
	}

	public void sayPhrase() {
		
		System.out.println(phrases.get(Main.getGameStage()));
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setPhrase(String phrase, int stage) {
		
		phrases.put(stage, phrase);
		
	}
	
	public void setPhrase(String phrase, int stage1, int stage2) {
		
		for (int i = stage1; i < stage2; i++) {
			
			phrases.put(i, phrase);
			
		}
		
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
	
	public boolean takeItem(Item i) {
		
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
	private Inventory inv;
	private HashMap<Integer, String> phrases;
	private boolean isAttackable;
	
	private int health, maxHealth;
	
}
