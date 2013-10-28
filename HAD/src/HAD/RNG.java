package HAD;

/** 
* Random Number Generation Class
*
* @author François Deslandes
*/
public class RNG {
	
	/**
	 * Provides uniformly distributed random numbers in [inf;sup]
	 * @param inf
	 * @param sup
	 * @return random number
	 */
	public static double luniform(double inf, double sup){
		return Math.random()*(sup-inf) + inf;
	}

	/**
	 * Provides normally distributed random numbers
	 * @param mean
	 * @param sigma
	 * @return random number
	 */
	public static double lnorm(double mean, double sigma){
		double x,y;

		x=luniform(0,1);
		y=luniform(0,1);

		return Math.sqrt(-2*Math.log10(x)) * Math.cos(2*Math.PI*y) * sigma + mean;
	}
	
	/**
	 * Generates a random state from a current state with normal distribution on every element of the state
	 * @param current state
	 * @return random state
	 */
	public static State getRandomState(State current){
		int i;
		State next = new State();
		for(i=0; i < current.size(); i++)
			next.addElement(RNG.lnorm(current.getElement(i), 1));
		return next;
	}

}
