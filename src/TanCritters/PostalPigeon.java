package TanCritters;

import java.util.ArrayList;

import CardTypes.TanCard;
import Main.*;

public class PostalPigeon extends TanCard{
	
	ArrayList<Card> twoRandomCard = new ArrayList<Card>();
	String twoCard = "The two random card is: " ;
	String choosableCards = "";

	public PostalPigeon() {
		super("Postal Pigeon",new Requirements(0,0,0,2),false,0,"Post Office");
	}
	
	public void removeCard(Card card) {
		twoRandomCard.remove(card);
	}
	
	public void playCard(Town town, Deck deck, Players players){
		for (int i = 0; i < 2; i++) {
			Card randomCardFromDeck = deck.chooseRandomCard();
			twoCard += randomCardFromDeck.name + " ";
			if(randomCardFromDeck.points<=3) {
				choosableCards += randomCardFromDeck.name + " ";
				twoRandomCard.add(randomCardFromDeck);
				deck.takeFromDeck(randomCardFromDeck);				
			}
		}
		System.out.println(twoCard);
		
		if(twoRandomCard.size()==0) {
			System.out.println("Non of the cards worth 3 points or less from.");
		}
		else {
			String choosedCard = "";
			String cardName = "cardName";
//			String started = "";
//			String finished = "";
//			for(Card card: twoRandomCard) {
//				finished += card.name;
//			}
//			System.out.println("finished " + finished);
//			while(!started.equals(finished)) {
			while(!choosedCard.equals(cardName)) {
				System.out.println("Choose from the next available cards: " + choosableCards);
				choosedCard = readCardName();
				for(Card card: twoRandomCard) {
					cardName=card.name;
//					started += card.name;
					if(choosedCard.equals(card.name)){
						System.out.println("Great, " + choosedCard + " is added to " + town.playersName + "'s town.");
//						if(card instanceof Fool) {
//							Fool fool = (Fool) card;
//							fool.playFoolToOtherTown(card, town, players, deck);
//						}
//						else {		
							removeCard(card);				
							town.playACardFree(card, players, deck);
//						}
						break;
					}
				}
			}
			if(twoRandomCard.size()!=0) {
				deck.cards.add(twoRandomCard.get(0));
				removeCard(twoRandomCard.get(0));
			}
		}
		
		super.playCard(town, deck);
	}
	
}