package Main;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Card {
	public String name;
	public Boolean critter = true;
	public Requirements requirements;
	public Boolean cityLimit;
	int points;
	String relatedCard;
	
	public Card(){
		this("Husband", new Requirements(0,0,0,2),false,2,"Farm");
	}
	
	public Card(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		this.name = name;
		this.requirements = requirements;
		this.cityLimit = cityLimit;
		this.points = points;
		this.relatedCard = relatedCard;
	}
	
	public void notACritter() {
		this.critter = false;
	}
	
	public void playCard(Town town, Deck deck){
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
	}
	
	public void copyCard(Card card) {
		this.name = card.name;
		this.requirements = card.requirements;
		this.cityLimit = card.cityLimit;
		this.points = card.points;
		this.relatedCard = card.relatedCard;
	}
	
	public String readResourceInput(String addOrTake) {
		String resource = "";
		System.out.println("Select a type of resource to " + addOrTake + ": ");
		BufferedReader resourceInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			resource = resourceInput.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resource;
	}
	
	public int readResourceAmmount() {
		int ammount = 0;
//		while(ammount==0) {
			System.out.println("Select the ammount of resource to pay up to 2: ");
			BufferedReader ammountInput = new BufferedReader(new InputStreamReader(System.in));
			try {
				ammount = Integer.parseInt(ammountInput.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
		return ammount;
	}
	
	public String[] changeResources(Town town) {
		String resourceToAdd = "";
		String resourceToCheckToAdd = "";
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
		if(town.requirements.twig!=0 || town.requirements.resin!=0 || town.requirements.pebble!=0 || town.requirements.berry!=0) {
			while(!resourceToTake.equals(resourceToCheckForTake)) {
				resourceToTake = this.readResourceInput("take");
				for(String resourceName: town.requirementsName) {
					resourceToCheckForTake = resourceName;
					if(resourceToTake.equals(resourceName) && town.isRequirementInTown(resourceToTake)) {
						town.addSpecificRequirementsToTown(resourceToTake,-1);
						while(!resourceToCheckToAdd.equals("added")) {
							resourceToAdd = this.readResourceInput("add");
							for(String resource: town.requirementsName) {
								resourceToCheckToAdd = resource;
								if(resourceToAdd.equals(resource)){
									System.out.println(resourceToTake + " taken, " + resourceToAdd + " added.");
									resourceToCheckToAdd = "added";
									town.addSpecificRequirementsToTown(resourceToAdd,1);
									town.printRequirementsInTown();
									break;
								}
							}
						}
						break;
					}
					if(!town.isRequirementInTown(resourceToTake)) {
						System.out.println("No " + resourceToTake + " in town, choose a valid resource.");
						resourceToCheckForTake = "";
						break;
					}
				}
			}
		}
		else {
			System.out.println("No " + resourceToTake + " in town, choose a valid resource.");
			this.changeResources(town);
		}
		String[] toTakeAndToAdd = {resourceToTake, resourceToAdd}; 
		return toTakeAndToAdd;
	}
	
	public ArrayList<String> availableResources(Card cardToPlay) {
		int twigOnCard = cardToPlay.requirements.twig;
		int resinOnCard = cardToPlay.requirements.resin;
		int pebbleOnCard = cardToPlay.requirements.pebble;
		int berryOnCard = cardToPlay.requirements.berry;
		ArrayList<String> requirementsName = new ArrayList<String>();
		if(twigOnCard>0) {			
			requirementsName.add("twig");
		}	
		if(resinOnCard>0) {
			requirementsName.add("resin");
		}
		if(pebbleOnCard>0) {
			requirementsName.add("pebble");
		}
		if(berryOnCard>0) {
			requirementsName.add("berry");
		}
		return requirementsName;
	}
	
	public Requirements addSpecificRequirementsToCard(Requirements requirements, String resourceName, int quantity) {
		if(resourceName.equals("twig")) {
			requirements.twig += quantity;
			if(requirements.twig<0) {
				requirements.twig=0;
			}
		}
		if(resourceName.equals("resin")){			
			requirements.resin += quantity;
			if(requirements.resin<0) {
				requirements.resin=0;
			}
		}
		if(resourceName.equals("pebble")) {
			requirements.pebble += quantity;
			if(requirements.pebble<0) {
				requirements.pebble=0;
			}
		}
		if(resourceName.equals("berry")) {
			requirements.berry += quantity;
			if(requirements.berry<0) {
				requirements.berry=0;
			}
		}
		return requirements;
	}
	
	public Requirements changeRequirements(Card cardToPlay, Town town) {
		String resourceToAdd = "";
		String resourceToCheckToAdd = "";
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
		Requirements newRequirements = cardToPlay.requirements;
		ArrayList<String> requirementsOnCard = availableResources(cardToPlay);
		if(cardToPlay.requirements.twig!=0 || cardToPlay.requirements.resin!=0 || cardToPlay.requirements.pebble!=0 || cardToPlay.requirements.berry!=0) {
			while(!resourceToTake.equals(resourceToCheckForTake)) {
				resourceToTake = this.readResourceInput("take");
				for(String resourceName: requirementsOnCard) {
					resourceToCheckForTake = resourceName;
					if(resourceToTake.equals(resourceName)) {
						addSpecificRequirementsToCard(newRequirements,resourceToTake,-1);
						while(!resourceToCheckToAdd.equals("added")) {
							resourceToAdd = this.readResourceInput("add");
							for(String resource: town.requirementsName) {
								resourceToCheckToAdd = resource;
								if(resourceToAdd.equals(resource)){
//									System.out.println(resourceToTake + " taken, " + resourceToAdd + " added.");
									resourceToCheckToAdd = "added";
									addSpecificRequirementsToCard(newRequirements,resourceToAdd,1);
									break;
								}
							}
						}
						break;
					}
					if(!town.isRequirementInTown(resourceToTake)) {
						System.out.println("No " + resourceToTake + " on card, choose a valid resource.");
						resourceToCheckForTake = "";
						break;
					}
					if(!resourceToTake.equals(resourceName)) {
						resourceToCheckForTake = "";
					}
				}
			}
		}
		else {
			System.out.println("Changing of resources was unsuccessful.");
//			System.out.println("No " + resourceToTake + " on card, choose a valid resource.");
//			this.changeRequirements(cardToPlay, town);
		}
		return newRequirements;
	}
	
	public void printCardDetails() {
		String uniqueOrCommon = "Common";
		String cardType = "Critter";
		
		if(cityLimit) {			
			uniqueOrCommon = "Unique";
		}
		if(!critter) {
			cardType = "Construction"; 
		}
		
		System.out.println("Name: " + name + "\nCard type: " + cardType + "\nRequirements: Twig = " + requirements.twig + ", Resin = " + requirements.resin + ", Pebble = " + requirements.pebble + ", Berry = " + requirements.berry + "\n" + uniqueOrCommon + "\nPoints: " + points);
	}
}
