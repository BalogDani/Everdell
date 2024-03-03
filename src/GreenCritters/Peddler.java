package GreenCritters;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class Peddler extends GreenCard{

	public Peddler() {
		super("Peddler", new Requirements(0, 0, 0, 2), false, 1, "Ruins");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		int ammount = this.readResourceAmmount();
		if(ammount > 2) {
			ammount = 2;
		}
		
		int sumOfRequirementsInTown = player.requirements.twig + player.requirements.resin + player.requirements.pebble + player.requirements.berry;
		if(sumOfRequirementsInTown!=0) {
			for(int i = 0; i < ammount; i++) {
				this.changeResources(player);
				System.out.println(i+1 + ". resource exchanged.\n");
			}			
		}
		else {
			System.out.println("Not enough resources in town to change them.");
		}
	}
}
