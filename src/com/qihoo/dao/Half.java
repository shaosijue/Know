/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-29 
 * 
 *******************************************************************************/
package com.qihoo.dao;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015-1-29
 * 作者:	 冯晓钊
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */

/** 
 * 二分法查找，必须对已经排好序的序列进行查找，假设现在有一个递增序列，取中间位置的数及序号midIndex=(beginIndex+endIndex)/2， 
 * 然后将一个序列折成两半，beginIndex~midIndex，midIndex~endIndex,如果目标数T等于S[midIndex]，找到， 
 * 否则，如果T<S[midIndex]，则在beginIndex~midIndex中继续查找；如果T>S[midIndex],则在midIndex~endIndex 
 * 中继续查找，如此反复进行，直到找到目标数据， 
 * 初始对传入参数进行约束及避免无效计算的条件为，T<S[beginIndex]或T>S[endIndex]或beginIndex>endIndex 
 * 或beginIndex>S.length-1||endIndex>S.length-1||beginIndex<0||endIndex<0 
 * 
 */

public class Half {
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub ** * 二分法查找 
		int a[] = { 23, 45, 98, 100, 110, 34, 120, 140, 43,4534,
				435 };

		int search = 32;// 记录要查找的元素
		int lower = 0;// 记录第一个元素
		int temp = a.length - 1;
		int index = -1;
		while (lower <= temp) {
			index = (lower + temp) / 2;
			// 记录中间元素，用两边之和除a2.
			int currentValue = a[index];
			if (currentValue == search) {
				// 如果得到的数与要查找的数相等则break退出;
				break;
			} else if (currentValue < search) {// 如果得到的数要小于查找的数、就用下标加1;否则减一
				lower = index + 1;
			} else {
				temp = index - 1;
			}
		}
		if (lower <= temp) {
			System.out.println(search + "在数组中第：" + (index + 1)
					+ "位");
		} else {
			System.out.println("里面没有这个元素");
		}
	}*/
	
	/** 
	     * 找到返回索引下标，否则返回-1； 
	     * @return index 
	     */  
	 public int binarySearch(int dataset[],int target,int beginIndex,int endIndex){  
	  //数组校验  
	  if(dataset==null||dataset.length==0){  
	      return -1;  
	  }  
	  //beginIndex,endIndex校验  
	  if(beginIndex>endIndex||beginIndex>dataset.length-1||endIndex>dataset.length-1||beginIndex<0||endIndex<0){  
	   System.out.println("error arguments!");  
	   return -1;  
	  }  
	    
	  //无效参数处理  
	  if(target<dataset[beginIndex]||target>dataset[endIndex]||beginIndex>endIndex){  
	   return -1;  
	  }  
	  int midIndex=(beginIndex+endIndex)/2;  
	    
	  //System.out.println(midIndex);  
	  if(target==dataset[midIndex]){  
	   return midIndex;  
	  }  
	  else if(target<dataset[midIndex]){  
	   return binarySearch(dataset,target,beginIndex,midIndex-1);//注意midIndex-1  
	  }  
	  else{  
	   return binarySearch(dataset,target,midIndex+1,endIndex);//注意midIndex+1  
	  }  
	    
	 }  
	   
	 /** 
	  * @param args 
	  */  
	 public static void main(String[] args) {  
	  // TODO Auto-generated method stub  
	  Half bs=new Half();  
	    
	  int[] data=new int[]{1,3,5,7,9,12};  
	    
	  int index=bs.binarySearch(data,12,0, 5);  
	    
	  System.out.println("The position of the target number in the array is :"+ index);  
	 }
	
}
