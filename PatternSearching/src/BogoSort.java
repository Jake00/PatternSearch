import java.util.Random;  

public class BogoSort  
{  
	private static final Random generator = new Random();  

	/**
	 * Generates a sorted sequence of data in a reasonable amount of time. (maybe)
	 * @param data The data to sort.
	 */
	public static void bogoSort(int[] data) {  
		while (!isSorted(data)) {  
			for (int i = 0; i < data.length; i++) {  
				int randomPosition = generator.nextInt(data.length);  

				int temp = data[i];  
				data[i] = data[randomPosition];  
				data[randomPosition] = temp;  
			}  
		}  
	}  

	/**
	 * Checks the data is sorted.
	 * @param data The data to check.
	 * @return true if the data is sorted.
	 */
	private static boolean isSorted(int[] data) {  
		for (int i = 1; i < data.length; i++)  
			if (data[i] < data[i - 1])  
				return false;  

		return true;  
	}  
}  