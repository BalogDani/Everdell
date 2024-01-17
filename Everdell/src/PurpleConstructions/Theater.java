package PurpleConstructions;

import Main.Card;
import Main.Requirements;
import Main.Town;

public class Theater extends PurpleConstruction{
	
	public Theater() {
		super("Theater", new Requirements(3, 1, 1, 0), true, 3, "Bard");
	}
	
	public void activatePurpleCard(Town town){
		for(Card card: town.cards) {
			if(card.cityLimit && card.critter) {
				town.addPoints(1);
			}
		}
	}
}
