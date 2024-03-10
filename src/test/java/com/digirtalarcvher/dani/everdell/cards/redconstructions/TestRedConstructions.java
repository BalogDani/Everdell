package com.digirtalarcvher.dani.everdell.cards.redconstructions;


import org.junit.Test;

import com.digirtalarcvher.dani.everdell.cards.greenconstructions.Farm;
import com.digirtalarcvher.dani.everdell.cards.purpleconstructions.Castle;
import com.digirtalarcvher.dani.everdell.cards.redconstructions.Inn;
import com.digirtalarcvher.dani.everdell.cards.redcritters.Queen;
import com.digirtalarcvher.dani.everdell.cards.tanconstructions.Ruins;
import com.digirtalarcvher.dani.everdell.main.*;

public class TestRedConstructions {

	@Test
	public void innTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Deck meadow = new Deck("meadow", deck);
		Player dani = new Player("Dani",players);
		Player friendless = new Player("Friendless",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		deck.printDeckDetails(deck);
		Inn inn = new Inn();
		Inn innTwo = new Inn();	
		dani.playACard(inn, players, dani, deck);
		dani.printTownDetails();
		inn.activateRedDestination(dani, deck, meadow, players);
		dani.printTownDetails();
		System.out.println(dani.playersName + "'s special points: " + dani.specialPoints + "\n");
		meadow.printDeckDetails(meadow);
		dani.playACard(innTwo, players, dani, deck);
		dani.printTownDetails();
		innTwo.activateRedDestination(friendless, deck, meadow, players);
		System.out.println(dani.playersName + "'s special points: " + dani.specialPoints + "\n");
		dani.printTownDetails();
		innTwo.activateRedDestination(friendless, deck, meadow, players);
		System.out.println(dani.playersName + "'s special points: " + dani.specialPoints + "\n");
		dani.printTownDetails();
		friendless.printTownDetails();
		deck.printDeckDetails(deck);
		meadow.printDeckDetails(meadow);
		System.out.println("\nWorkers left at Dani " + dani.workers + " and at Tamas " + friendless.workers + ".");
	}
	
	@Test
	public void queenTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Deck meadow = new Deck("meadow", deck);
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Inn inn = new Inn();
		Farm farm = new Farm();
		Castle castle = new Castle();
		Queen queen = new Queen();	
		dani.playACard(queen, players, dani, deck);
		dani.printTownDetails();
		queen.activateRedDestinaton(castle, dani, deck, meadow, players);
		dani.printTownDetails();
		queen.activateRedDestinaton(inn, dani, deck, meadow, players);
		dani.printTownDetails();
		queen.activateRedDestinaton(farm, dani, deck, meadow, players);
		dani.printTownDetails();
		meadow.printDeckDetails(meadow);
	}
	
	@Test
	public void queenCardFromMeadowTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Deck meadow = new Deck("meadow", deck);
		Player dani = new Player("Dani",players);
		Player friendless = new Player("Friendless",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Farm farm = new Farm();
		Castle castle = new Castle();
		Queen queen = new Queen();
		Ruins ruins = new Ruins();
		dani.playACard(queen, players, dani, deck);
		dani.printTownDetails();
		queen.activateRedDestinaton(ruins, dani, deck, meadow, players);
		dani.printTownDetails();
		Card card = meadow.chooseACardFromMeadow(meadow);
		queen.activateRedDestinaton(card, dani, deck, meadow, players);
		dani.printTownDetails();
		meadow.printDeckDetails(meadow);
		queen.activateRedDestinaton(castle, dani, deck, meadow, players);
		dani.printTownDetails();
		queen.activateRedDestinaton(farm, dani, deck, meadow, players);
		dani.printTownDetails();
	}
}
