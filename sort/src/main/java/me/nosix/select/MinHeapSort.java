package me.nosix.select;

import java.util.Arrays;

public class MinHeapSort {
	
	private static int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25,53, 51 };

	public static void main(String []args) {
		heapSort(a);
	}
	
	public static void heapSort(int[] a) {
		System.out.println("开始排序");
		int arrayLength = a.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			MakeMinHeap(a, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(a, 0, arrayLength - 1 - i);
		}
		System.out.println(Arrays.toString(a));
	}
	
	private static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;

	}
	//建立最小堆  
	private static void MakeMinHeap(int a[], int n)  
	{  
	    for (int i = n / 2 - 1; i >= 0; i--)  
	        MinHeapFixdown(a, i, n);  
	}
	
	//  新加入i结点  其父结点为(i - 1) / 2  
	private static void MinHeapFixup(int a[], int i)  
	{  
	    int j, temp;  
	      
	    temp = a[i];  
	    j = (i - 1) / 2;      //父结点  
	    while (j >= 0 && i != 0)  
	    {  
	        if (a[j] >= temp)  
	            break;  
	          
	        a[i] = a[j];     //把较大的子结点往下移动,替换它的子结点  
	        i = j;  
	        j = (i - 1) / 2;  
	    }  
	    a[i] = temp;  
	}  
	
	
	
	//在最小堆中加入新的数据nNum  
	private static void MinHeapAddNumber(int a[], int n, int nNum)  
	{  
	    a[n] = nNum;  
	    MinHeapFixup(a, n);  
	}
	
	//  从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2  
	private static void MinHeapFixdown(int a[], int i, int n)  
	{  
	    int j, temp;  
	  
	    temp = a[i];  
	    j = 2 * i + 1;  
	    while (j < n)  
	    {  
	        if (j + 1 < n && a[j + 1] >= a[j]) //在左右孩子中找最小的  
	            j++;  
	  
	        if (a[j] <= temp)  
	            break;  
	  
	        a[i] = a[j];     //把较小的子结点往上移动,替换它的父结点  
	        i = j;  
	        j = 2 * i + 1;  
	    }  
	    a[i] = temp;  
	}  
	//在最小堆中删除数  
	private static void MinHeapDeleteNumber(int a[], int n)  
	{  
	    swap(a, 0, n-1);
	    MinHeapFixdown(a, 0, n - 1);  
	}  
}
