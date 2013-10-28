package HAD;

/**
 * Simulated annealing
 * @author François Deslandes
 *
 */
public class Annealing implements Heuristic{
	/**
	 * Initial temperature
	 */
	double init_temp;
	/**
	 * final temperature
	 */
	double final_temp;
	/**
	 * current temperature
	 */
	double temp;
	/**
	 * Maximum number of iterations allowed
	 */
	int nmax;
	/**
	 * Number of moves accepted
	 */
	int moves;
	/**
	 * Number of iterations
	 */
	int iterations;
	/**
	 * Initial state
	 */
	State initial;
	/**
	 * Terminal state
	 */
	State terminal;
	/**
	 * Cost function
	 */
	Cost cost;
	
	/**
	 * 
	 * @param Cost function
	 * @param Initial temperature
	 * @param Maximum number of iterations
	 */
	public Annealing(Cost costf, double T, int max){
		init_temp = T;
		cost = costf;
		nmax = max;
	}

	@Override
	public State run(State instate) {
		State min = instate;
		State current = instate;
		State next;
		moves = 0;
		temp = init_temp;
		initial = instate;
		
		while(iterations < nmax){
			if(cost(min) > cost(current)){
				min = current;
			}
			
			next = RNG.getRandomState(current);
			if(RNG.luniform(0,1) < delta(current, next)){
				current = next;
				moves++;
			}
			
			boltzmann();
			iterations++;
		}
		terminal = min;
		final_temp = temp;
		return terminal;
	}

	@Override
	public State getInitial() {
		return initial;
	}

	@Override
	public State getTerminal() {
		return terminal;
	}

	@Override
	public int getIterations() {
		return iterations;
	}

	@Override
	public double cost(State state) {
		return cost.cost(state);
	}
	
	/**
	 * Decreases temperature according to the Boltzmann statistics
	 */
	private void boltzmann(){
		temp = Math.pow(0.9, iterations+1)*temp+1;
	}
	
	/**
	 * Calculates the ratio of cost
	 * @param current state
	 * @param next state
	 * @return ratio
	 */
	private double delta(State current, State next){
		return Math.exp(cost(current) - cost(next));
	}
	
	/**
	 * Prints a summary
	 */
	public void printSummary(){
		System.out.println("");
		System.out.println("===========================");
		System.out.println("=== Simulated Annealing ===");
		System.out.println("= Cost function : ");
		System.out.println("  (name)          " + cost.getName());
		System.out.println("  (desc)          " + cost.getDesc());
		System.out.println("= Iterations    : ");
		System.out.println("  (max)           " + nmax);
		System.out.println("  (iterations)    " + iterations);
		System.out.println("  (moves)         " + moves);
		System.out.println("= Initial       : " );
		System.out.println("  (cost)          " + cost.cost(initial));
		System.out.println("  (temperature)   " + init_temp);
		System.out.println("= Terminal      : " );
		System.out.println("  (cost)          " + cost.cost(terminal));
		System.out.println("  (temperature)   " + final_temp);
		System.out.println("===========================");
		System.out.println("");
	}

}
