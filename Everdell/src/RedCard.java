
public class RedCard extends Card {
	
	public RedCard() {
		super("Inn", new Requirements(2,1,0,0),"RedCard",false,2);
	}
	
	public void activateRedCard() {
		System.out.println("It's activated.");
	}

}