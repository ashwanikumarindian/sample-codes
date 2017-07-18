//***************************************************************
//*   TIL Expresso Colombia Team  								*
//* ---------------------------------------------------------   *
//* NOTICE: 2017 All Rights Reserved . 	*
//***************************************************************
package ashwani.practise.test.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <div class="problem-content regular problem-description">
 * <p>
 * Given an integer NN, print the factorial of the <b>N (mod 10^9+7)</b>.
 * </p>
 * <p>
 * <strong>Input:</strong><br>
 * First line contains one integer,T, number of test cases. Each test case
 * contains one integer, N
 * <p>
 * <strong>Output:</strong><br>
 * For each test case you need to print the factorial of <b>N (mod 10^9+7)</b>.
 * </p>
 * <p>
 * <strong>Constraints:</strong><br>
 * <p>
 * 1 ≤ T ≤ 10^5
 * </p>
 * <p>
 * 0 ≤ N ≤ 10^5
 * </p>
 * </div>
 * 
 * @author Ashwani.Kumar
 *
 */
public class Factorial {
	static final int M = 1000000007;
	static final long[] FACT_RESULT = new long[100000]; 
	//facti = facti-1 * i
	public static void main(String[] args) {
		Arrays.fill(FACT_RESULT, -1);
		try (Scanner sc = new Scanner(System.in);) {
			int T = sc.nextInt();
			int[] nums = new int[T];
			for (int i = 0; i < T; i++) {
				nums[i] = sc.nextInt();
			}
			for (int i = 0; i < T; i++) {
				System.out.println(computeFact(nums[i]));
			}
		}
	}

	private static long computeFact(int i) {
		if(FACT_RESULT[i] != -1){
			return FACT_RESULT[i];
		}
		if(i <= 1)return 1;
		return FACT_RESULT[i]=((i%M) * (computeFact(i-1)%M))%M;
	}
	
}
