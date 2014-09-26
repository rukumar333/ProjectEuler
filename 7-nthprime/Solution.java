//Question: 10001st Prime

import java.io.*;
import java.util.*;

public class Solution{
    //add all primes up to the 10000th prime and then binary search through the array
    private int[] primes = new int[10000];

    public Solution(){
	boolean passed = false;
	int count = 1;
	int index = 0;
	int num  = 2;
	while(count <= 10000){
	    if(isPrime(num)){
		primes[index] = num;
		index ++;
		count ++;
	    }
	    if(!passed){
		num ++;
		passed = true;
	    }else{
		num = num + 2;
	    }
	}
    }

    public boolean isPrime(int n){
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

    public int solve(int x){
	return primes[x - 1];
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	int count = Integer.parseInt(sc.nextLine());
	int[] nums = new int[count];
	for(int i = 0; i < count; i ++){
	    nums[i] = Integer.parseInt(sc.nextLine());
	}
	for(int i = 0; i < count; i ++){
	    System.out.println(sol.solve(nums[i]));
	}
    }


}
