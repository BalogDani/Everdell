package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Innkeeper extends BlueCard{
	
	public Innkeeper() {
		super("Inkeeper",new Requirements(0,0,0,1),true,1,"Inn");
	}
	
	public void blueCardEffect(Card cardToPlay, Town town, Deck deck){
		boolean usedBlueCardEffect = false;
		
		if(cardToPlay.critter) {
			usedBlueCardEffect = town.useBlueCardOrNot(this);
			if(usedBlueCardEffect) {
				cardToPlay.printCardDetails();
				addSpecificRequirementsToCard(cardToPlay.requirements, "berry", -3);
				town.removeCardFromTown(this, deck);
				cardToPlay.printCardDetails();
			}
		}
	}
	
}
