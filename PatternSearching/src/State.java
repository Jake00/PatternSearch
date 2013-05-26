
/**
 * A single state in our state machine. May either be a branching
 * state with no literal consumed and two next states, or a literal
 * consuming with single next state.
 * @author jrb46
 *
 */
public class State {
	final char literal;
	int next1, next2;
	
	/**
	 * Constructs a new {@code State} object with a pointer to its
	 * next states if we already know them.
	 * @param ch The literal to consume, or 0 if nothing.
	 * @param next1 The first next state.
	 * @param next2 The second next state.
	 */
	public State(char ch, int next1, int next2) {
		this.literal = ch;
		this.next1 = next1;
		this.next2 = next2;
	}
	
	/**
	 * Constructs a new {@code State} object with 
	 * @param ch The literal to consume, or 0 if nothing.
	 */
	public State(char ch) {
		this.literal = ch;
	}
	
	/**
	 * Updates the first next state pointer.
	 * @param n1 The index of the new next state.
	 */
	public void setNextState1(int n1) {
		this.next1 = n1;
	}
	
	/**
	 * Updates the second next state pointer.
	 * @param n2 The index of the new next state.
	 */
	public void setNextState2(int n2) {
		this.next2 = n2;
	}
}