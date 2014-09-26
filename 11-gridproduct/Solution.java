// Question: Largest Product in a Grid

import java.io.*;
import java.util.*;

public class Solution{

    public long solve(long[][] matrix){
	long result = 0;
	for(int i = 0; i < 20; i ++){
	    for(int k = 0; k < 20; k ++){
		if(k < 17){
		    long temp = matrix[i][k] * matrix[i][k+1] * matrix[i][k+2] * matrix[i][k+3];
		    if(temp > result){
			result = temp;
		    }
		}
		if(i < 17){
		    long temp = matrix[i][k] * matrix[i+1][k] * matrix[i+2][k] * matrix[i+3][k];
		    if(temp > result){
			result = temp;
		    }
		}
		if(i < 17 && k < 17){
		    long temp = matrix[i][k] * matrix[i+1][k+1] * matrix[i+2][k+2] * matrix[i+3][k+3];
		    if(temp > result){
			result = temp;
		    }		    
		}
		if(i > 2 && k < 17){
		    long temp = matrix[i][k] * matrix[i-1][k+1] * matrix[i-2][k+2] * matrix[i-3][k+3];
		    if(temp > result){
			result = temp;
		    }		    
		}
	    }
	}
	return result;
    }
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Solution sol = new Solution();
	long[][] grid = new long[20][20];
	for(int i = 0; i < 20; i ++){
	    String[] temp = sc.nextLine().split(" ");
	    for(int k = 0; k < 20; k ++){
		grid[i][k] = Long.parseLong(temp[k]);
	    }
	}
	System.out.println(sol.solve(grid));
	// for(int i = 0; i < 20; i ++){
	//     System.out.println(Arrays.toString(grid[i]));
	// }
    }

}
