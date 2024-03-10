package com.digitalarcher.dani.everdell.cards.blueconstructions;

import com.digitalarcher.dani.everdell.main.*;

public class Courthouse extends BlueConstruction{

	public Courthouse() {
		super("Courthouse",new Requirements(1,1,2,0),true,2,"Judge");
	}
	
	public void blueCardEffect(Card cardToPlay, Player player, Deck deck){
		if(!cardToPlay.critter && !cardToPlay.name.equals(this.name)) {
			String resource = this.readResourceInput("add");
			if(resource.equals("twig") || resource.equals("resin") || resource.equals("pebble")) {
				player.requirements.addSpecificRequirementsToTown(player, resource,1);
				System.out.println("A " + this.name + " card is played by " + player.playersName + ".");
			}
			else {
				System.out.println("Resource " + resource + " can't be added to town.");
				this.blueCardEffect(cardToPlay, player, deck);
			}
		}
	}
}
