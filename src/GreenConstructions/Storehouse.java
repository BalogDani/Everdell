package GreenConstructions;

import Main.*;

public class Storehouse extends GreenConstruction{
	
	Requirements store = new Requirements(0, 0, 0, 0);
	boolean workerIsPlaced = false;

	public Storehouse() {
		super("Storehouse", new Requirements(1,1,1,0),false,2,"Woodcarver");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);	
		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
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
			System.out.println("Resource " + resource + " can't be added to player.");
			this.activateGreenCard(player);
		}
		printStoredResources(player.playersName);
	}
	
	public void emptyingStorehouse(String playersTownName, Player player, Players players) {
		if(!workerIsPlaced) {			
			for(Player playerFromPlayers: players.players) {
				if(playerFromPlayers.playersName.equals(playersTownName) && playerFromPlayers==player) {
					boolean workerSent = playerFromPlayers.requirements.sendWorkerForRequirements(player, store.twig, store.resin, store.pebble, store.berry);
					if(workerSent) {
						store = new Requirements(0,0,0,0);
						workerIsPlaced = true;
					}
					break;
				}
				else {
					System.out.println(player.playersName + " can't activate " + playersTownName + "'s storehouse. Duh!\n");
					break;
				}
			}
		}
		else {
			System.out.println("A worker already emptied Storehouse before.");
			printStoredResources(playersTownName);
		}
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
