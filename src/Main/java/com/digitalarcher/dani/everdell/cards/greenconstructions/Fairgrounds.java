package com.digitalarcher.dani.everdell.cards.greenconstructions;

import com.digitalarcher.dani.everdell.main.*;

public class Fairgrounds extends GreenConstruction{
	
	public Fairgrounds() {
		super("Fairgrounds",new Requirements(1,2,1,0),true,3,"Fool");
		notACritter();
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player, deck);	
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player, Deck deck){
		for (int i = 0; i < 2; i++) {
			player.addRandomCardFromDeckToHand(deck);
		}
	}
}
