package com.digirtalarcvher.dani.everdell.cards.greencritters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.digirtalarcvher.dani.everdell.cardtypes.GreenCard;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class Doctor extends GreenCard{
	
	public Doctor() {
		super("Doctor", new Requirements(0, 0, 0, 4), true, 4, "University");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player, deck);	
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player, Deck deck){
		System.out.println("Select the ammount of berries to pay up to 3: ");
		BufferedReader ammountInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			int ammount = Integer.parseInt(ammountInput.readLine());
			if(ammount > 3) {
				ammount = 3;
			}
			player.requirements.addSpecificRequirementsToTown(player, "berry", -ammount);
			player.specialPoints += ammount; 
			System.out.println("A " + this.name + " card is played by " + player.playersName + ", " + ammount + " berry is paid.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
