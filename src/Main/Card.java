package Main;

public class Card implements InputOutput{
	public String name;
	public Boolean critter = true;
	public Requirements requirements;
	public Boolean cityLimit;
	public int points;
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
	
	public void playCard(Player player, Deck deck){
		System.out.println(this.name + " is played by " + player.playersName + ".");
	}
	
	public void playCard(Player player, Deck deck, Players players){
//		System.out.println("Overloaded method.");
	}
	
	public void copyCard(Card card) {
		this.name = card.name;
		this.requirements = card.requirements;
		this.cityLimit = card.cityLimit;
		this.points = card.points;
		this.relatedCard = card.relatedCard;
	}
	
	public String[] changeResources(Player player) {
		String resourceToAdd = "";
		String resourceToCheckToAdd = "";
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
		if(player.requirements.twig!=0 || player.requirements.resin!=0 || player.requirements.pebble!=0 || player.requirements.berry!=0) {
			while(!resourceToTake.equals(resourceToCheckForTake)) {
				resourceToTake = this.readResourceInput("take");
				for(String resourceName: player.requirementsName) {
					resourceToCheckForTake = resourceName;
					if(resourceToTake.equals(resourceName) && player.requirements.isRequirementAtPlayer(player, resourceToTake)) {
						player.requirements.addSpecificRequirementsToTown(player, resourceToTake, -1);
						while(!resourceToCheckToAdd.equals("added")) {
							resourceToAdd = this.readResourceInput("add");
							for(String resource: player.requirementsName) {
								resourceToCheckToAdd = resource;
								if(resourceToAdd.equals(resource)){
									System.out.println(resourceToTake + " taken, " + resourceToAdd + " added.");
									resourceToCheckToAdd = "added";
									player.requirements.addSpecificRequirementsToTown(player, resourceToAdd,1);
									player.printRequirementsInTown();
									break;
								}
							}
						}
						break;
					}
					if(!player.requirements.isRequirementAtPlayer(player, resourceToTake)) {
						System.out.println("No " + resourceToTake + " in town, choose a valid resource.");
						resourceToCheckForTake = "";
						break;
					}
				}
			}
		}
		else {
			System.out.println("No " + resourceToTake + " in town, choose a valid resource.");
			this.changeResources(player);
		}
		String[] toTakeAndToAdd = {resourceToTake, resourceToAdd}; 
		return toTakeAndToAdd;
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
