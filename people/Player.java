package people;

import items.Inventory;
import main.Main;
import java.util.HashMap;
import java.util.Vector;

public class Player {
	
	public Player() {
		
		health = 25;
		maxHealth = 25;
		mana = 10;
		maxMana = 10;
		name = "";
		
		inv = new Inventory();
		quests = new HashMap<Integer, String>();
		finishedQuests = new Vector<Integer>();
		
	}

	public boolean isAlive() {
		
		return health > 0;
		
	}
	
	public void changeHealth(float val) {
		
		health -= val;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setSpecialty(int s) {
		
		this.specialty = s;
		
		// You get 25 points that are randomly assigned.
		
		int pointsLeft = 70, boostFactor = 0, additionalNum = 0;
		
		switch (specialty) {
		
		case 1: // Illuminati
			
			health = Main.genRandNum(2, 10);
			pointsLeft -= health;
			mana = Main.genRandNum(2, 10);
			pointsLeft -= mana;
			attack = Main.genRandNum(2, 10);
			pointsLeft -= attack;
			defense = Main.genRandNum(2, 10);
			pointsLeft -= defense;
			magic = Main.genRandNum(2, 10);
			pointsLeft -= magic;
			intelligence = Main.genRandNum(2, 10);
			pointsLeft -= intelligence;
			speed = Main.genRandNum(2, 10);
			pointsLeft -= speed;
			
			boostFactor = Main.genRandNum(1, 3);
			
			attack -= boostFactor;
			health -= boostFactor;
			
			intelligence += boostFactor;
			magic += boostFactor;
			
			additionalNum = pointsLeft % 7;
			
			for (int i = 0; i < additionalNum; i++) {
				
				attack++;
				health++;
				mana++;
				defense++;
				magic++;
				intelligence++;
				speed++;
				
				pointsLeft -= 7;
				
			}
			
			pointsLeft /= 2;
			
			intelligence += pointsLeft;
			magic += pointsLeft;
			
			maxHealth = health;
			maxMana = mana;
			
			break;
			
		case 2: // Chicken Knights
			
			health = Main.genRandNum(2, 10);
			pointsLeft -= health;
			mana = Main.genRandNum(2, 10);
			pointsLeft -= mana;
			attack = Main.genRandNum(2, 10);
			pointsLeft -= attack;
			defense = Main.genRandNum(2, 10);
			pointsLeft -= defense;
			magic = Main.genRandNum(2, 10);
			pointsLeft -= magic;
			intelligence = Main.genRandNum(2, 10);
			pointsLeft -= intelligence;
			speed = Main.genRandNum(2, 10);
			pointsLeft -= speed;
			
			boostFactor = Main.genRandNum(1, 3);
			
			magic -= boostFactor;
			speed -= boostFactor;
			
			attack += boostFactor;
			defense += boostFactor;
			
			additionalNum = pointsLeft % 7;
			
			for (int i = 0; i < additionalNum; i++) {
				
				attack++;
				health++;
				mana++;
				defense++;
				magic++;
				intelligence++;
				speed++;
				
				pointsLeft -= 7;
				
			}
			
			pointsLeft /= 2;
			
			attack += pointsLeft;
			defense += pointsLeft;
			
			maxHealth = health;
			maxMana = mana;
			
			break;
			
		case 3: // Hogwarts
			
			health = Main.genRandNum(2, 10);
			pointsLeft -= health;
			mana = Main.genRandNum(2, 10);
			pointsLeft -= mana;
			attack = Main.genRandNum(2, 10);
			pointsLeft -= attack;
			defense = Main.genRandNum(2, 10);
			pointsLeft -= defense;
			magic = Main.genRandNum(2, 10);
			pointsLeft -= magic;
			intelligence = Main.genRandNum(2, 10);
			pointsLeft -= intelligence;
			speed = Main.genRandNum(2, 10);
			pointsLeft -= speed;
			
			boostFactor = Main.genRandNum(1, 3);
			
			defense -= boostFactor;
			speed -= boostFactor;
			
			magic += boostFactor;
			mana += boostFactor;
			
			additionalNum = pointsLeft % 7;
			
			for (int i = 0; i < additionalNum - 1; i++) {
				
				attack++;
				health++;
				mana++;
				defense++;
				magic++;
				intelligence++;
				speed++;
				
				pointsLeft -= 7;
				
			}
			
			pointsLeft /= 2;
			
			magic += pointsLeft;
			mana += pointsLeft;
			
			maxHealth = health;
			maxMana = mana;
			
			break;
			
		case 4: // Jack Black
			
			health = Main.genRandNum(2, 10);
			pointsLeft -= health;
			mana = Main.genRandNum(2, 10);
			pointsLeft -= mana;
			attack = Main.genRandNum(2, 10);
			pointsLeft -= attack;
			defense = Main.genRandNum(2, 10);
			pointsLeft -= defense;
			magic = Main.genRandNum(2, 10);
			pointsLeft -= magic;
			intelligence = Main.genRandNum(2, 10);
			pointsLeft -= intelligence;
			speed = Main.genRandNum(2, 10);
			pointsLeft -= speed;
			
			boostFactor = Main.genRandNum(1, 3);
			
			mana -= boostFactor;
			defense -= boostFactor;
			
			magic += boostFactor;
			health += boostFactor;
			
			additionalNum = pointsLeft % 7;
			
			for (int i = 0; i < additionalNum; i++) {
				
				attack++;
				health++;
				mana++;
				defense++;
				magic++;
				intelligence++;
				speed++;
				
				pointsLeft -= 7;
				
			}
			
			pointsLeft /= 2;
			
			health += pointsLeft;
			magic += pointsLeft;
			
			maxHealth = health;
			maxMana = mana;
			
			break;
			
		case 5: // Nazi
			
			health = Main.genRandNum(2, 10);
			pointsLeft -= health;
			mana = Main.genRandNum(2, 10);
			pointsLeft -= mana;
			attack = Main.genRandNum(2, 10);
			pointsLeft -= attack;
			defense = Main.genRandNum(2, 10);
			pointsLeft -= defense;
			magic = Main.genRandNum(2, 10);
			pointsLeft -= magic;
			intelligence = Main.genRandNum(2, 10);
			pointsLeft -= intelligence;
			speed = Main.genRandNum(2, 10);
			pointsLeft -= speed;
			
			boostFactor = Main.genRandNum(1, 3);
			
			speed += 5;
			pointsLeft -= 35;
			
			additionalNum = pointsLeft % 7;
			
			for (int i = 0; i < additionalNum; i++) {
				
				attack++;
				health++;
				mana++;
				defense++;
				magic++;
				intelligence++;
				speed++;
				
				pointsLeft -= 7;
				
			}
			
			speed += pointsLeft;
			
			maxHealth = health;
			maxMana = mana;
			
			break;
		
		}
		
	}
	
	public Inventory getInventory() {
		
		return inv;
		
	}
	
	public void printStats() {
		
		System.out.println(name + ":\n");
		
		System.out.printf("%-20s\t\t%d\n", "Attack", attack);	
		System.out.printf("%-20s\t\t%d\n", "Defense", defense);	
		System.out.printf("%-20s\t\t%d\n", "Magic", magic);	
		System.out.printf("%-20s\t\t%d\n", "Intelligence", intelligence);	
		System.out.printf("%-20s\t\t%d\n", "Speed", speed);	
		System.out.printf("%-20s\t\t%d\n", "Mana", mana);	
		System.out.printf("%-20s\t\t%f\n", "Health", health);
		
	}
	
	public void printQuests() {
		
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println("              Quests");
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println();
		
		for (String value : quests.values()) {
			
			System.out.println("- " + value);
			
		}
		
	}
	
	public void addQuest(int id, String value) {
		
		quests.put(id, value);
		
	}
	
	public void setQuestFinished(int id) {
		
		quests.remove(id);
		finishedQuests.add(id);
		
	}
	
	public boolean hasCompletedQuest(int id) {
		
		return finishedQuests.contains(id);
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getStatsAsString() {
		
		return String.valueOf(health) + " " + String.valueOf(maxHealth) + " " + String.valueOf(specialty) + " " + String.valueOf(attack) + " " +
		String.valueOf(defense) + " " + String.valueOf(magic) + " " + String.valueOf(intelligence) + " " + String.valueOf(speed)
	    + " " + String.valueOf(mana) + " " + String.valueOf(maxMana);
		
	}
	
	public void setStats(float health, float maxHealth, int specialty, int attack, int defense, int magic, int intelligence, int speed, int mana, int maxMana) {
		
		this.health = health;
		this.maxHealth = maxHealth;
		this.specialty = specialty;
		this.attack = attack;
		this.defense = defense;
		this.magic = magic;
		this.intelligence = intelligence;
		this.speed = speed;
		this.mana = mana;
		this.maxMana = maxMana;
		
	}
	
	private float health, maxHealth;
	private String name;
	private int specialty;
	private Inventory inv;
	private int attack, defense, magic, intelligence, speed, mana, maxMana;
	private HashMap<Integer, String> quests;
	private Vector<Integer> finishedQuests;
	
}
