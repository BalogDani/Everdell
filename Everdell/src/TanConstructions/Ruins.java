package TanConstructions;

import Main.*;

public class Ruins extends TanConstruction{

	public Ruins() {
		super("Ruins", new Requirements(0, 0, 0, 0), false, 0, "Peddler");
	}
	
	public void playCard(Town town, Deck deck){
		boolean cardIsRemoved = town.removeCardFromTown("construction", deck);
		int decksLastIndex = deck.cards.size()-1;
		if(cardIsRemoved) {
			int twig = deck.cards.get(decksLastIndex).requirements.twig;
			int resin = deck.cards.get(decksLastIndex).requirements.resin;
			int pebble = deck.cards.get(decksLastIndex).requirements.pebble;
			town.addRequirementsToTown(twig, resin, pebble, 0);
		}
		super.playCard(town, deck);
	}

}
