package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Judge extends BlueCard{
	
	public Judge() {
		super("Judge",new Requirements(0,0,0,3),true,2,"Courthouse");
	}
	
	public boolean blueCardEffect(Card cardToPlay, Town town){
		boolean usedBlueCardEffect = false;
		boolean judgeIsUsed = false;
		int sumOfRequirementsOnCard = cardToPlay.requirements.twig + cardToPlay.requirements.resin + cardToPlay.requirements.pebble + cardToPlay.requirements.berry;
		
		usedBlueCardEffect = town.useBlueCardOrNot(this, cardToPlay);
		if(usedBlueCardEffect) {			
			int twigInTown = town.requirements.twig;
			int resinInTown = town.requirements.resin;
			int pebbleInTown = town.requirements.pebble;
			int berryInTown = town.requirements.berry;
			int twigOnCard = cardToPlay.requirements.twig;
			int resinOnCard = cardToPlay.requirements.resin;
			int pebbleOnCard = cardToPlay.requirements.pebble;
			int berryOnCard = cardToPlay.requirements.berry;
			
			boolean notEnoughTwig = twigInTown<=twigOnCard;
			boolean notEnoughResin = resinInTown<=resinOnCard;
			boolean notEnoughPebble = pebbleInTown<=pebbleOnCard;
			boolean notEnoughBerry = berryInTown<=berryOnCard;
			
			boolean everythingIsChangeable = !notEnoughTwig && !notEnoughResin && !notEnoughPebble && !notEnoughBerry;
			boolean twigIsChangeable = notEnoughTwig && !notEnoughResin && !notEnoughPebble && !notEnoughBerry;
			boolean resinIsChangeable = !notEnoughTwig && notEnoughResin && !notEnoughPebble && !notEnoughBerry;
			boolean pebbleIsChangeable = !notEnoughTwig && !notEnoughResin && notEnoughPebble && !notEnoughBerry;
			boolean berryIsChangeable = !notEnoughTwig && !notEnoughResin && !notEnoughPebble && notEnoughBerry;
			
			if((everythingIsChangeable || twigIsChangeable || resinIsChangeable || pebbleIsChangeable || berryIsChangeable) && sumOfRequirementsOnCard!=0) {
				judgeIsUsed = true;
				cardToPlay.printCardDetails();
				town.changeRequirements(cardToPlay, town);
				System.out.println("Changed requirements to pay: Twig = " + town.requirementsToPayForCard.twig + ", Resin = " + town.requirementsToPayForCard.resin + ", Pebble = " + town.requirementsToPayForCard.pebble + ", Berry = " + town.requirementsToPayForCard.berry);
			}
			else {
				System.out.println("Not enough resource to use Judge.\n");
			}
		}
		return judgeIsUsed;
	}
}
