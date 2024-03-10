
import org.junit.Test;

import com.digirtalarcvher.dani.everdell.cards.greenconstructions.*;
import com.digirtalarcvher.dani.everdell.cards.greencritters.ChipSweep;
import com.digirtalarcvher.dani.everdell.cards.greencritters.Husband;
import com.digirtalarcvher.dani.everdell.cards.greencritters.MinerMole;
import com.digirtalarcvher.dani.everdell.cards.greencritters.Teacher;
import com.digirtalarcvher.dani.everdell.cards.purplecritters.Wife;
import com.digirtalarcvher.dani.everdell.cards.tanconstructions.Ruins;
import com.digirtalarcvher.dani.everdell.cards.tancritters.Fool;
import com.digirtalarcvher.dani.everdell.cards.tancritters.PostalPigeon;
import com.digirtalarcvher.dani.everdell.cards.tancritters.Wanderer;
import com.digirtalarcvher.dani.everdell.cardtypes.*;
import com.digirtalarcvher.dani.everdell.main.Card;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;
import com.digirtalarcvher.dani.everdell.main.Requirements;

public class FinalCardTests {
		
	@Test
	public void cardTest() {
		TanCard tanCard = new TanCard();
		tanCard.printCardDetails();
	}
	
	
	@Test
	public void sendWorkerTest() {
		Players players = new Players();
		Player newTown = new Player("Dani",players);
		newTown.requirements.sendWorkerForRequirements(newTown, 3, 0, 0, 0);
		newTown.requirements.sendWorkerForRequirements(newTown, 0, 0, 1, 0);
		newTown.requirements.sendWorkerForRequirements(newTown, 0, 2, 0, 0);
	}

	@Test
	public void sameUniqueCardPlayTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player newTown = new Player("Dani",players);
		newTown.requirements.sendWorkerForRequirements(newTown, 20, 20, 20, 20);
		TanCard tanCard = new TanCard();
		newTown.playACard(tanCard, players, newTown, deck);
		GreenCard greenCard = new GreenCard();
		newTown.playACard(greenCard, players, newTown, deck);
		newTown.playACard(tanCard, players, newTown, deck);
	}
	
	@Test
	public void deckTest() {
		Deck makeIt = new Deck("makeIt");
		Deck deck = new Deck("deck");
		Deck discard = new Deck("discard");
		deck.printDeckDetails(deck);
		discard.printDeckDetails(discard);
		System.out.println("After creating meadow:");
		Deck meadow = new Deck("meadow", deck);
		meadow.printDeckDetails(meadow);
		deck.printDeckDetails(deck);
		System.out.println("Random card from deck: " + deck.chooseRandomCard());
	}
}
