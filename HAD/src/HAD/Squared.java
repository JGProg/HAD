package HAD;

public class Squared implements Cost{

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
}
