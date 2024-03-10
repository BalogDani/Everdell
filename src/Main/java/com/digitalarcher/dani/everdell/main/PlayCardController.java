package com.digitalarcher.dani.everdell.main;

import com.digitalarcher.dani.everdell.cards.blueconstructions.BlueConstruction;
import com.digitalarcher.dani.everdell.cards.blueconstructions.Courthouse;
import com.digitalarcher.dani.everdell.cards.blueconstructions.Crane;
import com.digitalarcher.dani.everdell.cards.bluecritters.Historian;
import com.digitalarcher.dani.everdell.cards.bluecritters.Innkeeper;
import com.digitalarcher.dani.everdell.cards.bluecritters.Judge;
import com.digitalarcher.dani.everdell.cards.bluecritters.Shopkeeper;
import com.digitalarcher.dani.everdell.cards.greenconstructions.Farm;
import com.digitalarcher.dani.everdell.cards.greenconstructions.GreenConstruction;
import com.digitalarcher.dani.everdell.cards.greencritters.Husband;
import com.digitalarcher.dani.everdell.cards.purpleconstructions.EverTree;
import com.digitalarcher.dani.everdell.cards.purpleconstructions.PurpleConstruction;
import com.digitalarcher.dani.everdell.cards.purplecritters.Wife;
import com.digitalarcher.dani.everdell.cards.tanconstructions.Ruins;
import com.digitalarcher.dani.everdell.cards.tanconstructions.TanConstruction;
import com.digitalarcher.dani.everdell.cards.tancritters.Fool;
import com.digitalarcher.dani.everdell.cards.tancritters.Wanderer;
import com.digitalarcher.dani.everdell.cardtypes.Construction;

public interface PlayCardController{
	
	default boolean uniqueCheck(Card cardToPlay, Player player) {
		boolean playable = true;
		if(cardToPlay.cityLimit){
			playable = !player.isTheCardInArrayList(cardToPlay.name, player.cards);	
			if(!playable) {				
				System.out.println(cardToPlay.name + " is already in your town.");
			}
		}
		return playable;
	}
	
	default boolean outOfTownLimitCheck(Card cardToPlay, Player player){
		boolean outOfTownLimit = false;
		if(player.spaces==15) {
			outOfTownLimit = true;
		}
		if(outOfTownLimit) {
			if(cardToPlay instanceof Wanderer) {
				outOfTownLimit = false;
				System.out.println("Your town is full, but a Wanderer still can be played.");
			}
			if(cardToPlay instanceof Wife) {
				for(Card card: player.cards) {
					if(card instanceof Husband) {
						Husband husband = (Husband) card;
						if(!husband.pairedWithWife) {
							outOfTownLimit = false;
							break;
						}
					}
				}
				System.out.println("Your town is full, but a Wife still can be paired with a Husband.");
			}
			if(cardToPlay instanceof Husband) {
				for(Card card: player.cards) {
					if(card instanceof Wife) {
						Wife wife = (Wife) card;
						if(!wife.pairedWithHusband) {
							outOfTownLimit = false;
							break;
						}
					}
				}
				System.out.println("Your town is full, but a Husband still can be paired with a Wife.");
			}
			if(cardToPlay instanceof Ruins) {
				outOfTownLimit = false;
				System.out.println("Your town is full, but a Ruins still can be played.");
			}
			if(cardToPlay instanceof Fool) {
				outOfTownLimit = false;
				System.out.println("Your town is full, but a Fool still can be played to another town.");
			}
			for(Card card: player.cards) {
				if(card instanceof Crane) {
					outOfTownLimit = false;
					System.out.println("Your town is full, but your Crane still can be used.");
					break;				
				}
				if(card instanceof Innkeeper) {
					outOfTownLimit = false;
					System.out.println("Your town is full, but your Innkeeper still can be used.");
					break;
				}
//			if(card instanceof Dungeon) {
//				outOfTownLimit = false;
//				System.out.println("Your town is full, but your Dungeon still can be used.");
//				break;
//			}
			}
		}
		return outOfTownLimit;
	}
	
	default boolean occupieConstructionCardInTown(Card cardToPlay, Player player, Deck deck, Players players) {
		boolean isCardPlayed = false;
		boolean playable = true;
		
		for(Card card: player.cards) {
			if (card instanceof EverTree && cardToPlay.critter) {
				EverTree everTree = (EverTree) card;
				if(!everTree.occupied) {
					String yesOrNo = "";
					while(!yesOrNo.equals("Yes") && !yesOrNo.equals("No")) {
						yesOrNo = everTree.decideToOccupiesTheCritterToTown(cardToPlay);
						if(yesOrNo.equals("Yes")) {
							everTree.occupie(cardToPlay.name);
//							player.cards.add(cardToPlay);
							isCardPlayed = true;
						}
						if(yesOrNo.equals("No")) {
							System.out.println(cardToPlay.name + " is not occupied in Ever Tree.");
						}
						if(!yesOrNo.equals("Yes") && !yesOrNo.equals("No")) {
							System.out.println("Please choose a correct answer 'Yes' or 'No'.");
						}
					}
					break;
				}
			}
			if (card instanceof Farm && card.name==cardToPlay.relatedCard) {
				Farm farm = (Farm) card;
				if(!farm.occupied && cardToPlay.name=="Husband") {
					farm.occupie("Husband");
					farm.occupieHusband();
//					player.cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
				if(!farm.occupied && cardToPlay.name=="Wife") {
					farm.occupie("Wife");
					farm.occupieWife();
//					player.cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof GreenConstruction && card.name==cardToPlay.relatedCard) {
				GreenConstruction greenConstructionCard = (GreenConstruction) card;
				if((cardToPlay instanceof Fool) && !greenConstructionCard.occupied) {
					greenConstructionCard.occupie(cardToPlay.name);
					isCardPlayed = true;
					break;
				}
				if(!greenConstructionCard.occupied) {					
					greenConstructionCard.occupie(cardToPlay.name);
//					player.cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof BlueConstruction && card.name==cardToPlay.relatedCard) {
				BlueConstruction blueConstructionCard = (BlueConstruction) card;
				if(!blueConstructionCard.occupied) {					
					blueConstructionCard.occupie(cardToPlay.name);
//					player.cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof TanConstruction && card.name==cardToPlay.relatedCard) {
				TanConstruction tanConstructionCard = (TanConstruction) card;
				if(!tanConstructionCard.occupied) {					
					tanConstructionCard.occupie(cardToPlay.name);
//					player.cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
			if (card instanceof PurpleConstruction && card.name==cardToPlay.relatedCard) {
				PurpleConstruction purpleConstructionCard = (PurpleConstruction) card;
				if(!purpleConstructionCard.occupied) {					
					purpleConstructionCard.occupie(cardToPlay.name);
//					player.cards.add(cardToPlay);
					isCardPlayed = true;
					break;
				}
			}
		}
		
//		for(Card card: player.cards) {
//			if (card instanceof Farm && card.name==cardToPlay.relatedCard) {
//				Farm farm = (Farm) card;
//				if(farm.occupied && !farm.husbandOccupier) {
//					farm.occupieHusband();
//					pairWithPartner(cardToPlay, player);
////					player.spaces--;
//					break;
//				}
//				if(farm.occupied && !farm.wifeOccupier) {
//					farm.occupieWife();
//					pairWithPartner(cardToPlay, player);
////					player.spaces--;
//					break;
//				}
//			}
//		}
		
		if(isCardPlayed) {
			addCardToTown(player, cardToPlay, players, deck, new Requirements(0,0,0,0));
			cardEffect(playable, cardToPlay, player, deck, players);
			playable = false;
		}
		
		return playable;
	}
	
	default void pairWithPartner(Card cardToPlay, Player player) {
		for(Card card: player.cards) {
			if (card instanceof Husband && cardToPlay instanceof Wife) {
				Husband husband = (Husband) card;
				Wife wife = (Wife) cardToPlay;
				if(!husband.pairedWithWife) {
					husband.pairedWithWife = true;
					wife.pairedWithHusband = true;
					player.spaces--;
				}
			}
			if (card instanceof Wife && cardToPlay instanceof Husband) {
				Wife wife = (Wife) card;
				Husband husband = (Husband) cardToPlay;
				if(!wife.pairedWithHusband) {
					wife.pairedWithHusband = true;
					husband.pairedWithWife = true;
					player.spaces--;
				}
			}
		}
	}
	
//	default List<BlueCard> resourceCheck(Player player, Card cardToPlay){
//		Requirements requirementsToPayForCard = cardToPlay.requirements.copyRequirementsToPayForCard(cardToPlay.requirements);
//		
//		if(player.requirements.twig<=requirementsToPayForCard.twig || 
//				player.requirements.resin<=requirementsToPayForCard.resin || 
//				player.requirements.pebble<=requirementsToPayForCard.pebble || 
//				player.requirements.berry<=requirementsToPayForCard.berry) {
//			
//		}
//	}
	
	default Requirements checkBlueCardsBeforePlayingACard(Requirements requirementsToPayForCard, Card cardToPlay, Deck deck, Player player) {
		boolean usedBlueCardEffect = false;
		
		for(Card card: player.cards) {
			if(card instanceof Judge) {
				Judge judge = (Judge) card;
				usedBlueCardEffect = judge.blueCardEffect(requirementsToPayForCard, cardToPlay, player);
				if(usedBlueCardEffect) {
					break;
				}
			}
			if(!usedBlueCardEffect && card instanceof Innkeeper) {
				Innkeeper innkeeper = (Innkeeper) card;
				usedBlueCardEffect = innkeeper.blueCardEffect(requirementsToPayForCard, cardToPlay, player, deck);
				if(usedBlueCardEffect) {
					break;
				}
			}
			if(!usedBlueCardEffect && card instanceof Crane) {
				Crane crane = (Crane) card;
				usedBlueCardEffect = crane.blueCardEffect(requirementsToPayForCard, cardToPlay, player, deck);
				if(usedBlueCardEffect) {
					break;
				}
			}
//			if(card instanceof Dungeon) {
//				Dungeon dungeon = (Dungeon) card;
//				usedBlueCardEffect = dungeon.blueCardEffect(requirementsToPayForCard, cardToPlay, player, deck);
//				if(usedBlueCardEffect) {
//					break;
//				}
//			}
		}
		return requirementsToPayForCard;
	}
	
	default boolean payResources(Player player, Requirements requirementsToPayForCard, Card cardToPlay) {
		boolean playable = true;
		if(player.requirements.twig>=requirementsToPayForCard.twig && 
				player.requirements.resin>=requirementsToPayForCard.resin && 
				player.requirements.pebble>=requirementsToPayForCard.pebble && 
				player.requirements.berry>=requirementsToPayForCard.berry) {
			if(!(cardToPlay instanceof Fool)) {				
				requirementsToPayForCard.takeRequirementsFromTown(player, requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
			}
		}
		else {
			System.out.println("You don't have enough requirements.");
			playable = false;
		}
		return playable;
	}
	
	default void addCardToTown(Player player, Card cardToPlay, Players players, Deck deck, Requirements requirementsToPayForCard) {
		boolean ruinsCanBePlayed = false;
		boolean foolIsPlayed = false;
		
		if(cardToPlay instanceof Fool) {
			Fool fool = (Fool) cardToPlay;
			foolIsPlayed = fool.playFoolToAnotherTown(cardToPlay, player, players, deck);
			if(foolIsPlayed) {
				requirementsToPayForCard.takeRequirementsFromTown(player, requirementsToPayForCard.twig, requirementsToPayForCard.resin, requirementsToPayForCard.pebble, requirementsToPayForCard.berry);
			}
			player.spaces--;
		}
		if(cardToPlay instanceof Ruins) {
			Ruins ruins = (Ruins) cardToPlay;
			for(Card card: player.cards) {
				if(card instanceof Construction) {
					ruins.playCard(player, deck, players);
					ruinsCanBePlayed = ruins.isRuinsUsed;
					break;
				}
			}
			if(!ruinsCanBePlayed) {
				System.out.println("You have no construction in your town. Ruins can't be played.");
				player.spaces--;
			}
		}
		if(cardToPlay instanceof Wife) {
			for(Card card: player.cards) {
				if (card instanceof Husband) {
					Husband husband = (Husband) card;
					if(!husband.pairedWithWife) {
						pairWithPartner(cardToPlay, player);
//						player.spaces--;
						break;
					}
				}
			}
		}
		if(cardToPlay instanceof Husband) {
			for(Card card: player.cards) {
				if (card instanceof Wife) {
					Wife wife = (Wife) card;
					if(!wife.pairedWithHusband) {
						pairWithPartner(cardToPlay, player);
//						player.spaces--;
						break;
					}
				}
			}
		}
		if(cardToPlay instanceof Ruins && ruinsCanBePlayed) {
			player.cards.add(cardToPlay);
		}
		if(!(cardToPlay instanceof Fool) && !(cardToPlay instanceof Ruins)) {
			player.cards.add(cardToPlay);
		}
		player.spaces++;
	}
	
	default boolean cardEffect(boolean playable, Card cardToPlay, Player player, Deck deck, Players players) {
		if(playable) {
			if(playable && cardToPlay instanceof Wanderer) {
				player.spaces--;
			}
			if(!(cardToPlay instanceof Fool) && !(cardToPlay instanceof Ruins)) {			
				cardToPlay.playCard(player, deck);
				cardToPlay.playCard(player, deck, players);
			}
			playable = false;
		}
		return playable;
	}
	
	default void checkBlueCardsAfterPlayingACard(Player player, Card cardToPlay, Deck deck) {
		for(Card card: player.cards) {
			if(card instanceof Shopkeeper) {
				Shopkeeper shopkeeper = (Shopkeeper) card;
				shopkeeper.blueCardEffect(cardToPlay, player);
			}
			if(card instanceof Historian) {
				Historian historian = (Historian) card;
				historian.blueCardEffect(cardToPlay, player, deck);
			}
			if(card instanceof Courthouse) {
				Courthouse courthouse = (Courthouse) card;
				courthouse.blueCardEffect(cardToPlay, player, deck);
			}
		}
	}
	
	default boolean playACard(Card cardToPlay, Players players, Player player, Deck deck){
		boolean playable = true;
		Requirements requirementsToPayForCard = cardToPlay.requirements.copyRequirementsToPayForCard(cardToPlay.requirements);
		
		playable = uniqueCheck(cardToPlay, player);
		boolean outOfTownLimit = outOfTownLimitCheck(cardToPlay, player);
		
		if(!outOfTownLimit && playable) {
			playable = occupieConstructionCardInTown(cardToPlay, player, deck, players);
		}
		if(playable) {
			requirementsToPayForCard = checkBlueCardsBeforePlayingACard(requirementsToPayForCard, cardToPlay, deck, player);
			playable = payResources(player, requirementsToPayForCard, cardToPlay);
		}
		if(playable) {
			addCardToTown(player, cardToPlay, players, deck, requirementsToPayForCard);
			playable = cardEffect(playable, cardToPlay, player, deck, players);
		}
		if(!playable) {
			checkBlueCardsAfterPlayingACard(player, cardToPlay, deck);
		}
		if(player.spaces==15) {
			System.out.println("Your town is full.");
		}
		
		System.out.println("");
		return !playable;
	}

	default boolean playACardFree(Card cardToPlay, Players players, Player player, Deck deck){
		boolean playable = true;
		
		playable = uniqueCheck(cardToPlay, player);
		boolean outOfTownLimit = outOfTownLimitCheck(cardToPlay, player);
		
		if(!outOfTownLimit && playable) {
			System.out.println(cardToPlay.name + " will be played for free.");
		}
		if(playable) {
			addCardToTown(player, cardToPlay, players, deck, new Requirements(0,0,0,0));
			playable = cardEffect(playable, cardToPlay, player, deck, players);
		}
		if(!playable) {
			checkBlueCardsAfterPlayingACard(player, cardToPlay, deck);
		}
		if(player.spaces==15) {
			System.out.println("Your town is full.");
		}
		
		System.out.println("");
		return !playable;
	}
}
