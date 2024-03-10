package com.digitalarcher.dani.everdell.cards.bluecritters;

import com.digitalarcher.dani.everdell.cardtypes.BlueCard;
import com.digitalarcher.dani.everdell.main.*;

public class Innkeeper extends BlueCard{
	
	public Innkeeper() {
		super("Innkeeper",new Requirements(0,0,0,1),true,1,"Inn");
	}
	
	public boolean blueCardEffect(Requirements requirementsToPayForCard, Card cardToPlay, Player player, Deck deck){
		boolean usedBlueCardEffect = false;
		boolean inkeeperIsUsed = false;
		
		if(cardToPlay.critter) {
			usedBlueCardEffect = useBlueCardOrNot(this, cardToPlay);
			if(usedBlueCardEffect) {
				inkeeperIsUsed = true;
				cardToPlay.printCardDetails();
				requirementsToPayForCard.modifyRequirementsToPayForCard("berry", requirementsToPayForCard, -3);
				player.removeCardFromTown(this, deck);
				System.out.println("Changed requirements to pay: Twig = " + requirementsToPayForCard.twig + ", Resin = " + requirementsToPayForCard.resin + ", Pebble = " + requirementsToPayForCard.pebble + ", Berry = " + requirementsToPayForCard.berry);
			}
		}
		
		return inkeeperIsUsed;
	}
	
}
