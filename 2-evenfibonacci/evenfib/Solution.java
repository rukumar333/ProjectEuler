//Question: Even Fibonacci Numbers

import java.util.*;
import java.io.*;

public class Solution{

    public long solve(long num){
	long result = 0;
	/*
	if(num > 2){
	    result = result + 2;
	}
	*/
	result = result + solve(1,2,num);
	return result;
    }

    public long solve(long first, long second, long num){
	if(second > num){
	    return 0;
	}
	if(second % 2 == 0){
	    return second + solve(second, first + second, num);
	}else{
	    return solve(second, first + second, num);
	}
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution s = new Solution();
	String s1 = "";
	int count = Integer.parseInt(sc.nextLine());
	long[] nums = new long[count];
	for(int i = 0; i < count; i ++){
	    nums[i] = Long.parseLong(sc.nextLine());
	}
	for(int i = 0; i < count; i ++){
	    System.out.println(s.solve(nums[i]));
	}
    }

}
