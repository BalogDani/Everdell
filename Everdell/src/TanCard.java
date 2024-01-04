
public class TanCard extends Card {
	
	public TanCard() {
		super("Ranger", new Requirements(0,0,0,2),"TanCard",true,1);
	}
	
	public void activateTanCard() {
		System.out.println("It's activated.");
	}

}
