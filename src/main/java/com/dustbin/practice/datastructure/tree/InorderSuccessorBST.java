package com.dustbin.practice.datastructure.tree;

import java.util.LinkedList;

public class InorderSuccessorBST {

	Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static Node insert(Node root, int data) {

		if (root == null) {
			Node newNode = new Node(data);
			root = newNode;
		} else if (data <= root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		}

		return root;
	}

	static void displayLevelOrderTraversal(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		Node current = null;
		if (root == null) {
			System.out.println("empty tree");
		} else {
			queue.add(root);
			while (!queue.isEmpty()) {
				current = queue.peek();
				System.out.print(current.data + " ");
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
				queue.poll();
			}
		}
	}

	static void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	static Node find(Node root, int data) {

		if (root == null)
			return null;
		else if (root.data == data)
			return root;
		else if (root.data < data)
			return find(root.right, data);
		else
			return find(root.left, data);
	}

	static Node findMin(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	static Node getSuccessor(Node root, int data) {

		Node searchedNode = find(root, data);
		if (searchedNode == null)
			return null;
		// Case 1: Node has right subtree- O(h)
		else if (searchedNode.right != null) {
			return findMin(searchedNode.right);
		} else {
			// Case 2: No right subtree - O(h)
			Node successor = null;
			Node ancestor = root;
			while (ancestor != searchedNode) {
				if (searchedNode.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
	}

	public static void main(String[] args) {

		InorderSuccessorBST btree = new InorderSuccessorBST();
		Node root = btree.root;
		
		/*Code To Test the logic
		  Creating an example tree
		            15
				   / \
				  10   20
				 / \   /  \
				8  12 17  25
			   /   /  /     \
			  6   11 16     27
	    */

		root = insert(root, 15);
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 12);
		root = insert(root, 17);
		root = insert(root, 25);
		root = insert(root, 6);
		root = insert(root, 11);
		root = insert(root, 16);
		root = insert(root, 27);

		displayLevelOrderTraversal(root);
		System.out.println();

		inorderTraversal(root);
		System.out.println();
		
		System.out.println(getSuccessor(root,17).data);

	}

}
