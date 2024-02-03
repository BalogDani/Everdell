package CardTypes;
import Main.Card;
import Main.Requirements;

public class TanCard extends Card {
	
	public TanCard() {
		super("Ranger", new Requirements(0,0,0,2),true,1,"Dungeon");
	}
	
	public TanCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}

}
