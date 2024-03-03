package Main;

import java.util.ArrayList;
import java.util.List;

public class Players {
	
	public List<Player> players;
	
	public Players() {
		this.players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void pointsOfPlayers() {
		for(Player player: players) {
//			String name = player.playersName;
			System.out.println("Player " + player.playersName);
			player.printPointsInTown(player);
		}
	}
}
