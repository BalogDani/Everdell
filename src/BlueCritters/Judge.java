package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Judge extends BlueCard{
	
	public Judge() {
		super("Judge",new Requirements(0,0,0,3),true,2,"Courthouse");
	}
	
	public boolean blueCardEffect(Requirements requirementsToPayForCard, Card cardToPlay, Player player){
		boolean usedBlueCardEffect = false;
		boolean judgeIsUsed = false;
		int sumOfRequirementsOnCard = cardToPlay.requirements.twig + cardToPlay.requirements.resin + cardToPlay.requirements.pebble + cardToPlay.requirements.berry;
		
		usedBlueCardEffect = useBlueCardOrNot(this, cardToPlay);
		if(usedBlueCardEffect) {			
			int twigInTown = player.requirements.twig;
			int resinInTown = player.requirements.resin;
			int pebbleInTown = player.requirements.pebble;
			int berryInTown = player.requirements.berry;
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
				cardToPlay.requirements.changeRequirements(requirementsToPayForCard, cardToPlay, player);
				System.out.println("Changed requirements to pay: Twig = " + requirementsToPayForCard.twig + ", Resin = " + requirementsToPayForCard.resin + ", Pebble = " + requirementsToPayForCard.pebble + ", Berry = " + requirementsToPayForCard.berry);
			}
			else {
				System.out.println("Not enough resource to use Judge.\n");
			}
		}
		return judgeIsUsed;
	}
}
