package Main;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import BlueConstructions.*;
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
	public Requirements requirementsToPayForCard = new Requirements(0, 0, 0, 0);
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
	
	public boolean sendWorkerForRequirements(int twig, int resin, int pebble, int berry) {
		boolean workerSent = false;
		if(workers>0) {
			workers--;
			requirements.twig+=twig;
			requirements.resin+=resin;
			requirements.pebble+=pebble;
			requirements.berry+=berry;
			workerSent = true;
			System.out.println("Worker sent.");
		}
		else {
			System.out.println("No available workers in town");
		}
		printRequirementsInTown();
		return workerSent;
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
	
	public void copyRequirementsToPayForCard(Requirements requirementsOnCard) {
		requirementsToPayForCard.twig=requirementsOnCard.twig;
		requirementsToPayForCard.resin=requirementsOnCard.resin;
		requirementsToPayForCard.pebble=requirementsOnCard.pebble;
		requirementsToPayForCard.berry=requirementsOnCard.berry;
	}
	
	public void modifyRequirementsToPayForCard(String resourceName, int quantity) {
		if(resourceName.equals("twig")) {
			requirementsToPayForCard.twig += quantity;
			if(requirementsToPayForCard.twig<0) {
				requirementsToPayForCard.twig=0;
			}
		}
		if(resourceName.equals("resin")){			
			requirementsToPayForCard.resin += quantity;
			if(requirementsToPayForCard.resin<0) {
				requirementsToPayForCard.resin=0;
			}
		}
		if(resourceName.equals("pebble")) {
			requirementsToPayForCard.pebble += quantity;
			if(requirementsToPayForCard.pebble<0) {
				requirementsToPayForCard.pebble=0;
			}
		}
		if(resourceName.equals("berry")) {
			requirementsToPayForCard.berry += quantity;
			if(requirementsToPayForCard.berry<0) {
				requirementsToPayForCard.berry=0;
			}
		}
//		return requirementsToPayForCard;
	}
	
	public void changeRequirements(Card cardToPlay, Town town) {
		String resourceToAdd = "";
		String resourceToCheckToAdd = "";
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
//		Requirements newRequirements = cardToPlay.requirements;
		ArrayList<String> requirementsOnCard = cardToPlay.availableResources(cardToPlay);
		if(cardToPlay.requirements.twig!=0 || cardToPlay.requirements.resin!=0 || cardToPlay.requirements.pebble!=0 || cardToPlay.requirements.berry!=0) {
			while(!resourceToTake.equals(resourceToCheckForTake)) {
				resourceToTake = cardToPlay.readResourceInput("take");
				for(String resourceName: requirementsOnCard) {
					resourceToCheckForTake = resourceName;
					if(resourceToTake.equals(resourceName)) {
						town.modifyRequirementsToPayForCard(resourceToTake,-1);
						while(!resourceToCheckToAdd.equals("added")) {
							resourceToAdd = cardToPlay.readResourceInput("add");
							for(String resource: town.requirementsName) {
								resourceToCheckToAdd = resource;
								if(resourceToAdd.equals(resource)){
//									System.out.println(resourceToTake + " taken, " + resourceToAdd + " added.");
									resourceToCheckToAdd = "added";
									town.modifyRequirementsToPayForCard(resourceToAdd,1);
									break;
								}
							}
						}
						break;
					}
					if(!town.isRequirementInTown(resourceToTake)) {
						System.out.println("No " + resourceToTake + " on card, choose a valid resource.");
						resourceToCheckForTake = "";
						break;
					}
					if(!resourceToTake.equals(resourceName)) {
						resourceToCheckForTake = "";
					}
				}
			}
		}
		else {
			System.out.println("Changing of resources was unsuccessful.\n");
//			System.out.println("No " + resourceToTake + " on card, choose a valid resource.");
//			this.changeRequirements(cardToPlay, town);
		}
//		return newRequirements;
	}
	
	public void playACardFree(Card cardToPlay, Players players, Deck deck){
		boolean playable = true;
		
		if(cardToPlay.cityLimit){
			playable = !isTheCardInArrayList(cardToPlay.name, this.cards);
		}
		if(!playable) {			
			System.out.println(cardToPlay.name+" is already in your town.");
		}
		if(spaces<16 && playable) {
			if(cardToPlay instanceof Teacher) {
				Teacher teacher = (Teacher) cardToPlay;
				cards.add(teacher);
				teacher.playCard(this, deck, players);
				playable = false;
			}
			if(cardToPlay instanceof Fool) {
				Fool fool = (Fool) cardToPlay;
				fool.playFoolToOtherTown(cardToPlay, this, players, deck);
				spaces--;
				playable = false;
			}
			if(cardToPlay instanceof PostalPigeon) {
				PostalPigeon postalPigeon = (PostalPigeon) cardToPlay;
				cards.add(postalPigeon);
				postalPigeon.playCard(this, deck, players);
				playable = false;
			}
			if(playable && cardToPlay instanceof Fairgrounds) {
				Fairgrounds fairgrounds = (Fairgrounds) cardToPlay;
				cards.add(fairgrounds);
				fairgrounds.playCard(this, deck);
				playable = false;
			}
			if(playable && cardToPlay instanceof Wanderer) {
				Wanderer wanderer = (Wanderer) cardToPlay;
				cards.add(wanderer);
				wanderer.playCard(this, deck);
				spaces--;
				playable = false;
			}
			if(playable && cardToPlay instanceof Ruins) {
				Ruins ruins = (Ruins) cardToPlay;
				boolean ruinsCanBePlayed = false;
				for(Card card: cards) {
					if(card instanceof Construction) {
						ruins.playCard(this, deck);
						ruinsCanBePlayed = ruins.isRuinsUsed;
						if(ruinsCanBePlayed) {								
							cards.add(ruins);
						}
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
			}
			playable = false;
			spaces++;
		}
		if(spaces==15) {
			System.out.println("Your town is full.");
		}
		
		if(!playable) {			
			checkBlueCardsAfterPlayingACard(cardToPlay, deck);
		}
		
		System.out.println("");
	}
	
	public void playACard(Card cardToPlay, Players players, Deck deck){
		boolean playable = true;
		copyRequirementsToPayForCard(cardToPlay.requirements);
		
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
				if(cardToPlay instanceof Teacher) {
					Teacher teacher = (Teacher) cardToPlay;
					teacher.playCard(this, deck, players);
					spaces++;
				}
				else {
					spaces++;
				}
				playable = false;
			}
			if(playable) {
				checkBlueCardsBeforePlayingACard(cardToPlay, deck);
			}
			if(playable && this.requirements.twig>=requirementsToPayForCard.twig && this.requirements.resin>=requirementsToPayForCard.resin && this.requirements.pebble>=requirementsToPayForCard.pebble && this.requirements.berry>=requirementsToPayForCard.berry) {
				if(cardToPlay instanceof Teacher) {
					Teacher teacher = (Teacher) cardToPlay;
					cards.add(teacher);
					teacher.playCard(this, deck, players);
					takeRequirementsFromTown(requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
					playable = false;
				}
				if(cardToPlay instanceof Fool) {
					Fool fool = (Fool) cardToPlay;
					boolean foolIsPlayed = fool.playFoolToOtherTown(cardToPlay, this, players, deck);
					if(foolIsPlayed) {
						takeRequirementsFromTown(requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
					}
					spaces--;
					playable = false;
				}
				if(cardToPlay instanceof PostalPigeon) {
					PostalPigeon postalPigeon = (PostalPigeon) cardToPlay;
					cards.add(postalPigeon);
					postalPigeon.playCard(this, deck, players);
					takeRequirementsFromTown(requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
					playable = false;
				}
				if(playable && cardToPlay instanceof Fairgrounds) {
					Fairgrounds fairgrounds = (Fairgrounds) cardToPlay;
					cards.add(fairgrounds);
					fairgrounds.playCard(this, deck);
					takeRequirementsFromTown(requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
					playable = false;
				}
				if(playable && cardToPlay instanceof Wanderer) {
					Wanderer wanderer = (Wanderer) cardToPlay;
					cards.add(wanderer);
					wanderer.playCard(this, deck);
					takeRequirementsFromTown(requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
					spaces--;
					playable = false;
				}
				if(playable && cardToPlay instanceof Ruins) {
					Ruins ruins = (Ruins) cardToPlay;
					boolean ruinsCanBePlayed = false;
					for(Card card: cards) {
						if(card instanceof Construction) {
							ruins.playCard(this, deck);
							ruinsCanBePlayed = ruins.isRuinsUsed;
							if(ruinsCanBePlayed) {								
								cards.add(ruins);
//								takeRequirementsFromTown(requirementsToTake.twig, requirementsToTake.resin, requirementsToTake.pebble, requirementsToTake.berry);
							}
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
					takeRequirementsFromTown(requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
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
		
		if(!playable) {
			checkBlueCardsAfterPlayingACard(cardToPlay, deck);
		}
		
		System.out.println("");
	}
	
	public boolean useBlueCardOrNot(Card cardToUse, Card cardToPlay) {
		boolean useIt = false;
		String yesOrNo = "";
		while(!yesOrNo.equals("Yes") && !yesOrNo.equals("yes") && !yesOrNo.equals("No") && !yesOrNo.equals("no")) {
			yesOrNo = answerUseBlueCardOrNot(cardToUse, cardToPlay);
			if(yesOrNo.equals("Yes") || yesOrNo.equals("yes")) {
				useIt = true;
			}
			if(yesOrNo.equals("No") || yesOrNo.equals("no")) {
				System.out.println(cardToUse.name + "'s effect will be not used.\n");
			}
			if(!yesOrNo.equals("Yes") && !yesOrNo.equals("yes") && !yesOrNo.equals("No") && !yesOrNo.equals("no")) {
				System.out.println("Please choose a correct answer 'Yes' or 'No'.");
			}
		}
		
		return useIt;
	}
	
	public String answerUseBlueCardOrNot(Card cardToUse, Card cardToPlay) {
		System.out.println("Use " + cardToUse.name + "'s effect on " + cardToPlay.name + "?");
		String yesOrNo = "";
		BufferedReader answer = new BufferedReader(new InputStreamReader(System.in));
		try {
			yesOrNo = answer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yesOrNo;
	}
	
	public void checkBlueCardsBeforePlayingACard(Card cardToPlay, Deck deck) {
		boolean usedBlueCardEffect = false;
		
		for(Card card: cards) {
			if(card instanceof Judge) {
				Judge judge = (Judge) card;
				usedBlueCardEffect = judge.blueCardEffect(cardToPlay, this);
				if(usedBlueCardEffect) {
					break;
				}
			}
			if(!usedBlueCardEffect && card instanceof Innkeeper) {
				Innkeeper innkeeper = (Innkeeper) card;
				usedBlueCardEffect = innkeeper.blueCardEffect(cardToPlay, this, deck);
				if(usedBlueCardEffect) {
					break;
				}
			}
			if(!usedBlueCardEffect && card instanceof Crane) {
				Crane crane = (Crane) card;
				usedBlueCardEffect = crane.blueCardEffect(cardToPlay, this, deck);
				if(usedBlueCardEffect) {
					break;
				}
			}
//			System.out.println("checkBlueCardsBeforePlayingACard done");
		}
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
			if(card instanceof Courthouse) {
				Courthouse courthouse = (Courthouse) card;
				courthouse.blueCardEffect(cardToPlay, this, deck);
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
					this.addRequirementsToTown(card.requirements.twig, card.requirements.resin, card.requirements.pebble, card.requirements.berry);
					this.cards.remove(card);
					spaces--;
					deck.addToDeck(cardName);
					cardIsRemoved = true;
					cardFound = "Card " + cardName + " is found.";
//					System.out.println("for 1. if, card name: " + cardName + " card is removed: " + cardIsRemoved);
					break;
				}
				if(card.name.equals(cardName) && !card.critter && critterOrContstruction.equals("construction")) {
					this.addRequirementsToTown(card.requirements.twig, card.requirements.resin, card.requirements.pebble, card.requirements.berry);
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
	
	public boolean occupieConstructionCardInTown(Card cardToPlay) {
		boolean isCardPlayed = false;
		for(Card card: cards) {
			if (card instanceof EverTree && cardToPlay.critter) {
				EverTree everTree = (EverTree) card;
				if(!everTree.occupied) {
					String yesOrNo = "";
					while(!yesOrNo.equals("Yes") && !yesOrNo.equals("No")) {
						yesOrNo = everTree.decideToOccupiesTheCritterToTown(cardToPlay);
						if(yesOrNo.equals("Yes")) {
							everTree.occupie(cardToPlay.name);
							cards.add(cardToPlay);
							isCardPlayed = true;
						}
						if(yesOrNo.equals("No")) {
							System.out.println(cardToPlay.name + " is not occupied in Ever Tree.");
						}
						else {
							System.out.println("Please choose a correct answer 'Yes' or 'No'.");
						}
					}
					break;
				}
			}
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
				GreenConstruction greenConstructionCard = (GreenConstruction) card;
				if((cardToPlay instanceof Fool) && !greenConstructionCard.occupied) {
					greenConstructionCard.occupie(cardToPlay.name);
					isCardPlayed = true;
					break;
				}
				if(!greenConstructionCard.occupied) {					
					greenConstructionCard.occupie(cardToPlay.name);
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof BlueConstruction && card.name==cardToPlay.relatedCard) {
				BlueConstruction blueConstructionCard = (BlueConstruction) card;
				if(!blueConstructionCard.occupied) {					
					blueConstructionCard.occupie(cardToPlay.name);
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof TanConstruction && card.name==cardToPlay.relatedCard) {
				TanConstruction tanConstructionCard = (TanConstruction) card;
				if(!tanConstructionCard.occupied) {					
					tanConstructionCard.occupie(cardToPlay.name);
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof PurpleConstruction && card.name==cardToPlay.relatedCard) {
				PurpleConstruction purpleConstructionCard = (PurpleConstruction) card;
				if(!purpleConstructionCard.occupied) {					
					purpleConstructionCard.occupie(cardToPlay.name);
					cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
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
			if (card instanceof Fairgrounds) {
				((Fairgrounds) card).activateGreenCard(this, deck);;
			}
			if (card instanceof Farm) {
				((Farm) card).activateGreenCard(this);;
			}
			if (card instanceof GeneralStore) {
				((GeneralStore) card).activateGreenCard(this);;
			}
			if (card instanceof Mine) {
				((Mine) card).activateGreenCard(this);;
			}
			if (card instanceof ResinRefinery) {
				((ResinRefinery) card).activateGreenCard(this);;
			}
			if (card instanceof Storehouse) {
				((Storehouse) card).activateGreenCard(this);
			}
			if (card instanceof TwigBarge) {
				((TwigBarge) card).activateGreenCard(this);;
			}
			if (card instanceof BargeToad) {
				((BargeToad) card).activateGreenCard(this);;
			}
			if (card instanceof Doctor) {
				((Doctor) card).activateGreenCard(this, deck);;
			}
			if (card instanceof Husband) {
				((Husband) card).activateGreenCard(this);;
			}
			if (card instanceof Peddler) {
				((Peddler) card).activateGreenCard(this);;
			}
			if (card instanceof Teacher) {
				((Teacher) card).activateGreenCard(this, deck, players);;
			}
			if (card instanceof Woodcarver) {
				((Woodcarver) card).activateGreenCard(this);;
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
	
	public boolean isRequirementInRequirementsToPayForCard(String requirementName) {
		if(requirementName.equals("twig")) {
			return requirementsToPayForCard.twig>0;
		}
		if(requirementName.equals("resin")) {
			return requirementsToPayForCard.resin>0;
		}
		if(requirementName.equals("pebble")) {
			return requirementsToPayForCard.pebble>0;
		}
		if(requirementName.equals("berry")) {
			return requirementsToPayForCard.berry>0;
		}
		return false;
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
			if (card instanceof Architect) {
				((Architect) card).activatePurpleCard(town);	
			}
			if (card instanceof Wife) {
				((Wife) card).activatePurpleCard(town);
			}
			if (card instanceof Castle) {
				((Castle) card).activatePurpleCard(town);	
			}
			if (card instanceof EverTree) {
				((EverTree) card).activatePurpleCard(town);	
			}
			if (card instanceof Palace) {
				((Palace) card).activatePurpleCard(town);	
			}
			if (card instanceof School) {
				((School) card).activatePurpleCard(town);	
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
