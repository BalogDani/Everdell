package RedCritters;

import CardTypes.RedCard;
import Main.*;

public class Queen extends RedCard{
	
	public boolean workerSent = false;

	public Queen() {
		super("Queen",new Requirements(0,0,0,5),true,4,"Palace");
	}
	
	public void activateRedDestinaton(Card cardToPlay, Town town, Deck deck, Deck meadow, Players players){
		boolean cardIsPlayed = false;
		
		if(!workerSent) {			
			if(cardToPlay.points<=3) {
				if(town.workers>0) {
					cardIsPlayed = town.playACardFree(cardToPlay, players, deck);
					if(cardIsPlayed) {						
						workerSent = true;
						town.workers--;
						if(meadow.isTheCardInDeck(cardToPlay, meadow)) {
							meadow.takeCardAndRefillMeadow(cardToPlay, deck);
						}
					}
				}
				else {
					System.out.println("No more workers left in town. " + name + "'s destination can't be activated.");
				}
			}
			else {
				System.out.println(cardToPlay.name + " is too valuable to be played by the Queen.");
			}
		}
		else {
			System.out.println("Queen was used earlier.");
		}
	}

}
