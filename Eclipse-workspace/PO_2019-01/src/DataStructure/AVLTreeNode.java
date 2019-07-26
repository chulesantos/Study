package DataStructure;

import Element.Jobs;

public class AVLTreeNode {

	private ThreadedList itemList = new ThreadedList();
	private AVLTreeNode left, right;
	private byte balancingFactor;

	public AVLTreeNode(Jobs jobs) {

		itemList.InsertFirst(jobs);
		this.balancingFactor = 0;

	}

	public  AVLTreeNode(ThreadedList list) {

		itemList = list;
		this.balancingFactor = 0;

	}
	
	public AVLTreeNode getRight() {

		return this.right;
	}

	public void setRight(AVLTreeNode right) {

		this.right = right;
	} 

	public AVLTreeNode getLeft() {

		return this.left;
	}

	public void setLeft(AVLTreeNode left) {

		this.left = left;
	}

	public byte getBalancingFactor() {

		return this.balancingFactor;
	}

	public void setBalancingFactor(byte balancingFactor) {

		this.balancingFactor = balancingFactor;
	}

	public ThreadedList getItemList() {

		return this.itemList;
	}
}