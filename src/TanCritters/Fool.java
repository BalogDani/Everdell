package TanCritters;

import CardTypes.TanCard;
import Main.*;

public class Fool extends TanCard{

	public Fool() {
		super("Fool", new Requirements(0, 0, 0, 3), true, -2, "Fairgrounds");
	}
	
	public boolean playCard(String anotherPlayersTownName, Town playersTown, Players players, Deck deck) {
		boolean anotherTownIsChoosed = false;
		boolean isFoolInAnotherTown = false;
		for(Town player: players.players) {
			if(player.playersName.equals(anotherPlayersTownName) && !anotherPlayersTownName.equals(playersTown.playersName)) {
				isFoolInAnotherTown = player.isTheCardInArrayList("Fool", player.cards);
				if(!isFoolInAnotherTown) {
					player.cards.add(this);
					player.spaces++;
					anotherTownIsChoosed = true;
					break;					
				}
				else {
					System.out.println("Fool can't be played to " + anotherPlayersTownName + "'s town.");
				}
			}
		}
		if(!anotherTownIsChoosed && !isFoolInAnotherTown) {
			playersTown.playACard(this, players, deck);
		}
		super.playCard(playersTown, deck);
		return anotherTownIsChoosed;
	}
	
	public boolean playFoolToAnotherTown(Card cardToplay, Town town, Players players, Deck deck) {
		boolean foolIsPlayed = false;
		String anotherPlayersTownName = chooseAnotherTownName();
		Fool fool = (Fool) cardToplay;
		foolIsPlayed = fool.playCard(anotherPlayersTownName, town, players, deck);
		return foolIsPlayed;
	}
}
