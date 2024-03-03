package GreenCritters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CardTypes.GreenCard;
import Main.*;

public class Teacher extends GreenCard{
	
	public Teacher() {
		super("Teacher", new Requirements(0, 0, 0, 2), false, 2, "School");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player, deck, players);
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player, Deck deck, Players players) {
		boolean choosed = false;
		boolean addedToPlayersHand = false;
		boolean addedToAnotherPlayersHand = false;
		Card firstRandomCardFromDeck = deck.chooseRandomCard();
		Card secondRandomCardFromDeck = deck.chooseRandomCard();
		System.out.println("Select a card, " + firstRandomCardFromDeck.name + " or " + secondRandomCardFromDeck.name + ":");
		BufferedReader randomCardName = new BufferedReader(new InputStreamReader(System.in));
		try {
			String choosenCard = randomCardName.readLine();
			while(!choosenCard.equals(firstRandomCardFromDeck.name) && !choosenCard.equals(secondRandomCardFromDeck.name)) {
				System.out.println("These are the only cards to select, " + firstRandomCardFromDeck.name + " or " + secondRandomCardFromDeck.name + ":");
				choosenCard = randomCardName.readLine();
			}
			String anotherPlayersTownName = chooseAnotherPlayersTown();
			for(Player playerFromPlayers: players.players) {
				if(playerFromPlayers.playersName.equals(anotherPlayersTownName) && !anotherPlayersTownName.equals(player.playersName)) {
					if(choosenCard.equals(firstRandomCardFromDeck.name)) {
						addedToPlayersHand = player.addSpecificCardToHand(firstRandomCardFromDeck);
						if(addedToPlayersHand) {
							deck.takeFromDeck(firstRandomCardFromDeck);
						}
						addedToAnotherPlayersHand = playerFromPlayers.addSpecificCardToHand(secondRandomCardFromDeck);
						if(addedToAnotherPlayersHand) {
							deck.takeFromDeck(secondRandomCardFromDeck);
						}
						choosed = true;
						break;
					}
					if(choosenCard.equals(secondRandomCardFromDeck.name)) {
						addedToPlayersHand = player.addSpecificCardToHand(secondRandomCardFromDeck);
						if(addedToPlayersHand) {								
							deck.takeFromDeck(secondRandomCardFromDeck);
						}
						addedToAnotherPlayersHand = playerFromPlayers.addSpecificCardToHand(firstRandomCardFromDeck);
						if(addedToAnotherPlayersHand) {
							deck.takeFromDeck(firstRandomCardFromDeck);
						}
						choosed = true;
						break;
					}
				}
			}
			if(!choosed) {
				System.out.println("Choose again, " + anotherPlayersTownName + " is not another player's town.");
				anotherPlayersTownName = chooseAnotherPlayersTown();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String chooseAnotherPlayersTown() {
		String anotherPlayersTownName = "";
		System.out.println("Choose other player to gave him/ her the other card:");
		BufferedReader readTownName = new BufferedReader(new InputStreamReader(System.in));
		try {
			anotherPlayersTownName = readTownName.readLine();
			return anotherPlayersTownName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anotherPlayersTownName;
	}
}
