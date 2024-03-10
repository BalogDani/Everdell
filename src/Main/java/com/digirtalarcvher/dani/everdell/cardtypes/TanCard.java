package com.digirtalarcvher.dani.everdell.cardtypes;
import com.digirtalarcvher.dani.everdell.main.Card;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class TanCard extends Card {
	
	public TanCard() {
		super("Ranger", new Requirements(0,0,0,2),true,1,"Dungeon");
	}
	
	public TanCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}

	public void playCard(Player player, Deck deck, Players players){
		System.out.println(this.name + " is played by " + player.playersName + ".");
	}
}
