package com.digirtalarcvher.dani.everdell.cards.greenconstructions;

import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class TwigBarge extends GreenConstruction{

	public boolean occupied = false;
	
	public TwigBarge() {
		super("Twig Barge", new Requirements(1,0,1,0),false,1,"Barge Toad");
		notACritter();
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);	
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addSpecificRequirementsToTown(player, "twig", 1);
	}
}
