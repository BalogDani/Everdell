package com.digitalarcher.dani.everdell.cardtypes;
import java.util.ArrayList;

import com.digitalarcher.dani.everdell.cards.greenconstructions.*;
import com.digitalarcher.dani.everdell.cards.greencritters.BargeToad;
import com.digitalarcher.dani.everdell.cards.greencritters.ChipSweep;
import com.digitalarcher.dani.everdell.cards.greencritters.Doctor;
import com.digitalarcher.dani.everdell.cards.greencritters.Husband;
import com.digitalarcher.dani.everdell.cards.greencritters.MinerMole;
import com.digitalarcher.dani.everdell.cards.greencritters.Peddler;
import com.digitalarcher.dani.everdell.cards.greencritters.Teacher;
import com.digitalarcher.dani.everdell.cards.greencritters.Woodcarver;
import com.digitalarcher.dani.everdell.main.*;

public class GreenCard extends Card {
	
	public GreenCard() {
		this("Husband", new Requirements(0,0,0,2),false,2,"Farm");
	}
	
	public GreenCard(String name, Requirements requirements, Boolean cityLimit, int points, String relatedCard) {
		super(name,requirements,cityLimit,points,relatedCard);
	}
	
//	public void playCard(Player player, Deck deck, Players players){
//		System.out.println(this.name + " is played by " + player.playersName + ".");
//	}
	
	public void activateGreenCard(Player player){
		System.out.println("It's activated.");
	}
	
	public void activateChoosenGreenCard(Player playersTown, Player choosenTown, Deck deck, Players players) {
		Card choosenGreenCard = chooseGreenCardFromTheList(choosenTown);
		if(choosenGreenCard instanceof Fairgrounds) {
			Fairgrounds fairgrounds = (Fairgrounds) choosenGreenCard;
			fairgrounds.activateGreenCard(playersTown, deck);
		}
		if(choosenGreenCard instanceof Farm) {
			Farm farm = (Farm) choosenGreenCard;
			farm.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof GeneralStore) {
			GeneralStore generalStore = (GeneralStore) choosenGreenCard;
			generalStore.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof Mine) {
			Mine mine = (Mine) choosenGreenCard;
			mine.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof ResinRefinery) {
			ResinRefinery resinRefinery = (ResinRefinery) choosenGreenCard;
			resinRefinery.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof Storehouse) {
			Storehouse storehouse = (Storehouse) choosenGreenCard;
			storehouse.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof TwigBarge) {
			TwigBarge twigBarge = (TwigBarge) choosenGreenCard;
			twigBarge.activateGreenCard(playersTown);
		}
		
		if(choosenGreenCard instanceof BargeToad) {
			BargeToad bargeToad = (BargeToad) choosenGreenCard;
			bargeToad.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof ChipSweep) {
			ChipSweep chipSweep = (ChipSweep) choosenGreenCard;
			chipSweep.activateGreenCard(playersTown, deck, players);
		}
		if(choosenGreenCard instanceof Doctor) {
			Doctor doctor = (Doctor) choosenGreenCard;
			doctor.activateGreenCard(playersTown, deck);
		}
		if(choosenGreenCard instanceof Husband) {
			Husband husband = (Husband) choosenGreenCard;
			husband.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof MinerMole) {
			MinerMole minerMole = (MinerMole) choosenGreenCard;
			minerMole.activateGreenCard(playersTown, deck, players);
		}
		System.out.println("Monk needs to be implemented.");
//		if(choosenGreenCard instanceof Monk) {
//			Monk monk = (Monk) choosenGreenCard;
//			monk.activateGreenCard(playersTown);
//		}
		if(choosenGreenCard instanceof Peddler) {
			Peddler peddler = (Peddler) choosenGreenCard;
			peddler.activateGreenCard(playersTown);
		}
		if(choosenGreenCard instanceof Teacher) {
			Teacher teacher = (Teacher) choosenGreenCard;
			teacher.activateGreenCard(playersTown, deck, players);
		}
		if(choosenGreenCard instanceof Woodcarver) {
			Woodcarver woodcarver = (Woodcarver) choosenGreenCard;
			woodcarver.activateGreenCard(playersTown);
		}
	}
	
	public Card chooseGreenCardFromTheList(Player player) {
		String greenCardToTake = "greenCard";
		String greenCardToCheckForTake = "";
		String greenCardName = "";
		ArrayList<Card> greenCards = sortGreenCards(player);
		Card choosenGreenCard = new GreenCard();
		
		while(!greenCardToTake.equals(greenCardName)) {
			System.out.println("Choose a green card to activate:");
			greenCardToTake = readCardName();
			for (Card greenCard : greenCards) {
				greenCardToCheckForTake = greenCard.name;
				if(greenCardToTake.equals(greenCardToCheckForTake)) {
					greenCardName=greenCardToCheckForTake;
					choosenGreenCard = greenCard;
					System.out.println("");
					break;
				}
			}
		}

//		System.out.println(choosenGreenCard.name + " is choosed from chooseGreenCardFromTheList.");
		return choosenGreenCard;
	}

	public ArrayList<Card> sortGreenCards(Player player){
		ArrayList<Card> greenCards = new ArrayList<Card>();
		String nameOfGreenCards = "Available green cards: ";
		for(Card card: player.cards) {
			if(card instanceof GreenCard) {
				greenCards.add(card);
				nameOfGreenCards += card.name + " ";
			}
		}
		System.out.println(nameOfGreenCards);
		return greenCards;
	}
}
