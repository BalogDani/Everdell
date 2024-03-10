package com.digitalarcher.dani.everdell.cards.purpleconstructions;

import com.digitalarcher.dani.everdell.cardtypes.Construction;
import com.digitalarcher.dani.everdell.cardtypes.PurpleCard;
import com.digitalarcher.dani.everdell.main.Requirements;

public abstract class PurpleConstruction extends PurpleCard implements Construction{

	public boolean occupied = false;
	
	public PurpleConstruction(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
		super.notACritter();
	}
	
	public void occupie(String name) {
		this.occupied = true;
		System.out.println(super.name + " is occupied by " + name + ".\n");
	}
	
}