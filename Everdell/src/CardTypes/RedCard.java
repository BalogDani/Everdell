package CardTypes;
import Main.Card;
import Main.Requirements;

public class RedCard extends Card {
	
	public RedCard() {
		super("Inn", new Requirements(2,1,0,0),false,2,"Inkeeper");
	}
	
	public void activateRedCard() {
		System.out.println("It's activated.");
	}

}