//Question: Largest Palindrome Product

import java.util.*;
import java.io.*;

public class Solution{

    long[] palindromes = new long[2470];
    boolean created = false;

    /*
    public boolean checkPalindrome(long num){
	long temp = num;
	long x = 0;
	long k = 0;
	int count = (int)(Math.log10(num) + 1);
	boolean passed = false;
	for(int i = 1; i <= count / 2; i ++){
	    if(passed){
		k = temp / ((int)Math.pow(10,count - i - 1));
	    }else{
		k = temp / (int)Math.pow(10,count - i);
		passed = true;
	    }
	    x = temp % 10;
	    temp = temp % (int)Math.pow(10,count - i);
	    temp = temp / 10;
	    System.out.println("This is x" + x);
	    System.out.println("This is k" + k);
	    System.out.println("This is temp" + temp);
	    if(!(x == k)){
		return false;
	    }
	}
	return true;
	    
    }
    */

    public boolean checkPalindrome(long num){
	String temp = num + "";
	int x = 0;
	int k = 0;
	while(temp.length() > 1){
	    x = Integer.parseInt(temp.substring(0,1));
	    k = Integer.parseInt(temp.substring(temp.length() - 1,temp.length()));
	    // System.out.println("This is x" + x);
	    // System.out.println("This is k" + k);
	    if(!(x == k)){
		return false;
	    }
	    temp = temp.substring(1,temp.length() - 1);
	}
	return true;
    }

    public void setPalindromes(){
	int index = 0;
	for(int i = 101; i < 1000; i ++){
	    for(int k = 101; k < 1000; k ++){
		if(checkPalindrome(k * i)){
		    palindromes[index] = k * i;
		    index ++;
		}
	    }
	}
	Arrays.sort(palindromes);
	// System.out.println(palindromes[palindromes.length - 1]);
    }

    public long solve(long num){
	for(int i = 1; num - i > 10000; i ++){
	    if(checkPalindrome(num - i)){
		if(Arrays.binarySearch(palindromes,num - i) >= 0){
		    return num - i;
		}
	    }
	}
	return 0;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	int count = Integer.parseInt(sc.nextLine());
	long[] nums = new long[count];
	sol.setPalindromes();
	for(int i = 0; i < count; i ++){
	    nums[i] = Long.parseLong(sc.nextLine());
	}
	
	for(int i = 0; i < count; i ++){
	    System.out.println(sol.solve(nums[i]));
	}
	
	/*
	while(true){
	    long k = Long.parseLong(sc.nextLine());
	    System.out.println(sol.checkPalindrome(k));
	}
	*/
    }

}
