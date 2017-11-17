package civLife;


import java.util.Scanner;
import java.util.concurrent.*;

public class CivLifeDriver {
	
	private static final Object HelpInfo = null;
	private static Resource wood = new Resource("WOOD",100);
	private static Resource stone = new Resource("STONE",100);
	private static Resource food = new Resource("FOOD",100);
	
	private static PersonType farmer = new PersonType("FARMER", 10);
	private static PersonType fighter = new PersonType("FIGHTER", 0);			
	private static PersonType lumberjack = new PersonType("LUMBERJACK", 10);
	private static PersonType miner = new PersonType("MINER",10);
	
	private static int month = 0;
	private static int year = 0;
	private static int gatherAnswer;
	private static String civName = getUserName();
	
	private static Building hut = new Hut(250,250,"HUT",6,1);
	
	public static void main(String[] args) {
		
		menu();
	}//end main
	
	//main menu method
	public static void menu() {
		
		Scanner menuScan = new Scanner(System.in);
		String userInput;
		boolean done = false;
		
		//layout of main screen
		menus main = new menus();
		main.mainMenu(civName, year, month);

		//User decides whether they wan to view or gather resources
		while(!done){
			
			userInput = menuScan.nextLine();
			
			if(userInput.equalsIgnoreCase("V")) {
				
				System.out.println();
				viewResources();
				done = true;
			}
			
			else if(userInput.equalsIgnoreCase("G")) {
				
				System.out.println();
				gatherResourceMenu();
				done = true;
			}
			
			else if(userInput.equalsIgnoreCase("P")){
				
				System.out.println();
				viewPopulation();
				done = true;				
			}
			
			else if(userInput.equalsIgnoreCase("B")){
				
				System.out.println();
				viewBuildings();
				done = true;				
			}
			
			else if(userInput.equalsIgnoreCase("A")){
				
				System.out.println();
				buyBuildings();
				done = true;	
			} else if(userInput.equalsIgnoreCase("H")) {
				System.out.println();
				help();
				done = true;
			} else if(userInput.equalsIgnoreCase("E")) {
				System.out.println("Thank you for playing!");
				done = true;
			}
		}	
	}//end menu
	
	

	//View resources menu method
	public static void viewResources() {
		
		Scanner viewScan = new Scanner(System.in);
		String userViewInput;
		boolean done = false;
		
		
		//layout for viewing resources menu
		
		System.out.println("  YOUR RESOURCES   ");
		System.out.println("-------------------");
		System.out.println(wood.toString());
		System.out.println(stone.toString());
		System.out.println(food.toString());
		System.out.println("(B)ack");
		
		//If the user wants to go back to main menu
		while(!done) {
			
			userViewInput = viewScan.nextLine();
			
			if(userViewInput.equalsIgnoreCase("B")) {
				
				System.out.println();
				menu();
				done = true;
			}
		}
	}//end viewResource menu
	
	//gather resources menu method
	public static void gatherResourceMenu() {
			
		Scanner gatherScan = new Scanner(System.in);
		gatherAnswer = 4;
		//layout for gather resources menu
		System.out.println("WHAT RESOURCE WOULD YOU LIKE TO GATHER?");
		System.out.println("---------------------------------------");
		System.out.println("(1) "+ wood.getResourceName());
		System.out.println("(2) "+ stone.getResourceName());
		System.out.println("(3) "+ food.getResourceName());
		
		
		while(!(gatherAnswer == 1 || gatherAnswer == 2 || gatherAnswer == 3)) {
			
			gatherAnswer = gatherScan.nextInt();
			
			//if user wants to gather wood
			if(gatherAnswer == 1) {
				
				System.out.println();
				System.out.println("Gathering wood");
				for(int i=0; i < 3; i++) {
					System.out.print(".");
					try {
						TimeUnit.MILLISECONDS.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				int woodAmount = wood.gatherResource(wood,lumberjack.getTypePopulation());
				int bonusWood = (woodAmount + lumberjack.getTypePopulation()/10)- woodAmount;
				
				System.out.println(civName +", wood has been gathered! You gained: " + woodAmount);
				System.out.println("Having " + lumberjack.getTypePopulation() + " lumberjacks gave you a bonus "  + bonusWood + (" wood"));
				System.out.println("Current amount of wood: " + wood.getResourceAmount());;
				
				//updates the current month
				month++;
				
				if(month == 13){
					
					year++;
					month = 0;
				}
			}
			
			//if the user wants to gather stone
			else if(gatherAnswer == 2) {
				
				System.out.println();
				System.out.println("Gathering stone");
				for(int i=0; i < 3; i++) {
					System.out.print(".");
					try {
						TimeUnit.MILLISECONDS.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	

				int stoneAmount = stone.gatherResource(stone,miner.getTypePopulation());
				int bonusStone = (stoneAmount + miner.getTypePopulation()/10)- stoneAmount;
				
				System.out.println(civName +", stone has been successfully gathered! You gained: " + stoneAmount);
				System.out.println("Having " + miner.getTypePopulation() + " miners gave you a bonus "  + bonusStone + (" stone"));
				System.out.println("Current amount of stone: " + stone.getResourceAmount());
				
				month++;
				
				if(month == 13){
					
					year++;
					month = 0;
				}
			}
			
			//if the user wants to gather food
			else if(gatherAnswer == 3) {
				
				System.out.println();
				System.out.println("Finding and collecting food");
				for(int i=0; i < 3; i++) {
					System.out.print(".");
					try {
						TimeUnit.MILLISECONDS.sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
				
				int foodAmount = food.gatherResource(food,farmer.getTypePopulation());
				int bonusFood = (foodAmount + farmer.getTypePopulation()/10)- foodAmount;
				
				System.out.println(civName +", food has been found and gathered! You gained: " + foodAmount);
				System.out.println("Having " + farmer.getTypePopulation() + " farmers gave you a bonus "  + bonusFood + (" food"));
				System.out.println("Current amount of food: " + food.getResourceAmount());
				
				//updates the current month
				month++;
				if(month == 13){
					
					year++;
					month = 0;
				}
			}
			
			//if the user enters an invalid option
			else {
				
				System.out.println("Please enter a valid input");
			}
		}
		
		System.out.println();	
		menu();
	}//end gatherResource menu
	
	public static void viewPopulation(){
		
		Scanner viewPopScan = new Scanner(System.in);
		boolean done = false;
		
		//layout for population menu
		System.out.println("CURRENT POPULATION");
		System.out.println("------------------");
		System.out.println(farmer.toString());
		System.out.println(fighter.toString());
		System.out.println(miner.toString());
		System.out.println(lumberjack.toString());
		System.out.println("(B)ack");
		
		//If the user wants to go back to main menu
		while(!done) {
			
			String userInput = viewPopScan.nextLine();
			
			if(userInput.equalsIgnoreCase("B")) {
				
				menu();
				done = true;
			}
		}		
	}
	
	public static void viewBuildings(){
		
		Scanner viewBuildingScan = new Scanner(System.in);
		String userInput;
		boolean done = false;
	
		//layout for building menu
		System.out.println("YOUR BUILDINGS");
		System.out.println("----------------");
		System.out.println("HUTS: " + ((Hut) hut).getNumOfHuts() + "   LVL: " + (hut.getBuildingLevel()));
		System.out.println("(B)ack");
		
		//If the user wants to go back to main menu
		while(!done) {
			
			userInput = viewBuildingScan.nextLine();
			
			if(userInput.equalsIgnoreCase("B")) {
				
				System.out.println();
				menu();
				done = true;
			}
		}	
	}
	
	public static void buyBuildings(){
		
		Scanner buyScan = new Scanner(System.in);
		String buyAnswer;
		//boolean properAnswer = false;
		
		//layout for gather resources menu
		System.out.println("WHAT BUILDING WOULD YOU LIKE TO BUY?");
		System.out.println("---------------------------------------");
		System.out.println("(1) "+ hut.getBuildingName() + " (" + hut.getWoodPrice() + " wood, " + hut.getStonePrice() + " stone)");
		System.out.println("(B)ack");
	
			buyAnswer = buyScan.nextLine();
			
			//User wants to buy a hut
			if(buyAnswer.equals("1")) {
				
				if(hut.purchaseBuilding(wood.getResourceAmount(), stone.getResourceAmount())){
					
					System.out.println("This purchase was successful!");
					System.out.println(hut.getWoodPrice() + " wood was deducted");
					System.out.println(hut.getStonePrice() + " stone was deducted");					
					((Hut) hut).addHut();
					
					wood.removeResourceAmount(wood, hut.getWoodPrice());
					stone.removeResourceAmount(stone, hut.getStonePrice());
					
					System.out.println("You now own " + ((Hut) hut).getNumOfHuts() + " huts");
					//properAnswer = true;
				}
				
				else if((wood.getResourceAmount() <= hut.getWoodPrice()) && (stone.getResourceAmount() <= hut.getStonePrice())){
					
					System.out.println(wood.notEnough(hut.getWoodPrice()) + "\n\nAND\n\n" +stone.notEnough(hut.getStonePrice()) );
				}
				
				else if(wood.getResourceAmount() <= hut.getWoodPrice()){
					
					System.out.println(wood.notEnough(hut.getWoodPrice()));
				}
				
				else if(stone.getResourceAmount() <= hut.getStonePrice()){
					
					System.out.println(stone.notEnough(hut.getStonePrice()));
				}
				
				menu();
			}
			
			if(buyAnswer.equalsIgnoreCase("B")) {
				
				menu();
			}
			
			//if the user enters an invalid option
			else{
				
				System.out.println("Please enter a valid input");
				System.out.println();
				buyBuildings();
			}		
	}//end buyBuilding menu		
	
	public static void help() {
		Scanner helpScan = new Scanner(System.in);
		HelpInfo help = new HelpInfo();
		
		menus helpMenu = new menus();
		// calls the Help Menu
		helpMenu.helpMenu();

		String helpInput =  helpScan.nextLine();
		boolean validHelp =  false;
		
		while(!validHelp) {
			if(helpInput.equalsIgnoreCase("T")) {
				help.gameHelp();
				validHelp = true;
			} else if(helpInput.equalsIgnoreCase("G")) {
				help.resourcesHelp();
				validHelp = true;
			} else if(helpInput.equalsIgnoreCase("P")) {
				help.populationHelp();
				validHelp = true;
			} else if(helpInput.equalsIgnoreCase("B"))  {
				help.buildingsHelp();
				validHelp = true;
			} else if(helpInput.equalsIgnoreCase("A")) {
				help.acquireBuildingsHelp();
				validHelp = true;
			}
		} 
		//If the user wants to go back to main menu
		System.out.println("Type B to back to main menu.");
		boolean done = false;
		
				while(!done) {
					String menuBack = helpScan.nextLine();
					if(menuBack.equalsIgnoreCase("B")) {
						
						System.out.println();
						menu();
						done = true;
					} else {
						System.out.println("Please type B to go back to main menu.");
					}
				}
	}
	
	public static  String getUserName(){
		
		Scanner civNameScan = new Scanner(System.in);
		boolean validName = false;
		
		//opening screen, allows user to enter name
		System.out.println("Welcome to our text based civilization game!!");
		System.out.println("To begin enter your name");
		String civNameInput = civNameScan.nextLine();
		
		//check if name is valid
		while(!validName){
			
			if(civNameInput.equals("")||civNameInput.length()<2||civNameInput.length()>12){
				
				System.out.println("Please enter a valid name");
				civNameInput = civNameScan.nextLine();
			}
			else {
				
				validName = true;
			}
		}
		
		return civNameInput;
	}
}//end class
