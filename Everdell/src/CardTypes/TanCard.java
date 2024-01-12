package CardTypes;
import Main.Card;
import Main.Requirements;

public class TanCard extends Card {
	
	public TanCard() {
		super("Ranger", new Requirements(0,0,0,2),true,1,"Dungeon");
	}
	
	public void activateTanCard() {
		System.out.println("It's activated.");
	}

}
