package GreenCritters;

import CardTypes.GreenCard;
import Main.*;

public class MinerMole extends GreenCard{

	public MinerMole() {
		super("Miner Mole", new Requirements(0, 0, 0, 3), false, 2, "Mine");
	}
	
	public void playCard(Town town, Deck deck, Players players){
		activateGreenCard(town, deck, players);	
		super.playCard(town, deck);
	}
	
	public void activateGreenCard(Town playersTown, Deck deck, Players players){
		boolean anotherTownIsChoosed = false;
		String anotherPlayersTownName = chooseAnotherTownName();
		
		for(Town player: players.players) {
			if(player.playersName.equals(anotherPlayersTownName) && !anotherPlayersTownName.equals(playersTown.playersName)) {
				activateChoosenGreenCard(playersTown, player, deck, players);
				anotherTownIsChoosed = true;
				break;
			}
		}
		if(!anotherTownIsChoosed) {
			this.activateGreenCard(playersTown, deck, players);
		}
	}
}
