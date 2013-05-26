import java.util.ArrayList;

/**
 * State machine used for parsing text.
 * @author jrb46
 *
 */
public class StateMachine {

	//Internal representation of the state machine.
	private final ArrayList<State> states;
	
	/**
	 * Constructs a new state machine from a given regular expression
	 * for parsing text.
	 * @param regexp The regular expression, given as a String.
	 */
	public StateMachine(String regexp) {
		this(setUpNewStateMachine(regexp));
	}
	
	/**
	 * Constructs a new state machine for parsing text from a given
	 * array.
	 * @param states The state machine to use.
	 */
	public StateMachine(ArrayList<State> states) {
		this.states = states;
	}
	
	/**
	 * Converts a formatted String representation of a FSM table to a usable
	 * array.
	 * @param table The String to read and split into an array.
	 * @return An array of states set up.
	 */
	public static final ArrayList<State> processTable(String table) {
		//Initially empty new array to represent our state machine.
		ArrayList<State> machine = new ArrayList<State>();
		//Split the data up
		String[] rows  =   table.split("\n");
		String[] index = rows[1].split("\t");
		String[] chs   = rows[2].split("\t");
		String[] next1 = rows[3].split("\t");
		String[] next2 = rows[4].split("\t");
		

		//Iterate over each column entry, read the values and add them into
		//our array.
		for (int col = 1; col <= index.length; col++) {
			char ch = chs[col].charAt(0);
			//If this state is non consuming
			if (ch == '-')
				ch = 0;
			int n1 = Integer.parseInt(next1[col]);
			int n2 = Integer.parseInt(next2[col]);
			
			machine.add(new State(ch, n1, n2));
		}
		
		return machine;
	}
	
	/**
	 * Creates a new state machine from a well formed regular expression.
	 * @param regexp The regular expression.
	 * @return An array representing the new state machine.
	 */
	private static final ArrayList<State> setUpNewStateMachine(String regexp) {
		//Initial empty state machine.
		ArrayList<State> machine = new ArrayList<State>();
		//Bracket counter incremented for every '(' encountered and decremented for ')'.
		int bracketLevel = 0;
		
		/**
		 * Loop over the entire expression looking at every character.
		 * Determine whether to build a new branching state, new literal-consuming state,
		 * or edit previous states based on our grammar rules.
		 */
		for (int i = 0; i < regexp.length(); i++) {
			char c = regexp.charAt(i);
			
			//TODO build new states and add them into machine
			//addBranchingState( ... );
			//addLiteralConsumingState( ... );
		}
		
		return machine;
	}
	
	private void addBranchingState() {
		
	}
	
	private void addLiteralConsumingState() {
		
	}
	
	/**
	 * Gets the indices for the next states in the array.
	 * @param current The index of the current state to look at.
	 * @return A length 1 or 2 integer array consisting of the next state indices.
	 */
	public int[] getNextStates(int current) {
		State s = states.get(current);
		
		int[] nexts;
		if (s.next1 == s.next2) 
			nexts = new int[] { s.next1 };
		 else 
			nexts = new int[] { s.next1, s.next2 };
		
		return nexts;
	}
	
	/**
	 * Gets the current state object.
	 * @param current The index of the state to get.
	 * @return The State object.
	 */
	public State getCurrentState(int current) {
		return states.get(current);
	}
}
