/*******************************************************************************
 * Copyright (c) 2015 by tennis Corporation all right reserved.
 * 2015-1-29 
 * 
 *******************************************************************************/
package com.qihoo.dao;

import java.util.Scanner;

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
public class Fibonacci {
	/*
	 * public static void main(String[] args) { Scanner scanner = new
	 * Scanner(System.in); System.out.println("请输入斐波那契的位数:"); int n =
	 * scanner.nextInt(); if(n>56){ scanner.close(); }
	 * System.out.println(fibonacci(n) + " " + fibonacciNomal(n));
	 * 
	 * int sum = 0; for(int i =0;i<n;i++){ sum += fibonacci(i); }
	 * System.out.println(sum); }
	 * 
	 * public static int fibonacci(int i){ if(i<=2){ return 1; }else{ return
	 * fibonacci(i-1)+fibonacci(i-2); } }
	 * 
	 * public static int fibonacciNomal(int n){ if(n <= 2){ return 1; } int
	 * n1 = 1, n2 = 1, sn = 0; for(int i = 0; i < n - 2; i ++){ sn = n1 +
	 * n2; n1 = n2; n2 = sn; } return sn;
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// 定义三个变量方法
		/*
		 * int a=1, b=1, c=0; Scanner scanner = new Scanner(System.in);
		 * System.out.println("请输入斐波那契的位数(<1000):"); int n =
		 * scanner.nextInt(); if(n<1000){ scanner.close(); }
		 * System.out.println("斐波那契数列前"+n+"项为："); System.out.print(a +
		 * "\t" + b + "\t"); for (int i = 1; i <= n; i++) { c = a + b; a
		 * = b; b = c; System.out.print(c + "\t"); if ((i + 2) % 5 == 0)
		 * System.out.println(); }
		 */

		// 数组
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入斐波那契的位数(<1000):");
		int n = scanner.nextInt();
		if (n > 1000) {
			scanner.close();
		}
		int arr[] = new int[n];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println("斐波那契数列的前" + n + "项如下所示：");
		for (int i = 0; i < arr.length; i++) {
			if (i % 5 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
	}
}
