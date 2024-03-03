package GreenCritters;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class Husband extends GreenCard{
	
	public boolean pairedWithWife = false;
	
	public Husband() {
		super("Husband", new Requirements(0, 0, 0, 3), false, 2, "Farm");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		if(player.isTheCardInArrayList("Farm", player.cards) && pairedWithWife) {
			String resource = this.readResourceInput("add");
			if(resource.equals("twig") || resource.equals("resin") || resource.equals("pebble") || resource.equals("berry")) {
				player.requirements.addSpecificRequirementsToTown(player, resource,1);
				System.out.println("A " + this.name + " card is played by " + player.playersName + ".");
			}
			else {
				this.activateGreenCard(player);
			}
		}
	}
}
