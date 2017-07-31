package me.nosix.insert;

import me.nosix.util.PrintUtil;

public class InsertSort{
    static int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	
    public static void main(String[] args) {
		PrintUtil.print(sort(a));
	}
    
	public static int[] sort(int array[]) {
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			for(;j >=0 && array[j] > temp; j--) {
				array[j+1] = array[j];
			}
			a[j+1] = temp;
		}
		return array;
	}
}
