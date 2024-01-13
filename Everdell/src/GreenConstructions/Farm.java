package GreenConstructions;

import Main.Requirements;
import Main.Town;

public class Farm extends GreenConstruction{
	
	public String secondRelatedCard;
	public boolean husbandOccupier = false;
	public boolean wifeOccupier = false;
	
	public Farm() {
		super("Farm",new Requirements(2,1,0,0),false,1,"Husband");
		this.secondRelatedCard = "Wife";
	}
	
	public void occupieHusband() {
		husbandOccupier = true;
	}
	
	public void occupieWife() {
		wifeOccupier = true;
	}
	
	public void playCard(Town town){
		town.addRequirementsToTown(0, 0, 0, 1);
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
	}
	
	public void activateGreenCard(Town town){
		playCard(town);
	}
}