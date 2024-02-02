package Main;

import java.util.*;

import BlueCritters.*;
import GreenConstructions.*;
import GreenCritters.*;
import PurpleConstructions.*;
import PurpleCritters.*;
import TanConstructions.*;
import TanCritters.*;


public class Deck {
	public String typeOfPile = null;
	public ArrayList<Card> cards = null;
	
	public Deck(String typeOfPile) {
		this.typeOfPile = typeOfPile;
		if(typeOfPile.equals("deck")) {
			this.cards = new ArrayList<Card>();
			for (int i = 0; i < 2; i++) {
				this.addToDeck("Architect");
				this.addToDeck("Bard");
				this.addToDeck("Doctor");
				this.addToDeck("Fool");
				this.addToDeck("Judge");
	//			this.addToDeck("King");
	//			this.addToDeck("Monk");
	//			this.addToDeck("Queen");
	//			this.addToDeck("Ranger");
	//			this.addToDeck("Undertaker");
	//			this.addToDeck("Shepherd");
				this.addToDeck("Castle");
	//			this.addToDeck("Cemetery");
	//			this.addToDeck("Chapel");
				this.addToDeck("Courthouse");
	//			this.addToDeck(Dungeon);
				this.addToDeck("EverTree");
	//			this.addToDeck(Lookout);
	//			this.addToDeck(Monastery);
				this.addToDeck("Palace");
				this.addToDeck("School");
				this.addToDeck("Theater");
	//			this.addToDeck(University);
			}
			for (int i = 0; i < 3; i++) {
				this.addToDeck("Barge Toad");
	//			this.addToDeck(ChipSweep);
				this.addToDeck("Historian");
				this.addToDeck("Innkeeper");
	//			this.addToDeck(MinerMole);
				this.addToDeck("Peddler");
	//			this.addToDeck(PostalPigeon);
				this.addToDeck("Shopkeeper");
				this.addToDeck("Teacher");
				this.addToDeck("Wanderer");
				this.addToDeck("Woodcarver");
	//			this.addToDeck(ClockTower);
	//			this.addToDeck(Crane);
				this.addToDeck("FairGrounds");
				this.addToDeck("General Store");
	//			this.addToDeck(Inn);
				this.addToDeck("Mine");
	//			this.addToDeck(PostOffice);
				this.addToDeck("Resin Refinery");
				this.addToDeck("Ruins");
				this.addToDeck("Storehouse");
				this.addToDeck("Twig Barge");
			}
			for (int i = 0; i < 4; i++) {
				this.addToDeck("Husband");
				this.addToDeck("Wife");
			}
			for (int i = 0; i < 8; i++) {
				this.addToDeck("Farm");
			}	
		}
		if(typeOfPile.equals("discard")) {
			this.cards = new ArrayList<Card>();
		}
		if(!typeOfPile.equals("deck") && !typeOfPile.equals("discard")) {
			System.out.println("Only deck and discard pile exists. Duh!");
		}
	}
	
	public void addToDeck(String cardName) {
		Card card = new Card();
		if(cardName.equals("Architect")){
			Architect architect = new Architect();
			card = (Architect) architect;
		}
		if(cardName.equals("Bard")){
			Bard bard = new Bard();
			card = (Bard) bard;
		}
		if(cardName.equals("Doctor")){
			Doctor doctor = new Doctor();
			card = (Doctor) doctor;
		}
		if(cardName.equals("Fool")){
			Fool fool = new Fool();
			card = (Fool) fool;
		}
		if(cardName.equals("Judge")){
			Judge judge = new Judge();
			card = (Judge) judge;
		}
//		if(cardName.equals("King"){
//			King King = new King();
//			card = (King) king;
//		}
//			Monk Monk = new Monk();
//			this.addToDeck(Monk);
//			Queen Queen = new Queen();
//			this.addToDeck(Queen);
//			Ranger Ranger = new Ranger();
//			this.addToDeck(Ranger);
//			Undertaker Undertaker = new Undertaker();
//			this.addToDeck(Undertaker);
//			Shepherd Shepherd = new Shepherd();
//			this.addToDeck(Shepherd);
		if(cardName.equals("Castle")) {
			Castle castle = new Castle();
			card = (Castle) castle;
		}
//			Cemetery Cemetery = new Cemetery();
//			this.addToDeck(Cemetery);
//			Chapel Chapel = new Chapel();
//			this.addToDeck(Chapel);
//			Courthouse Courthouse = new Courthouse();
//			this.addToDeck(Courthouse);
//			Dungeon Dungeon = new Dungeon();
//			this.addToDeck(Dungeon);
		if(cardName.equals("Castle")) {
			EverTree everTree = new EverTree();
			card = (EverTree) everTree;
		}
//			Lookout Lookout = new Lookout();
//			this.addToDeck(Lookout);
//			Monastery Monastery = new Monastery();
//			this.addToDeck(Monastery);
		if(cardName.equals("Palace")) {
			Palace palace = new Palace();
			card = (Palace) palace;
		}
		if(cardName.equals("School")) {
			School school = new School();
			card = (School) school;
		}
		if(cardName.equals("Theater")) {
			Theater theater = new Theater();
			card = (Theater) theater;
		}
//			University University = new University();
//			this.addToDeck(University);
		if(cardName.equals("Barge Toad")) {
			BargeToad bargeToad = new BargeToad();
			card = (BargeToad) bargeToad;
		}
//			ChipSweep ChipSweep = new ChipSweep();
//			this.addToDeck(ChipSweep);
		if(cardName.equals("Historian")) {
			Historian historian = new Historian();
			card = (Historian) historian;
		}
		if(cardName.equals("Innkeeper")) {
			Innkeeper innkeeper = new Innkeeper();
			card = (Innkeeper) innkeeper;
		}
//			MinerMole MinerMole = new MinerMole();
//			this.addToDeck(MinerMole);
		if(cardName.equals("Peddler")) {
			Peddler peddler = new Peddler();
			card = (Peddler) peddler;
		}
//			PostalPigeon PostalPigeon = new PostalPigeon();
//			this.addToDeck(PostalPigeon);
		if(cardName.equals("Shopkeeper")) {
			Shopkeeper shopkeeper = new Shopkeeper();
			card = (Shopkeeper) shopkeeper;
		}
		if(cardName.equals("Teacher")) {
			Teacher teacher  = new Teacher();
			card = (Teacher) teacher;
		}
		if(cardName.equals("Wanderer")) {
			Wanderer wanderer = new Wanderer();
			card = (Wanderer) wanderer;
		}
		if(cardName.equals("Woodcarver")) {
			Woodcarver woodcarver = new Woodcarver();
			card = (Woodcarver) woodcarver;
		}
//			ClockTower ClockTower = new ClockTower();
//			this.addToDeck(ClockTower);
//			Crane Crane = new Crane();
//			this.addToDeck(Crane);
		if(cardName.equals("Fairgrounds")) {
			Fairgrounds fairGrounds = new Fairgrounds();
			card = (Fairgrounds) fairGrounds;
		}
		if(cardName.equals("General Store")) {
			GeneralStore generalStore = new GeneralStore();
			card = (GeneralStore) generalStore;
		}
//			Inn Inn = new Inn();
//			this.addToDeck(Inn);
		if(cardName.equals("Mine")) {
			Mine mine = new Mine();
			card = (Mine) mine;
		}
//			PostOffice PostOffice = new PostOffice();
//			this.addToDeck(PostOffice);
		if(cardName.equals("Resin Refinery")) {
			ResinRefinery resinRefinery = new ResinRefinery();
			card = (ResinRefinery) resinRefinery;
		}
		if(cardName.equals("Ruins")) {
			Ruins ruins = new Ruins();
			card = (Ruins) ruins;
		}
		if(cardName.equals("Storehouse")) {
			Storehouse storehouse = new Storehouse();
			card = (Storehouse) storehouse;
		}
		if(cardName.equals("Twig Barge")) {
			TwigBarge twigBarge = new TwigBarge();
			card = (TwigBarge) twigBarge;
		}
		if(cardName.equals("Husband")) {
			Husband husband = new Husband();
			card = (Husband) husband;
		}
		if(cardName.equals("Wife")) {
			Wife wife = new Wife();
			card = (Wife) wife;
		}
		if(cardName.equals("Farm")) {
			Farm farm = new Farm();
			card = (Farm) farm;
		}
		this.cards.add(card);
	}
	
	public Deck(String meadow, Deck deck) {
		this.typeOfPile = meadow;
		if(typeOfPile.equals("meadow")) {
			this.cards = new ArrayList<Card>();
			for (int i = 0; i < 8; i++) {
				Card randomCardFromDeck = deck.chooseRandomCard();
				this.cards.add(randomCardFromDeck);
				deck.takeFromDeck(randomCardFromDeck);
			}
		}
		else {
			System.out.println("You can create meadow only with a deck. Duh!");
		}
	}
	
	public void takeFromDeck(Card card) {
		this.cards.remove(card);
	}
	
	public String printDeckCardsName(Deck deck) {
		String inTheDeck = "";
		int counter = 0;
		for(Card card: deck.cards) {
			inTheDeck += card.name + " ";
			counter++;
			if(counter%10==0 && counter!=0) {
				inTheDeck += "\n";
			}
		}
		return inTheDeck;
	}
	
	public Card chooseRandomCard() {
		int n = this.cards.size();
		Random rand = new Random();
        int randomPosition = rand.nextInt(n);
        Card card = this.cards.get(randomPosition);
        return card;
	}
	
	public void printDeckDetails(Deck deck) {
		System.out.println(deck.cards.size() + " card in the " + deck.typeOfPile + ".\nThe pile:\n" + deck.printDeckCardsName(deck) + "\n");
	}
}
