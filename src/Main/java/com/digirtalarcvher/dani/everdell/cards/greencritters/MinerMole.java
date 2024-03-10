package com.digirtalarcvher.dani.everdell.cards.greencritters;

import com.digirtalarcvher.dani.everdell.cardtypes.GreenCard;
import com.digirtalarcvher.dani.everdell.main.*;

public class MinerMole extends GreenCard{

	public MinerMole() {
		super("Miner Mole", new Requirements(0, 0, 0, 3), false, 2, "Mine");
	}
	
	public void playCard(Player player, Deck deck, Players players){
		activateGreenCard(player, deck, players);	
//		super.playCard(player, deck, players);
	}
	
	public void activateGreenCard(Player player, Deck deck, Players players){
		boolean anotherTownIsChoosed = false;
		String anotherPlayersTownName = chooseAnotherPlayersName();
		
		for(Player playerFromPlayers: players.players) {
			if(playerFromPlayers.playersName.equals(anotherPlayersTownName) && !anotherPlayersTownName.equals(player.playersName)) {
				activateChoosenGreenCard(player, playerFromPlayers, deck, players);
				anotherTownIsChoosed = true;
				break;
			}
		}
		if(!anotherTownIsChoosed) {
			this.activateGreenCard(player, deck, players);
		}
	}
}
