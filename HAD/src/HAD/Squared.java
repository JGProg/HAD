package HAD;

public class Squared extends Instance{

	public Squared(State state) {
		super(state);
	}

	@Override
	public double cost(State state) {
		return state.getElement(0) * state.getElement(0) + 2;
	}

	@Override
	public String getName() {
		return "Squared";
	}

	@Override
	public String getDesc() {
		return "f(x) = x * x + 2";
	}

	@Override
	public State getRandomState(State current){
		int i;
		State next = new State();
		for(i=0; i < current.size(); i++)
			next.addElement(RNG.lnorm(current.getElement(i), 1));
		return next;
	}
}
