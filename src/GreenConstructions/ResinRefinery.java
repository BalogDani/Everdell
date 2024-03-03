package GreenConstructions;

import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class ResinRefinery extends GreenConstruction {
	
	public ResinRefinery() {
		super("Resin Refinery", new Requirements(0,1,1,0),false,1,"Chip Sweep");
		notACritter();
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);	
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addSpecificRequirementsToTown(player, "resin", 1);
	}
}
