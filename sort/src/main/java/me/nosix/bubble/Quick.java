package me.nosix.bubble;

import me.nosix.util.PrintUtil;

public class Quick {
	static int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
    public static void main(String[] args) {
    	PrintUtil.print(sort(a,0, a.length-1));
    }
    
    public static int[] sort(int[] array, int left, int right) {
    	if(left < right) {
    		int i = left;
    		int j = right;
    		int x = array[left];
    		while(i < j) {
    			while(i < j && array[j] >= x)
        			j--;
    			if(i < j)   
                    array[i++] = array[j];  
        		while(i< j && array[i] < x) 
        			i++;
        		if(i < j) {
        			array[j--] = array[i];
        		}
    		}
    		array[i] = x;
    		sort(array, left, i - 1); // 递归调用   
    		sort(array, i + 1, right);
    	}	
    	return array;
    }
}
