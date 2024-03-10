package com.digirtalarcvher.dani.everdell.cards.tanconstructions;

import com.digirtalarcvher.dani.everdell.cardtypes.*;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class TanConstruction extends TanCard implements Construction{

	public boolean occupied = false;
	
	public TanConstruction(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
		super.notACritter();
	}
	
	public void occupie(String name) {
		this.occupied = true;
		System.out.println(super.name + " is occupied by " + name + ".");
	}
	
}
