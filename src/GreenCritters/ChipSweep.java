package GreenCritters;

import CardTypes.GreenCard;
import Main.*;

public class ChipSweep extends GreenCard{

	public ChipSweep() {
		super("Chip Sweep", new Requirements(0, 0, 0, 3), false, 2, "Resin Refinery");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player, deck, players);	
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player, Deck deck, Players players){
		activateChoosenGreenCard(player, player, deck, players);
	}
}
