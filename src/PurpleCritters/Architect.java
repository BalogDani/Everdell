package PurpleCritters;

import CardTypes.PurpleCard;
import Main.Requirements;
import Main.Player;

public class Architect extends PurpleCard{
	
	public Architect() {
		super("Architect", new Requirements(0, 0, 0, 4), true, 2, "Crane");
	}
	
	public void activatePurpleCard(Player player){
		int points = player.requirements.resin + player.requirements.pebble;
		if(points>6) {
			points = 6;
		}
		player.addPoints(points);
	}
}
