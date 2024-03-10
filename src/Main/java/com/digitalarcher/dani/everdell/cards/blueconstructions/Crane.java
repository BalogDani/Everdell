package com.digitalarcher.dani.everdell.cards.blueconstructions;

import com.digitalarcher.dani.everdell.main.*;

public class Crane extends BlueConstruction{

	public Crane() {
		super("Crane",new Requirements(0,0,1,0),true,1,"Architect");
	}
	
	public boolean blueCardEffect(Requirements requirementsToPayForCard, Card cardToPlay, Player player, Deck deck){
		boolean usedBlueCardEffect = false;
		boolean craneIsUsed = false;
		
		int sumOfRequirementsOnCard = cardToPlay.requirements.twig + cardToPlay.requirements.resin + cardToPlay.requirements.pebble + cardToPlay.requirements.berry;
		int ammountOfSourceToTake = 3;
		if(sumOfRequirementsOnCard<3) {
			ammountOfSourceToTake=sumOfRequirementsOnCard;
		}
		
		if(!cardToPlay.critter) {
			usedBlueCardEffect = useBlueCardOrNot(this, cardToPlay);
			if(usedBlueCardEffect) {
				if(ammountOfSourceToTake!=0) {
					craneIsUsed = true;
					cardToPlay.printCardDetails();					
					if(sumOfRequirementsOnCard<=3) {
						requirementsToPayForCard.twig -= cardToPlay.requirements.twig;
						requirementsToPayForCard.resin -= cardToPlay.requirements.resin;
						requirementsToPayForCard.pebble -= cardToPlay.requirements.pebble;
						requirementsToPayForCard.berry -= cardToPlay.requirements.berry;
					}
					else {						
						requirementsToPayForCard.decreaseRequirementsOnCard(requirementsToPayForCard, ammountOfSourceToTake, cardToPlay, player);
					}
					System.out.println("Changed requirements to pay: Twig = " + requirementsToPayForCard.twig + ", Resin = " + requirementsToPayForCard.resin + ", Pebble = " + requirementsToPayForCard.pebble + ", Berry = " + requirementsToPayForCard.berry);
					player.removeCardFromTown(this, deck);
				}
				else {
					System.out.println("Not enough resource to use Crane.\n");
				}
			}
		}
		return craneIsUsed;
	}
}