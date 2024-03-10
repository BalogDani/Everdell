package com.digirtalarcvher.dani.everdell.cards.greenconstructions;

import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class GeneralStore extends GreenConstruction{

	public GeneralStore() {
		super("General Store", new Requirements(0, 1, 1, 0), false, 1, "Shopkeeper");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addSpecificRequirementsToTown(player, "berry", 1);
		boolean isFarmInTown = player.isTheCardInArrayList("Farm", player.cards);
		if (isFarmInTown) {
			player.requirements.addSpecificRequirementsToTown(player, "berry", 1);
		}
	}
}
