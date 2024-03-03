package PurpleConstructions;

import Main.Card;
import Main.Requirements;
import Main.Player;

public class Palace extends PurpleConstruction{
	
	public Palace() {
		super("Palace", new Requirements(2, 3, 3, 0), true, 4, "King");
	}
	
	public void activatePurpleCard(Player player){
		for(Card card: player.cards) {
			if(card.cityLimit && !card.critter) {
				player.addPoints(1);
			}
		}
	}
}
