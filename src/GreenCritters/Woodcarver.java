package GreenCritters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CardTypes.GreenCard;
import Main.Deck;
import Main.Requirements;
import Main.Player;
import Main.Players;

public class Woodcarver extends GreenCard{
	
	public Woodcarver() {
		super("Woodcarver", new Requirements(0, 0, 0, 2), false, 2, "Storehouse");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player);
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player){
		System.out.println("Select the ammount of twigs to pay up to 3: ");
		BufferedReader ammountInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			int ammount = Integer.parseInt(ammountInput.readLine());
			if(ammount > 3) {
				ammount = 3;
			}
			player.requirements.addSpecificRequirementsToTown(player, "twig", -ammount);
			player.specialPoints += ammount; 
			System.out.println("A " + this.name + " card is played by " + player.playersName + ", " + ammount + " twig is paid.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
