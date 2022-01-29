package com.greatlearning.bst;

import com.greatlearning.bst.ConvertBST2SkewTree.Node;

public class ConvertBST2SkewTree {
	
	public class Node
    {
        int val;
        public Node left;
		public Node right;
        
        public Node(int item)
        {
            val = item;
            left = right = null;
        }
    }
	
	 public static Node prevNode = null;
	 public static Node headNode = null;

    // Function to convert BST to skewed tree
    public void convertBst2Skew(Node root)
    {
       
        if(root == null)
        {
            return;
        }
        
        // Traverse to left most node, as left most node is least value and 
        // will be next root for skewed tree
        convertBst2Skew(root.left);
        Node rightNode = root.right;
        Node leftNode = root.left;
        
        // headNode is new root. prevNode always points to previous root 
        // to which next right node is attached
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
        
        // Traverse right tree of BST
        convertBst2Skew(rightNode);
        
    }
    
    // Function to traverse and print skewed tree
    public static void traverseSkewedTree(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseSkewedTree(root.right);       
    }
};
	