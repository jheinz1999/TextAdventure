package main;

import items.ItemList;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		ItemList i = new ItemList();
		
		randGen = new Random();
		
		Game g = new Game();
		
		g.run();
		
	}
	
	public static int getGameStage() {
		
		return gameStage;
		
	}
	
	public static void changeGameStage(int change) {
		
		gameStage += change;
		
	}
	
	public static int genRandNum(int min, int max) {
		
		return randGen.nextInt(max + 1 - min) + min;
		
	}
	
	private static int gameStage;
	
	private static Random randGen;
	
}
