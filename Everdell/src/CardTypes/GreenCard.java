package CardTypes;
import Main.Card;
import Main.Requirements;

public class GreenCard extends Card {
	
	String secondRelatedCard;
	
	public GreenCard() {
		this("Farm", new Requirements(2,1,0,0),false,1,"Husband","Wife");
	}
	
	public GreenCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
	public GreenCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard, String secondRelatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
		this.secondRelatedCard = secondRelatedCard;
	}
	
	public void activateGreenCard(){
		System.out.println("It's activated.");
	}

}
