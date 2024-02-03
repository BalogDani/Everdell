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
		
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
		
		if(!cardToPlay.critter) {
			usedBlueCardEffect = town.useBlueCardOrNot(this, cardToPlay);
			if(usedBlueCardEffect) {
				if(ammountOfSourceToTake!=0) {
					craneIsUsed = true;
					cardToPlay.printCardDetails();					
					if(ammountOfSourceToTake<=3) {
						town.requirementsToPayForCard.twig -= cardToPlay.requirements.twig;
						town.requirementsToPayForCard.resin -= cardToPlay.requirements.resin;
						town.requirementsToPayForCard.pebble -= cardToPlay.requirements.pebble;
						town.requirementsToPayForCard.berry -= cardToPlay.requirements.berry;
					}
					else {						
						for(int i = 0; i < ammountOfSourceToTake; i++) {
//							System.out.println("i " + i);
							while(!resourceToTake.equals(resourceToCheckForTake)) {
								resourceToTake = readResourceInput("take");
								for(String resourceName: town.requirementsName) {
									resourceToCheckForTake = resourceName;
									if(resourceToTake.equals(resourceName) && town.isRequirementInRequirementsToPayForCard(resourceToTake)) {
										town.modifyRequirementsToPayForCard(resourceToTake, -1);
										break;
									}
									if(!town.isRequirementInRequirementsToPayForCard(resourceToTake)) {
										System.out.println("No " + resourceToTake + " in card requirements, choose a another resource.");
										resourceToCheckForTake = "";
										break;
									}
								}
							}
							resourceToCheckForTake = "";
						}
					}
					town.removeCardFromTown(this, deck);
					System.out.println("Changed requirements to pay: Twig = " + town.requirementsToPayForCard.twig + ", Resin = " + town.requirementsToPayForCard.resin + ", Pebble = " + town.requirementsToPayForCard.pebble + ", Berry = " + town.requirementsToPayForCard.berry);
				}
				else {
					System.out.println("Not enough resource to use Crane.\n");
				}
			}
		}
		return craneIsUsed;
	}
}