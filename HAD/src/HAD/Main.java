package HAD;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		State init = new State(1);
		Squared squared = new Squared();
		init.addElement(5);
		System.out.println("Starting : " + squared.cost(init));
		Annealing monte = new Annealing(squared, 100000, 1000);
		monte.run(init);
		System.out.println("Starting : " + squared.cost(monte.getTerminal()));
		monte.printSummary();
	}

}
