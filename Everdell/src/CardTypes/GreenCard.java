package CardTypes;
import Main.Card;
import Main.Requirements;

public class GreenCard extends Card {
	
	public GreenCard() {
		this("Husband", new Requirements(0,0,0,2),false,2,"Farm");
	}
	
	public GreenCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
	public void activateGreenCard(){
		System.out.println("It's activated.");
	}

}
