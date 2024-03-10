package com.digirtalarcvher.dani.everdell.cards.purpleconstructions;


import org.junit.Test;

import com.digirtalarcvher.dani.everdell.cards.greenconstructions.Fairgrounds;
import com.digirtalarcvher.dani.everdell.cards.purpleconstructions.Theater;
import com.digirtalarcvher.dani.everdell.cards.purplecritters.Architect;
import com.digirtalarcvher.dani.everdell.main.Deck;
import com.digirtalarcvher.dani.everdell.main.Player;
import com.digirtalarcvher.dani.everdell.main.Players;

public class TestPurpleContructions {
	
	@Test
	public void architectTheaterTest() {
		Players players = new Players();
		Deck deck = new Deck("deck");
		Player dani = new Player("Dani",players);
		dani.requirements.addRequirementsToTown(dani, 20, 20, 20, 20);
		dani.printTownDetails();
		System.out.println("Let's begin with 20 resource from everything!\n");
		Architect architect = new Architect();
		Fairgrounds fairgrounds = new Fairgrounds();
		Theater theater = new Theater();
		dani.playACard(architect, players, dani, deck);
		dani.playACard(theater, players, dani, deck);
		dani.playACard(fairgrounds, players, dani, deck);
		dani.printTownDetails();
	}
}
