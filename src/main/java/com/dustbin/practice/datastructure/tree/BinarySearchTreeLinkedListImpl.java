package com.dustbin.practice.datastructure.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTreeLinkedListImpl {

	BSTNode rootNodePointer;

	static class BSTNode {
		int data;
		BSTNode left;
		BSTNode right;

		BSTNode(int data) {
			this.data = data;
		}
	}

	BSTNode insertRecursiveApproach(BSTNode node, int data) {

		if (node == null) {
			BSTNode newBstNode = new BSTNode(data);
			node = newBstNode;
		} else if (data <= node.data) {
			node.left = insertRecursiveApproach(node.left, data);
		} else if (data > node.data) {
			node.right = insertRecursiveApproach(node.right, data);
		}
		System.out.println(node.data);
		return node;
	}

	BSTNode insertNew(BSTNode node, int data) {

		if (node == null) {
			BSTNode newBstNode = new BSTNode(data);
			node = newBstNode;
			System.out.println(node.data);
		} else if (data <= node.data) {
			node.left = insertNew(node.left, data);
			System.out.println(node.data);
		} else if (data > node.data) {
			node.right = insertNew(node.right, data);
		}
		return node;
	}

	BSTNode insertIterativeApproach(BSTNode rootNode, int data) {

		BSTNode temp = rootNode;
		BSTNode newNode = new BSTNode(data);
		if (rootNode == null) {
			rootNode = newNode;
		} else {
			while (temp != null) {

				if (data <= temp.data) {
					if (temp.left != null)
						temp = temp.left;
					else {
						temp.left = newNode;
						break;
					}
				} else if (data > temp.data) {
					if (temp.right != null)
						temp = temp.right;
					else {
						temp.right = newNode;
						break;
					}
				}
			}
		}

		return rootNode;
	}

	public static void findFullNode(BSTNode root) {
		if (root != null) {
			findFullNode(root.left);
			if (root.left != null && root.right != null)
				System.out.print(root.data + " ");
			findFullNode(root.right);
		}
	}

	static boolean search(BSTNode root, int data) {
		if (root == null) {
			return false;
		} else if (data < root.data) {
			System.out.println(root.data);
			return search(root.left, data);
		} else if (data > root.data) {
			System.out.println(root.data);
			return search(root.right, data);
		} else if (root.data == data) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}

	int findMin(BSTNode rootNode) {

		if (rootNode == null) {
			System.out.println("tree is empty");
			return 0;
		}

		int min = rootNode.data;
		while (rootNode.left != null) {
			rootNode = rootNode.left;
		}
		min = rootNode.data;
		return min;
	}

	int findMinRecursive(BSTNode rootNode) {

		if (rootNode == null) {
			System.out.println("tree is empty");
			return 0;
		}
		int min = rootNode.data;
		System.out.println(min);
		if (rootNode.left != null) {
			min = findMinRecursive(rootNode.left);
		}

		return min;
	}

	int findMax(BSTNode rootNode) {

		if (rootNode == null) {
			System.out.println("tree is empty");
			return 0;
		}

		int min = rootNode.data;
		while (rootNode.right != null) {
			rootNode = rootNode.right;
		}
		min = rootNode.data;
		return min;
	}

	int findHeight(BSTNode root) {

		if (root == null) {
			return -1;
		}
		return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
	}

	void levelOrderTraversalBFS(BSTNode root) {

		BSTNode current = null;
		LinkedList<BSTNode> queue = new LinkedList<>();
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

	void dfsPreOrder(BSTNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			dfsPreOrder(root.left);
			dfsPreOrder(root.right);
		}
	}

	void dfsInOrder(BSTNode root) {
		if (root != null) {
			dfsInOrder(root.left);
			System.out.print(root.data + " ");
			dfsInOrder(root.right);
		}
	}

	void dfsPostOrder(BSTNode root) {
		if (root != null) {
			dfsPostOrder(root.left);
			dfsPostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) {

		BinarySearchTreeLinkedListImpl bst = new BinarySearchTreeLinkedListImpl();
		BSTNode rootNode = bst.rootNodePointer;

		/*
		 * rootNode = bst.insertRecursiveApproach(rootNode, 15); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 10); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 20); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 17); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 25); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 8); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 12); rootNode =
		 * bst.insertRecursiveApproach(rootNode, 5);
		 */

		rootNode = bst.insertIterativeApproach(rootNode, 15);
		rootNode = bst.insertIterativeApproach(rootNode, 10);
		rootNode = bst.insertIterativeApproach(rootNode, 20);
		rootNode = bst.insertIterativeApproach(rootNode, 17);
		rootNode = bst.insertIterativeApproach(rootNode, 25);
		rootNode = bst.insertIterativeApproach(rootNode, 8);
		rootNode = bst.insertIterativeApproach(rootNode, 12);
		rootNode = bst.insertIterativeApproach(rootNode, 5);

		// System.out.println(search(rootNode, 17) == true ? "found" : "not found");
		// System.out.println("minimum element in tree- " +
		// bst.findMinRecursive(rootNode));
		// System.out.println("maximum element in tree- " + bst.findMax(rootNode));
		// System.out.println("height of a tree- " + bst.findHeight(rootNode));

		// Level Order traversal- BFS
		bst.levelOrderTraversalBFS(rootNode);
		System.out.println("- level order travarsal(BFS)");

		// DFS traversal Pre Order
		bst.dfsPreOrder(rootNode);
		System.out.println("- pre order traversal(DFS)");

		// DFS traversal In Order
		bst.dfsInOrder(rootNode);
		System.out.println("- in order traversal(DFS)");

		// DFS traversal Post Order
		bst.dfsPostOrder(rootNode);
		System.out.println("- post order traversal(DFS)");

		// findFullNode(rootNode);

	}

}
