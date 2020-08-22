package com.dustbin.practice.datastructure.tree;

import java.util.LinkedList;

public class DeleteNodeBST {

	Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
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

	Node delete(Node root, int data) {
		if (root == null) {
			return root;
		} else if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			} else {
				Node temp = findMin(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}

		return root;
	}

	Node findMin(Node root) {
		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	public static void main(String[] args) {

		DeleteNodeBST btree = new DeleteNodeBST();
		Node root = btree.root;
		root = btree.insert(root, 12);
		root = btree.insert(root, 5);
		root = btree.insert(root, 15);
		root = btree.insert(root, 3);
		root = btree.insert(root, 7);
		root = btree.insert(root, 13);
		root = btree.insert(root, 17);
		root = btree.insert(root, 1);
		root = btree.insert(root, 9);
		root = btree.insert(root, 14);
		root = btree.insert(root, 20);
		root = btree.insert(root, 8);
		root = btree.insert(root, 11);
		root = btree.insert(root, 18);

		btree.levelOrderTraversalBFS(root);
		System.out.println();

		root = btree.delete(root, 12);
		System.out.println(root.data);
		btree.levelOrderTraversalBFS(root);

	}

}
