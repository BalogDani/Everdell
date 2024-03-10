package com.digitalarcher.dani.everdell.cards.greenconstructions;

import com.digitalarcher.dani.everdell.main.Deck;
import com.digitalarcher.dani.everdell.main.Player;
import com.digitalarcher.dani.everdell.main.Players;
import com.digitalarcher.dani.everdell.main.Requirements;

public class Farm extends GreenConstruction{
	
	public String secondRelatedCard;
	public boolean husbandOccupier = false;
	public boolean wifeOccupier = false;
	
	public Farm() {
		super("Farm",new Requirements(2,1,0,0),false,1,"Husband");
		this.secondRelatedCard = "Wife";
	}
	
	public void occupieHusband() {
		husbandOccupier = true;
	}
	
	public void occupieWife() {
		wifeOccupier = true;
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		player.requirements.addRequirementsToTown(player, 0, 0, 0, 1);
	}
}