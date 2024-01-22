package Main;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import BlueCritters.*;
import CardTypes.Construction;
import GreenConstructions.*;
import GreenCritters.*;
import PurpleConstructions.*;
import PurpleCritters.*;
import TanConstructions.*;
import TanCritters.*;

public class Town {
	public String playersName;
	public int workers;
	public int spaces = 0;
	public Requirements requirements;
	public String[] requirementsName = {"twig", "resin", "pebble", "berry"};
	public ArrayList<Card> cards;
	public ArrayList<Card> hand;
	public int points = 0;
	public int specialPoints = 0;
	
	public Town(String playersName, Players players) {
		this.playersName = playersName;
		this.workers = 2;
		this.requirements = new Requirements(0,0,0,0);
		this.cards = new ArrayList<Card>();
		this.hand = new ArrayList<Card>();
		players.addPlayer(this);
	}
	
	public void sendWorkerForRequirements(int twig, int resin, int pebble, int berry) {
		if(workers>0) {
			workers--;
			requirements.twig+=twig;
			requirements.resin+=resin;
			requirements.pebble+=pebble;
			requirements.berry+=berry;
		}
		else {
			System.out.println("No available workers in town");
		}
		printRequirementsInTown();
	}
	
	public void addSpecificRequirementsToTown(String resourceName, int quantity) {
		if(resourceName.equals("twig")) {
			requirements.twig += quantity;
		}
		if(resourceName.equals("resin")){			
			requirements.resin += quantity;
		}
		if(resourceName.equals("pebble")) {
			requirements.pebble += quantity;
		}
		if(resourceName.equals("berry")) {
			requirements.berry += quantity;
		}
	}
	
	public void addRequirementsToTown(int twig, int resin, int pebble, int berry) {
		requirements.twig+=twig;
		requirements.resin+=resin;
		requirements.pebble+=pebble;
		requirements.berry+=berry;
	}
	
	public void takeRequirementsFromTown(int twig, int resin, int pebble, int berry) {
		requirements.twig-=twig;
		requirements.resin-=resin;
		requirements.pebble-=pebble;
		requirements.berry-=berry;
	}
	
	public void playACard(Card cardToPlay, Players players, Deck deck){
		boolean playable = true;
		
		if(cardToPlay.cityLimit){
			playable = !isTheCardInArrayList(cardToPlay.name, this.cards);
		}
		if(!playable) {			
			System.out.println(cardToPlay.name+" is already in your town.");
		}
		if(spaces<16 && playable) {
			if(occupieConstructionCardInTown(cardToPlay)) {
				if(cardToPlay instanceof Fool) {
					Fool fool = (Fool) cardToPlay;
					fool.playFoolToOtherTown(cardToPlay, this, players, deck);
				}
				else {
					spaces++;
				}
				playable = false;
			}
			if(playable && this.requirements.twig>=cardToPlay.requirements.twig && this.requirements.resin>=cardToPlay.requirements.resin && this.requirements.pebble>=cardToPlay.requirements.pebble && this.requirements.berry>=cardToPlay.requirements.berry) {
				if(cardToPlay instanceof Fool) {
					Fool fool = (Fool) cardToPlay;
					boolean foolIsPlayed = fool.playFoolToOtherTown(cardToPlay, this, players, deck);
//					System.out.println("Select another players town: ");
//					try (Scanner scanner = new Scanner(System.in)) {
//						String anotherPlayersTownName = scanner.next();
//						Fool fool = (Fool) cardToPlay;
//						foolIsPlayed = fool.playCard(anotherPlayersTownName, this, players, deck);
//						playable = false;
//					}
					if(foolIsPlayed) {
						takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
					}
					spaces--;
					playable = false;
				}
				if(playable && cardToPlay instanceof Fairgrounds) {
					Fairgrounds fairgrounds = (Fairgrounds) cardToPlay;
					cards.add(fairgrounds);
					fairgrounds.playCard(this, deck);
					takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
					playable = false;
				}
				if(playable && cardToPlay instanceof Wanderer) {
					Wanderer wanderer = (Wanderer) cardToPlay;
					cards.add(wanderer);
					wanderer.playCard(this, deck);
					takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
					spaces--;
					playable = false;
				}
				if(playable && cardToPlay instanceof Ruins) {
					boolean ruinsCanBePlayed = false;
					for(Card card: cards) {
						if(card instanceof Construction) {
							ruinsCanBePlayed = true;
							cards.add(cardToPlay);
							cardToPlay.playCard(this, deck);
							takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
							break;
						}
					}
					if(!ruinsCanBePlayed) {
						System.out.println("You have no construction in your town. Ruins can't be played.");
						spaces--;
					}
					playable = false;
				}
				if(playable) {					
					cards.add(cardToPlay);
					cardToPlay.playCard(this, deck);
					takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
				}
				playable = false;
				spaces++;
			}
			if(playable) {
				System.out.println("You don't have enough requirements.");
			}
		}
		if(spaces==15) {
			System.out.println("Your town is full.");
		}
		
		checkBlueCardsAfterPlayingACard(cardToPlay, deck);
		
		System.out.println("");
	}
	
	public void checkBlueCardsAfterPlayingACard(Card cardToPlay, Deck deck) {
		for(Card card: cards) {
			if(card instanceof Shopkeeper) {
				Shopkeeper shopkeeper = (Shopkeeper) card;
				shopkeeper.blueCardEffect(cardToPlay, this);
			}
			if(card instanceof Historian) {
				Historian historian = (Historian) card;
				historian.blueCardEffect(cardToPlay, this, deck);
			}
		}
	}
	
	public boolean isTheCardInArrayList(String cardName, ArrayList<Card> arrayList) {
		boolean isTheCardInArrayList = false;
		for(Card card: arrayList) {
//			System.out.println(cardName + " is in the list " + card.name==cardName);
			if(card.name.equals(cardName)) {
				isTheCardInArrayList = true;
				break;
			}
		}
		return isTheCardInArrayList;
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
					this.cards.remove(card);
					spaces--;
					deck.addToDeck(cardName);
					cardIsRemoved = true;
					cardFound = "Card " + cardName + " is found.";
//					System.out.println("for 1. if, card name: " + cardName + " card is removed: " + cardIsRemoved);
					break;
				}
				if(card.name.equals(cardName) && !card.critter && critterOrContstruction.equals("construction")) {
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
	
//	public void discardCardFromTown(Town town, Deck deck, String cardName, String critterOrContstruction) {
//		
//	}
	
	public boolean occupieConstructionCardInTown(Card cardToPlay) {
		boolean isCardPlayed = false;
		for(Card card: cards) {
			if (card instanceof Farm && card.name==cardToPlay.relatedCard) {
				Farm farm = (Farm) card;
				if(!farm.occupied && cardToPlay.name=="Husband") {
					farm.occupie("Husband");
					farm.occupieHusband();
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
				if(!farm.occupied && cardToPlay.name=="Wife") {
					farm.occupie("Wife");
					farm.occupieWife();
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
				if(farm.occupied && !farm.husbandOccupier) {
					farm.occupieHusband();
					pairWithPartner(cardToPlay);
					spaces--;
					break;
				}
				if(farm.occupied && !farm.wifeOccupier) {
					farm.occupieWife();
					pairWithPartner(cardToPlay);
					spaces--;
					break;
				}
			}
			if (card instanceof GreenConstruction && card.name==cardToPlay.relatedCard) {
				GreenConstruction constructionCard = (GreenConstruction) card;
				if((cardToPlay instanceof Fool) && !constructionCard.occupied) {
					constructionCard.occupie(cardToPlay.name);
					isCardPlayed = true;
					break;
				}
				if(!constructionCard.occupied) {					
					constructionCard.occupie(cardToPlay.name);
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
//				if(playable && cardToPlay instanceof Wanderer) {
//					Wanderer wanderer = (Wanderer) cardToPlay;
//					cards.add(wanderer);
//					wanderer.playCard(this, deck);
//					takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
//					spaces--;
//					playable = false;
//				}
			}
		}
		return isCardPlayed;
	}
	
	public void pairWithPartner(Card cardToPlay) {
		for(Card card: cards) {
			if (card instanceof Husband && cardToPlay instanceof Wife) {
				Husband husband = (Husband) card;
				Wife wife = (Wife) cardToPlay;
				if(!husband.pairedWithWife) {
					husband.pairedWithWife = true;
					wife.pairedWithHusband = true;
				}
			}
			if (card instanceof Wife && cardToPlay instanceof Husband) {
				Wife wife = (Wife) card;
				Husband husband = (Husband) cardToPlay;
				if(!wife.pairedWithHusband) {
					wife.pairedWithHusband = true;
					husband.pairedWithWife = true;					
				}
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
	
	public void addSpecificCardToHand(Card card) {
		if(hand.size()<=8) {
			this.hand.add(card);
		}
		else {
			System.out.println(this.playersName + "'s hand is full.");
		}
	}
	
	public void removeCardFromHand(String cardName, Deck deck) {
//		Card thisCard = new Card();
		for(Card handCard: hand) {
			if(handCard.name.equals(cardName)) {
				System.out.println("Remove " + cardName + " from hand.");
//				thisCard = handCard;
				this.hand.remove(handCard);
				break;
			}
		}
//		return thisCard;
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
	
//	public void addRandomCardFromDeckToHand(Deck deck) {
//	//if(hand.size()<=8) {
//	System.out.println("hand size " + hand);
//		Card randomCardFromDeck = deck.chooseRandomCard();
//		Card addThisCardToHand = new Card();
//		System.out.println("rand from deck " + randomCardFromDeck + "\nName " + randomCardFromDeck.name);
//		addThisCardToHand.copyCard(randomCardFromDeck);
//		System.out.println("add to hand" + addThisCardToHand + "\nName " + addThisCardToHand.name);
//		this.hand.add(addThisCardToHand);
//		deck.takeFromDeck(randomCardFromDeck);
//	//}
//	//else {
//	//	System.out.println(this.playersName + "'s hand is full.");
//	//}
//	}
	
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
	
	public boolean isRequirementInTown(String requirementName) {
		if(requirementName.equals("twig")) {
			return this.requirements.twig>0;
		}
		if(requirementName.equals("resin")) {
			return this.requirements.resin>0;
		}
		if(requirementName.equals("pebble")) {
			return this.requirements.pebble>0;
		}
		if(requirementName.equals("berry")) {
			return this.requirements.berry>0;
		}
		return false;
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
	
	public void printPointsInTown(Town town) {
		this.points = 0;
		for(Card card: cards) {
			if (card instanceof Wife) {
				((Wife) card).activatePurpleCard(town);
			}
			if (card instanceof Architect) {
				((Architect) card).activatePurpleCard(town);	
			}
			if (card instanceof Theater) {
				((Theater) card).activatePurpleCard(town);	
			}
			this.points += card.points;
			this.points += specialPoints;
		}
		System.out.println("Points: " + points);
	}
}
