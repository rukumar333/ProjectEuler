// Question: Summation of Primes

import java.io.*;
import java.util.*;

public class Solution{

    private long[] primes = new long[78498];

    public Solution(){
	int index = 0;
	for(int i = 2; i <= 1000000; i++){
	    if(isPrime(i)){
		primes[index] = i;
		index ++;
	    }
	}
    }

    public boolean isPrime(long n){
	if(n < 2){
	    return false;
	}
	if(n == 2){
	    return true;
	}
	if(n % 2 == 0){
	    return false;
	}
	for(int i = 3; i * i <= n; i = i + 2){
	    if(n % i == 0){
		return false;
	    }
	}
	return true;
    }

    public long solve(long num){
	long sum = 0;
	int index = Math.abs((Arrays.binarySearch(primes,num) + 1));
	for(int i = 0; i < index; i ++){
	    sum = primes[i] + sum;
	}
	return sum;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	String s = "";
	int count = Integer.parseInt(sc.nextLine());
	long[] nums = new long[count];
	for(int i = 0; i < count; i ++){
	    nums[i] = Long.parseLong(sc.nextLine());
	}
	for(int i = 0; i < count; i ++){
	    System.out.println(sol.solve(nums[i]));
	}
	/*
	for(int i = 0; i < count; i ++){
	    int x = Integer.parseInt(sc.nextLine());
	    s = s + sums[x] + "\n";
	}
	*/
	// System.out.println(s.trim());
    }

}
