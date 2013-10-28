package HAD;

/**
 * Holds the cost function
 * @author François Deslandes
 *
 */
public interface Cost {
	public double cost(State state);
	public String getName();
	public String getDesc();
}
