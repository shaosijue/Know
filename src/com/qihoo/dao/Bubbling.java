/*******************************************************************************
 * Copyright (c) 2015 by tennis Corporation all right reserved.
 * 2015-1-28 
 * 
 *******************************************************************************/ 
package com.qihoo.dao;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015-1-28
 * 作者:	 冯晓钊
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class Bubbling {
	
	public static void main(String[] args) {
		int[] nums = {12,34,1,32,43,4,63,35};
		int temp ;
		for(int i = 0;i<nums.length;i++){
			for(int j = 0;j<nums.length-1;j++){
				if(nums[i]<nums[j]){
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		for(int i = 0 ;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}
	
		
	
}
