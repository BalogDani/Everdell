package CardTypes;
import Main.*;

public class RedCard extends Card {
	
	public RedCard() {
		super("Inn", new Requirements(2,1,0,0),false,2,"Inkeeper");
	}
	
	public RedCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
	public void ownerOrAnotherPlayer(Card redCard, Town town, Players players) {
		boolean isTheCardInTown = town.isTheCardInTown(redCard, town);
		if(!isTheCardInTown) {
			for (Town player : players.players) {
				if(player.isTheCardInTown(redCard, player)) {
					player.specialPoints++;
					System.out.println(player.playersName + "'s special points: " + player.specialPoints + "\n");
				}
			}
		}
	}
	
//	public void usingRedDestination(boolean workerSent, Card redCard, Town palyerUsingRedDestination, Deck deck, Deck meadow, Players players) {
//		if(!workerSent) {
//			ownerOrAnotherPlayer(redCard, palyerUsingRedDestination, players);
//			
//			if(palyerUsingRedDestination.workers>0) {
//				Card cardToPlay = chooseACardFromMeadow(meadow);
//				palyerUsingRedDestination.workers--;
//				
//				int sumOfRequirementsOnCard = cardToPlay.requirements.twig + cardToPlay.requirements.resin + cardToPlay.requirements.pebble + cardToPlay.requirements.berry;
//				int ammountOfSourceToTake = 3;
//				if(sumOfRequirementsOnCard<3) {
//					ammountOfSourceToTake=sumOfRequirementsOnCard;
//				}
//				
//				if(ammountOfSourceToTake!=0) {
//					cardToPlay.printCardDetails();
//					if(sumOfRequirementsOnCard<=3) {
//						town.playACardFree(cardToPlay, players, deck);
//					}
//					else {
//						System.out.println("You choosed " + cardToPlay.name);
//						decreaseRequirementsOnCard(ammountOfSourceToTake, cardToPlay, town);
//						town.playACard(cardToPlay, players, deck);
//					}
//					meadow.takeCardAndRefillMeadow(cardToPlay,deck);
//					workerSent = true;
//				}
//				else {
//					System.out.println("Not enough resource to use Inn. You can play this card without using a worker.\n");
//				}
//			}
//			else {
//				System.out.println("No more workers left in town. " + name + "'s destination can't be activated.");
//			}
//		}
//		else {
//			System.out.println("Inn was used earlier.");
//		}
//	}
	
	public void activateRedCard() {
		System.out.println("It's activated.");
	}

}