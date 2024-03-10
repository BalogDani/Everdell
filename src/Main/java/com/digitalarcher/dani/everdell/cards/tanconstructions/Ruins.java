package com.digitalarcher.dani.everdell.cards.tanconstructions;

import com.digitalarcher.dani.everdell.main.*;

public class Ruins extends TanConstruction{
	
	public boolean isRuinsUsed = false;

	public Ruins() {
		super("Ruins", new Requirements(0, 0, 0, 0), false, 0, "Peddler");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		boolean cardIsRemoved = player.removeCardFromTown("construction", deck);
//		int decksLastIndex = deck.cards.size()-1;
		if(cardIsRemoved) {
			player.addRandomCardFromDeckToHand(deck);
			player.addRandomCardFromDeckToHand(deck);
//			int twig = deck.cards.get(decksLastIndex).requirements.twig;
//			int resin = deck.cards.get(decksLastIndex).requirements.resin;
//			int pebble = deck.cards.get(decksLastIndex).requirements.pebble;
//			System.out.println("Get back: " + twig + ", " + resin + ", " + pebble);
//			player.addRequirementsToTown(twig, resin, pebble, 0);
//			super.playCard(player, deck, players);
			isRuinsUsed = true;
		}
	}
	
}
