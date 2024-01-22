package GreenCritters;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Peddler extends GreenCard{

	public Peddler() {
		super("Peddler", new Requirements(0, 0, 0, 2), false, 1, "Ruins");
	}
	
	public void playCard(Town town, Deck deck){
		activateGreenCard(town);
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town){
		int ammount = this.readResourceAmmount();
		if(ammount > 2) {
			ammount = 2;
		}
		for(int i = 0; i < ammount; i++) {
			this.changeResources(town);
			System.out.println(i+1 + ". resource to take.");
		}
	}
}
