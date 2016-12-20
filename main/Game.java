package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import items.*;
import people.*;
import rooms.*;

public class Game {
	
	public Game() {
		
		inDevice = new Scanner(System.in);
		
		allRooms = new Vector<Room>();
		
		player1 = new Player();
		isPlaying = true;
		
		// People initializations
		
		Person p1 = new QuestGiver();
		
		p1.setName("QuestGiver");
		p1.setPhrase("Greetings, traveler. I am the quest giver.\n" +
		"I lost my peanut butter sandwich. Can you find it for me?");
		p1.setDescription("A smelly hobo with a santa hat");
		
		// Room initializations
		
		Room r1 = new Room();
		
		r1.setDescription("You are in Room 1");
		r1.setDetailedDescription("Room 1");
		r1.setExitText("To the South is Room 2");
		r1.setID("R1");
		
		Room r2 = new Room();
		
		r2.setDescription("You are in Room 2");
		r2.setDetailedDescription("Room 2");
		r2.setExitText("To the North is Room 1\nTo the South is Room 3");
		r2.setID("R2");
		
		Room r3 = new Room();
		
		r3.setDescription("You are in Room 3");
		r3.setDetailedDescription("Room 3");
		r3.setExitText("To the North is Room 2\nTo the South is Room 4\nTo the East is Room 7");
		r3.setID("R3");
		
		Room r4 = new Room();
		
		r4.setDescription("You are in Room 4");
		r4.setDetailedDescription("Room 4");
		r4.setExitText("To the North is Room 3\nTo the South is Room 5");
		r4.setID("R4");
		
		Room r5 = new Room();
		
		r5.setDescription("You are in Room 5");
		r5.setDetailedDescription("Room 5");
		r5.setExitText("To the North is Room 4\nTo the South is Room A\nTo the East is Room 6");
		r5.setID("R5");
		
		Room r6 = new Room();
		
		r6.setDescription("You are in Room 6");
		r6.setDetailedDescription("Room 6");
		r6.setExitText("To the West is Room 5");
		r6.setID("R6");
		
		Room r7 = new Room();
		
		r7.setDescription("You are in Room 7");
		r7.setDetailedDescription("Room 7");
		r7.setExitText("To the East is Room 8\nTo the West is Room 3");
		r7.setID("R7");
		
		Room r8 = new Room();
		
		r8.setDescription("You are in Room 8");
		r8.setDetailedDescription("Room 8");
		r8.setExitText("To the North is Room 9\nTo the West is Room 7");
		r8.setID("R8");
		
		Room r9 = new Room();
		
		r9.setDescription("You are in Room 9");
		r9.setDetailedDescription("Room 9");
		r9.setExitText("To the South is Room 8\nTo the East is Room a");
		r9.setID("R9");
		
		Room ra = new Room();
		
		ra.setDescription("You are in Room a");
		ra.setDetailedDescription("Room a");
		ra.setExitText("To the East is Room 9\nTo the West is Room b");
		ra.setID("RA");
		
		Room rb = new Room();
		
		rb.setDescription("You are in Room b");
		rb.setDetailedDescription("Room b");
		rb.setExitText("To the South is Room c\nTo the West is Room a");
		rb.setID("RB");
		
		Room rc = new Room();
		
		rc.setDescription("You are in Room c");
		rc.setDetailedDescription("Room c");
		rc.setExitText("To the North is Room b\nTo the South is Room d");
		rc.setID("RC");
		
		Room rd = new Room();
		
		rd.setDescription("You are in Room d");
		rd.setDetailedDescription("Room d");
		rd.setExitText("To the North is Room c\nTo the South is Room e\nTo the East is Room g");
		rd.setID("RD");
		
		// Populate rooms
		
		r1.addEntity("QuestGiver", p1);
		
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
		
		allRooms.add(r1);
		allRooms.add(r2);
		allRooms.add(r3);
		allRooms.add(r4);
		allRooms.add(r5);
		allRooms.add(r6);
		allRooms.add(r7);
		allRooms.add(r8);
		allRooms.add(r9);
		allRooms.add(ra);
		allRooms.add(rb);
		allRooms.add(rc);
		allRooms.add(rd);
		
		currentRoom = r1;
		
	}

	public void run() {
		
		String input = new String();
		
		showInitialScreen();
		
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
			System.out.printf("%-20s\t\t%s\n", "Stats", "Shows your current stats");
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
				
				String target = new String();
				
				target += words[1];
				
				for (int i = 2; i < words.length; i++) {
					
					target += " " + words[i];
					
				}
			
				if (currentRoom.hasEntity(target)) {
					
					currentRoom.getEntity(target).sayDescription();
					
				}
				
				else if (currentRoom.hasItem(target)) {
					
					currentRoom.getItem(target).sayDescription();
					
				}
				
				else {
					
					System.out.println("There is no " + target + " here.");
					
				}
				
			}
			
		}
		
		else if (words[0].equalsIgnoreCase("Inventory")) {
			
			player1.getInventory().listInventory();
			
		}
		
		else if (words[0].equalsIgnoreCase("get")) {
			
			if (words.length == 1) {
				
				System.out.println("Get what?");
				
			}
			
			else {
				
				String target = new String();
				
				target += words[1];
				
				for (int i = 2; i < words.length; i++) {
					
					target += " " + words[i];
					
				}
				
				if (currentRoom.hasItem(target)) {
					
					player1.getInventory().addItem(currentRoom.getItem(target), 1);
					currentRoom.removeItem(currentRoom.getItem(target));
					
				}
				
				else {
					
					System.out.println("There is no " + target + " here.");
					
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
		
		else if (words[0].equalsIgnoreCase("save")) {
			
			String saveData = new String();
			
			saveData += currentRoom.getID();
			saveData += "\n" + player1.getName();
			saveData += "\n" + player1.getStatsAsString();
			saveData += "\n" + player1.getInventory().getInvAsString();
			saveData += "\n";
			
			for (Room r : allRooms) {
				
				if (r.getItemCount() > 0)
					saveData += r.save() + " ";
				
			}
			
			try {
			
				Files.write(Paths.get("save/save.bin"), saveData.getBytes());
			
			}
			
			catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			System.out.println("Game saved.");
			
		}
		
		else if (words[0].equalsIgnoreCase("stats")) {
			
			player1.printStats();
			
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
				
				try {
				
					List<String> lines = Files.readAllLines(Paths.get("save/save.bin"), StandardCharsets.UTF_8);
					
					int lineNumber = 0;
					
					boolean worked = true;
					
					for (String i : lines) {
						
						String[] values = i.split("\\s");
						
						switch (lineNumber) {
							
							case 0: // Current room
								
								for (Room r : allRooms) {
									
									if (r.getID().equals(i)) {
										
										currentRoom = r;
										break;
										
									}
									
								}
								
								break;
								
							case 1: // Player name
								
								player1.setName(i);
								
								break;
								
							case 2: // Player stats
								
								player1.setStats(Float.parseFloat(values[0]), Float.parseFloat(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]));
								
								break;
								
							case 3: // Inventory
								
								int itemsToAdd = Integer.parseInt(values[0]);
								
								for (int j = 0; j < itemsToAdd; j++) {
									
									player1.getInventory().addItem(ItemList.getItem(Integer.parseInt(values[j * 2 + 1])), Integer.parseInt(values[(j * 2) + 2]));
									
								}
								
								break;
								
							case 4: // Rooms
							
								int currentWord = 0;
								
								for (Room r : allRooms) {
									
									String id = values[currentWord];
									
									System.out.println("lookin man. im at " + r.getID());
									
									if (r.getID().equals(id)) {
										
										System.out.println("Inside room " + r.getID());
										
										currentWord++;
										
										int count = Integer.parseInt(values[currentWord]);
										
										for (int j = 0; j < count; j++) {
											
											System.out.println("Looking for #" + j + 1 + "/" + count);
											
											currentWord++;
											
											r.addItem(ItemList.getItem(Integer.parseInt(values[currentWord])));
											
											currentWord++;
											
											if (currentWord == values.length)
												currentWord--;
											
										}
										
									}
									
								}
								
								break;
							
						}
						
						lineNumber++;
						
					}
					
					if (!worked) {
						
						System.out.println("There was an error in loading the file.");
						
					}
					
					
					
					else {
					
						picked = true;
						inDevice.nextLine();
						
					}
				
				}
				
				catch (IOException e) {
					
					System.out.println(e);
					
				}
				
			}
			
			else {
				
				inDevice.nextLine();
			
				showInitialInfo();
				getPlayerInfo();
				
				// Populate rooms
				
				for (Room r : allRooms) {
					
					if (r.getID().equals("R6")) {
						
						r.addItem(ItemList.getItem(1));
						
					}
					
					if (r.getID().equals("R3")) {
						
						r.addItem(ItemList.getItem(2));
						
					}
					
				}
				
				picked = true;
				
			}
			
		} while (!(picked));
		
	}
	
	private Player player1;
	private boolean isPlaying;
	private Room currentRoom;
	private Scanner inDevice;
	private Vector<Room> allRooms;
	
}
