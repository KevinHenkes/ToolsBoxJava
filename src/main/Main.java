package main;

import entities.Queue;

public class Main {

	public static void main(String[] args) {
	    Queue queue = new Queue();
	    
	    queue.push(5);
	    
	    queue.push(10);
	    
	    System.out.println(queue.pop());
	}
}
