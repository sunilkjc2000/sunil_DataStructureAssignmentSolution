package com.greatlearning.driver;
import com.greatlearning.bst.*;
import com.greatlearning.bst.ConvertBST2SkewTree.Node;


public class driver {
	
	public static void main (String[] args)
    {
		ConvertBST2SkewTree tree = new ConvertBST2SkewTree();
		
		// Construct BST
		Node node;
	    node = tree.new Node(40);
		node.left = tree.new Node(30);
		node.right = tree.new Node(60);
		node.left.left = tree.new Node(10);
		node.right.left= tree.new Node(50);
       
        //Convert BST to skewed tree
        tree.convertBst2Skew(node);
        
        // PRint skewed tree
        ConvertBST2SkewTree.traverseSkewedTree(tree.headNode);
    }
}
