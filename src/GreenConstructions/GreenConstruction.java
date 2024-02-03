package GreenConstructions;

import CardTypes.Construction;
import CardTypes.GreenCard;
import Main.Requirements;

public class GreenConstruction extends GreenCard implements Construction{

	public boolean occupied = false;
	
	public GreenConstruction(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
		super.notACritter();
	}
	
	public void occupie(String name) {
		this.occupied = true;
		System.out.println(super.name + " is occupied by " + name + ".");
	}
	
	public void activateGreenCard(){
		System.out.println("It's activated.");
	}
}
