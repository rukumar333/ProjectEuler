// Question: Special Pythagorean Triplet

import java.io.*;
import java.util.*;

public class Solution{

    public long solve(int x){
	ArrayList<Long> nums = new ArrayList<Long>();
	long[] temp;
	for(int a = 3; a < x / 3  + 1; a ++){
	    int count = 1;
	    for(int b = a + 1; b < x - (a + b); b ++){
		int c = x - (a + b);

		if(checkTriple(a,b,c)){
		    nums.add(new Long(a * b * c));
		}
	    }
	}
	if(nums.size() == 0){
	    return -1;
	}
	temp = new long[nums.size()];
	for(int i = 0; i < nums.size(); i ++){
	    temp[i] = nums.get(i);
	}
	Arrays.sort(temp);
	return temp[temp.length - 1];
    }

    public boolean checkTriple(int a, int b, int c){
	return ((a * a) + (b * b) == (c * c));
    }
    
    public static void main(String[] args){
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	long[] nums = new long[3001];
	String s = "";
	for(int i = 0; i <= 3000; i ++){
	    nums[i] = sol.solve(i);
	}
	int count = Integer.parseInt(sc.nextLine());
	for(int i = 0; i < count; i ++){
	    int x = Integer.parseInt(sc.nextLine());
	    s = s + nums[x] + "\n";
	}
	System.out.println(s.trim());
    }

}
