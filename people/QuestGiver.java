package people;

import items.Item;
import main.Main;

public class QuestGiver extends Person {
	
	@Override
	public boolean takeItem(Item i) {
		
		if (i.getName().equalsIgnoreCase("Sandwich") && !hasSandwich && Main.getGameStage() == 0) {
			
			System.out.println("No way!!! You found my sandwich!!!");
			hasSandwich = true;
			
			Main.changeGameStage(1);
			
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
	}
	
	boolean hasSandwich;

}
