/*******************************************************************************
 * Copyright (c) 2015 by tennis Corporation all right reserved.
 * 2015-1-28 
 * 
 *******************************************************************************/ 
package com.qihoo.dao;

/**
 * <pre>
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015-1-28
 * ����:	 ������
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
 * </pre>
 */
public class Select {
	public static void main(String[] args) {
		int[] nums = {12,34,1,32,43,4,63,35};
		int temp;
		for(int i = 0;i<nums.length-1;i++){
			for(int j = i+1;j<nums.length;j++){
				if(nums[i]>nums[j]){
					temp= nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		for(int i = 0; i<nums.length;i++){
			System.out.println(nums[i]);
		}
		
	}
}