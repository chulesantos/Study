package DataStructure;

import Element.Jobs;

public class BinarySearchTreeNode {

	private ThreadedList itemList;
	private BinarySearchTreeNode left, right;

	public BinarySearchTreeNode(Jobs jobs) {

		itemList = new ThreadedList();
		this.itemList.InsertLast(jobs);

	}

	public BinarySearchTreeNode getRight() {

		return right;
	}

	public void setRight(BinarySearchTreeNode right) {

		this.right = right;
	}

	public BinarySearchTreeNode getLeft() {

		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {

		this.left = left;
	}

	public ThreadedList getItemList() {

		return itemList;
	}

	public void setItemList(Jobs jobs) {

		itemList.getFirst().setJobs(jobs);;
	}

	public void Insert(Jobs jobs) {
		
		this.itemList.InsertLast(jobs);
	}
}
