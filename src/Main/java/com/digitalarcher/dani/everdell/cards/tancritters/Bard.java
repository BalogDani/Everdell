package com.digitalarcher.dani.everdell.cards.tancritters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.digitalarcher.dani.everdell.cardtypes.TanCard;
import com.digitalarcher.dani.everdell.main.Deck;
import com.digitalarcher.dani.everdell.main.Player;
import com.digitalarcher.dani.everdell.main.Players;
import com.digitalarcher.dani.everdell.main.Requirements;

public class Bard extends TanCard{

	public Bard() {
		super("Bard",new Requirements(0,0,0,3),true,0,"Theater");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		String cardName = "";
		boolean inHand = false;
//		Card thisCard = null;
		System.out.println("How many cards to discard? ");
		BufferedReader ammountInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			int ammount = Integer.parseInt(ammountInput.readLine());
			if(ammount > 5) {
				ammount = 5;
			}
			if(player.hand.size()>=ammount) {
				for (int i = 1; i < ammount+1; i++) {
					System.out.println("Select a card: ");
					BufferedReader cardNameInput = new BufferedReader(new InputStreamReader(System.in));
					try {
						cardName = cardNameInput.readLine();
						System.out.println(i + ". card " + cardName + " is in hand " + player.isTheCardInArrayList(cardName, player.hand));
						inHand = player.isTheCardInArrayList(cardName, player.hand);
						if(inHand) {
							player.removeCardFromHand(cardName, deck);
//							System.out.println("Choosed " + cardName + " and in hand " + thisCard.name);
							deck.addToDeck(cardName);
							player.printHand();
							player.specialPoints++;
						}
						if(!inHand) {
							System.out.println(cardName + " is not in hand.");
							i--;
						}
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else {
				System.out.println(player.playersName + "'s hand has not enough card to discard " + ammount + " card.");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		super.playCard(player, deck, players);
	}
}
