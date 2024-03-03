package PurpleConstructions;

import Main.Card;
import Main.Requirements;
import Main.Player;

public class Theater extends PurpleConstruction{
	
	public Theater() {
		super("Theater", new Requirements(3, 1, 1, 0), true, 3, "Bard");
	}
	
	public void activatePurpleCard(Player player){
		for(Card card: player.cards) {
			if(card.cityLimit && card.critter) {
				player.addPoints(1);
			}
		}
	}
}
