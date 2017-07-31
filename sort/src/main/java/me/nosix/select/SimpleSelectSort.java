package me.nosix.select;

import me.nosix.util.PrintUtil;

public class SimpleSelectSort {
	static int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	
	public static void main(String []args) {
		PrintUtil.print(sort(a));
	}
	public static int[] sort(int array[]) {
		int position = 0;
		for(int i = 0;i < array.length; i++) {
			int temp = array[i];
			position = i;
			for(int j = i;j < array.length; j++) {
				if(array[j] < temp) {
					temp = array[j];
					position = j;
				}
			}
			array[position] = array[i];
			array[i] = temp;
		}
		return array;
	}
}
