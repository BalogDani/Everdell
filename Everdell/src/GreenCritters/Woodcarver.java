package GreenCritters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Town;

public class Woodcarver extends GreenCard{
	
	public Woodcarver() {
		super("Woodcarver", new Requirements(0, 0, 0, 2), false, 2, "Storehouse");
	}
	
	public void playCard(Town town, Deck deck){
		System.out.println("Select the ammount of twigs to pay up to 3: ");
		BufferedReader ammountInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			int ammount = Integer.parseInt(ammountInput.readLine());
			if(ammount > 3) {
				ammount = 3;
			}
			town.addSpecificRequirementsToTown("twig", -ammount);
			town.specialPoints += ammount; 
			System.out.println("A " + this.name + " card is played by " + town.playersName + ", " + ammount + " twig is paid.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.playCard(town, deck);	
	}
	
	public void activateGreenCard(Town town, Deck deck){
		playCard(town, deck);
	}
}
