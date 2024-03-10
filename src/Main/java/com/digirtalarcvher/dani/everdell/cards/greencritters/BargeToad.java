package com.digirtalarcvher.dani.everdell.cards.greencritters;

import com.digirtalarcvher.dani.everdell.cards.greenconstructions.Farm;
import com.digirtalarcvher.dani.everdell.cardtypes.GreenCard;
import com.digirtalarcvher.dani.everdell.main.Card;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class BargeToad extends GreenCard{

	public BargeToad() {
		super("Barge Toad", new Requirements(0, 0, 0, 2), false, 1, "Twig Barge");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);	
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		for(Card card: player.cards) {
			if(card instanceof Farm) {
				player.requirements.addSpecificRequirementsToTown(player, "twig", 2);
			}
		}
	}
}
