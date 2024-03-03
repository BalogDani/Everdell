package PurpleCritters;

import CardTypes.PurpleCard;
import Main.Requirements;
import Main.Player;

public class Wife extends PurpleCard{
	
	public boolean pairedWithHusband = false;
	
	public Wife() {
		super("Wife", new Requirements(0, 0, 0, 2), false, 2, "Farm");
	}
	
	public void activatePurpleCard(Player player){
		if(pairedWithHusband) {			
			player.addPoints(3);
		}
	}
	
}
