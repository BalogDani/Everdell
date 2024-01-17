package TanCritters;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

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
					System.out.println("Fool can't play to " + anotherPlayersTownName + "'s town.");
				}
			}
		}
		if(!anotherTownIsChoosed && !isFoolInAnotherTown) {
			playersTown.playACard(this, players, deck);
		}
		super.playCard(playersTown, deck);
		return anotherTownIsChoosed;
	}
	
	public boolean playFoolToOtherTown(Card cardToplay, Town town, Players players, Deck deck) {
		boolean foolIsPlayed = false;
		System.out.println("Select another players town: ");
		BufferedReader readTownName = new BufferedReader(new InputStreamReader(System.in));
		try {
			String anotherPlayersTownName = readTownName.readLine();
			Fool fool = (Fool) cardToplay;
			foolIsPlayed = fool.playCard(anotherPlayersTownName, town, players, deck);
//			readTownName.close();
			return foolIsPlayed;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foolIsPlayed;
	}
}
