import java.io.*;

public class PatternSearch {
	
	public BufferedReader in;
	
	public PatternSearch(String file) throws FileNotFoundException {
		in = new BufferedReader(new FileReader(file));
	}

	/**
	 * @param args 	[0]: regexp pattern (String), 
	 * 				[1]: filename for text input (String)
	 */
	public static void main(String[] args) {
		
		try {
			PatternSearch ps = new PatternSearch("FSM1");
			String line;
			StringBuilder msg = new StringBuilder();
			while ((line = ps.in.readLine()) != null) {
				msg.append(line);
				msg.append("\n");
			}
			
			StateMachine sm = new StateMachine(StateMachine.processTable(msg.toString()));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
