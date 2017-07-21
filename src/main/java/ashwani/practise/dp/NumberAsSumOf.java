//***************************************************************
//* NOTICE: 2017 All Rights Reserved . 	                        *
//***************************************************************
package ashwani.practise.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Ways to write n as sum of two or more positive integers</p>
 * <p>For a given number n > 0, find the number of different ways in which n can be written as a sum of at two or more positive integers.</p>
 * <p></p>
 * <p>Examples:</p>
 * <p></p>
 * <p>Input : n = 5</p>
 * <p>Output : 6</p>
 * <p>Explanation : All possible six ways are :</p>
 * <br/>4 + 1
 * <br/>3 + 2
 * <br/>3 + 1 + 1
 * <br/>2 + 2 + 1
 * <br/>2 + 1 + 1 + 1
 * <br/>1 + 1 + 1 + 1 + 1
 * <p></p>
 * <p>Input : 3</p>
 * <p>Output : 4</p>
 * <p>Explanation : All possible four ways are :</p>
 * <br/>3 + 1
 * <br/>2 + 2
 * <br/>2 + 1 + 1
 * <br/>1 + 1 + 1 + 1
 * @author Ashwani.Kumar
 *
 */
public class NumberAsSumOf {
	static long[] cache ;
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("what is the max value of test case?");
			cache = new long[sc.nextInt()+1];
			cache[0] = 1;
			System.out.println("enter collection of numbers \n(enter less than or equal to Zero to stop)\n");
			List<Integer> nums = new ArrayList<Integer>();
			int num = sc.nextInt();
			while(num>0) {
				nums.add(num);
				num = sc.nextInt();
			}
			System.out.println("how many test case for the numbers?");
			int T = sc.nextInt();
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < T; i++) {
				if(T>cache.length){
					System.out.println(i+" is greater than provided max test case number"+cache.length+". Hence ignoring");
					continue;
				}
				result.append(findNoOfWaysCanBeSummed(sc.nextInt(),nums)).append(System.lineSeparator());
			}
			
			System.out.println(result.toString());
			
		}
	}

	private static long findNoOfWaysCanBeSummed(int s, List<Integer> nums) {
		for(int n=1;n<=s;n++){
			for (Integer x : nums) {
				if((n-x)>=0){
					cache[n] += cache[n-x];
				}
			}
		}
		return cache[s];
	}
	
}
