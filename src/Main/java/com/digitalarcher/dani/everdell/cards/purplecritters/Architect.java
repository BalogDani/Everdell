package com.digitalarcher.dani.everdell.cards.purplecritters;

import com.digitalarcher.dani.everdell.cardtypes.PurpleCard;
import com.digitalarcher.dani.everdell.main.Player;
import com.digitalarcher.dani.everdell.main.Requirements;

public class Architect extends PurpleCard{
	
	public Architect() {
		super("Architect", new Requirements(0, 0, 0, 4), true, 2, "Crane");
	}
	
	public void activatePurpleCard(Player player){
		int points = player.requirements.resin + player.requirements.pebble;
		if(points>6) {
			points = 6;
		}
		player.addPoints(points);
	}
}
