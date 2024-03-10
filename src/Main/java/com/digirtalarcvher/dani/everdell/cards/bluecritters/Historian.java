package com.digirtalarcvher.dani.everdell.cards.bluecritters;

import com.digirtalarcvher.dani.everdell.cardtypes.BlueCard;
import com.digirtalarcvher.dani.everdell.main.*;

public class Historian extends BlueCard{
	
	public Historian() {
		super("Historian",new Requirements(0,0,0,2),true,1,"Clock Tower");
	}
	
	public void blueCardEffect(Card cardToPlay, Player player, Deck deck){
		if(!cardToPlay.name.equals(this.name)) {
			player.addRandomCardFromDeckToHand(deck);
		}
	}

}
