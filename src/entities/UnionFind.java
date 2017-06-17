package entities;

public class UnionFind {
    int[] up = new int[1];
    int[] rank = new int[1];
    int i = 0;
    
    public UnionFind(int foo) {
	this.up = new int[foo];
	this.i = 0;
	
	while (i < up.length) {
	    this.up[i] = i;
	    i++;
	}
	
	this.rank = new int[foo];
    }
    
    public int find(int x) {
	if (this.up[x] == x) {
	    return x;
	} else {
	    this.up[x] = this.find(this.up[x]);
	    return this.up[x];
	}
    }
    
    public boolean union(int x, int y) {
	int repr_x = this.find(x);
	int repr_y = this.find(y);
	
	if (repr_x == repr_y) {
	    return false;
	}
	
	if (this.rank[repr_x] == this.rank[repr_y]) {
	    this.rank[repr_x] += 1;
	    this.up[repr_y] = repr_x;
	} else if(this.rank[repr_x] > this.rank[repr_y]) {
	    this.up[repr_y] = repr_x;
	} else {
	    this.up[repr_x] = repr_y;
	}
	
	return true;
    }
}
