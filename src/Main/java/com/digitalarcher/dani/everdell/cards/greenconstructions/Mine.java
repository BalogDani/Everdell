package com.digitalarcher.dani.everdell.cards.greenconstructions;

import com.digitalarcher.dani.everdell.main.Deck;
import com.digitalarcher.dani.everdell.main.Player;
import com.digitalarcher.dani.everdell.main.Players;
import com.digitalarcher.dani.everdell.main.Requirements;

public class Mine extends GreenConstruction{
	
	public Mine() {
		super("Mine", new Requirements(1,1,1,0),false,2,"Miner Mole");
		notACritter();
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addSpecificRequirementsToTown(player, "pebble", 1);
	}
}
