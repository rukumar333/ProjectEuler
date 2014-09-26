//Question: Largest Prime Factor

import java.io.*;
import java.util.*;

public class Solution{


    public boolean isPrime(long n){
	if(n == 2){
	    return true;
	}
	if(n % 2 == 0){
	    return false;
	}
	for(long i = 3; i * i <= n; i = i + 2){
	    if(n % i == 0){
		return false;
	    }
	}
	return true;
    }

    public long solve(long num){
	long result = 1;
	if(num == 2){
	    return 2;
	}
	for(long i = 1; i * i <= num; i ++){
	    if(num % i == 0 && isPrime(i) && result < i){
		result = i;
		// System.out.println("It is this here " + i);
	    }
	    // System.out.println("This is the result in between" + result);
	    // System.out.println("This is the n/i in between" + num/i);
	    if(num % i == 0 && isPrime(num/i) && result < num/i){
		result = num / i;
		// System.out.println("It is this here " + i);
	    }
	}
	if(result == 1){
	    return num;
	}else{
	    return result;   
	}
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
