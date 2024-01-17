package GreenCritters;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Husband extends GreenCard{
	
	public boolean pairedWithWife = false;
	
	public Husband() {
		super("Husband", new Requirements(0, 0, 0, 3), false, 2, "Farm");
	}
	
	public void playCard(Town town, Deck deck){
		String resource = this.readResourceInput();
		if(town.isTheCardInArrayList("Farm", town.cards) && pairedWithWife) {
			if(resource.equals("twig") || resource.equals("resin") || resource.equals("pebble") || resource.equals("berry")) {
				town.addSpecificRequirementsToTown(resource,1);
				System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
			}
			else {
				this.playCard(town, deck);
			}
		}
		super.playCard(town, deck);
	}
	
	public String readResourceInput() {
		String resource = "";
		System.out.println("Select a type of resource: ");
		BufferedReader resourceInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			resource = resourceInput.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resource;
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}
