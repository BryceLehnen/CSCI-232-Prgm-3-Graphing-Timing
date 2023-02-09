
// Houses a method that determines the longest increasing subsequence
// for a given int[]
// ie. if given [2, 3, 8, 5, 6]
// the LIS would be [2, 3, 5, 6] which has a length of 4
//
// Partially taken from:
//https://www.youtube.com/watch?v=aPQY__2H3tE
// https://www.geeksforgeeks.org/java-program-for-longest-increasing-subsequence/
public class LongestSubsequence {

	// Initialize varaibles
	private static int longest;
	
	// Determines the LIS for each
	// element in the array and will return
	// the longest length
	public static int LIS(int[] arr, int n) {
		
		// It's possible that the client sends in the wrong size
		// so it will return 0 if that happens
		if (n <= 0) {
			return 0;
		}
		else {
			// Base case
			longest = 1;
		}
		
		privLIS(arr, n);
		return longest;
	}
	
	private static int privLIS(int[] arr, int n) {
		
		// Base case
		if (n == 1) {
			return 1;
		}
		
		// Max is length of LIS ending in arr[n-1]
		int res = 1;
		int max = 1;
		
		// Recursivelly calls all LIS ending from arr[0] to arr[n-2]
		// If arr[i-1] is smaller than arr[n-1] and the max with arr[n-1] needs
		// to be updated, then it will update it
		for (int i = 1; i < n; i++) {
			res = privLIS(arr, i);
			if (arr[i-1] < arr[n-1] && res + 1 > max) {
				max = res + 1;
			}
		}
		
		// Comares the temp max with the current longest
		if (longest < max) {
			longest = max;
		}
		
		return max;
	}
}
