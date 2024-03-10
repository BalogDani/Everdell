package com.digirtalarcvher.dani.everdell.cards.purpleconstructions;

import com.digirtalarcvher.dani.everdell.main.Card;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class School extends PurpleConstruction{
	
	public School() {
		super("School", new Requirements(2, 2, 0, 0), true, 2, "Teacher");
	}
	
	public void activatePurpleCard(Player player){
		for(Card card: player.cards) {
			if(!card.cityLimit && card.critter) {
				player.addPoints(1);
			}
		}
	}
}
