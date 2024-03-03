package Main;

import java.util.ArrayList;

public class Requirements implements InputOutput{
	public int twig;
	public int resin;
	public int pebble;
	public int berry;
	public String[] requirementsName = {"twig", "resin", "pebble", "berry"};
	
	public Requirements(int twig, int resin, int pebble, int berry) {
		this.twig = twig;
		this.resin = resin;
		this.pebble = pebble;
		this.berry = berry;
	}
	
	public ArrayList<String> availableResources(Card cardToPlay) {
		int twigOnCard = cardToPlay.requirements.twig;
		int resinOnCard = cardToPlay.requirements.resin;
		int pebbleOnCard = cardToPlay.requirements.pebble;
		int berryOnCard = cardToPlay.requirements.berry;
		ArrayList<String> requirementsName = new ArrayList<String>();
		if(twigOnCard>0) {			
			requirementsName.add("twig");
		}	
		if(resinOnCard>0) {
			requirementsName.add("resin");
		}
		if(pebbleOnCard>0) {
			requirementsName.add("pebble");
		}
		if(berryOnCard>0) {
			requirementsName.add("berry");
		}
		return requirementsName;
	}
	
	public void modifyRequirementsToPayForCard(String resourceName, Requirements requirementsToPayForCard, int quantity) {
		if(resourceName.equals("twig")) {
			requirementsToPayForCard.twig += quantity;
			if(requirementsToPayForCard.twig<0) {
				requirementsToPayForCard.twig=0;
			}
		}
		if(resourceName.equals("resin")){			
			requirementsToPayForCard.resin += quantity;
			if(requirementsToPayForCard.resin<0) {
				requirementsToPayForCard.resin=0;
			}
		}
		if(resourceName.equals("pebble")) {
			requirementsToPayForCard.pebble += quantity;
			if(requirementsToPayForCard.pebble<0) {
				requirementsToPayForCard.pebble=0;
			}
		}
		if(resourceName.equals("berry")) {
			requirementsToPayForCard.berry += quantity;
			if(requirementsToPayForCard.berry<0) {
				requirementsToPayForCard.berry=0;
			}
		}
	}
	
	public Requirements copyRequirementsToPayForCard(Requirements requirementsOnCard) {
		Requirements requirements = new Requirements(
				requirementsOnCard.twig,
				requirementsOnCard.resin,
				requirementsOnCard.pebble,
				requirementsOnCard.berry);
		return requirements;
	}
	
	public Requirements changeRequirements(Requirements requirements, Card card, Player player) {
		String resourceToAdd = "";
		String resourceToCheckToAdd = "";
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
//		Requirements newRequirements = cardToPlay.requirements;
		ArrayList<String> requirementsOnCard = availableResources(card);
		if(requirements.twig!=0 || requirements.resin!=0 || requirements.pebble!=0 || requirements.berry!=0) {
			while(!resourceToTake.equals(resourceToCheckForTake)) {
				resourceToTake = readResourceInput("take");
				for(String resourceName: requirementsOnCard) {
					resourceToCheckForTake = resourceName;
					if(resourceToTake.equals(resourceName)) {
						modifyRequirementsToPayForCard(resourceToTake, requirements, -1);
						while(!resourceToCheckToAdd.equals("added")) {
							resourceToAdd = readResourceInput("add");
							for(String resource: requirementsName) {
								resourceToCheckToAdd = resource;
								if(resourceToAdd.equals(resource)){
//									System.out.println(resourceToTake + " taken, " + resourceToAdd + " added.");
									resourceToCheckToAdd = "added";
									modifyRequirementsToPayForCard(resourceToAdd, requirements, 1);
									break;
								}
							}
						}
						break;
					}
					if(!isRequirementAtPlayer(player, resourceToTake)) {
						System.out.println("No " + resourceToTake + " on card, choose a valid resource.");
						resourceToCheckForTake = "";
						break;
					}
					if(!resourceToTake.equals(resourceName)) {
						resourceToCheckForTake = "";
					}
				}
			}
		}
		else {
			System.out.println("Changing of resources was unsuccessful.\n");
		}
		return requirements;
	}
	
	public Requirements decreaseRequirementsOnCard(Requirements requirements, int ammountOfSourceToTake, Card cardToPlay, Player player) {
		String resourceToTake = "";
		String resourceToCheckForTake = "twig";
		
		for(int i = 0; i < ammountOfSourceToTake; i++) {
			while(!resourceToTake.equals(resourceToCheckForTake)) {
				resourceToTake = readResourceInput("take");
				for(String resourceName: player.requirementsName) {
					resourceToCheckForTake = resourceName;
					if(resourceToTake.equals(resourceName) && isRequirementInRequirementsToPayForCard(resourceToTake, requirements)) {
						modifyRequirementsToPayForCard(resourceToTake, requirements, -1);
						System.out.println("Changed requirements to pay: Twig = " + requirements.twig + ", Resin = " + requirements.resin + ", Pebble = " + requirements.pebble + ", Berry = " + requirements.berry);
						break;
					}
					if(!isRequirementAtPlayer(player, resourceToTake) || !isRequirementInRequirementsToPayForCard(resourceToTake, requirements)) {
						System.out.println("No " + resourceToTake + " in card requirements, choose a another resource.");
						resourceToCheckForTake = "";
						break;
					}
				}
			}
			resourceToCheckForTake = "";
		}
		return requirements;
	}
	
	public boolean sendWorkerForRequirements(Player player, int twig, int resin, int pebble, int berry) {
		boolean workerSent = false;
		if(player.workers>0) {
			player.workers--;
			player.requirements.twig+=twig;
			player.requirements.resin+=resin;
			player.requirements.pebble+=pebble;
			player.requirements.berry+=berry;
			workerSent = true;
			System.out.println("Worker sent.");
		}
		else {
			System.out.println("No available workers in town");
		}
		player.printRequirementsInTown();
		return workerSent;
	}
	
	public void addSpecificRequirementsToTown(Player player, String resourceName, int quantity) {
		if(resourceName.equals("twig")) {
			player.requirements.twig += quantity;
		}
		if(resourceName.equals("resin")){			
			player.requirements.resin += quantity;
		}
		if(resourceName.equals("pebble")) {
			player.requirements.pebble += quantity;
		}
		if(resourceName.equals("berry")) {
			player.requirements.berry += quantity;
		}
	}
	
	public void addRequirementsToTown(Player player, int twig, int resin, int pebble, int berry) {
		player.requirements.twig+=twig;
		player.requirements.resin+=resin;
		player.requirements.pebble+=pebble;
		player.requirements.berry+=berry;
	}
	
	public void takeRequirementsFromTown(Player player, int twig, int resin, int pebble, int berry) {
		player.requirements.twig-=twig;
		player.requirements.resin-=resin;
		player.requirements.pebble-=pebble;
		player.requirements.berry-=berry;
	}
	
	public boolean isRequirementInRequirementsToPayForCard(String requirementName, Requirements requirementsToPayForCard) {
		if(requirementName.equals("twig")) {
			return requirementsToPayForCard.twig>0;
		}
		if(requirementName.equals("resin")) {
			return requirementsToPayForCard.resin>0;
		}
		if(requirementName.equals("pebble")) {
			return requirementsToPayForCard.pebble>0;
		}
		if(requirementName.equals("berry")) {
			return requirementsToPayForCard.berry>0;
		}
		return false;
	}
	
	public boolean isRequirementAtPlayer(Player player, String requirementName) {
		if(requirementName.equals("twig")) {
			return player.requirements.twig>0;
		}
		if(requirementName.equals("resin")) {
			return player.requirements.resin>0;
		}
		if(requirementName.equals("pebble")) {
			return player.requirements.pebble>0;
		}
		if(requirementName.equals("berry")) {
			return player.requirements.berry>0;
		}
		return false;
	}
}
