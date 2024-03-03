package CardTypes;
import Main.Card;
import Main.Requirements;
import Main.Player;

public abstract class PurpleCard extends Card {
	
	public PurpleCard() {
		super("King", new Requirements(0,0,0,6),true,4,"Castle");
	}
	
	public PurpleCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
	public abstract void activatePurpleCard(Player player);

}