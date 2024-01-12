package CardTypes;
import Main.Card;
import Main.Requirements;

public class PurpleCard extends Card {
	
	public PurpleCard() {
		super("King", new Requirements(0,0,0,6),true,4,"Castle");
	}
	
	public void activatePurpleCard() {
		System.out.println("It's activated.");
	}

}