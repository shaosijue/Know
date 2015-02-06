/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-31 
 * 
 *******************************************************************************/ 
package com.qihoo.dao;

/**
 * <pre>
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015-1-31
 * ����:	 ������
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
 * </pre>
 */
public class BinaryTreeTest {
	public static void testInvalid(String generalList) {  
	        try {  
	            BinaryTree.createBinaryTree(generalList);  
	        }  
	        catch (Exception e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	      
	    public static void testTreeInfo(BinaryTree bt) {  
	          
	        System.out.println("�������Ĺ�����ʾ��" + bt.getGeneralListString());  
	        System.out.println("�������߶�: " + bt.height(bt.getRoot()));  
	        System.out.println("�������ܽ������ " + bt.size(bt.getRoot()));  
	        System.out.println("��������Ҷ�ӽ������ " + bt.leafCounter(bt.getRoot()));  
	        System.out.println("������������Ҷ�ӽ��: " + bt.listToString(bt.getLeafNodes()));  
	        System.out.println("������������Ҷ�ӽ�㵽����·��: ");  
	        bt.printLeafPaths();  
	        System.out.println("�������е�һ���·��: " + bt.listToString(bt.longestPath()));  
	          
	    }  
	      
	    public static void testTraverse(BinaryTree bt) {  
	          
	        System.out.println("�������Ľ�������ʾ��");  
	        System.out.println(bt.getNodelinkList());  
	          
	        System.out.println("�����������������");  
	        System.out.println("�ݹ�: " + bt.listToString(bt.getPreOrderList(true)));  
	        System.out.println("�ǵݹ�: " + bt.listToString(bt.getPreOrderList(false)));  
	          
	        System.out.println("�����������������");  
	        System.out.println("�ݹ�:" + bt.listToString(bt.getInOrderList(true)));  
	        System.out.println("�ǵݹ�:" + bt.listToString(bt.getInOrderList(false)));  
	          
	        System.out.println("�������ĺ��������");  
	        System.out.println("�ݹ�: " + bt.listToString(bt.getPostOrderList(true)));  
	        System.out.println("�ǵݹ�:" + bt.listToString(bt.getPostOrderList(false)));  
	         
	        System.out.println("�������Ĳ��������");  
	        System.out.println(bt.listToString(bt.getFloorOrderList()));  
	          
	    }  
	      
	    public static void testAll(BinaryTree bt) {  
	        testTreeInfo(bt);  
	        testTraverse(bt);  
	    }  
	      
	    public static void main(String[] args) {  
	          
	        String  expression = "  -(  +(a, *(b, -(c,d))), /(e,f)/t)   ";  
	        // String expression = "b( , %)";  
	        BinaryTree bt = null;  
	          
	        try {  
	                bt = BinaryTree.createBinaryTree(expression);         
	                testAll(bt);              
	                System.out.println();  
	                  
	                System.out.println(" ----------- ����ǰ����������б��������  ------------ ");  
	                bt = BinaryTree.createBinaryTree("ABCDEFG", "CBEDAFG");    
	                testAll(bt);  
	                System.out.println();  
	                  
	                System.out.println(" ----------- �������򼰺�������б��������  ------------ ");  
	                bt = BinaryTree.createBinaryTree("CBEDAFG", "CEDBGFA", true);     
	                testAll(bt);  
	                System.out.println();  
	                  
	                System.out.println("���ƶ�����: ********************* ");  
	                BinaryTree copy = bt.copyBinaryTree();  
	                
	                testAll(copy);  
	                System.out.println("*************  �������Ƚϣ� bt VS copy : ****************** ");  
	                System.out.println("bt: " + bt.getGeneralListString());  
	                System.out.println("copy: " + copy.getGeneralListString());  
	                System.out.println("�ȽϹ�����ʾ�Ƿ����? " + bt.getGeneralListString().equals(copy.getGeneralListString()));  
	                System.out.println("�Ƚϸ����������Ƿ�ȫ��? " + (bt.equalsTo(copy) ? "��": "��"));       
	                  
	                testInvalid("A(B(C,D)");  
	                testInvalid("A(B,), C(D)");  
	                testInvalid("A(B(C, D),E),F),)");  
	                testInvalid("A(B)");  
	                testInvalid("AB(C,D)");  
	                  
	                bt = BinaryTree.createBinaryTree("A(B(D, ), C(E,F))");  
	                testAll(bt);  
	                bt.swapTree();  
	                testAll(bt);  
	        }  
	        catch (Exception e) {  
	            System.out.println(e.getMessage());  
	            e.printStackTrace();  
	        }  
	                  
	    }
}
