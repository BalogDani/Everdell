package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Shopkeeper extends BlueCard{

	public Shopkeeper() {
		super("Shopkeeper",new Requirements(0,0,0,2),true,1,"General Store");
	}
	
	public void blueCardEffect(Card card, Town town){
		if(card.critter && !card.name.equals(this.name)) {
			town.addSpecificRequirementsToTown("berry", 1);
		}
	}
}
