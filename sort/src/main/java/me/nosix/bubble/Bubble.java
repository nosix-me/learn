package me.nosix.bubble;

import me.nosix.util.PrintUtil;

public class Bubble {
    static int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
    public static void main(String[] args) {
    	PrintUtil.print(sort2(a));
    }
    
    public static int[] sort(int[] array) {
    	int temp = 0;
    	for(int i=0; i < array.length; i++) {
    		for(int j = 0; j < array.length-1-i; j++) {
    			if(array[j] >= array[j+1]) {
    				temp = array[j];
    				array[j] = array[j+1];
    				array[j+1] = temp;
    			}
    		}
    	}
    	return array;
    }
    
    public static int[] sort1(int[] array) {
    	for(int i=0; i < array.length; i++) {
    		boolean flag = false;
    		for(int j = 0; j < array.length-1-i; j++) {
    			if(array[j] >= array[j+1]) {
    				int temp = array[j];
    				array[j] = array[j+1];
    				array[j+1] = temp;
    				flag = true;
    			}
    		}
    		if(!flag) {
    			return array;
    		}
    	}
    	return array;
    }
    public static int[] sort2(int[] array) {
    	int k = array.length - 1; 
    	int pos = 0;
    	for(int i=0; i < array.length; i++) {
    		boolean flag = false;
    		for(int j = 0; j < k; j++) {
    			if(array[j] >= array[j+1]) {
    				int temp = array[j];
    				array[j] = array[j+1];
    				array[j+1] = temp;
    				flag = true;
    				pos = j;
    				
    			}
    		}
    		k = pos;
    		if(!flag) {
    			return array;
    		}
    	}
    	return array;
    }
    
}
