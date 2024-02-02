package BlueCritters;

import CardTypes.BlueCard;
import Main.*;

public class Judge extends BlueCard{
	
	public Judge() {
		super("Judge",new Requirements(0,0,0,3),true,2,"Courthouse");
	}
	
	public void blueCardEffect(Card cardToPlay, Town town){
		boolean usedBlueCardEffect = false;
		
		usedBlueCardEffect = town.useBlueCardOrNot(this);
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
			
			if(everythingIsChangeable || twigIsChangeable || resinIsChangeable || pebbleIsChangeable || berryIsChangeable) {
				cardToPlay.printCardDetails();
				cardToPlay.requirements = changeRequirements(cardToPlay, town);
				cardToPlay.printCardDetails();
			}
			else {
				System.out.println("Not enough resource to use Judge.");
			}
		}
	}
}
