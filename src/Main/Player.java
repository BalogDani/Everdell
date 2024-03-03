package Main;
import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import CardTypes.GreenCard;
import CardTypes.PurpleCard;
import GreenConstructions.*;
import GreenCritters.*;

public class Player implements PlayCardController{
	public String playersName;
	public int workers;
	public int spaces = 0;
	public Requirements requirements;
	public String[] requirementsName = {"twig", "resin", "pebble", "berry"};
	public ArrayList<Card> cards;
	public ArrayList<Card> hand;
	public int points = 0;
	public int specialPoints = 0;
	
	public Player(String playersName, Players players) {
		this.playersName = playersName;
		this.workers = 2;
		this.requirements = new Requirements(0,0,0,0);
		this.cards = new ArrayList<Card>();
		this.hand = new ArrayList<Card>();
		players.addPlayer(this);
	}
	
	public boolean isTheCardInArrayList(String cardName, ArrayList<Card> arrayList) {
		boolean isTheCardInArrayList = false;
		for(Card card: arrayList) {
			if(card.name.equals(cardName)) {
				isTheCardInArrayList = true;
				break;
			}
		}
		return isTheCardInArrayList;
	}
	
	public boolean isTheCardInTown(Card cardToCheck, Player town) {
		boolean theCardIsInTown = false;
		for (Card card : town.cards) {
			if(card.equals(cardToCheck)) {
				theCardIsInTown = true;
				break;
			}
		}
		return theCardIsInTown;
	}
	
	public boolean removeCardFromTown(String critterOrContstruction, Deck deck) {
		boolean cardIsRemoved = false;
		System.out.println("Select a " + critterOrContstruction + " in town: ");
		BufferedReader readCardName = new BufferedReader(new InputStreamReader(System.in));
		try {
			String cardName = readCardName.readLine();
			String cardFound = "Card " + cardName + " is not found.";
			if(cards.size()==0) {
				System.out.println("No card to remove. The town is empty.");
			}
			for(Card card: cards) {
				if(card.name.equals(cardName) && card.critter && critterOrContstruction.equals("critter")) {
					this.requirements.addRequirementsToTown(this, card.requirements.twig, card.requirements.resin, card.requirements.pebble, card.requirements.berry);
					this.cards.remove(card);
					spaces--;
					deck.addToDeck(cardName);
					cardIsRemoved = true;
					cardFound = "Card " + cardName + " is found.";
//					System.out.println("for 1. if, card name: " + cardName + " card is removed: " + cardIsRemoved);
					break;
				}
				if(card.name.equals(cardName) && !card.critter && critterOrContstruction.equals("construction")) {
					this.requirements.addRequirementsToTown(this, card.requirements.twig, card.requirements.resin, card.requirements.pebble, card.requirements.berry);
					this.cards.remove(card);
					spaces--;
					deck.addToDeck(cardName);
					cardIsRemoved = true;
					cardFound = "Card " + cardName + " is found.";
//					System.out.println("for 2. if, card name: " + cardName + " card is removed: " + cardIsRemoved);
					break;				
				}
				if (!cardIsRemoved) {
					cardFound = "There is no " + cardName + " " + critterOrContstruction + " in the town.";
//					System.out.println("for 3. if, card name: " + cardName + " card is removed: " + cardIsRemoved);
				}
			}
			if(cardFound.equals("There is no " + cardName + " " + critterOrContstruction + " in the town.")) {
				System.out.println(cardFound + " Please choose another card.");
				this.removeCardFromTown(critterOrContstruction, deck);
				cardIsRemoved = true;
				cardFound = "Card is finally found.";
			}
			System.out.println(cardFound);
			return cardIsRemoved;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardIsRemoved;
	}
	
	public void removeCardFromTown(Card cardToRemove, Deck deck) {
		if(cards.size()==0) {
			System.out.println("No card to remove. The town is empty.");
		}
		for(Card card: cards) {
			if(card.name.equals(cardToRemove.name)) {
				this.cards.remove(card);
				spaces--;
				deck.addToDeck(cardToRemove.name);
				break;
			}
		}
	}
	
	public Card findCardInTown(String name) {
		Card cardFound = new Card();
		for(Card card: cards) {
			if(card.name==name) {
				cardFound = card;
			}
		}
		return cardFound;
	}
	
	public boolean addSpecificCardToHand(Card card) {
		boolean addedToHand = false;
		if(hand.size()<8) {
			this.hand.add(card);
			addedToHand = true;
		}
		if(!addedToHand) {
			System.out.println(this.playersName + "'s hand is full. " + card.name + " is discarded.");
		}
		return addedToHand;
	}
	
	public void removeCardFromHand(String cardName, Deck deck) {
		for(Card handCard: hand) {
			if(handCard.name.equals(cardName)) {
				System.out.println("Remove " + cardName + " from hand.");
				this.hand.remove(handCard);
				deck.cards.add(handCard);
				break;
			}
		}
	}
	
	public void addRandomCardFromDeckToHand(Deck deck) {
		if(hand.size()<8) {
			Card randomCardFromDeck = deck.chooseRandomCard(); 
			this.hand.add(randomCardFromDeck);
			deck.takeFromDeck(randomCardFromDeck);
		}
		else {
			System.out.println(this.playersName + "'s hand is full.");
		}
	}
	
	public void activateGreenCards(Deck deck, Players players) {
		for(Card card: cards) {
			if (card instanceof GreenCard) {
				if (card instanceof Fairgrounds) {
					((Fairgrounds) card).activateGreenCard(this, deck);
				}
				if (card instanceof Doctor) {
					((Doctor) card).activateGreenCard(this, deck);
				}
				if (card instanceof ChipSweep) {
					((ChipSweep) card).activateGreenCard(this, deck, players);
				}
				if (card instanceof MinerMole) {
					((MinerMole) card).activateGreenCard(this, deck, players);
				}
				if (card instanceof Teacher) {
					((Teacher) card).activateGreenCard(this, deck, players);
				}
				else {					
					((GreenCard) card).activateGreenCard(this);
				}
			}
		}
	}
	
	public void printHand() {
		String inHand = this.hand.size() + " card is in " + this.playersName + "'s hand: ";
		for(Card card: hand) {
			inHand += card.name + " ";
		}
		System.out.println(inHand);
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public void printTownDetails() {
		printCardsInTown();
		printRequirementsInTown();
		printPointsInTown(this);
		System.out.println("");
	}
	
	public void printCardsInTown() {
		String inTown = cards.size() + " card and " + spaces + " used spaces in " + this.playersName + "'s town: ";
		for(Card card: cards) {
			inTown += card.name + " ";
		}
		System.out.println(inTown);
	}
	
	public void printRequirementsInTown() {
		System.out.println("Twig: "+this.requirements.twig+", Resin: "+this.requirements.resin+", Pebble: "+this.requirements.pebble+", Berry: "+this.requirements.berry);
	}
	
	public void printPointsInTown(Player town) {
		this.points = 0;
		for(Card card: cards) {
			if (card instanceof PurpleCard) {
				((PurpleCard) card).activatePurpleCard(town);	
			}
			this.points += card.points;
		}
		int allPointsInTown = points + specialPoints;
		System.out.println("Points: " + allPointsInTown);
	}
}
