
public class PurpleCard extends Card {
	
	public PurpleCard() {
		super("King", new Requirements(0,0,0,6),"PurpleCard",true,4);
	}
	
	public void activatePurpleCard() {
		System.out.println("It's activated.");
	}

}