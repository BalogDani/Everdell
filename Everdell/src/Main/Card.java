package Main;

public class Card {
	public String name;
	Boolean critter = true;
	Requirements requirements;
	Boolean cityLimit;
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
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
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
