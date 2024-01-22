package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Historian extends BlueCard{
	
	public Historian() {
		super("Historian",new Requirements(0,0,0,2),true,1,"Clock Tower");
	}
	
	public void blueCardEffect(Card card, Town town, Deck deck){
		if(!card.name.equals(this.name)) {
			town.addRandomCardFromDeckToHand(deck);
		}
	}

}
