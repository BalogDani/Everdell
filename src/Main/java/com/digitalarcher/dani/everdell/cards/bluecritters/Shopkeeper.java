package com.digitalarcher.dani.everdell.cards.bluecritters;

import com.digitalarcher.dani.everdell.cardtypes.BlueCard;
import com.digitalarcher.dani.everdell.main.*;

public class Shopkeeper extends BlueCard{

	public Shopkeeper() {
		super("Shopkeeper",new Requirements(0,0,0,2),true,1,"General Store");
	}
	
	public void blueCardEffect(Card card, Player player){
		if(card.critter && !card.name.equals(this.name)) {
			player.requirements.addSpecificRequirementsToTown(player, "berry", 1);
		}
	}
}
