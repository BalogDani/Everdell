package Main;

import java.util.ArrayList;
import java.util.List;

public class Players {
	
	public List<Town> players;
	
	public Players() {
		this.players = new ArrayList<Town>();
	}
	
	public void addPlayer(Town town) {
		this.players.add(town);
	}
	
	public void pointsOfPlayers() {
		for(Town player: players) {
//			String name = player.playersName;
			System.out.println("Player " + player.playersName);
			player.printPointsInTown(player);
		}
	}
}
