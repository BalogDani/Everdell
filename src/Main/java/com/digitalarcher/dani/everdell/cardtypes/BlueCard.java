package com.digitalarcher.dani.everdell.cardtypes;
import com.digitalarcher.dani.everdell.main.Card;
import com.digitalarcher.dani.everdell.main.Requirements;

public class BlueCard extends Card {
	public BlueCard() {
		super("Courthouse", new Requirements(1,1,2,0),true,2,"Judge");
		this.blueCardEffect();
	}
	
	public BlueCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
	public void blueCardEffect(){
		System.out.println("The blue card effect will be here.");
	}
}
