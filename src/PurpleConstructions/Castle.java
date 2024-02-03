package PurpleConstructions;

import Main.Card;
import Main.Requirements;
import Main.Town;

public class Castle extends PurpleConstruction{
	
	public Castle() {
		super("Castle", new Requirements(2, 3, 3, 0), true, 4, "King");
	}
	
	public void activatePurpleCard(Town town){
		for(Card card: town.cards) {
			if(!card.cityLimit && !card.critter) {
				town.addPoints(1);
			}
		}
	}
}
