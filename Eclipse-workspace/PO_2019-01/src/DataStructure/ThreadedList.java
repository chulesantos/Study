package DataStructure;

import Element.Jobs;

public class ThreadedList {

	private ThreadedListNode first;
	private ThreadedListNode last;
	private int nodeAmount;

	public ThreadedList() {

		this.first = null;
		this.last = null;
		this.nodeAmount = 0;
	}

	public int getNodeAmount() {
		
		return this.nodeAmount;
	}

	public ThreadedListNode getFirst() {
		
		return this.first;
	}

	public ThreadedListNode getLast() {
		
		return this.last;
	}

	public void setNodeAmount(int newValue) {
		
		this.nodeAmount = newValue;
	}

	public void setFirst(ThreadedListNode newNode) {
		
		this.first = newNode;
	}

	public void setLast(ThreadedListNode newNode) {
		
		this.last = newNode;
	}

	public boolean Empty() {
		
		return (this.first == null);
	}

	public void InsertFirst(Jobs jobs) {

		ThreadedListNode newNode = new ThreadedListNode(jobs);

		if (this.Empty()) {
			
			this.last = newNode;
		}

		newNode.setNext(this.first);
		this.first = newNode;
		this.nodeAmount++;
	}

	public void InsertLast(Jobs jobs) {

		ThreadedListNode newNode = new ThreadedListNode(jobs);

		if (this.Empty()) {

			this.first = newNode;

		} else {

			this.last.setNext(newNode);
		}

		this.last = newNode;
		this.nodeAmount++;
	}

	public ThreadedListNode Search(String key) {

		ThreadedListNode content = this.first;

		while ((content != null) && (content.getJobs().getStrJobs().compareTo(key) != 0)) {

			content = content.getNext();
		}	

		return content;
	}

	public boolean Remove(String key) {

		ThreadedListNode content = this.first;
		ThreadedListNode previous = null;

		if (Empty()) {

			return false;

		} else {
			
			while ((content != null) && (content.getJobs().getStrJobs().compareTo(key) != 0)) {

				previous = content;
				content = content.getNext();
			}

			if (content == null) {

				return false;
			}

			else {

				if (content == this.first) {

					if (this.first == this.last) {

						this.last = null;
					}

					this.first = this.first.getNext();

				} else {

					if (content == this.last) {
						this.last = previous;
					}

					previous.setNext(content.getNext());
				}

				this.nodeAmount--;

				return true;
			}
		}
	}

	public String toString() {

		String str = "";
		ThreadedListNode content = this.first;

		while (content != null) {

			str += content.getJobs().toString()+"\n";
			content = content.getNext();
		}
		return str;
	}
}