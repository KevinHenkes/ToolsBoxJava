package lib;

public class Array {
    public static Object[] reverse(Object[] foo) {
	int i = 0;
	
	for (;i < foo.length; i++) {
	    Object temp = foo[i];
	    foo[i] = foo[foo.length - i];
	    foo[foo.length - i] = temp;
	}
	
	return foo;
    }
}
