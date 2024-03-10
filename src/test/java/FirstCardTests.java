import org.junit.Test;

import com.digirtalarcvher.dani.everdell.cardtypes.GreenCard;

public class FirstCardTests {

//	@Test
//	public void cardTests() {
//		Card myFirstCard = new Card();
//		myFirstCard.printCardname();
//	}
//	
//	@Test
//	public void cardTests2() {
//		new Card("Church").printCardname();
//	}
	
	@Test
	public void cardTest3() {
		GreenCard greenCard = new GreenCard();
		greenCard.printCardDetails();
		
//		((GreenCard) greenCard).activateGreenCard();
		
//		greenCard = new Card("Judge");
//		((GreenCard) greenCard).activateGreenCard();
	}
//	
//	@Test
//	public void cardBlueTest() {
//		BlueCard blueCard = new BlueCard();
//		blueCard.printCardDetails();
//	}
}
