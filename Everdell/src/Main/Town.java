package Main;
import java.util.*;

import GreenConstructions.*;
import GreenCritters.*;
import PurpleCritters.*;
import TanCritters.Fool;
import TanCritters.Wanderer;

public class Town {
	public String playersName;
	public int workers;
	public int spaces = 0;
	public Requirements requirements;
	public ArrayList<Card> cards;
	public ArrayList<Card> hand;
	public int points = 0;
	
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
	
//	public void playACard(Card cardToPlay){
//		boolean playable = true;
//		
//		if(cardToPlay.cityLimit){
//			playable = !isTheCardInTown(cardToPlay.name);
//		}
//		if(!playable) {			
//			System.out.println(cardToPlay.name+" is already in your town.");
//		}
//		if(spaces<16 && playable) {
//			if(cardToPlay instanceof Fool) {
//				System.out.println("You can't play a Fool to your own town.");
//				playable = false;
//			}
//			if(playable && occupieConstructionCardInTown(cardToPlay)) {
//				playable = false;
//				spaces++;
//			}
//			if(playable && this.requirements.twig>=cardToPlay.requirements.twig && this.requirements.resin>=cardToPlay.requirements.resin && this.requirements.pebble>=cardToPlay.requirements.pebble && this.requirements.berry>=cardToPlay.requirements.berry) {
//				cards.add(cardToPlay);
//				cardToPlay.playCard(this);
//				takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
//				playable = false;
//				spaces++;
//			}
//			if(playable) {
//				System.out.println("You don't have enough requirements.");
//			}
//		}
//		if(spaces==15) {
//			System.out.println("Your town is full.");
//		}
//		System.out.println("");
//	}
	
	public void playACard(Card cardToPlay, Players players, Deck deck){
		boolean playable = true;
		
		if(cardToPlay.cityLimit){
			playable = !isTheCardInTown(cardToPlay.name);
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
				if(playable) {					
					cards.add(cardToPlay);
					cardToPlay.playCard(this);
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
		System.out.println("");
	}
	
	public boolean isTheCardInTown(String cardName) {
		boolean isTheCardInTown = false;
		for(Card card: cards) {
			if(card.name==cardName) {
				isTheCardInTown = true;
				break;
			}
		}
		return isTheCardInTown;
	}
	
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
		Card cardFound = null;
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
	
	public void removeCardToTheHand(Card card) {
		this.hand.remove(card);
	}
	
	public void addRandomCardFromDeckToHand(Deck deck) {
		if(hand.size()<=8) {
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
			this.points += card.points;
		}
		System.out.println("Points: " + points);
	}
}
