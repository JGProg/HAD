package HAD;

import java.util.Vector;

/**
 * State used in the heuristic (should probably extends vector ??)
 * @author François Deslandes
 *
 */
public class State {
	Vector<Double> state;
	
	public State(int i){
		state = new Vector<Double>(i);
	}
	
	public State(){
		state = new Vector<Double>(1);
	}
	
	public double norm(){
		double norm = 0;
		int i;
		
		for(i=0; i < state.size(); i++){
			norm = norm + state.elementAt(i)*state.elementAt(i);
		}
		return Math.sqrt(norm);
	}
	
	public double getElement(int i){
		return state.get(i);
	}
	
	public void setElement(int i, double val){
		state.set(i, val);
	}
	
	public void addElement(double val){
		state.addElement(val);
	}
	
	public int size(){
		return state.size();
	}

}
