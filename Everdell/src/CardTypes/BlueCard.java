package CardTypes;
import Main.Card;
import Main.Requirements;

public class BlueCard extends Card {
	public void effect(){
		System.out.println("The blue cards effect will be here.");
	};
	
	public BlueCard() {
		super("Courthouse", new Requirements(1,1,2,0),true,2,"Judge");
		this.effect();
	}
}
