package GreenCritters;

import CardTypes.GreenCard;
import GreenConstructions.Farm;
import Main.Card;
import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class BargeToad extends GreenCard{

	public BargeToad() {
		super("Barge Toad", new Requirements(0, 0, 0, 2), false, 1, "Twig Barge");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);	
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		for(Card card: player.cards) {
			if(card instanceof Farm) {
				player.requirements.addSpecificRequirementsToTown(player, "twig", 2);
			}
		}
	}
}
