package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import items.Item;
import people.*;
import rooms.*;

public class Game {
	
	public Game() {
		
		inDevice = new Scanner(System.in);
		
		player1 = new Player();
		isPlaying = true;
		
		// People initializations
		
		Person p1 = new QuestGiver();
		
		p1.setName("QuestGiver");
		p1.setPhrase("Greetings, traveler. I am the quest giver.\n" +
		"I lost my peanut butter sandwich. Can you find it for me?");
		p1.setDescription("A smelly hobo with a santa hat");
		
		// Item initializations
		
		Item i = new Item();
		
		i.setName("Sandwich");
		i.setDescription("A fresh peanut butter sandwich.");
		
		// Room initializations
		
		Room r1 = new Room();
		
		r1.setDescription("You are in Room 1");
		r1.setDetailedDescription("Room 1");
		r1.setExitText("To the South is Room 2");
		
		Room r2 = new Room();
		
		r2.setDescription("You are in Room 2");
		r2.setDetailedDescription("Room 2");
		r2.setExitText("To the North is Room 1\nTo the South is Room 3");
		
		Room r3 = new Room();
		
		r3.setDescription("You are in Room 3");
		r3.setDetailedDescription("Room 3");
		r3.setExitText("To the North is Room 2\nTo the South is Room 4\nTo the East is Room 7");
		
		Room r4 = new Room();
		
		r4.setDescription("You are in Room 4");
		r4.setDetailedDescription("Room 4");
		r4.setExitText("To the North is Room 3\nTo the South is Room 5");
		
		Room r5 = new Room();
		
		r5.setDescription("You are in Room 5");
		r5.setDetailedDescription("Room 5");
		r5.setExitText("To the North is Room 4\nTo the South is Room A\nTo the East is Room 6");
		
		Room r6 = new Room();
		
		r6.setDescription("You are in Room 6");
		r6.setDetailedDescription("Room 6");
		r6.setExitText("To the West is Room 5");
		
		Room r7 = new Room();
		
		r7.setDescription("You are in Room 7");
		r7.setDetailedDescription("Room 7");
		r7.setExitText("To the East is Room 8\nTo the West is Room 3");
		
		Room r8 = new Room();
		
		r8.setDescription("You are in Room 8");
		r8.setDetailedDescription("Room 8");
		r8.setExitText("To the North is Room 9\nTo the West is Room 7");
		
		Room r9 = new Room();
		
		r9.setDescription("You are in Room 9");
		r9.setDetailedDescription("Room 9");
		r9.setExitText("To the South is Room 8\nTo the East is Room a");
		
		Room ra = new Room();
		
		ra.setDescription("You are in Room a");
		ra.setDetailedDescription("Room a");
		ra.setExitText("To the East is Room 9\nTo the West is Room b");
		
		Room rb = new Room();
		
		rb.setDescription("You are in Room b");
		rb.setDetailedDescription("Room b");
		rb.setExitText("To the South is Room c\nTo the West is Room a");
		
		Room rc = new Room();
		
		rc.setDescription("You are in Room c");
		rc.setDetailedDescription("Room c");
		rc.setExitText("To the North is Room b\nTo the South is Room d");
		
		Room rd = new Room();
		
		rd.setDescription("You are in Room d");
		rd.setDetailedDescription("Room d");
		rd.setExitText("To the North is Room c\nTo the South is Room e\nTo the East is Room g");
		
		// Populate rooms
		
		r1.addEntity("QuestGiver", p1);
		r6.addItem(i);
		
		// Exits
		
		r1.addExit("South", r2);
		r2.addExit("South", r3);
		r2.addExit("North", r1);
		r3.addExit("North", r2);
		r3.addExit("South", r4);
		r3.addExit("East", r7);
		r4.addExit("North", r3);
		r4.addExit("South", r5);
		r5.addExit("North", r4);
		r5.addExit("East", r6);
		r6.addExit("West", r5);
		r7.addExit("East", r8);
		r7.addExit("West", r3);
		r8.addExit("North", r9);
		r8.addExit("West", r7);
		r9.addExit("South", r8);
		r9.addExit("East", ra);
		ra.addExit("East", r9);
		ra.addExit("West", rb);
		rb.addExit("South", rc);
		rb.addExit("West", ra);
		rc.addExit("North", rb);
		rc.addExit("South", rd);
		
		currentRoom = r1;
		
	}

	public void run() {
		
		String input = new String();
		
		showInitialScreen();
		
		showInitialInfo();
		getPlayerInfo();
		
		inDevice.reset();
		
		// Game loop
		
		while (player1.isAlive() && isPlaying) {
			
			System.out.println();
			
			currentRoom.printDescription();
			
			System.out.println();
			System.out.print("> ");
			
			input = inDevice.nextLine();
			
			System.out.println();
			
			parseInput(input);
			
		}
		
		System.out.println("done");
		
	}
	
	private void showInitialInfo() {
		
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println("     THE QUEST FOR CHICKENTOPIA");
		System.out.println();
		System.out.println("       An epic text adventure");
		System.out.println("           By Jonny Heinz");
		System.out.println();
		System.out.println("------------------------------------");
		
		System.out.println();
		
		System.out.println("Greetings, traveler. You are about to embark on a great and noble quest.");
		System.out.println("Before you embark on this quest, you must first gain some insight as to\nwho you are, and what your motives are.");
		System.out.println("You are a magical wizard from Mordor.");
		System.out.println("Dumbledore (Gandalf's secret brother) has lost his magic wand. It is\nrumored to have been stolen by the famous master\nof the kind of dim arts, Captain Crunch.");
		System.out.println("Your task is to seek out this magic wand");
		
		System.out.println();
		
	}
	
	private void getPlayerInfo() {
		
		System.out.println("Before you can embark on your noble journey, it is imperative that we establish"
				+ "\na few things about your character.");
		
		System.out.println("What is your wizard's name?");
		player1.setName(inDevice.nextLine());
		
		boolean specialtyPicked = false;
		
		int specialty = 0;
		
		do {
		
			System.out.println("What is your wizard's discipline?");
			
			System.out.println("[1] - The Discipline of the Illuminati");
			System.out.println("[2] - The Discipline of the Blue Chicken Knights");
			System.out.println("[3] - The Discipline of Hogwarts");
			System.out.println("[4] - The Discipline of Jack Black");
			System.out.println("[5] - The Discipline of Lesbian Nazi Hookers Abducted By Space Aliens And Forced Into Weight Loss Programs");
			
			try {
			
				specialty = inDevice.nextInt();
				
			} 
			
			catch (InputMismatchException e) {
				
				inDevice.nextLine();
				
			}
			
			if (!(1 <= specialty && specialty <= 5))
				System.out.println("Please enter a number from 1-5.");
			else
				specialtyPicked = true;
			
		} while (!specialtyPicked);
		
		inDevice.nextLine();
		
		player1.setSpecialty(specialty);
		
		System.out.println("We now have enough information to send you out into the world.\n");
		System.out.println("A few tips:");
		System.out.println("Always LOOK at things.");
		System.out.println("TALK to everyone that you meet.");
		System.out.println("At any time, you may type \"HELP\" to list possible commands.");
		
		System.out.println();
		
		System.out.println("You are now ready to embark on your quest. Good luck, traveler.");
		
		System.out.println("STATS: \n");
		
		player1.printStats();
		
	}
	
	private void parseInput(String input) {
		
		String[] words = input.split("\\s");
		
		if (words[0].equalsIgnoreCase("help")) {
			
			System.out.println("Help\n\nYou can use the following commands to explore your environment:\n");
			System.out.printf("%-20s\t\t%s\n", "Go [direction]", "Move in the desired direction");
			System.out.printf("%-20s\t\t%s\n", "Look [thing]", "Prints detailed description of thing");
			System.out.printf("%-20s\t\t%s\n", "Get [item]", "Gets item");
			System.out.printf("%-20s\t\t%s\n", "Talk [entity]", "Talks to entity");
			System.out.printf("%-20s\t\t%s\n", "Give [entity] [item]", "Gives item to entity");
			System.out.printf("%-20s\t\t%s\n", "Map", "Displays immediate surroundings");
			System.out.printf("%-20s\t\t%s\n", "Inventory", "Displays inventory contents");
			System.out.printf("%-20s\t\t%s\n", "Quests", "Shows your current quest");
			System.out.printf("%-20s\t\t%s\n", "Save", "Saves the game");
			System.out.printf("%-20s\t\t%s\n", "Quit", "Quits the game");
			
		}
		
		else if (words[0].equalsIgnoreCase("go")) {
			
			if (words.length == 2) {
			
				if (currentRoom.hasExit(words[1]))
					currentRoom = currentRoom.getExit(words[1]);
				
				else
					System.out.println("You can't go that way.");
				
			}
			
			else
				System.out.println("Go where?");
			
		}
		
		else if (words[0].equalsIgnoreCase("talk")) {
			
			if (words.length != 2) {
				
				System.out.println("Talk to who?");
				
			}
			
			else {
			
				if (currentRoom.hasEntity(words[1].toUpperCase())) {
					
					currentRoom.getEntity(words[1].toUpperCase()).sayPhrase(player1); 
					
				}
				
				else {
					
					System.out.println("There is no " + words[1] + " here.");
					
				}
			
			}
			
		}
		
		else if (words[0].equalsIgnoreCase("quit") && words.length == 1) {
			
			isPlaying = false;
			
		}
		
		else if (words[0].equalsIgnoreCase("look")) {
			
			if (words.length == 1) {
				
				currentRoom.printDetailedDescription();
				
			}
			
			else {
			
				if (currentRoom.hasEntity(words[1])) {
					
					currentRoom.getEntity(words[1]).sayDescription();
					
				}
				
				else if (currentRoom.hasItem(words[1])) {
					
					currentRoom.getItem(words[1]).sayDescription();
					
				}
				
				else {
					
					System.out.println("There is no " + words[1] + " here.");
					
				}
				
			}
			
		}
		
		else if (words[0].equalsIgnoreCase("Inventory")) {
			
			player1.getInventory().listInventory();
			
		}
		
		else if (words[0].equalsIgnoreCase("get")) {
			
			if (words.length != 2) {
				
				System.out.println("Get what?");
				
			}
			
			else {
				
				if (currentRoom.hasItem(words[1])) {
					
					player1.getInventory().addItem(currentRoom.getItem(words[1]), 1);
					currentRoom.removeItem(currentRoom.getItem(words[1]));
					
				}
				
				else {
					
					System.out.println("There is no " + words[1] + " here.");
					
				}
				
			}
			
		}
		
		else if (words[0].equalsIgnoreCase("give")) {
			
			if (words.length < 2) {
				
				System.out.println("Give what?");
				
			}
			
			else if (words.length == 3) {
				
				if (player1.getInventory().hasItem(words[2])) {
					
					if (currentRoom.hasEntity(words[1])) {
						
						if (currentRoom.getEntity(words[1]).takeItem(player1.getInventory().getItem(words[2]), player1)) {
							
							player1.getInventory().removeItem(words[2]);
							
						}
						
					}
					
					else {
						
						System.out.println(words[1] + " isn't here.");
						
					}
					
				}
				
				else {
					
					System.out.println("You don't have a " + words[2]);
					
				}
				
			}
			
		}
		
		else if ((words[0]).equalsIgnoreCase("Quests")) {
			
			player1.printQuests();
			
		}
		
		else if (words[0].equalsIgnoreCase("map")) {
			
			currentRoom.drawMap();
			
		}
		
		else {
			
			System.out.println("Command not processed.");
			
		}
		
	}
	
	private void showInitialScreen() {
		
		System.out.println("---------------------------------------------");
		
		System.out.println();
		
		System.out.println("      .\".\".\".\n" +
"    (`       `)               _.-=-.\n" +
"     '._.--.-;             .-`  -'  '.\n" +
"    .-'`.o )  \\           /  .-_.--'  `\\\n" +
"   `;---) \\    ;         /  / ;' _-_.-' `\n" +
"     `;\"`  ;    \\        ; .  .'   _-' \\\n" +
"      (    )    |        |  / .-.-'    -`\n" +
"       '-.-'     \\       | .' ` '.-'-\\`\n" +
"        /_./\\_.|\\_\\      ;  ' .'-'.-.\n" +
"        /         '-._    \\` /  _;-,\n" +
"       |         .-=-.;-._ \\  -'-,\n" +
"       \\        /      `\";`-`,-\"`)\n" +
"        \\       \\     '-- `\\.\\\n" +
"         '.      '._ '-- '--'/\n" +
"           `-._     `'----'`;\n" +
"               `\"\"\"--.____,/\n" +
"                      \\\\  \\\n" +
"                      // /`\n" +
"                  ___// /__\n" +
"                (`(`(---\"-`)\")\n");

		System.out.println();
		
		System.out.println("---------------------------------------------");
		
		boolean picked = false;
		
		int input = 0;
		
		do {
			
			System.out.println("[1] New Game");
			System.out.println("[2] Load Game");
			
			try {
				
				input = inDevice.nextInt();
				
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Please enter 1 or 2.");
				
				inDevice.nextLine();
				
			}
			
			if (input != 1) {
				
				System.out.println("Loading hasn't been implemented.");
				
			}
			
			else
				picked = true;
			
		} while (!(picked));
		
		inDevice.nextLine();
		
	}
	
	private Player player1;
	private boolean isPlaying;
	private Room currentRoom;
	private Scanner inDevice;
	
}
