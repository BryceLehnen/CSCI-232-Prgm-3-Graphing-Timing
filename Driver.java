import java.util.Random;



public class Driver {

	// Initialize variables
	private static int size = 10000;
	private static int[] arr;
	
	
	// Creates an array containing random numbers from 1 to 10,000
	// without duplicates
	// Sends the array to Graph and searches for the LIS
	// Sends the array to LongestSubsequence to find LIS
	// Times both (but not the creation of the array or graph)
	public static void main(String[] args) {
		
		// UNUSED
		// In theory this method works, but it takes far too long
		// to run
		/*
		boolean[] temparr = new boolean[1000];	// array to show if value is in arr
		Random rand = new Random();				// variable for random number generation
		int random;
		// Runs 1000 times to fill arr
		// but may run for longer to ensure that every int
		// is never used more than once
		for (int i = 0; i < 1000; i++) {
			random = rand.nextInt(999) + 1; // 0-999 + 1
			
			// The random num has not been added
			if (temparr[random-1] == false) {
				arr[i] = random;
				temparr[random-1] = true;
			}
			// The random num has already been added
			else if (temparr[random-1] == true) {
				i--;
			}
		}
		System.out.println("YEEEEEEEEEEAHHHHHHH BOIIIIIIIIII");
		*/
		
		// UNUSED
		// Creates an array containing all ints from 1 to 1000
		// Shuffles the array to randomize the order
		// of the elements inside
		/*
		for (int i = 1; i <= size; i++) {
			arr[i-1] = i;
		}
		List<Integer> templist = Arrays.asList(arr);
		Collections.shuffle(templist);
		templist.toArray(arr);
		System.out.println(Arrays.toString(arr));
		*/
		
		// Creates a new temp array to hold values
		// and a boolean array to protect from duplicates
		// Each int will be put in the array and will be generated
		// with a random int from 1 - 10,000
		Random rand = new Random();				// variable for random number generation
		int random;
		int counter = 0;
		int[] temparr = new int[size];
		boolean[] check = new boolean[size];
		for (int i = 0; i < size; i++) {
			random = rand.nextInt(size-1) + 1; // 0-999 + 1
			
			// The random num has not been added
			// Does nothing if it already exists
			if (check[random-1] == false) {
				temparr[counter] = random;
				check[random-1] = true;
				counter++;
			}
		}
		
		// The temparr will most likely have a sequence of 0's
		// at the end so we only add the unique ints into arr[]
		size = counter;
		System.out.println(size);
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = temparr[i];
		}
		
		// Starting StopWatchCPU
		StopWatchCPU timer = new StopWatchCPU();
		
		
		// LIS dynamic programming
		int dpLIS = LongestSubsequence.LIS(arr, size);
		System.out.println(dpLIS);
		
		// Returns timer for dynamix programming
		System.out.println(timer.elapsedTime());
	}
}




