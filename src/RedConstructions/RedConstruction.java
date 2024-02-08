package RedConstructions;

import CardTypes.*;
import Main.*;

public class RedConstruction extends RedCard implements Construction{
	
	public boolean occupied = false;
	public boolean open = false;
	public boolean workerSent = false;
	
	public RedConstruction(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
		super.notACritter();
	}
	
	public void occupie(String name) {
		this.occupied = true;
		System.out.println(super.name + " is occupied by " + name + ".");
	}
	
	public void activateRedDestination() {
		System.out.println("It's activated.");
	}

}