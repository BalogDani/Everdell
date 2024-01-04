
public class Card {
	String name;
	Requirements requirements;
	String type;
	Boolean cityLimit;
	int points;
	
	public Card(){
		this("Farm", new Requirements(2,1,0,0),"GreenCard",false,1);
	}
	
	public Card(String name, Requirements requirements, String type, Boolean cityLimit, int points) {
		this.name = name;
		this.requirements = requirements;
		this.type = type;
		this.cityLimit = cityLimit;
		this.points = points;
	}
	
	public void printCardDetails() {
		String uniqueOrCommon = "Common";
		if (cityLimit) {			
			uniqueOrCommon = "Unique";
		}
		
		System.out.println("Name: " + name + "\nRequirements: Twig = " + requirements.twig + ", Resin = " + requirements.resin + ", Pebble = " + requirements.pebble + ", Berry = " + requirements.berry + "\nType: " + type + "\n" + uniqueOrCommon + "\nPoints: " + points);
	}
}
