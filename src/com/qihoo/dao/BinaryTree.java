/*******************************************************************************
  * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-31 
 * 
 *******************************************************************************/ 
package com.qihoo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

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
public class BinaryTree {
	/** �������Ĺ�����ʾ  */  
	    private String expression;  
	    /**   ���ĸ����   */      
	    private TreeNode  root;  
	      
	    /**  
	     * ���ڼ��������������ʽ�Ϸ��Եı����˵�������ʽ: 
	     * �Ϸ��Ĺ������ʽ�����ǣ� 
	     * [1] �������ʽ�� A��A(,), A(B,), A(,B), A(B,C) 
	     * [2] ������ A��B��C ������ [1] �еĻ������ʽ 
	     * [3] A,B,C �������ȡֵ��Χ��Ӧ�þ���������������� ��Сд��ĸ�����֣�+-/*% 
	     * [4] ���ʽ�в����κοո������ˣ��ڼ����ʽ֮ǰ������ȷ�����ʽ�в����ո�� 
	     *  
	     */  
	    private static String permittedChars = "[a-zA-Z0-9//+//-//*/////%]";  
	    private static String basicUnit = "[a-zA-Z0-9//+//-//*/////%//(//),]";  
	    private static Pattern basicPattern = Pattern.compile("" + "|" + permittedChars + "|" + permittedChars + "//(" + permittedChars + "?," + permittedChars + "?//)?");  
	    private static Pattern extendPattern = Pattern.compile(permittedChars + "//(" + basicUnit + "*," + basicUnit + "*//)");  
	      
	    /** 
	     * ������ 
	     * @param root ���ĸ���� 
	     */  
	    public BinaryTree(TreeNode root) {  
	        this.root = root;  
	    }  
	      
	    /** 
	     * ������ 
	     * @param expression �������Ĺ������ʽ 
	     */  
	    private BinaryTree(String expression) {  
	        this.expression = expression;  
	    }  
	    /** 
	     * �����ʵ�� 
	     */  
	    private class TreeNode {  
	          
	        private char ch;  
	        private TreeNode rchild;  
	        private TreeNode lchild;  
	          
	        public TreeNode(char ch, TreeNode rchild, TreeNode lchild) {  
	            this.ch = ch;  
	            this.rchild = rchild;  
	            this.lchild = lchild;  
	        }  
	        public char getCh() {  
	            return ch;  
	        }  
	        public TreeNode getRchild() {  
	            return rchild;  
	        }  
	        public void setRchild(TreeNode rchild) {  
	            this.rchild = rchild;  
	        }  
	        public TreeNode getLchild() {  
	            return lchild;  
	        }  
	        public void setLchild(TreeNode lchild) {  
	            this.lchild = lchild;  
	        }     
	          
	        public String toString()  
	        {  
	            return "" + getCh();  
	        }  
	    }  
	      
	    /** 
	     * �������� 
	     */  
	    private class NodeLink {  
	          
	        private TreeNode node1;  
	        private TreeNode node2;  
	          
	        public NodeLink(TreeNode node1, TreeNode node2) {  
	            this.node1 = node1;  
	            this.node2 = node2;  
	        }  
	          
	        public String toString() {  
	              
	            return "(" + node1.getCh() + "," + node2.getCh() + ")";  
	        }  
	              
	    }  
	      
	    /** 
	     *  ������/��ȡ������ 
	     */  
	    public TreeNode getRoot() {  
	        return root;  
	    }  
	    public void setRoot(TreeNode root) {  
	        this.root = root;  
	    }  
	      
	      
	    /** 
	     * getPreOrderList: ���������������б� 
	     * @param flag �Ƿ���õݹ�����ı�ǣ��� flag = true�� ���õݹ���������򣬲��÷ǵݹ���� 
	     * @return ����������������б� 
	     */  
	      
	    public List<TreeNode> getPreOrderList(boolean flag) {  
	          
	        List<TreeNode>    nodelist = new ArrayList<TreeNode>();  
	        if (flag == true) {  
	           nodelist = preOrderTraverse(getRoot(), nodelist);  
	        }  
	        else {  
	           nodelist = preOrderTraverseIter(getRoot());  
	        }  
	        return nodelist;  
	    }  
	      
	    /** 
	     * getInOrderList: ���������������б� 
	     * @param flag �Ƿ���õݹ�����ı�ǣ��� flag = true�� ���õݹ���������򣬲��÷ǵݹ���� 
	     * @return ���������������б� 
	     */  
	      
	    public List<TreeNode> getInOrderList(boolean flag) {  
	          
	        List<TreeNode>    nodelist = new ArrayList<TreeNode>();  
	        if (flag == true) {  
	           nodelist = inOrderTraverse(getRoot(), nodelist);  
	        }  
	        else {  
	           nodelist = inOrderTraverseIter(getRoot());  
	        }  
	        return nodelist;  
	    }  
	      
	    /** 
	     * getPostOrderList: ������ĺ�������б� 
	     * @param flag �Ƿ���õݹ�����ı�ǣ��� flag = true�� ���õݹ���������򣬲��÷ǵݹ���� 
	     * @return ������ĺ�������б� 
	     */  
	      
	    public List<TreeNode> getPostOrderList(boolean flag) {  
	          
	        List<TreeNode>    nodelist = new ArrayList<TreeNode>();  
	        if (flag == true) {  
	            nodelist = postOrderTraverse(getRoot(), nodelist);  
	        }  
	        else {  
	            nodelist = postOrderTraverseIter(getRoot());  
	        }  
	        return nodelist;  
	    }  
	      
	    /** 
	     * ������Ĳ�������б� 
	     *  
	     * @return ������Ĳ�������б� 
	     */  
	      
	    public List<TreeNode> getFloorOrderList() {  
	          
	        List<TreeNode>    nodelist = new ArrayList<TreeNode>();  
	        nodelist = floorOrderTraverse(getRoot());  
	        return nodelist;  
	    }  
	      
	    /** 
	     * createBinaryTree: �������Ĺ�����ʾ��������� 
	     * @throws Exception  
	     */  
	    public static BinaryTree createBinaryTree(String expression) throws Exception   
	    {  
	        BinaryTree bt = new BinaryTree(trimSpace(expression));  
	        bt.createBinaryTree();  
	        return bt;  
	    }  
	      
	    /** 
	     * createBinaryTree: ���ݶ������Ĺ������ʽ������������ 
	     * @exception ���������Ĺ������ʽ���Ϸ������׳��쳣 
	     */  
	    private void createBinaryTree() throws Exception {  
	          
	        // ��鴫��Ķ����������ʾ���Ƿ�Ϸ���Ч  
	        if (!checkValid(expression))  
	            throw new Exception("�������ʽ���Ϸ����޷�����������!");  
	          
	        // ʹ�� LinkedList ��ִ��ջ�Ĺ���  
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  
	        TreeNode newnode = null;  
	        int flag = 0;  //  flag = 0: ���������� | flag = 1: ����������  
	          
	        for (char ch: expression.toCharArray()) {  
	            switch (ch) {  
	                 
	               // ����  "(" ʱ����ʾ�ý������к��ӽ�㣬���ø����ѹ��ջ��  
	               case '(':   
	                   stack.push(newnode);  
	                   flag = 0;  
	                   break;  
	                     
	               // ����  ")" ʱ����ʾ�Ѿ�ɨ���길�����Һ��ӽ���ֵ�������ø����        
	               case ')':  
	                   stack.pop();  
	                   break;  
	                     
	              // ���� "," ʱ�� ��ʾ��Ҫɨ�踸�����Һ��ӽ���ֵ��        
	               case ',':  
	                   flag = 1;  
	                   break;        
	                
	              // ��������ֵ����������������         
	               default:  
	                     
	                    newnode = new TreeNode(ch, null, null);  
	                    if (root == null) {  
	                           root = newnode;  
	                    }  
	                    else {  
	                           if (flag == 0) {  
	                              TreeNode topnode = stack.peek();  
	                              topnode.setLchild(newnode);  
	                           }  
	                           else   
	                           {  
	                               TreeNode topnode = stack.peek();  
	                               topnode.setRchild(newnode);   
	                           }  
	                    }  
	                    break;           
	            }  
	        }         
	    }  
	      
	    /** 
	     * checkValid: �жϸ����������Ĺ�����ʾ�Ƿ�Ϸ���Ч 
	     *              
	     * @param expression �����������Ĺ�����ʾ���ַ�����ʽ�� 
	     * @return ��������Ķ�����������ʾ�Ϸ���Ч������true; ���򣬷��� false 
	     *  
	     */  
	    private static boolean checkValid(String expression)  
	    {  
	        if (basicPattern.matcher(expression).matches())  
	            return true;  
	        else if ((extendPattern.matcher(expression)).matches()) {  
	            int index = separatorIndex(expression);  
	            if (index == -1) {  // �������ܹ��ָ������������ʽ�������������ʽ�Ķ���  
	                return false;  
	            }  
	            String rightEx = "";  
	            String leftEx = "";   
	            if (index > 2) {  
	                leftEx = expression.substring(2, index);  // �������Ĺ�����ʽ  
	            }  
	            if (index < expression.length()-2) {   
	                  rightEx = expression.substring(index+1, expression.length()-1);  // �������Ĺ�����ʽ  
	            }  
	            return checkValid(leftEx) && checkValid(rightEx);         
	        }  
	        else {  
	            return false;  
	        }  
	    }  
	      
	      
	    /** 
	     * getGeneralList: ��ȡ�ö������Ĺ�����ʾ(�ַ�����ʾ) 
	     */  
	    public String getGeneralListString()  
	    {  
	        StringBuilder sb = new StringBuilder("");  
	        if (expression == null) {  
	            createGeneralList(root, sb);  
	            return sb.toString();  
	        }  
	        return  expression;       
	    }  
	      
	    /** 
	     * getGeneralList: ���ݸ��������������������ʾ(�ַ�����ʽ) 
	     * @param root ���ĸ���� 
	     * @return ���Ĺ�����ʾ���ַ�����ʽ�� 
	     */   
	    private void createGeneralList(TreeNode root, StringBuilder sb) {  
	          
	        if (root != null) {  
	              
	            sb.append(root.getCh());  
	            if (root.getLchild() != null || root.getRchild() != null) {  
	                sb.append('(');  
	                if (root.getLchild() != null) {  
	                    createGeneralList(root.getLchild(), sb);  
	                }  
	                sb.append(',');  
	                if (root.getRchild() != null) {               
	                    createGeneralList(root.getRchild(), sb);          
	                }  
	                sb.append(')');  
	            }     
	        }             
	    }  
	      
	    /** 
	     * size: ��ȡ�������Ľ������ 
	     *   
	     * @param root ���ĸ���� 
	     * @return  ���Ľ������ 
	     *  
	     */  
	    public int size(TreeNode root) {  
	          
	        if (root == null)  
	            return 0;  
	        else {  
	            return size(root.getLchild()) + size(root.getRchild()) + 1;  
	        }  
	    }  
	      
	    /** 
	     * leafCounter: ��ȡ��������Ҷ�ӽ����Ŀ 
	     *  
	     * @param root ���ĸ���� 
	     * @return  ����Ҷ�ӽ����Ŀ 
	     *  
	     */  
	    public int leafCounter(TreeNode root) {  
	        if (root == null)  
	            return 0;  
	        else {  
	            if (root.getLchild() == null && root.getRchild() == null)  
	                return 1;  
	            else  
	                return leafCounter(root.getLchild()) + leafCounter(root.getRchild());  
	        }  
	    }  
	      
	    /** 
	     * getLeafNodes : ��ȡ�ö�����������Ҷ�ӽ�� 
	     */  
	    public List<TreeNode> getLeafNodes()  
	    {  
	        List<TreeNode> leaflist = new ArrayList<TreeNode>();  
	        getLeafNodes(getRoot(), leaflist);  
	        return leaflist;  
	    }  
	      
	    /** 
	     * printLeafPaths : ��ӡ�ö�����������Ҷ�ӽ�㵽����·�� 
	     */  
	    public void printLeafPaths()  
	    {  
	        List<TreeNode> leafPath = new ArrayList<TreeNode>();  
	        buildLeafPaths(root, leafPath);  
	    }  
	      
	    /** 
	     * buildLeafPaths : �ݹ�������������������Ҷ�ӽ�㵽����·�� 
	     * @param root �����������ĸ���� 
	     * @param path ���ĳ��Ҷ�ӽ�㵽����·�� 
	     */  
	    public void buildLeafPaths(TreeNode root, List<TreeNode> path)  
	    {  
	        if (root != null) {   
	            path.add(root);  // ���Ӹ���㵽Ҷ�ӽ���·���ϵĽ�㱣������  
	            if (root.getLchild() == null && root.getRchild() == null) { // ����Ҷ�ӽ�㣬���һ��·�������ɶ��䴦��  
	                processPath(path);  
	            }  
	            else {  
	                buildLeafPaths(root.getLchild(), path);  
	                if (root.getLchild() != null) {     
	                   path.remove(path.size()-1);  // ���ݣ�������������������ɾ��ǰһ��·���ϵ�Ҷ�ӽ��  
	                }  
	                buildLeafPaths(root.getRchild(), path);  
	                if (root.getRchild() != null) {  
	                   path.remove(path.size()-1);  
	                }  
	            }  
	        }  
	    }  
	      
	    /** 
	     * processPath : �����ĳҶ�ӽ�㵽������·���Ĳ��� 
	     */  
	    private void processPath(List<TreeNode> path)  
	    {  
	        System.out.println(listToString(path));  
	    }  
	      
	    /** 
	     * getLeafNodes: �ݹ�������������������Ҷ�ӽ�� 
	     * @param root   �����������ĸ���� 
	     * @param leaflist ����������������Ҷ�ӽ�� 
	     */  
	    private void getLeafNodes(TreeNode root, List<TreeNode> leaflist)  
	    {  
	        if (root != null) {  
	            if (root.getLchild() == null && root.getRchild() == null) {  
	                leaflist.add(root);  
	                return ;  
	            }  
	            getLeafNodes(root.getLchild(), leaflist);  
	            getLeafNodes(root.getRchild(), leaflist);  
	        }  
	    }  
	      
	      
	    /** 
	     * height: ��ȡ�������ĸ߶�  
	     *  
	     * @param root   ���ĸ���� 
	     * @return       ���ĸ߶� 
	     *   
	     */  
	      
	    public int height(TreeNode root)  
	    {  
	        if (root == null)  
	            return 0;  
	        else  
	            return 1 + Math.max(height(root.getLchild()), height(root.getRchild()));  
	    }  
	      
	    /** 
	     * getNodelinkList: ��ȡ�ö������Ľ������б� 
	     * @return ���Ľ������б� 
	     */  
	    public List<NodeLink> getNodelinkList() {  
	          
	        List<NodeLink> linklist = new ArrayList<NodeLink>();  
	        createNodelinkList(getRoot(), linklist);  
	        return linklist;  
	          
	    }  
	          
	    /** 
	     * createNodelinkList: �ݹ��������������Ľ������б��ʾ 
	     * @param root �����������ĸ���� 
	     * @param linklist ��Ÿ����������Ľ��������� 
	     */  
	    private void createNodelinkList(TreeNode root, List<NodeLink> linklist) {  
	          
	        if (root != null) {  
	            if (root.getLchild() != null) {  
	                NodeLink nodelink = new NodeLink(root, root.getLchild());  
	                linklist.add(nodelink);  
	                createNodelinkList(root.getLchild(), linklist);  
	            }  
	            if (root.getRchild() != null) {  
	                NodeLink nodelink = new NodeLink(root, root.getRchild());  
	                linklist.add(nodelink);  
	                createNodelinkList(root.getRchild(), linklist);  
	            }  
	        }  
	    }  
	      
	    /** 
	     * preOrderTraverse: �������ĵݹ�������� 
	     *  
	     */  
	    private List<TreeNode> preOrderTraverse(TreeNode root, List<TreeNode> nodelist) {  
	          
	        if (root != null) {  
	            nodelist.add(root);  
	            preOrderTraverse(root.getLchild(), nodelist);     
	            preOrderTraverse(root.getRchild(), nodelist);  
	        }  
	          
	        return nodelist;  
	    }  
	      
	    /** 
	     * preOrderTraverseIter: �������ķǵݹ�������� 
	     */  
	    private List<TreeNode> preOrderTraverseIter(TreeNode root) {  
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  
	        List<TreeNode> nodelist = new ArrayList<TreeNode>();  
	        TreeNode pNode = root;  
	        for (;;) {  
	            while (pNode != null) {  
	                nodelist.add(pNode);        // ���ʸ����  
	                stack.push(pNode);          // �������ջ      
	                pNode = pNode.getLchild();  // ����������  
	            }     
	            pNode = stack.pop();  
	            pNode = pNode.getRchild();      // ����������  
	            if (pNode == null && stack.isEmpty()) { break; }  
	        }             
	        return nodelist;  
	    }  
	      
	    /** 
	     * inOrderTraverse: �������ĵݹ�������� 
	     *  
	     */  
	    private List<TreeNode> inOrderTraverse(TreeNode root, List<TreeNode> nodelist) {  
	          
	        if (root != null) {  
	            inOrderTraverse(root.getLchild(), nodelist);  
	            nodelist.add(root);  
	            inOrderTraverse(root.getRchild(), nodelist);  
	        }  
	          
	        return nodelist;  
	    }  
	      
	    /** 
	     * inOrderTraverseIter: �������ķǵݹ�������� 
	     */  
	      
	    private List<TreeNode> inOrderTraverseIter(TreeNode root) {  
	          
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  
	        List<TreeNode> nodelist = new ArrayList<TreeNode>();  
	          
	        TreeNode pNode = root;  
	        for (;;) {  
	            while (pNode != null) {            // ����������  
	                stack.push(pNode);        
	                pNode = pNode.getLchild();  
	            }  
	            pNode = stack.pop();     
	            nodelist.add(pNode);               // ���ʸ����  
	            pNode = pNode.getRchild();         // ����������  
	            if (pNode == null && stack.isEmpty()) { break; }  
	        }  
	          
	        return nodelist;  
	    }  
	      
	    /** 
	     * postOrderTraverse: �������ĵݹ������� 
	     */  
	    private List<TreeNode> postOrderTraverse(TreeNode root, List<TreeNode> nodelist) {  
	          
	        if (root != null) {  
	            postOrderTraverse(root.getLchild(), nodelist);  
	            postOrderTraverse(root.getRchild(), nodelist);  
	            nodelist.add(root);  
	        }  
	          
	        return nodelist;  
	    }  
	      
	    /** 
	     * postOrderTraverseIter: �������ķǵݹ������� 
	     */  
	    private List<TreeNode> postOrderTraverseIter(TreeNode root) {  
	          
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  
	        List<TreeNode> nodelist = new ArrayList<TreeNode>();  
	          
	        int flag = 0;  // ��ʶ�Ƿ���ʹ�������; flag = 0 ��ʾû�з��ʣ� flag = 1 ��ʾ�Ѿ����ʹ�  
	        TreeNode pNode = root;  
	        TreeNode tmpNode = null;  
	        loop1:  
	        for (;;) {  
	            while (pNode != null) {        // ����������  
	                stack.push(pNode);       
	                pNode = pNode.getLchild();  
	                flag = 0;  
	            }  
	            loop2:  
	            for (;;) {  
	                if (!stack.isEmpty()) {  
	                      
	                    if (flag == 0)               // ��δ���ʸ�����������  
	                    {  
	                       pNode = stack.peek();     // ȡ��������������������������  
	                       pNode = pNode.getRchild();   
	                       flag = 1;  
	                       continue loop1;  
	                    }  
	                      
	                    if (flag == 1) {            // �Ѿ����ʹ�������  
	                        pNode = stack.pop();  
	                        nodelist.add(pNode);    // ���ʸ���㣬ʵ����������������Ϊ�յ�Ҷ�ӽ��   
	                        tmpNode = pNode;        // ����ĳ���������������丸����������  
	                        pNode = stack.peek();   // ȡ�ý��ĸ����   
	                        if (pNode != null) {    // ����㲻Ϊ��(û�л��ݵ��������ĸ����)  
	                            if (tmpNode == pNode.getRchild()) {   
	                                // ����ոշ��ʵĽ�������丸�����Һ��ӣ���ֱ�ӻ��ݷ����丸���;   
	                                continue loop2;   
	                            }  
	                            else {  // ���򣬷����丸����������  
	                                pNode = pNode.getRchild();  
	                                continue loop1;  
	                            }  
	                        }   
	                          
	                    }  
	                      
	                      
	                }  
	                else   // ջ�գ��ݹ���ý������˳�  
	                {  
	                    break loop1;  
	                }  
	            }     
	              
	        }  
	        return nodelist;  
	    }  
	      
	    /** 
	     * floorOrderTraverse: �������Ĳ������ 
	     *  
	     * @param  root ���ĸ���� 
	     * @return ���Ĳ�������б� 
	     *  
	     */  
	    private List<TreeNode> floorOrderTraverse(TreeNode root) {  
	          
	        // ʹ�� LinkedList ��ִ�ж��еĹ���  
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
	        List<TreeNode> nodelist = new ArrayList<TreeNode>();  
	        if (root != null) {  
	            nodelist.add(root);  
	            queue.addLast(root);  
	            while(queue.size() > 0) {  
	                TreeNode node = queue.removeFirst();  
	                if (node.getLchild() != null) {  
	                    nodelist.add(node.getLchild());  
	                    queue.addLast(node.getLchild());  
	                }     
	                if (node.getRchild() != null) {  
	                    nodelist.add(node.getRchild());  
	                    queue.addLast(node.getRchild());  
	                }     
	            }  
	        }  
	          
	        return nodelist;  
	    }  
	      
	    /** 
	     * copyBinaryTree: ���ƶ����� 
	     * @return ���ƺ�Ķ����� 
	     */  
	    public BinaryTree copyBinaryTree()  
	    {  
	        TreeNode anotherRoot = null;  
	        anotherRoot = copy(getRoot());  
	        return new BinaryTree(anotherRoot);  
	    }  
	      
	    /** 
	     * copy: ���ƶ����� 
	     * @param srcRoot Ҫ���ƵĶ������ĸ���� 
	     * @param destRoot Ŀ��������ĸ���� 
	     */  
	    private TreeNode copy(TreeNode srcRoot)  
	    {  
	        if (srcRoot != null) {  
	            TreeNode newNode = new TreeNode(srcRoot.getCh(), null, null);  
	            newNode.setLchild(copy(srcRoot.getLchild()));  
	            newNode.setRchild(copy(srcRoot.getRchild()));  
	            return newNode;  
	        }  
	        return null;  
	    }  
	      
	    /** 
	     * equalsTo: �Ƚϸö���������������� another �Ƿ�ȫ�ȣ� 
	     *           ��ȫ���򷵻� true, ���򷵻� false. 
	     */  
	    public boolean equalsTo(BinaryTree another)  
	    {  
	        return compareEqual(root, another.getRoot());  
	    }  
	      
	    /** 
	     * equalsTo : �Ƚϸ����������������Ƿ�ȫ�� 
	     *            ����������ȫ�ȵ��ҽ���  
	     *            A. ������������Ϊ��; ����  
	     *            B. �������������ǿգ������ж�Ӧλ�õĽ�㶼��ͬ����Ӧ���֮��Ĺ���Ҳ��ȫ��ͬ. 
	     */  
	    private boolean compareEqual(TreeNode root, TreeNode anotherRoot)  
	    {  
	        return (root == null && anotherRoot == null) ||   
	               ((root != null && anotherRoot != null) &&  
	                (root.getCh() == anotherRoot.getCh()) &&  
	                (compareEqual(root.getLchild(), anotherRoot.getLchild())) &&   
	                (compareEqual(root.getRchild(), anotherRoot.getRchild())));  
	    }  
	      
	    /** 
	     * swapTree : ���ö����������н������Һ��ӻ��� 
	     */  
	    public void swapTree()  
	    {  
	        StringBuilder sb = new StringBuilder("");  
	        swapTree(root);  
	        createGeneralList(root, sb);  
	        expression = sb.toString();  
	    }  
	      
	    /** 
	     * swapTree : �������Ķ����������н������Һ��ӻ��� 
	     * @param root �����������ĸ���� 
	     */  
	    private void swapTree(TreeNode root)  
	    {  
	        if (root != null) {  
	            TreeNode tmp = root.getLchild();  
	            root.setLchild(root.getRchild());  
	            root.setRchild(tmp);  
	            swapTree(root.getLchild());  
	            swapTree(root.getRchild());  
	        }  
	    }  
	       
	    /** 
	     * longestPath: ��ȡ�ö������е�һ���·�� 
	     * @return �������е�һ���·�� 
	     */  
	    public List<TreeNode> longestPath()   
	    {  
	        List<TreeNode> longestPath = new ArrayList<TreeNode>();  
	        longestPath(root, longestPath);  
	        return longestPath;  
	    }  
	      
	    /** 
	     * longestPath: �ݹ���������������һ���·�� 
	     * @param root  �����������ĸ���� 
	     * @param longestPath ��Ŷ��������·���ϵĽ�� 
	     */  
	    private void longestPath(TreeNode root, List<TreeNode> longestPath)  
	    {  
	        if (root != null) {  
	            longestPath.add(root);  
	            if (root.getLchild() == null && root.getRchild() == null) { // ������������  
	                 return ;  
	            }  
	            if (root.getLchild() != null && root.getRchild() == null) { // �������ǿգ�������Ϊ�գ����·���Ľ�����������·����  
	                longestPath(root.getLchild(), longestPath);  
	            }  
	            if (root.getLchild() == null && root.getRchild() != null) { // �������ǿգ�������Ϊ�գ����·���Ľ�����������·����  
	                longestPath(root.getRchild(), longestPath);  
	            }  
	            if (root.getLchild() != null && root.getRchild() != null) { // �����������ǿ�;�ֱ���������������·����ȡ�����  
	                List<TreeNode> leftLongestPath = new ArrayList<TreeNode>();  
	                List<TreeNode> rightLongestPath = new ArrayList<TreeNode>();  
	                longestPath(root.getLchild(), leftLongestPath);  
	                longestPath(root.getRchild(), rightLongestPath);  
	                if (leftLongestPath.size() >= rightLongestPath.size()) {  
	                    longestPath.addAll(leftLongestPath);  
	                } else if (leftLongestPath.size() < rightLongestPath.size()) {  
	                    longestPath.addAll(rightLongestPath);  
	                }  
	                  
	            }  
	        }  
	    }  
	      
	      
	      
	    /** 
	     * listToString: ���ض������Ľ���б���ַ�����ʾ 
	     *  
	     * @param nodelist  ���Ľ���б� 
	     * @return  �������Ľ���б���ַ�����ʾ  
	     *  
	     */  
	    public String listToString(List<TreeNode> nodelist) {  
	          
	        if (nodelist == null || nodelist.size() == 0) {  
	            return "[ ���� ]";  
	        }  
	        StringBuilder str = new StringBuilder("[");  
	        Iterator<TreeNode> iter = nodelist.iterator();  
	        while (iter.hasNext()) {  
	            TreeNode node = iter.next();  
	            str.append(node.getCh()+" ");  
	        }  
	        str.deleteCharAt(str.length()-1);  
	        str.append(']');  
	        return str.toString();  
	    }  
	      
	      
	    /** 
	     * createBinaryTree: ����ǰ�����������б����ɶ����� 
	     *  
	     * @param preOrderList  ǰ���б��ַ��� 
	     * @param inOrderList   �����б��ַ��� 
	     * @throws Exception  
	     *  
	     */  
	    public static BinaryTree createBinaryTree(String preOrderList, String inOrderList) throws Exception {  
	        BinaryTree bt = new BinaryTree(getGeneralList(preOrderList, inOrderList));  
	        bt.createBinaryTree();  
	        return bt;  
	    }  
	      
	    /** 
	     * getGeneralist: ����ǰ�����������б����ɶ������Ĺ�����ʾ���ַ�����ʽ�� 
	     *  
	     * @param preOrderList  ǰ���б��ַ��� 
	     * @param inOrderList   �����б��ַ��� 
	     * @return generalList  ������ʾ 
	     *  
	     */  
	      
	    private static String getGeneralList(String preOrderList, String inOrderList) {  
	          
	        String s = "";  
	        if (preOrderList.length() > 0 || inOrderList.length() > 0) {  
	              
	            // ���ֻ��һ�����ֵ����ֱ�ӷ���  
	            if (preOrderList.length() == 1)  
	                return preOrderList;  
	              
	            // ����ǰ������� ��һ���Ǹ�����ֵ  
	            char ch = preOrderList.charAt(0);   
	              
	            // �����������������㣬��ǰ���б��Ϊ���������б�  
	            int index = inOrderList.indexOf(ch);  
	            String inOrderLeft = inOrderList.substring(0, index);                     // ����������������б�  
	            String inOrderRight = inOrderList.substring(index+1);                     // ����������������б�  
	            String preOrderLeft = preOrderList.substring(1, inOrderLeft.length()+1);  // ��������ǰ������б�  
	            String preOrderRight = preOrderList.substring(inOrderLeft.length()+1);    // ��������ǰ������б�  
	            s += ch;  
	            s += "(" + getGeneralList(preOrderLeft,inOrderLeft) + "," + getGeneralList(preOrderRight,inOrderRight) + ")";   
	        }  
	        return s;  
	    }  
	      
	    /** 
	     * createBinaryTree: ��������ͺ�������б����ɶ����� 
	     *  
	     * @param  inOrderList   �����б� 
	     * @param  postOrderList �����б� 
	     * @param  flag          ��� 
	     *  
	     * @throws Exception  
	     */  
	    public static BinaryTree createBinaryTree(String inOrderList, String postOrderList, boolean flag) throws Exception {  
	        BinaryTree bt = new BinaryTree(getGeneralList(inOrderList, postOrderList, flag));  
	        bt.createBinaryTree();  
	        return bt;  
	    }  
	      
	      
	      
	    /** 
	     * getGeneralList: ��������ͺ���������ɶ������Ĺ�����ʾ���ַ�����ʽ�� 
	     *  
	     * @param  inOrderList   �����б� 
	     * @param  postOrderList �����б� 
	     * @param  flag          ��� 
	     * @return generalList   ������ʾ 
	     *  
	     */  
	      
	    private static String getGeneralList(String inOrderList, String postOrderList, boolean flag) {  
	          
	        String s = "";  
	        if (inOrderList.length() > 0 || postOrderList.length() >0) {  
	              
	            // ���ֻ��һ�����ֵ����ֱ�ӷ���  
	            if (inOrderList.length() == 1)   
	                return inOrderList;  
	              
	            // ���ݺ�������������һ���Ǹ�����ֵ  
	            char ch = postOrderList.charAt(postOrderList.length()-1);   
	              
	            // �����������������㣬��ǰ���б��Ϊ���������б�  
	            int index = inOrderList.indexOf(ch);  
	            String inOrderLeft = inOrderList.substring(0, index);                     // ����������������б�  
	            String inOrderRight = inOrderList.substring(index+1);                     // ����������������б�  
	            String postOrderLeft = postOrderList.substring(0, inOrderLeft.length());  // ��������ǰ������б�  
	            String postOrderRight = postOrderList.substring(inOrderLeft.length(),   
	                                    inOrderLeft.length()+inOrderRight.length());    // ��������ǰ������б�  
	            s += ch;  
	            s += "(" + getGeneralList(inOrderLeft,postOrderLeft,true) + "," + getGeneralList(inOrderRight,postOrderRight,true) + ")";   
	        }  
	        return s;  
	    }  
	      
	    /** 
	     * trimSpace: ���������ʽ�ַ����еĿո��ȥ�� 
	     */  
	    private static String trimSpace(String s)  
	    {  
	        StringBuilder sb = new StringBuilder("");  
	        for (int i=0; i < s.length(); i++) {  
	            char ch = s.charAt(i);  
	            if (!(new Character(ch).toString().matches("//s"))) {     
	                sb.append(ch);  
	            }  
	        }  
	        return sb.toString();  
	    }  
	      
	    /** 
	     * separatorIndex : ���������ʽ�зָ����������ķָ�����λ�� 
	     *                  ��������ʹ�ö��ŷָ��������������ҽ�����λ��Ӧ�����㣺 
	     *                  �ڸ÷ָ��֮ǰ�������ŵ���Ŀǡ�ñ������ŵ���Ŀ��1.  
	     * @return  ���������������ķָ������򷵻���λ�ã����򷵻� -1 
	     */  
	    private static int separatorIndex(String expression)  
	    {  
	        int leftBracketCounter=0, rightBacketCounter=0;  
	        int index = 0;  
	        for (; index < expression.length(); index++) {  
	            char ch = expression.charAt(index);  
	            if (ch == '(') {  
	                leftBracketCounter++;  
	            }  
	            else if (ch == ')') {  
	                rightBacketCounter++;  
	            }  
	            else if (ch == ',') {  
	                if (leftBracketCounter == rightBacketCounter+1) break;  
	            }  
	        }  
	        if (index < expression.length()) {  
	            return index;  
	        }  
	        return -1;  
	    } 
}
