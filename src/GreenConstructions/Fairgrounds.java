package GreenConstructions;

import Main.*;

public class Fairgrounds extends GreenConstruction{
	
	public Fairgrounds() {
		super("Fairgrounds",new Requirements(1,2,1,0),true,3,"Fool");
		notACritter();
	}
	
	public void playCard(Town town, Deck deck){
		activateGreenCard(town, deck);	
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town, Deck deck){
		for (int i = 0; i < 2; i++) {
			town.addRandomCardFromDeckToHand(deck);
		}
	}
}
