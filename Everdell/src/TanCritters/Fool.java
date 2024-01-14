package TanCritters;

import org.junit.Test;

import CardTypes.TanCard;
import GreenConstructions.Farm;
import Main.Players;
import Main.Requirements;
import Main.Town;

public class Fool extends TanCard{

	public Fool() {
		super("Fool", new Requirements(0, 0, 0, 3), true, -2, "Fairgrounds");
	}
	
	public void playCard(String anotherPlayersTownName, Town playersTown, Players players) {
		boolean anotherTownIsChoosed = false;
		for(Town player: players.players) {
			if(player.playersName.equals(anotherPlayersTownName) && !anotherPlayersTownName.equals(playersTown.playersName)) {
				player.cards.add(this);
				anotherTownIsChoosed = true;
				break;
			}
		}
		if(!anotherTownIsChoosed) {
			playersTown.playACard(this, players);
		}
	}
	
	@Test
	public void foolTest() {
		Players players = new Players();
		Town dani = new Town("Dani",players);
		dani.addRequirementsToTown(20, 20, 20, 20);
		Town friendless = new Town("Friendless",players);
		friendless.addRequirementsToTown(20, 20, 20, 20);
		Fool Fool = new Fool();
		Farm farm = new Farm();
		dani.playACard(Fool);
		friendless.playACard(farm);
		dani.playACard(Fool,players);
		dani.printTownDetails();
		friendless.printTownDetails();
		players.pointsOfPlayers();
	}
}
