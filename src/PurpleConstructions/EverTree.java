package PurpleConstructions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CardTypes.PurpleCard;
import Main.*;

public class EverTree extends PurpleConstruction{
	
	public EverTree() {
		super("Ever Tree", new Requirements(3, 3, 3, 0), true, 5, "Any");
	}
	
	public void activatePurpleCard(Player player){
		for(Card card: player.cards) {
			if(card instanceof PurpleCard) {
				player.addPoints(1);
			}
		}
	}
	
	public String decideToOccupiesTheCritterToTown(Card card) {
		String yesOrNo = "";
		System.out.println("Will be " + card.name + " occupied in Ever Tree? ");
		BufferedReader answer = new BufferedReader(new InputStreamReader(System.in));
		try {
			yesOrNo = answer.readLine();
			return yesOrNo;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yesOrNo;
	}
}
