package GreenConstructions;

import CardTypes.GreenCard;
import Main.Requirements;
import Main.Town;
import CardTypes.Construction;

public class Farm extends GreenCard implements Construction {
	
	public boolean occupied = false;
	
	public Farm() {
		super("Farm", new Requirements(2,1,0,0),false,1,"Husband","Wife");
		notACritter();
	}
	
	public void notACritter() {
		super.notACritter();
	}
	
	public boolean occupie() {
		this.occupied = true;
		return this.occupied;
	}
	
	public void playCard(Town town){
		town.addRequirementsToTown(0, 0, 0, 1);
	}
	
	public void activateGreenCard(Town town){
		town.addRequirementsToTown(0, 0, 0, 1);
	}
	
	public void printCardDetails() {
		super.printCardDetails();
		System.out.println("Occupied: " + occupied);
	}
}