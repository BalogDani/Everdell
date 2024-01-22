package GreenConstructions;

import Main.Deck;
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
	
	public void playCard(Town town, Deck deck){
		activateGreenCard(town);
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town){
		town.addRequirementsToTown(0, 0, 0, 1);
	}
}