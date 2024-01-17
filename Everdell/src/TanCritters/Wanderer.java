package TanCritters;

import CardTypes.TanCard;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Wanderer extends TanCard{

	public Wanderer() {
		super("Wanderer",new Requirements(0,0,0,2),false,1,"Lookout");
	}
	
	public void playCard(Town town, Deck deck){
		for (int i = 0; i < 3; i++) {
			town.addRandomCardFromDeckToHand(deck);
		}
		super.playCard(town, deck);
	}
	
}
