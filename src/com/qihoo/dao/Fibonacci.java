/*******************************************************************************
 * Copyright (c) 2015 by tennis Corporation all right reserved.
 * 2015-1-29 
 * 
 *******************************************************************************/
package com.qihoo.dao;

import java.util.Scanner;

/**
 * <pre>
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015-1-29
 * ����:	 ������
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
 * </pre>
 */
public class Fibonacci {
	/*
	 * public static void main(String[] args) { Scanner scanner = new
	 * Scanner(System.in); System.out.println("������쳲�������λ��:"); int n =
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
		// ����������������
		/*
		 * int a=1, b=1, c=0; Scanner scanner = new Scanner(System.in);
		 * System.out.println("������쳲�������λ��(<1000):"); int n =
		 * scanner.nextInt(); if(n<1000){ scanner.close(); }
		 * System.out.println("쳲���������ǰ"+n+"��Ϊ��"); System.out.print(a +
		 * "\t" + b + "\t"); for (int i = 1; i <= n; i++) { c = a + b; a
		 * = b; b = c; System.out.print(c + "\t"); if ((i + 2) % 5 == 0)
		 * System.out.println(); }
		 */

		// ����
		Scanner scanner = new Scanner(System.in);
		System.out.println("������쳲�������λ��(<1000):");
		int n = scanner.nextInt();
		if (n > 1000) {
			scanner.close();
		}
		int arr[] = new int[n];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println("쳲��������е�ǰ" + n + "��������ʾ��");
		for (int i = 0; i < arr.length; i++) {
			if (i % 5 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
	}
}
