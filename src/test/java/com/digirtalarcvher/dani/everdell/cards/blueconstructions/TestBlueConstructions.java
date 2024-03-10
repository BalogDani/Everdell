package com.digirtalarcvher.dani.everdell.cards.blueconstructions;


import org.junit.Test;

import com.digirtalarcvher.dani.everdell.cards.blueconstructions.Courthouse;
import com.digirtalarcvher.dani.everdell.cards.blueconstructions.Crane;
import com.digirtalarcvher.dani.everdell.cards.bluecritters.Historian;
import com.digirtalarcvher.dani.everdell.cards.bluecritters.Innkeeper;
import com.digirtalarcvher.dani.everdell.cards.bluecritters.Judge;
import com.digirtalarcvher.dani.everdell.cards.bluecritters.Shopkeeper;
import com.digirtalarcvher.dani.everdell.cards.greenconstructions.Farm;
import com.digirtalarcvher.dani.everdell.cards.greenconstructions.GeneralStore;
import com.digirtalarcvher.dani.everdell.cards.greenconstructions.Mine;
import com.digirtalarcvher.dani.everdell.cards.purpleconstructions.Palace;
import com.digirtalarcvher.dani.everdell.cards.purplecritters.Wife;
import com.digirtalarcvher.dani.everdell.cards.tanconstructions.Ruins;
import com.digirtalarcvher.dani.everdell.cards.tancritters.Wanderer;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;

public class TestBlueConstructions {

	@Test
	public void shopkeeperHistorianTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Wanderer wanderer = new Wanderer();
		GeneralStore generalStore = new GeneralStore();
		Shopkeeper shopkeeper = new Shopkeeper();
		Wife wife = new Wife();
		Historian historian = new Historian();
		Wanderer wandererTwo = new Wanderer();
		Mine mine = new Mine();
		dani.playACard(wanderer, players, dani, deck);
		dani.playACard(generalStore, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(shopkeeper, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(historian, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(wife, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(wandererTwo, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
		dani.playACard(mine, players, dani, deck);
		dani.printTownDetails();
		dani.printHand();
	}
	
	@Test
	public void courthouseTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		GeneralStore generalStore = new GeneralStore();
		Courthouse courthouse = new Courthouse();
		Farm farm = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(generalStore, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(courthouse, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(farm, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(wanderer, players, dani, deck);
		dani.printTownDetails();
	}
	
	@Test
	public void bluCardsBeforeOtherCardsTest() throws Exception {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Judge judge = new Judge();
		Innkeeper innkeeper = new Innkeeper();
		Crane crane = new Crane();
		GeneralStore generalStore = new GeneralStore();
		Ruins ruins = new Ruins();
		Palace palace = new Palace();
		dani.playACard(judge, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(crane, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(generalStore, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(innkeeper, players, dani, deck);
		dani.printTownDetails();
		Farm farm = new Farm();
		Wanderer wanderer = new Wanderer();
		dani.playACard(palace, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(farm, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(ruins, players, dani, deck);
		dani.printTownDetails();
		dani.playACard(wanderer, players, dani, deck);
		dani.printTownDetails();
	}
	
}
