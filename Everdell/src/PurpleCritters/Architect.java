package PurpleCritters;

import org.junit.Test;

import CardTypes.PurpleCard;
import Main.Players;
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
	
	@Test
	public void farmTest() {
		Players players = new Players();
		Town newTown = new Town("Dani",players);
		newTown.addRequirementsToTown(20, 20, 20, 20);
		newTown.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Architect Architect = new Architect();
		newTown.playACard(Architect);
		newTown.printTownDetails();
	}
}
