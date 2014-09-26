//Question: Sum Square Difference

import java.io.*;
import java.util.*;

public class Solution{

    public long arithSeries(long x){
	long temp;
	temp = x * (x + 1);
	temp = temp / 2;
	return temp;
    }

    public long powerSeries(long x){
	long temp = 0;
	for(int i = 1; i <= x; i ++){
	    temp = temp + (i * i);
	}
	return temp;
    }

    public long solve(long x){
	long first = arithSeries(x);
	first = first * first;
	long second = powerSeries(x);
	return first - second;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	int count = Integer.parseInt(sc.nextLine());
	long[] nums = new long[count];
	for(int i = 0; i < count; i ++){
	    nums[i] = Long.parseLong(sc.nextLine());
	}
	for(int i = 0; i < count; i ++){
	    System.out.println(sol.solve(nums[i]));
	}
    }

}
