package people;

import items.Item;
import main.Main;

public class QuestGiver extends Person {
	
	@Override
	public boolean takeItem(Item i, Player player) {
		
		if (i.getName().equalsIgnoreCase("Sandwich") && !hasSandwich && !hasCompletedQuest) {
			
			System.out.println("No way!!! You found my sandwich!!!");
			hasSandwich = true;
			hasCompletedQuest = true;
			player.setQuestFinished(1);
			setPhrase("Thanks for the sandwich bro");
			System.out.println("\nQuest completed!");
			
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
	}
	
	@Override
	public void sayPhrase(Player player) {
		
		super.sayPhrase(player);
		
		if (!hasGivenQuest) {
			
			player.addQuest(1, "Get a sandwich for the QuestGiver");
			hasGivenQuest = true;
			System.out.println("\nNew Quest! Type \'quests\' to see it.");
			
		}
		
	}
	
	private boolean hasSandwich;
	private boolean hasGivenQuest;
	private boolean hasCompletedQuest;

}
