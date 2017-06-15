package entities;

import java.util.HashMap;
import java.util.Stack;

public class Heap {
    int n = 0;
    Stack<Worker> heap = new Stack<Worker>();
    HashMap<Worker, Integer> rank = new HashMap<Worker, Integer>();
    
    public Heap(Worker[] foo) {
	for (Worker x : foo) {
	    this.push(x);
	    x.run();
	}
    }
    
    public int length() {
   	return this.heap.size() - 1;
   }
    
    public void push(Worker x) {
	if (!rank.containsKey(x)) {
	    int i = this.heap.size();
	    this.heap.push(x);
	    this.rank.put(x, i);
	    this.up(i);
	}
    }
    
    public Worker pop() {
	Worker root = this.heap.get(1);
	this.rank.remove(root);
	Worker x = this.heap.pop();
	
	if (!this.heap.isEmpty()) {
	    this.heap.set(1, x);
	    this.rank.put(x, 1);
	    this.down(1);
	}
	
	return root;
    }
   
    public void up(int i) {
	Worker x = this.heap.get(i);
	while (i > 1 && x.id < this.heap.get((int)i / 2).id) {
	    this.heap.set(i, this.heap.get((int) i / 2));
	    this.rank.put(this.heap.get((int) i / 2), i);
	    i = (int) i / 2;
	}
	
	this.heap.set(i, x);
	this.rank.put(x, i);
    }
    
    public void down(int i) {
	Worker x = this.heap.get(i);
	n = heap.size();
	while (true) {
	    int left = 2 * i;
	    int right = left + 1;
	    if (right < n &&
		    this.heap.get(right).id < x.id && this.heap.get(right).id < this.heap.get(left).id) {
		this.heap.set(i, this.heap.get(right));
		this.rank.put(this.heap.get(right), i);
		i = right;
	    } else if (left < n && this.heap.get(left).id < x.id) {
		this.heap.set(i, this.heap.get(left));
		this.rank.put(this.heap.get(left), i);
		i = left;
	    } else {
		this.heap.set(i, x);
		this.rank.put(x, i);
		return;
	    }
	}
    }
    
    public void update(Worker older, Worker newer) {
	int i = this.rank.get(older);
	this.rank.remove(older);
	this.heap.set(i, newer);
	this.rank.put(newer, i);
	if (older.id < newer.id) {
	    this.down(i);
	} else {
	    this.up(i);
	}
    }
}
