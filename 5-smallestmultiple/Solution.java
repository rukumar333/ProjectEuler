//Question: Smallest Multiple

import java.io.*;
import java.util.*;

public class Solution{
    
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

    public boolean isSquare(int n){
	for(int i = 1; i <= 7; i ++){
	    if(i * i == n){
		return true;
	    }
	}
	return false;
    }

    public boolean isMultiple(int n, long num){
	for(int i = 1; i <= n; i ++){
	    if(!(num % i == 0)){
		return false;
	    }
	}
	return true;
    }

    public long solve(int num){
	long temp = 1;
	for(int i = 2; i <= num; i ++){
	    if(isSquare(i) || isPrime(i)){
		temp = temp * i;
	    }
	}
	for(int i = 1; i <= temp; i ++){
	    // System.out.println("This is the num: " + num + "\nThis is the i: " + i);
	    if(isMultiple(num, i)){
		return i;
	    }
	}
	return temp;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	int count = Integer.parseInt(sc.nextLine());
	int nums[] = new int[count];
	/*
	while(true){
	    int x = Integer.parseInt(sc.nextLine());
	    System.out.println("This is it " + sol.isMultiple(count,x));
	}
	*/
	
	for(int i = 0; i < count; i ++){
	    nums[i] = Integer.parseInt(sc.nextLine());
	}
	for(int i = 0; i < count; i ++){
	    System.out.println(sol.solve(nums[i]));
	}
    }

}
