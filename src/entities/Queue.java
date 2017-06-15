package entities;

import java.util.Stack;

public class Queue {
    public Stack<Object> inStack = new Stack<Object>();
    public Stack<Object> outStack = new Stack<Object>();

    public Queue() {}

    public int length() {
	return this.inStack.size() + this.outStack.size();
    }

    public void push(Object foo) {
	this.inStack.push(foo);
    }
    
    public Object pop() {
	if (this.outStack.isEmpty()) {
	    while (!this.inStack.isEmpty())
		this.outStack.push(this.inStack.pop());

	    this.inStack = new Stack<Object>();  	    
	}
	
	return this.outStack.pop();
    }
}
