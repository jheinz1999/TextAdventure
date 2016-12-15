package items;

public class Item {
	
	public Item() {
		
		name = new String();
		
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
	
	private String name;
	private String description;
	
}
