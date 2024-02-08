package BlueConstructions;

import Main.*;

public class Crane extends BlueConstruction{

	public Crane() {
		super("Crane",new Requirements(0,0,1,0),true,1,"Architect");
	}
	
	public boolean blueCardEffect(Card cardToPlay, Town town, Deck deck){
		boolean usedBlueCardEffect = false;
		boolean craneIsUsed = false;
		
		int sumOfRequirementsOnCard = cardToPlay.requirements.twig + cardToPlay.requirements.resin + cardToPlay.requirements.pebble + cardToPlay.requirements.berry;
		int ammountOfSourceToTake = 3;
		if(sumOfRequirementsOnCard<3) {
			ammountOfSourceToTake=sumOfRequirementsOnCard;
		}
		
		if(!cardToPlay.critter) {
			usedBlueCardEffect = town.useBlueCardOrNot(this, cardToPlay);
			if(usedBlueCardEffect) {
				if(ammountOfSourceToTake!=0) {
					craneIsUsed = true;
					cardToPlay.printCardDetails();					
					if(sumOfRequirementsOnCard<=3) {
						town.requirementsToPayForCard.twig -= cardToPlay.requirements.twig;
						town.requirementsToPayForCard.resin -= cardToPlay.requirements.resin;
						town.requirementsToPayForCard.pebble -= cardToPlay.requirements.pebble;
						town.requirementsToPayForCard.berry -= cardToPlay.requirements.berry;
					}
					else {						
						decreaseRequirementsOnCard(ammountOfSourceToTake, cardToPlay, town);
					}
					System.out.println("Changed requirements to pay: Twig = " + town.requirementsToPayForCard.twig + ", Resin = " + town.requirementsToPayForCard.resin + ", Pebble = " + town.requirementsToPayForCard.pebble + ", Berry = " + town.requirementsToPayForCard.berry);
					town.removeCardFromTown(this, deck);
				}
				else {
					System.out.println("Not enough resource to use Crane.\n");
				}
			}
		}
		return craneIsUsed;
	}
}