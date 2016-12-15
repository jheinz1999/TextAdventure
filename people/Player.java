package people;

import items.Inventory;
import main.Main;

public class Player {
	
	public Player() {
		
		health = 25;
		maxHealth = 25;
		mana = 10;
		maxMana = 10;
		name = "";
		
		inv = new Inventory();
		
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
		
		System.out.printf("%-20s\t\t%d\n", "Attack", attack);	
		System.out.printf("%-20s\t\t%d\n", "Defense", defense);	
		System.out.printf("%-20s\t\t%d\n", "Magic", magic);	
		System.out.printf("%-20s\t\t%d\n", "Intelligence", intelligence);	
		System.out.printf("%-20s\t\t%d\n", "Speed", speed);	
		System.out.printf("%-20s\t\t%d\n", "Mana", mana);	
		System.out.printf("%-20s\t\t%f\n", "Health", health);
		
	}
	
	private float health, maxHealth;
	private String name;
	private int specialty;
	private Inventory inv;
	private int attack, defense, magic, intelligence, speed, mana, maxMana;
	
}
