package GreenCritters;

import CardTypes.GreenCard;
import Main.*;

public class ChipSweep extends GreenCard{

	public ChipSweep() {
		super("Chip Sweep", new Requirements(0, 0, 0, 3), false, 2, "Resin Refinery");
	}
	
	public void playCard(Town town, Deck deck, Players players){
		activateGreenCard(town, deck, players);	
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town, Deck deck, Players players){
		activateChoosenGreenCard(town, town, deck, players);
	}
}
