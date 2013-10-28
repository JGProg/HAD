package HAD;

/**
 * Holds the heuristic methods
 * @author François Deslandes
 *
 */
public interface Heuristic {
	
	/**
	 * Runs the heuristic with initial state
	 * This will set the number of iterations and the terminal state
	 * @param initial state
	 * @return terminal state
	 */
	public State run(State instate);
	
	/**
	 * 
	 * @return initial state
	 */
	public State getInitial();
	
	/**
	 * 
	 * @return terminal state
	 */
	public State getTerminal();
	
	/**
	 * 
	 * @return number of iterations
	 */
	public int getIterations();
	
	/**
	 * Calculates the cost associated to state
	 * @param state
	 * @return Cost
	 */
	public double cost(State state);

}
