package com.dustbin.practice.datastructure.tree;

import java.util.LinkedList;

public class BinaryTree {

	Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	boolean isLesserThan(Node node, int data) {

		if (node != null) {
			if (node.data <= data && isLesserThan(node.left, data) && isLesserThan(node.right, data)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	boolean isGreaterThan(Node node, int data) {

		if (node != null) {
			if (node.data > data && isLesserThan(node.left, data) && isLesserThan(node.right, data)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	boolean isBST(Node root) {

		if (root != null) {
			if (isLesserThan(root.left, root.data) && isGreaterThan(root.right, root.data) && isBST(root.left)
					&& isBST(root.right)) {
				return true;
			}

		} else {
			return true;
		}

		return false;
	}

	boolean isBSTBounderApproach(Node root, int min, int max) {

		if (root == null) {
			return true;
		} else {
			if (root.data >= min && root.data < max && isBSTBounderApproach(root.left, min, root.data)
					&& isBSTBounderApproach(root.right, root.data, max))
				return true;

		}
		return false;
	}

	Node insert(Node root, int data) {

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

	void levelOrderTraversalBFS(Node root) {

		Node current = null;
		LinkedList<Node> queue = new LinkedList<>();
		if (root == null) {
			System.out.print("empty tree");
		} else {
			queue.add(root);
			while (!queue.isEmpty()) {
				current = queue.peek();
				System.out.print(queue.peek().data + " ");
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
				queue.poll();

			}
		}

	}

	void invertBinaryTree(Node root) {
		Node temp = null;
		if (root != null) {
			invertBinaryTree(root.left);
			invertBinaryTree(root.right);
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}

	public static void main(String[] args) {

		BinaryTree btree = new BinaryTree();
		Node root = btree.root;

		root = btree.insert(root, 4);
		root = btree.insert(root, 7);
		root = btree.insert(root, 2);
		root = btree.insert(root, 1);
		root = btree.insert(root, 3);
		root = btree.insert(root, 6);
		root = btree.insert(root, 9);
		
		/*root = btree.insert(root, 5);
		root = btree.insert(root, 1);
		root = btree.insert(root, 8);
		root = btree.insert(root, 9);
		root = btree.insert(root, 2);*/
		// System.out.println(root.data);

		btree.levelOrderTraversalBFS(root);
		System.out.println();
		// btree.invertBinaryTree(root);
		// btree.levelOrderTraversalBFS(root);
		System.out.println(btree.isBST(root));
		System.out.println(btree.isBSTBounderApproach(root, Integer.MIN_VALUE,Integer.MAX_VALUE));

	}

}
