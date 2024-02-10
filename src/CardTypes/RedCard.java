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
	
	public boolean ownerOrAnotherPlayer(RedCard redCard, boolean open, Town town, Players players) {
		boolean isTheCardInTown = town.isTheCardInTown(redCard, town);
		boolean ownerCheck = false;
		
		if(!isTheCardInTown && !open) {
			System.out.println(redCard.name + " is not open, only the owner can use it.");
		}
		if(!isTheCardInTown && open) {
			for (Town player : players.players) {
				if(player.isTheCardInTown(redCard, player)) {
					ownerCheck = true;
					player.specialPoints++;
					System.out.println(player.playersName + "'s special points: " + player.specialPoints + "\n");
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