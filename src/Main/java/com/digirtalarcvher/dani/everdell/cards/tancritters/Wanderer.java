package com.digirtalarcvher.dani.everdell.cards.tancritters;

import com.digirtalarcvher.dani.everdell.cardtypes.TanCard;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class Wanderer extends TanCard{

	public Wanderer() {
		super("Wanderer",new Requirements(0,0,0,2),false,1,"Lookout");
	}
	
	public void playCard(Player player, Deck deck){
		for (int i = 0; i < 3; i++) {
			player.addRandomCardFromDeckToHand(deck);
		}
	}
	
}
