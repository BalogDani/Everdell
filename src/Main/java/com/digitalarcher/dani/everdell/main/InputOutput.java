package com.digitalarcher.dani.everdell.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface InputOutput {
	
	default String readCardName() {
		String cardName = "";
		BufferedReader cardNameInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			cardName = cardNameInput.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardName;
	}
	
	default String readResourceInput(String addOrTake) {
		String resource = "";
		System.out.println("Select a type of resource to " + addOrTake + ": ");
		BufferedReader resourceInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			resource = resourceInput.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resource;
	}
	
	default int readResourceAmmount() {
		int ammount = 0;
		System.out.println("Select the ammount of resource to pay up to 2: ");
		BufferedReader ammountInput = new BufferedReader(new InputStreamReader(System.in));
		try {
			ammount = Integer.parseInt(ammountInput.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ammount;
	}
	
	default String chooseAnotherPlayersName() {
		System.out.println("Select another players town: ");
		String anotherPlayersTownName = "";
		BufferedReader readTownName = new BufferedReader(new InputStreamReader(System.in));
		try {
			anotherPlayersTownName = readTownName.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anotherPlayersTownName;
	}
	
	default boolean useBlueCardOrNot(Card cardToUse, Card cardToPlay) {
		boolean useIt = false;
		String yesOrNo = "";
		while(!yesOrNo.equals("Yes") && !yesOrNo.equals("yes") && !yesOrNo.equals("No") && !yesOrNo.equals("no")) {
			yesOrNo = answerUseBlueCardOrNot(cardToUse, cardToPlay);
			if(yesOrNo.equals("Yes") || yesOrNo.equals("yes")) {
				useIt = true;
			}
			if(yesOrNo.equals("No") || yesOrNo.equals("no")) {
				System.out.println(cardToUse.name + "'s effect will be not used.\n");
			}
			if(!yesOrNo.equals("Yes") && !yesOrNo.equals("yes") && !yesOrNo.equals("No") && !yesOrNo.equals("no")) {
				System.out.println("Please choose a correct answer 'Yes' or 'No'.");
			}
		}
		
		return useIt;
	}
	
	default String answerUseBlueCardOrNot(Card cardToUse, Card cardToPlay) {
		System.out.println("Use " + cardToUse.name + "'s effect on " + cardToPlay.name + "?");
		String yesOrNo = "";
		BufferedReader answer = new BufferedReader(new InputStreamReader(System.in));
		try {
			yesOrNo = answer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yesOrNo;
	}
}
