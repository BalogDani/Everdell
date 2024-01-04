import java.util.*;

public class Town {
	String playersName;
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
		printRequirementsInTown();
	}
	
	public void takeRequirementsFromTown(int twig, int resin, int pebble, int berry) {
		requirements.twig-=twig;
		requirements.resin-=resin;
		requirements.pebble-=pebble;
		requirements.berry-=berry;
		printRequirementsInTown();
	}
	
	public void playACard(Card cardToPlay){
		Boolean playable = true; 
		int n = cards.size();
		
		if(cardToPlay.cityLimit){
			for(Card card: cards) {
				if(card.name==cardToPlay.name) {
					System.out.println(cardToPlay.name+" is already in your town.");
					playable = false;
					break;
				}
			}
		}
		if(n<16 && playable==true && this.requirements.twig>=cardToPlay.requirements.twig && this.requirements.resin>=cardToPlay.requirements.resin && this.requirements.pebble>=cardToPlay.requirements.pebble && this.requirements.berry>=cardToPlay.requirements.berry) {
			cards.add(cardToPlay);
			takeRequirementsFromTown(cardToPlay.requirements.twig, cardToPlay.requirements.resin, cardToPlay.requirements.pebble, cardToPlay.requirements.berry);
		}
		if(this.requirements.twig<=cardToPlay.requirements.twig || this.requirements.resin<=cardToPlay.requirements.resin || this.requirements.pebble<=cardToPlay.requirements.pebble || this.requirements.berry<=cardToPlay.requirements.berry) {
			System.out.println("You don't have enough requirements.");
		}
		if(n==15) {
			System.out.println("Your town is full.");
		}
		printCardsInTown();
	}
	
	public void printCardsInTown() {
		String inTown = "";
		for(Card card: cards) {
			inTown += card.name + " ";
		}
		System.out.println(inTown);
	}
	
	public void printRequirementsInTown() {
		System.out.println("Twig: "+this.requirements.twig+", Resin: "+this.requirements.resin+", Pebble: "+this.requirements.pebble+", Berry: "+this.requirements.berry);
	}

}
