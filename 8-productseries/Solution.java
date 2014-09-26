//Question: Largest Product In A Series

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution{

    public long solve(int digits, int useDigits, String x){
	// System.out.println("These are the numbers " + digits + ", " + useDigits + ", " + x);
	String num = x;
	long result = 0;
	long[] temp = new long[digits];
	for(int i = digits - 1; i >= 0 ; i --){
	    temp[i] = Long.parseLong(num.substring(num.length()-1,num.length()));
	    num = num.substring(0,num.length() - 1);
	}
	for(int i = 0; i <= digits - useDigits; i ++){
	    long temp2 = 1;
	    for(int k = 0; k < useDigits; k ++){
		temp2 = temp2 * temp[k + i];
	    }
	    if(temp2 > result){
		result = temp2;
	    }
	}
	// System.out.println(Arrays.toString(temp));
	return result;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	int count = Integer.parseInt(sc.nextLine());
	String[] nums = new String[count];
	String[] firstLines = new String[count];
	for(int i = 0; i < count; i ++){
	    firstLines[i] = sc.nextLine();
	    nums[i] = sc.nextLine();
	}
	for(int i = 0; i < count; i ++){
	    String[] temp = firstLines[i].split(" ");
	    int dig = Integer.parseInt(temp[0]);
	    int useDig = Integer.parseInt(temp[1]);
	    String num = nums[i];
	    System.out.println(sol.solve(dig,useDig,num));
	}
    }

}
