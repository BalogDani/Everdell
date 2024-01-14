package Main;

import java.util.*;

import org.junit.Test;

import GreenConstructions.*;
import GreenCritters.*;
import PurpleCritters.*;
import TanCritters.*;


public class Deck {
	public List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		for (int i = 0; i < 2; i++) {
			Card Architect = new Architect();
			this.addToDeck(Architect);
//			Bard Bard = new Bard();
//			this.addToDeck(Bard);
//			Doctor Doctor = new Doctor();
//			this.addToDeck(Doctor);
			Fool Fool = new Fool();
			this.addToDeck(Fool);
//			Judge Judge = new Judge();
//			this.addToDeck(Judge);
//			King King = new King();
//			this.addToDeck(King);
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
//			Castle Castle = new Castle();
//			this.addToDeck(Castle);
//			Cemetery Cemetery = new Cemetery();
//			this.addToDeck(Cemetery);
//			Chapel Chapel = new Chapel();
//			this.addToDeck(Chapel);
//			Courthouse Courthouse = new Courthouse();
//			this.addToDeck(Courthouse);
//			Dungeon Dungeon = new Dungeon();
//			this.addToDeck(Dungeon);
//			EverTree EverTree = new EverTree();
//			this.addToDeck(EverTree);
//			Lookout Lookout = new Lookout();
//			this.addToDeck(Lookout);
//			Monastery Monastery = new Monastery();
//			this.addToDeck(Monastery);
//			Palace Palace = new Palace();
//			this.addToDeck(Palace);
//			School School = new School();
//			this.addToDeck(School);
//			Theater Theater = new Theater();
//			this.addToDeck(Theater);
//			University University = new University();
//			this.addToDeck(University);
		}
		for (int i = 0; i < 3; i++) {
//			BargeToad BargeToad = new BargeToad();
//			this.addToDeck(BargeToad);
//			ChipSweep ChipSweep = new ChipSweep();
//			this.addToDeck(ChipSweep);
//			Historian Historian = new Historian();
//			this.addToDeck(Historian);
//			Innkeeper Innkeeper = new Innkeeper();
//			this.addToDeck(Innkeeper);
//			MinerMole MinerMole = new MinerMole();
//			this.addToDeck(MinerMole);
//			Peddler Peddler = new Peddler();
//			this.addToDeck(Peddler);
//			PostalPigeon PostalPigeon = new PostalPigeon();
//			this.addToDeck(PostalPigeon);
//			Shopkeeper Shopkeeper = new Shopkeeper();
//			this.addToDeck(Shopkeeper);
//			Teacher Teacher = new Teacher();
//			this.addToDeck(Teacher);
//			Wanderer Wanderer = new Wanderer();
//			this.addToDeck(Wanderer);
//			Woodcarver Woodcarver = new Woodcarver();
//			this.addToDeck(Woodcarver);
//			ClockTower ClockTower = new ClockTower();
//			this.addToDeck(ClockTower);
//			Crane Crane = new Crane();
//			this.addToDeck(Crane);
//			FairGrounds FairGrounds = new FairGrounds();
//			this.addToDeck(FairGrounds);
//			GeneralStore GeneralStore = new GeneralStore();
//			this.addToDeck(GeneralStore);
//			Inn Inn = new Inn();
//			this.addToDeck(Inn);
			Mine Mine = new Mine();
			this.addToDeck(Mine);
//			PostOffice PostOffice = new PostOffice();
//			this.addToDeck(PostOffice);
			ResinRefinery ResinRefinery = new ResinRefinery();
			this.addToDeck(ResinRefinery);
//			ResinRefinery ResinRefinery = new ResinRefinery();
//			this.addToDeck(Ruins);
//			Storehouse Storehouse = new Storehouse();
//			this.addToDeck(Storehouse);
			TwigBarge TwigBarge = new TwigBarge();
			this.addToDeck(TwigBarge);
		}
		for (int i = 0; i < 4; i++) {
			Husband Husband = new Husband();
			this.addToDeck(Husband);
			Wife Wife = new Wife();
			this.addToDeck(Wife);
		}
		for (int i = 0; i < 8; i++) {
			Farm Farm = new Farm();
			this.addToDeck(Farm);
		}
		
	}
	
	public void addToDeck(Card card) {
		this.cards.add(card);
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
	
	@Test
	public void deckTest() {
		Deck deck = new Deck();
		String inTheDeck = deck.printDeckCardsName(deck);
		System.out.println(deck.cards.size() + " card in the deck.\n" + inTheDeck);
	}
}
