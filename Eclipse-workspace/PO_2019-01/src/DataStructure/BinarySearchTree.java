package DataStructure;

import Element.Jobs;

public class BinarySearchTree {

	private BinarySearchTreeNode root;
	int index;

	public BinarySearchTree() {

		this.root = null;
	}

	public BinarySearchTree(BinarySearchTreeNode root) {

		this.root = root;
	}

	public int getIndex() {

		return index;
	}

	public void setIndex(int index) {

		this.index = index;
	}

	public ThreadedList Search(String key) {

		BinarySearchTreeNode temp;
		temp = this.Search(key, this.root);

		if (temp != null) {

			return temp.getItemList();

		} else 

			return null;
	}
	
	public String SearchJobsOffice(String key) {

		boolean loop = true;

		String str = "";

		while(loop) {

			BinarySearchTreeNode temp;

			temp = this.Search(key, this.root);

			if (temp != null) {

				str +=  temp.getItemList().getFirst().getJobs().getEmpresa() + ", ";

				temp.getItemList().getFirst().getJobs().setStrOffice("");
			} 

			if(temp == null) {

				loop = false;
			}

		}
		return str;		
	}

	private BinarySearchTreeNode Search(String key, BinarySearchTreeNode node) {

		BinarySearchTreeNode temp;
		temp = node;

		if (temp != null) {

			if (key.compareTo(temp.getItemList().getFirst().getJobs().getStrOffice()) < 0) {

				temp = this.Search(key, temp.getLeft());

			} else {

				if (key.compareTo(temp.getItemList().getFirst().getJobs().getStrOffice()) > 0) {

					temp = this.Search(key, temp.getRight());

				}
			}
		}
		return temp;
	}

	public boolean Insert(Jobs jobs) {

		ThreadedList exist; 
		index++;
		exist = this.Search(jobs.getStrJobs());

		if (exist != null) {

			InsertIfExist(this.root, jobs);

		} else  

			this.root = this.Insert(jobs, this.root);

		return true;
	}

	private BinarySearchTreeNode Insert(Jobs jobs, BinarySearchTreeNode node) {

		BinarySearchTreeNode newNode; 

		if (node == null) {

			newNode = new BinarySearchTreeNode(jobs);

			return newNode;

		} else {

			if (jobs.getStrJobs().compareTo(node.getItemList().getFirst().getJobs().getStrJobs()) < 0) {

				node.setLeft(this.Insert(jobs, node.getLeft()));

				return node;

			} else {

				node.setRight(this.Insert(jobs, node.getRight()));

				return node;
			}
		}
	}

	private BinarySearchTreeNode InsertIfExist(BinarySearchTreeNode node, Jobs jobs){

		BinarySearchTreeNode newNode; 

		if (node == null) {

			newNode = new BinarySearchTreeNode(jobs);

			return newNode;
		}

		if (jobs.getStrJobs().compareTo(node.getItemList().getFirst().getJobs().getStrJobs()) < 0) {

			node.setLeft(this.Insert(jobs, node.getLeft()));

			return node;

		} else if (jobs.getStrJobs().compareTo(node.getItemList().getFirst().getJobs().getStrJobs()) > 0) {

			node.setRight(this.Insert(jobs, node.getRight()));

			return node;
		}

		else if (jobs.getStrJobs().compareTo(node.getItemList().getFirst().getJobs().getStrJobs()) == 0) {

			node.getItemList().InsertLast(jobs);

			return node;
		}
		return node;
	}

	public OrderVector CenterPath(OrderVector vectorOrdered) {

		return (this.ExecuteCenterPath(this.root, vectorOrdered));
	}

	private OrderVector ExecuteCenterPath(BinarySearchTreeNode node, OrderVector vectorOrdered) {

		if (node != null) {

			vectorOrdered = this.ExecuteCenterPath(node.getLeft(), vectorOrdered);
			vectorOrdered.Insert(node.getItemList().getFirst().getJobs());
			vectorOrdered = this.ExecuteCenterPath(node.getRight(), vectorOrdered);
		}
		return vectorOrdered;
	}

	public BinarySearchTree TreeBalanced(OrderVector vectorOrdered) {

		BinarySearchTree temp = new BinarySearchTree();

		this.Balance(vectorOrdered, temp, 0, vectorOrdered.getSize() -1);

		return temp;
	}

	private void Balance(OrderVector vector, BinarySearchTree temp, int begin, int end) {

		int middle;

		if (end >= begin) {

			middle = (begin + end) / 2;

			temp.Insert(vector.getJobs(middle));

			this.Balance(vector, temp, begin, middle - 1);

			this.Balance(vector, temp, middle + 1, end);
		}
	}

}