package DataStructure;

import Element.Jobs;

public class ThreadedListNode {

	private Jobs jobs; 
	private ThreadedListNode next;

	public ThreadedListNode(Jobs jobs){  

		this.jobs = jobs;
		this.next = null; 
	}

	public Jobs getJobs (){
		
		return this.jobs;
	}

	public void setJobs(Jobs jobs){
		
		this.jobs = jobs;
	}

	public ThreadedListNode getNext() {
		
		return this.next;
	}

	public void setNext(ThreadedListNode newNode) {
		
		this.next = newNode;
	}
}
