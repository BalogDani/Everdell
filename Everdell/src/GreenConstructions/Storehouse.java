package GreenConstructions;

import Main.*;

public class Storehouse extends GreenConstruction{
	
	Requirements store = new Requirements(0, 0, 0, 0);
	boolean workerIsPlaced = false;

	public Storehouse() {
		super("Storehouse", new Requirements(1,1,1,0),false,2,"Woodcarver");
	}
	
	public void playCard(Town town, Deck deck){
		activateGreenCard(town);	
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town town){
		String resource = this.readResourceInput("add");
		if(resource.equals("twig")) {
			addSpecificRequirementsToStore(resource);
			System.out.println("Stored " + resource + ".");
		}
		if(resource.equals("resin")) {
			addSpecificRequirementsToStore(resource);
			System.out.println("Stored " + resource + ".");
		}
		if(resource.equals("pebble")) {
			addSpecificRequirementsToStore(resource);
			System.out.println("Stored " + resource + ".");
		}
		if(resource.equals("berry")) {
			addSpecificRequirementsToStore(resource);
			System.out.println("Stored " + resource + ".");
		}
		if(!resource.equals("twig") && !resource.equals("resin") && !resource.equals("pebble") && !resource.equals("berry")) {
			System.out.println("Resource " + resource + " can't be added to town.");
			this.activateGreenCard(town);
		}
		printStoredResources(town.playersName);
	}
	
	public void emptyingStorehouse(String playersTownName, Town playersTown, Players players) {
		for(Town player: players.players) {
			if(player.playersName.equals(playersTownName) && player==playersTown) {
				boolean workerSent = player.sendWorkerForRequirements(store.twig, store.resin, store.pebble, store.berry);
				if(workerSent) {
					store = new Requirements(0,0,0,0);					
				}
				break;
			}
			else {
				System.out.println(playersTown.playersName + " can't activate " + playersTownName + "'s storehouse. Duh!\n");
				break;
			}
		}
		printStoredResources(playersTownName);
	}
	
	public void addSpecificRequirementsToStore(String resourceName) {
		if(resourceName.equals("twig")) {
			store.twig += 3;
		}
		if(resourceName.equals("resin")){			
			store.resin += 2;
		}
		if(resourceName.equals("pebble")) {
			store.pebble += 1;
		}
		if(resourceName.equals("berry")) {
			store.berry += 2;
		}
	}
	
	public void printStoredResources(String playersTownName) {
		System.out.println(playersTownName + "'s storehouse contains:");
		System.out.println("Twig: "+this.store.twig+", Resin: "+this.store.resin+", Pebble: "+this.store.pebble+", Berry: "+this.store.berry + "\n");
	}
}
