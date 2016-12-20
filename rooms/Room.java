package rooms;

import people.Person;
import java.util.HashMap;
import java.util.ArrayList;
import items.Item;

public class Room {
	
	public Room() {
		
		entities = new HashMap<String, Person>();
		items = new ArrayList<Item>();
		description = new String();
		exits = new HashMap<String, Room>();
		
	}

	public void addEntity(String id, Person person) {
		
		entities.put(id.toUpperCase(), person);
		
	}
	
	public void addItem(Item item) {
		
		items.add(item);
		
	}
	
	public boolean hasEntity(String id) {
		
		return entities.containsKey(id.toUpperCase());
		
	}
	
	public void addExit(String direction, Room room) {
		
		exits.put(direction.toUpperCase(), room);
		
	}
	
	public boolean hasExit(String id) {
		
		return exits.containsKey(id.toUpperCase());
		
	}
	
	public Room getExit(String id) {
		
		return exits.get(id.toUpperCase());
		
	}
	
	public Person getEntity(String id) {
		
		return entities.get(id.toUpperCase());
		
	}
	
	public void removePerson(String id) {
		
		if (entities.containsKey(id))
			entities.remove(id);
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public void setDetailedDescription(String description) {
		
		this.detailedDescription = description;
		
	}
	
	public void printDescription() {
		
		System.out.println(description);
		
		System.out.println();
		
		for (Item i : items) {
			
			System.out.println("There is one " + i.getName());
			
		}
		
		for (Person p : entities.values()) {
			
			System.out.println("A dude called " + p.getName() + " is chilling here.");
			
		}
		
		System.out.println(exitText);
		
	}
	
	public void printDetailedDescription() {
		
		System.out.println(detailedDescription);
		
	}
	
	public boolean hasItem(String name) {
		
		for (Item i : items) {
			
			if (i.getName().equalsIgnoreCase(name))
				return true;
			
		}
		
		return false;
		
	}
	
	public Item getItem(String name) {
		
		for (Item i : items) {
			
			if (i.getName().equalsIgnoreCase(name))
				return i;
			
		}
		
		return new Item();
		
	}
	
	public void removeItem(Item i) {
		
		items.remove(i);
		
	}
	
	public void setExitText(String text) {
		
		exitText = text;
		
	}
	
	public void drawMap() {
		
		if (exits.containsKey("NORTH"))
			System.out.println("    [ ]");
		
		else
			System.out.println("    ---");
		
		if (exits.containsKey("WEST"))
			System.out.print("[ ] ");
			
		else
			System.out.print("||| ");
			
		System.out.print("[+] ");
			
		if (exits.containsKey("EAST"))
			System.out.print("[ ]");
			
		else
			System.out.print("|||");
			
		if (exits.containsKey("SOUTH"))
			System.out.println("\n    [ ]");
		
		else
			System.out.println("\n    ---");
		
	}
	
	public void setID(String id) {
		
		this.id = id;
		
	}
	
	public String getID() {
		
		return id;
		
	}
	
	public String save() {
		
		String returnVal = new String();
		
		returnVal += items.size();
		
		for (Item i : items) {
			
			returnVal += " " + i.getID();
			
		}
		
		return id + " " + returnVal;
		
	}
	
	public int getItemCount() {
		
		return items.size();
		
	}
	
	private HashMap<String, Person> entities;
	private ArrayList<Item> items;
	private HashMap<String, Room> exits;
	private String description, detailedDescription, exitText;
	private String id;
	
}
