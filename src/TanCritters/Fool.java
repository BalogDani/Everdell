package TanCritters;

import CardTypes.TanCard;
import Main.*;

public class Fool extends TanCard{

	public Fool() {
		super("Fool", new Requirements(0, 0, 0, 3), true, -2, "Fairgrounds");
	}
	
	public boolean playCard(String anotherPlayersTownName, Player player, Players players, Deck deck) {
		boolean anotherPlayerIsChoosed = false;
		boolean isFoolInAnotherTown = false;
		for(Player playerFromPlayers: players.players) {
			if(playerFromPlayers.playersName.equals(anotherPlayersTownName) && !anotherPlayersTownName.equals(player.playersName)) {
				isFoolInAnotherTown = playerFromPlayers.isTheCardInArrayList("Fool", playerFromPlayers.cards);
				if(!isFoolInAnotherTown) {
					playerFromPlayers.cards.add(this);
					playerFromPlayers.spaces++;
					anotherPlayerIsChoosed = true;
					break;					
				}
				else {
					System.out.println("Fool can't be played to " + anotherPlayersTownName + "'s town.");
				}
			}
		}
		if(!anotherPlayerIsChoosed && !isFoolInAnotherTown) {
			player.playACard(this, players, player, deck);
		}
		if(anotherPlayerIsChoosed) {
			System.out.println("Fool is played by " + player.playersName + ".");
		}
//		super.playCard(player, deck, players);
		return anotherPlayerIsChoosed;
	}
	
	public boolean playFoolToAnotherTown(Card cardToplay, Player player, Players players, Deck deck) {
		boolean foolIsPlayed = false;
		String anotherPlayersTownName = chooseAnotherPlayersName();
		Fool fool = (Fool) cardToplay;
		foolIsPlayed = fool.playCard(anotherPlayersTownName, player, players, deck);
		return foolIsPlayed;
	}
}
