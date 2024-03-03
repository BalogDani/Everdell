package CardTypes;
import Main.*;

public class RedCard extends Card {
	
	public boolean open = false;
	
	public RedCard() {
		super("Inn", new Requirements(2,1,0,0),false,2,"Inkeeper");
	}
	
	public RedCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
	public boolean ownerOrAnotherPlayer(RedCard redCard, boolean open, Player player, Players players) {
		boolean isTheCardInTown = player.isTheCardInTown(redCard, player);
		boolean ownerCheck = false;
		
		if(!isTheCardInTown && !open) {
			System.out.println(redCard.name + " is not open, only the owner can use it.");
		}
		if(!isTheCardInTown && open) {
			for (Player playerFromPlayers : players.players) {
				if(playerFromPlayers.isTheCardInTown(redCard, playerFromPlayers)) {
					ownerCheck = true;
					playerFromPlayers.specialPoints++;
					System.out.println(playerFromPlayers.playersName + "'s special points: " + playerFromPlayers.specialPoints + "\n");
				}
			}
		}
		if(isTheCardInTown && open) {
			ownerCheck = true;
		}
		return ownerCheck;
	}
	
	public void activateRedDestinaton() {
		System.out.println("It's activated.");
	}

}