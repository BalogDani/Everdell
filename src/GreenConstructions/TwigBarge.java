package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class TwigBarge extends GreenConstruction{

	public boolean occupied = false;
	
	public TwigBarge() {
		super("Twig Barge", new Requirements(1,0,1,0),false,1,"Barge Toad");
		notACritter();
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);	
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addSpecificRequirementsToTown(player, "twig", 1);
	}
}
