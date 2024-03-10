package com.digirtalarcvher.dani.everdell.cards.purplecritters;

import com.digirtalarcvher.dani.everdell.cardtypes.PurpleCard;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class Wife extends PurpleCard{
	
	public boolean pairedWithHusband = false;
	
	public Wife() {
		super("Wife", new Requirements(0, 0, 0, 2), false, 2, "Farm");
	}
	
	public void activatePurpleCard(Player player){
		if(pairedWithHusband) {			
			player.addPoints(3);
		}
	}
	
}
