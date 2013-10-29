package HAD;

public abstract class Instance {
	State initial;
	State terminal;
	
	public Instance(State state){
		initial = state;
	}
	
	/**
	 * Cost function for the instance
	 * @param state
	 * @return Cost associated with state
	 */
	public abstract double cost(State state);
	
	/**
	 * Generates a random state from a current state with normal distribution on every element of the state
	 * @param current state
	 * @return random state
	 */
	public abstract State getRandomState(State state);
	
	/**
	 * 
	 * @return Name of the instance
	 */
	public abstract String getName();
	
	/**
	 * 
	 * @return Description of the instance
	 */
	public abstract String getDesc();
	
	/**
	 * 
	 * @return Initial state
	 */
	public State getInitial(){
		return initial;
	}
	
	/**
	 * 
	 * @return terminal state
	 */
	public State getTerminal(){
		return terminal;
	}

}
