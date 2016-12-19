package items;

public class Item {
	
	public Item() {
		
		name = new String();
		isEquippable = false;
		
	}

	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public void sayDescription() {
		
		System.out.println(description);
		
	}
	
	public void setID(int id) {
		
		this.id = id;
		
	}
	
	public int getID() {
		
		return id;
		
	}
	
	public void setEquippable() {
		
		isEquippable = true;
		
	}
	
	public boolean isEquippable() {
		
		return isEquippable;
		
	}
	
	private String name;
	private String description;
	private int id;
	private boolean isEquippable;
	
}
