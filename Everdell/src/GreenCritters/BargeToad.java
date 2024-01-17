package GreenCritters;

import CardTypes.GreenCard;
import GreenConstructions.Farm;
import Main.Card;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class BargeToad extends GreenCard{

	public BargeToad() {
		super("Barge Toad", new Requirements(0, 0, 0, 2), false, 1, "Twig Barge");
	}
	
	public void playCard(Town town, Deck deck){
		for(Card card: town.cards) {
			if(card instanceof Farm) {
				town.addSpecificRequirementsToTown("twig", 2);
			}
		}
		super.playCard(town, deck);	
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}
