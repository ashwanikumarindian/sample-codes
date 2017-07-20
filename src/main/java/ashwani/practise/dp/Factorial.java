//***************************************************************
//* NOTICE: 2017 All Rights Reserved . 				*
//***************************************************************
package ashwani.practise.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * Given an integer N, print the factorial of the <b>N (mod 10^9+7)</b>.
 * </p>
 * <strong>Input:</strong><br>
 * First line contains one integer,T, number of test cases. Each test case
 * contains one integer, N
 * <strong>Output:</strong><br>
 * For each test case you need to print the factorial of <b>N (mod 10^9+7)</b>.
 * </p>
 * <strong>Constraints:</strong><br>
 * 1 ≤ T ≤ 10^5 
 * <br> 0 ≤ N ≤ 10^5 
 * 
 * @author Ashwani.Kumar
 * @createdOn 18-July-2017
 *
 */
public class Factorial {
	static final int M = 1000000007;
	static final long[] FACT_RESULT = new long[100000]; 
	static int maxCachedFact = 2;
	public static void main(String[] args) {
		Arrays.fill(FACT_RESULT, -1);
		FACT_RESULT[0] = 1;
		FACT_RESULT[1] = 1;
		FACT_RESULT[2] = 2;
		try (Scanner sc = new Scanner(System.in);) {
			int T = sc.nextInt();
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				nums[i] = sc.nextInt();
			}
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < T; i++) {
				result.append(computeFact(nums[i])).append(System.lineSeparator());
			}
			System.out.println(result.toString());
		}
	}
	private static long computeFact(int i) {
		if(i<= maxCachedFact)
			return FACT_RESULT[i];
		for(int j=maxCachedFact+1;j<=i;j++){
			FACT_RESULT[j]= ((j%M) * (FACT_RESULT[j-1]%M))%M;
		}
		maxCachedFact = i;
		return FACT_RESULT[i];
	}
	
}
