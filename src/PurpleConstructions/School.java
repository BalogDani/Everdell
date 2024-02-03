package PurpleConstructions;

import Main.Card;
import Main.Requirements;
import Main.Town;

public class School extends PurpleConstruction{
	
	public School() {
		super("School", new Requirements(2, 2, 0, 0), true, 2, "Teacher");
	}
	
	public void activatePurpleCard(Town town){
		for(Card card: town.cards) {
			if(!card.cityLimit && card.critter) {
				town.addPoints(1);
			}
		}
	}
}
