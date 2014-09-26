//Question: Multiples of 3 and 5

import java.util.*;
import java.io.*;

public class Solution{

    public long solve(long num){
	long result = 0;
	long threes = (num - 1) / 3;
	long threesFact = 0;
	long fives = (num - 1) / 5;
	long fivesFact = 0;
	long fifteens = (num - 1) / 15;
	long fifteensFact = 0;
	threesFact = threes * (threes + 1);
	threesFact = threesFact / 2;
	result = threesFact * 3;
	fivesFact = fives * (fives + 1);
	fivesFact = fivesFact / 2;
	result = result + fivesFact * 5;
	
	fifteensFact = fifteens * (fifteens + 1);
	fifteensFact = fifteensFact / 2;
	result = result - fifteensFact * 15;
	
	return result;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution s = new Solution();
	String result = "";
	int count = Integer.parseInt(sc.nextLine());
	long[] nums = new long[count];
	for(int i = 0; i < count; i ++){
	    long x = Long.parseLong(sc.nextLine());
	    nums[i] = s.solve(x);
	}
	for(int i = 0; i < count; i ++){
	    System.out.println(nums[i]);
	}
    }

}
