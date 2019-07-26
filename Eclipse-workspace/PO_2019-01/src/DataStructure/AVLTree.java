package DataStructure;

import Element.Jobs;

public class AVLTree {

	private AVLTreeNode root;
	private boolean h;

	public AVLTree() {

		this.root = null;
		this.h = true;
	}

	public void InsertRoot(Jobs jobs) {

		this.root = this.Insert(jobs, this.root);
	}

	private AVLTreeNode Insert(Jobs jobs, AVLTreeNode node) {

		if (node == null) {

			AVLTreeNode newNode = new AVLTreeNode(jobs);

			this.h = true;

			return newNode;

		} else {

			if (jobs.getStrJobs().compareTo(node.getItemList().getFirst().getJobs().getStrJobs()) < 0) { 

				node.setLeft(this.Insert(jobs, node.getLeft()));

				node = this.balanceRight(node);

				return node;

			} else {

				node.setRight(this.Insert(jobs, node.getRight()));

				node = this.balanceLeft(node);

				return node;
			}
		}
	}

	private AVLTreeNode balanceRight(AVLTreeNode node){

		if (this.h) {

			switch(node.getBalancingFactor()) {

			case 1:

				node.setBalancingFactor((byte) 0);
				this.h = false;
				break;

			case 0:

				node.setBalancingFactor((byte) -1);
				break;

			case -1:

				node = this.RightRotation(node);
			}
		}
		return node;
	}


	private AVLTreeNode balanceLeft(AVLTreeNode node) {

		if (this.h) {

			switch(node.getBalancingFactor()) {

			case -1:

				node.setBalancingFactor((byte) 0);
				this.h = false;
				break;

			case 0:

				node.setBalancingFactor((byte) 1);
				break;

			case 1:

				node = this.LeftRotation(node);
			}
		}
		return node;
	}

	private AVLTreeNode RightRotation(AVLTreeNode node) {

		AVLTreeNode temp1, temp2;

		temp1 = node.getLeft();

		if (temp1.getBalancingFactor() == -1) {

			node.setLeft(temp1.getRight());

			temp1.setRight(node);

			node.setBalancingFactor((byte) 0);

			node = temp1;

		} else {

			temp2 = temp1.getRight();

			temp1.setRight(temp2.getLeft());

			temp2.setLeft(temp1);

			node.setLeft(temp2.getRight());

			temp2.setRight(node);

			if (temp2.getBalancingFactor() == -1) {

				node.setBalancingFactor((byte) 1);
			}

			else node.setBalancingFactor((byte) 0);

			if (temp2.getBalancingFactor() == 1) {

				temp1.setBalancingFactor((byte) -1);
			}

			else temp1.setBalancingFactor((byte) 0);

			node = temp2;
		}

		node.setBalancingFactor((byte) 0);

		this.h = false;

		return node;
	}

	private AVLTreeNode LeftRotation(AVLTreeNode node) {

		AVLTreeNode temp1, temp2;

		temp1 = node.getRight();

		if (temp1.getBalancingFactor() == 1) {

			node.setRight(temp1.getLeft());

			temp1.setLeft(node);

			node.setBalancingFactor((byte) 0);

			node = temp1;

		} else {

			temp2 = temp1.getLeft();

			temp1.setLeft(temp2.getRight());

			temp2.setRight(temp1);

			node.setRight(temp2.getLeft());

			temp2.setLeft(node);

			if (temp2.getBalancingFactor() == 1) {

				node.setBalancingFactor((byte) -1);
			}

			else node.setBalancingFactor((byte) 0);

			if (temp2.getBalancingFactor() == -1) {

				temp1.setBalancingFactor((byte) 1);
			}

			else temp1.setBalancingFactor((byte) 0);

			node = temp2;
		}

		node.setBalancingFactor((byte) 0);
		this.h = false;
		return node;
	}

	public String Search(String key) {

		boolean loop = true;

		String str = "";

		while(loop) {

			AVLTreeNode temp;

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

	private AVLTreeNode Search(String key, AVLTreeNode node) {

		AVLTreeNode temp;

		temp = node;

		if (temp != null) {

			if (key.compareTo(temp.getItemList().getFirst().getJobs().getStrOffice()) < 0) {

				temp = this.Search(key, temp.getLeft());

			} else {

				if (key.compareTo(temp.getItemList().getFirst().getJobs().getStrOffice()) > 0)

					temp = this.Search(key, temp.getRight());
			}
		}
		return temp;
	}
}