package Main;
import java.util.*;

import GreenConstructions.GreenConstruction;

public class Town {
	public String playersName;
	int workers;
	Requirements requirements;
	List<Card> cards;
	
	public Town(String playersName) {
		this.playersName = playersName;
		this.workers = 2;
		this.requirements = new Requirements(0,0,0,0);
		this.cards = new ArrayList<Card>();
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
	
	public void addRequirementsToTown(int twig, int resin, int pebble, int berry) {
		requirements.twig+=twig;
		requirements.resin+=resin;
		requirements.pebble+=pebble;
		requirements.berry+=berry;
//		printRequirementsInTown();
	}
	
	public void takeRequirementsFromTown(int twig, int resin, int pebble, int berry) {
		requirements.twig-=twig;
		requirements.resin-=resin;
		requirements.pebble-=pebble;
		requirements.berry-=berry;
//		printRequirementsInTown();
	}
	
	public void playACard(Card cardToPlay){
		boolean playable = true;
		boolean occupied = false;
		int n = cards.size();
		
		if(cardToPlay.cityLimit){
			playable = !isTheCardInTown(cardToPlay.name);
		}
		if(!playable) {			
			System.out.println(cardToPlay.name+" is already in your town.");
		}
		if(n<16 && playable) {
			if(occupieConstructionCardInTown(cardToPlay)) {
				playable = false;
				occupied = true;
			}
			if(playable && this.requirements.twig>=cardToPlay.requirements.twig && this.requirements.resin>=cardToPlay.requirements.resin && this.requirements.pebble>=cardToPlay.requirements.pebble && this.requirements.berry>=cardToPlay.requirements.berry) {
				cards.add(cardToPlay);
				cardToPlay.playCard(this);
				takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
				playable = false;
			}
			if(playable && !occupied) {
//			if(this.requirements.twig<cardToPlay.requirements.twig || this.requirements.resin<cardToPlay.requirements.resin || this.requirements.pebble<cardToPlay.requirements.pebble || this.requirements.berry<cardToPlay.requirements.berry) {
				System.out.println("You don't have enough requirements.");
			}
		}
		if(n==15) {
			System.out.println("Your town is full.");
		}
		printRequirementsInTown();
		printCardsInTown();
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
	
	public boolean occupieConstructionCardInTown(Card cardToplay) {
		boolean isCardPlayed = false;;
		for(Card card: cards) {
			if (card instanceof GreenConstruction && card.name==cardToplay.relatedCard) {
				GreenConstruction constructionCard = (GreenConstruction) card;
				if(!constructionCard.occupied) {					
					constructionCard.occupie(cardToplay.name);
					cards.add(cardToplay);
					isCardPlayed = true;
					break;
				}
			}
		}
		return isCardPlayed;
	}
	
	public void printCardsInTown() {
		String inTown = cards.size() + " card in " + this.playersName + "'s town: ";
		for(Card card: cards) {
			inTown += card.name + " ";
		}
		System.out.println(inTown);
	}
	
	public void printRequirementsInTown() {
		System.out.println("Twig: "+this.requirements.twig+", Resin: "+this.requirements.resin+", Pebble: "+this.requirements.pebble+", Berry: "+this.requirements.berry);
	}

}
