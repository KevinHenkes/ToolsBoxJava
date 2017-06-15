package entities;

public class Worker extends Thread {
    int id = 0;
    
    public Worker(int i) {
	id = i;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(id);
    }
}
