package PurpleCritters;

import CardTypes.PurpleCard;
import Main.Requirements;
import Main.Town;

public class Wife extends PurpleCard{
	
	public boolean pairedWithHusband = false;
	
	public Wife() {
		super("Wife", new Requirements(0, 0, 0, 2), false, 2, "Farm");
	}
	
	public void activatePurpleCard(Town town){
		if(pairedWithHusband) {			
			town.addPoints(3);
		}
	}
	
	
}
