package me.nosix.insert;

import me.nosix.util.PrintUtil;

public class ShellSort {
	
	static int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	
    public static void main(String[] args) {
		PrintUtil.print(sort(a));
	}
    
	public static int[] sort(int array[]) {
	    int temp=0;  
		double len = array.length;
		while(true) {
			len = Math.ceil(len/2);
			int b = (int) len;
			for(int i = 0; i < b; i++) {
				for(int j = i+b; j < array.length; j+=b) {
					int k = j - b;
					temp = array[j];
					for(;k >=0 && temp < array[k]; k-=b) {
						array[k+b] = array[k]; 
					}
					array[k+b] = temp;
				}
			}
			if(b == 1) {
				break;
			}
		}
		return array;
	}
}
