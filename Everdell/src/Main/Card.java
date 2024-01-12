package Main;

import CardTypes.GreenCard;

public class Card {
	String name;
	Boolean critter = true;
	Requirements requirements;
	Boolean cityLimit;
	int points;
	String relatedCard;
	
	public Card(){
		new GreenCard("Farm", new Requirements(2,1,0,0),false,1,"Husband","Wife");
	}
	
	public Card(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		this.name = name;
		this.requirements = requirements;
		this.cityLimit = cityLimit;
		this.points = points;
		this.relatedCard = relatedCard;
	}
	
//	public Card(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard, String secondRelatedCard) {
//		this.name = name;
//		this.requirements = requirements;
//		this.cityLimit = cityLimit;
//		this.points = points;
//		this.relatedCard = relatedCard;
//		this.secondRelatedCard = secondRelatedCard;
//	}
	
	public void notACritter() {
		this.critter = false;
	}
	
	public void playCard(Town town){
		System.out.println("A " + this.name + "card is played.");
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
