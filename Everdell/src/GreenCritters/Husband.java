package GreenCritters;

import java.util.Scanner;

import CardTypes.GreenCard;
import Main.Requirements;
import Main.Town;

public class Husband extends GreenCard{
	
	public boolean pairedWithWife = false;
	
	public Husband() {
		super("Husband", new Requirements(0, 0, 0, 3), false, 2, "Farm");
	}
	
	public void playCard(Town town){
		if(town.isTheCardInTown("Farm") && pairedWithWife) {
			System.out.println("Select a type of resource: ");
			try (Scanner scanner = new Scanner(System.in)) {
				String resource = scanner.next();
				town.addOneSpecificRequirementToTown(resource);
			}
		}
		System.out.println("A " + this.name + " card is played by " + town.playersName + ".");
	}
	
	public void activateGreenCard(Town town){
		playCard(town);
	}
}
