package TanCritters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CardTypes.TanCard;
//import Main.Card;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Bard extends TanCard{

	public Bard() {
		super("Bard",new Requirements(0,0,0,3),true,0,"Theater");
	}
	
	public void playCard(Town town, Deck deck){
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
			if(town.hand.size()>=ammount) {
				for (int i = 0; i < ammount; i++) {
					System.out.println("Select a card: ");
					BufferedReader cardNameInput = new BufferedReader(new InputStreamReader(System.in));
					try {
						cardName = cardNameInput.readLine();
						System.out.println(i + ". card " + cardName + " is in hand " + town.isTheCardInArrayList(cardName, town.hand));
						inHand = town.isTheCardInArrayList(cardName, town.hand);
						if(inHand) {
							town.removeCardFromHand(cardName);
//							System.out.println("Choosed " + cardName + " and in hand " + thisCard.name);
							deck.addToDeck(cardName);
							town.printHand();
							town.specialPoints++;
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
				System.out.println(town.playersName + "'s hand has not enough card to discard " + ammount + "card.");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.playCard(town, deck);
	}
}
