package lib;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Array {
    public static Object[] reverse(Object[] foo) {
	int i = 0;

	for (; i < foo.length; i++) {
	    Object temp = foo[i];
	    foo[i] = foo[foo.length - i];
	    foo[foo.length - i] = temp;
	}

	return foo;
    }

    public static Object majority(Object[] foo) {
	HashMap<Object, Integer> compte = new HashMap<Object, Integer>();
	int valmin = 0;
	Object argmin = new Object();

	for (Object object : foo) {
	    if (compte.containsKey(object)) {
		compte.put(object, compte.get(object) + 1);
	    } else {
		compte.put(object, 1);
	    }
	}

	for (Object object : compte.keySet()) {
	    if (Math.min(-compte.get(object), valmin) != valmin) {
		valmin = -compte.get(object);
		argmin = object;
	    }
	}

	return argmin;
    }
    
    public static int max(Integer[] foo) {
	int max = 0;
	int i = 0;
	
	while (i < foo.length) {
	    if (foo[i] > max) {
		max = foo[i];
	    }
	    
	    i++;
	}
	
	return max;
    }

    public static int[] closest_values(Integer[] foo) {
	int i = 1;
	int valmin = max(foo);
	
	int argmin = 0;

	if (foo.length >= 2) {
	    Arrays.sort(foo);
	    while (i < foo.length) {
		if (Math.min(foo[i] - foo[i - 1], valmin) != valmin) {
		    valmin = foo[i] - foo[i - 1];
		    argmin = i;
		}
		
		i++;
	    }
	}
	
	return new int[] { foo[argmin - 1], foo[argmin] };
    }
    
    public
}
