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
	 * Instance of a problem
	 */
	Instance instance;
	
	/**
	 * 
	 * @param Cost function
	 * @param Initial temperature
	 * @param Maximum number of iterations
	 */
	public Annealing(Instance inst, double T, int max){
		init_temp = T;
		instance = inst;
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
			if(instance.cost(min) > instance.cost(current)){
				min = current;
			}
			
			next = instance.getRandomState(current);
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
		return Math.exp(instance.cost(current) - instance.cost(next));
	}
	
	/**
	 * Prints a summary
	 */
	public void printSummary(){
		System.out.println("");
		System.out.println("===========================");
		System.out.println("=== Simulated Annealing ===");
		System.out.println("= Cost function : ");
		System.out.println("  (name)          " + instance.getName());
		System.out.println("  (desc)          " + instance.getDesc());
		System.out.println("= Iterations    : ");
		System.out.println("  (max)           " + nmax);
		System.out.println("  (iterations)    " + iterations);
		System.out.println("  (moves)         " + moves);
		System.out.println("= Initial       : " );
		System.out.println("  (cost)          " + instance.cost(initial));
		System.out.println("  (temperature)   " + init_temp);
		System.out.println("= Terminal      : " );
		System.out.println("  (cost)          " + instance.cost(terminal));
		System.out.println("  (temperature)   " + final_temp);
		System.out.println("===========================");
		System.out.println("");
	}

}
