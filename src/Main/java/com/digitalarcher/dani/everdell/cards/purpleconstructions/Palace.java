package com.digitalarcher.dani.everdell.cards.purpleconstructions;

import com.digitalarcher.dani.everdell.main.Card;
import com.digitalarcher.dani.everdell.main.Player;
import com.digitalarcher.dani.everdell.main.Requirements;

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
