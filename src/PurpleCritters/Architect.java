package PurpleCritters;

import CardTypes.PurpleCard;
import Main.Requirements;
import Main.Town;

public class Architect extends PurpleCard{
	
	public Architect() {
		super("Architect", new Requirements(0, 0, 0, 4), true, 2, "Crane");
	}
	
	public void activatePurpleCard(Town town){
		int points = town.requirements.resin + town.requirements.pebble;
		if(points>6) {
			points = 6;
		}
		town.addPoints(points);
	}
}
