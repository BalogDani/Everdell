package Main;
import java.util.*;

import GreenConstructions.Farm;
import GreenConstructions.GreenConstruction;
import GreenCritters.Husband;
import PurpleCritters.Wife;

public class Town {
	public String playersName;
	int workers;
	int spaces = 0;
	Requirements requirements;
	List<Card> cards;
	int points = 0;
	
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
	
	public void addOneSpecificRequirementToTown(String resourceName) {
		if(resourceName.equals("twig")) {
			requirements.twig++;
		}
		if(resourceName.equals("resin")){			
			requirements.resin++;
		}
		if(resourceName.equals("pebble")) {
			requirements.pebble++;
		}
		if(resourceName.equals("berry")) {
			requirements.berry++;
		}
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
//		boolean occupier = false;
		
		if(cardToPlay.cityLimit){
			playable = !isTheCardInTown(cardToPlay.name);
		}
		if(!playable) {			
			System.out.println(cardToPlay.name+" is already in your town.");
		}
		if(spaces<16 && playable) {
			if(occupieConstructionCardInTown(cardToPlay)) {
				playable = false;
//				occupier = true;
				spaces++;
			}
			if(playable && this.requirements.twig>=cardToPlay.requirements.twig && this.requirements.resin>=cardToPlay.requirements.resin && this.requirements.pebble>=cardToPlay.requirements.pebble && this.requirements.berry>=cardToPlay.requirements.berry) {
				cards.add(cardToPlay);
				cardToPlay.playCard(this);
				takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
				playable = false;
				spaces++;
			}
			if(playable 
//					&& !occupier
					) {
//			if(this.requirements.twig<cardToPlay.requirements.twig || this.requirements.resin<cardToPlay.requirements.resin || this.requirements.pebble<cardToPlay.requirements.pebble || this.requirements.berry<cardToPlay.requirements.berry) {
				System.out.println("You don't have enough requirements.");
			}
		}
		if(spaces==15) {
			System.out.println("Your town is full.");
		}
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
		boolean isCardPlayed = false;;
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
				if(!constructionCard.occupied) {					
					constructionCard.occupie(cardToPlay.name);
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
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public void printTownDetails(Town town) {
		printRequirementsInTown();
		printCardsInTown();
		printPointsInTown(town);
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
			this.points += card.points;
		}
		System.out.println("Points: " + points);
	}
}
