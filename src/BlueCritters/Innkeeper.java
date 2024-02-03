package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Innkeeper extends BlueCard{
	
	public Innkeeper() {
		super("Inkeeper",new Requirements(0,0,0,1),true,1,"Inn");
	}
	
	public boolean blueCardEffect(Card cardToPlay, Town town, Deck deck){
		boolean usedBlueCardEffect = false;
		boolean inkeeperIsUsed = false;
		
		if(cardToPlay.critter) {
			usedBlueCardEffect = town.useBlueCardOrNot(this, cardToPlay);
			if(usedBlueCardEffect) {
				inkeeperIsUsed = true;
				cardToPlay.printCardDetails();
				town.modifyRequirementsToPayForCard("berry", -3);
				town.removeCardFromTown(this, deck);
				System.out.println("Changed requirements to pay: Twig = " + town.requirementsToPayForCard.twig + ", Resin = " + town.requirementsToPayForCard.resin + ", Pebble = " + town.requirementsToPayForCard.pebble + ", Berry = " + town.requirementsToPayForCard.berry);
			}
		}
		
		return inkeeperIsUsed;
	}
	
}
