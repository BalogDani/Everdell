
public class GreenCard extends Card {
	
	public GreenCard() {
		super("Farm", new Requirements(2,1,0,0),"GreenCard",false,1);
	}
	
	public void activateGreenCard() {
		System.out.println("It's activated.");
	}

}
