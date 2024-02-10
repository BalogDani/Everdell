package RedConstructions;

import Main.*;

public class Inn extends RedConstruction{

	public boolean occupied = false;
	public boolean workerSent = false;
	
	public Inn() {
		super("Inn", new Requirements(2,1,0,0),false,2,"Inkeeper");
		super.open = true;
	}
	
	public void occupie(String name) {
		this.occupied = true;
		System.out.println(super.name + " is occupied by " + name + ".");
	}
	
	public void activateRedDestination(Town town, Deck deck, Deck meadow, Players players) {
		if(!workerSent) {			
			if(town.workers>0) {
				Card cardToPlay = meadow.chooseACardFromMeadow(meadow);
				town.workers--;
				
				int sumOfRequirementsOnCard = cardToPlay.requirements.twig + cardToPlay.requirements.resin + cardToPlay.requirements.pebble + cardToPlay.requirements.berry;
				int ammountOfSourceToTake = 3;
				if(sumOfRequirementsOnCard<3) {
					ammountOfSourceToTake=sumOfRequirementsOnCard;
				}
				
				if(ammountOfSourceToTake!=0) {
					boolean ownerCheck = ownerOrAnotherPlayer(this, open, town, players);
					if(ownerCheck) {						
						cardToPlay.printCardDetails();
						if(sumOfRequirementsOnCard<=3) {
							town.playACardFree(cardToPlay, players, deck);
						}
						else {
							System.out.println("You choosed " + cardToPlay.name);
							decreaseRequirementsOnCard(ammountOfSourceToTake, cardToPlay, town);
							town.playACard(cardToPlay, players, deck);
						}
						meadow.takeCardAndRefillMeadow(cardToPlay,deck);
						workerSent = true;
					}
				}
				else {
					System.out.println("Not enough resource to use Inn. You can play this card without using a worker.\n");
				}
			}
			else {
				System.out.println("No more workers left in town. " + name + "'s destination can't be activated.");
			}
		}
		else {
			System.out.println("Inn was used earlier.");
		}
	}
}
