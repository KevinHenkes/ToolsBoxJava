package main;

import lib.Array;

public class Main {

	public static void main(String[] args) {
	    Integer[] array = {1,3,10,25,38,75,188,189};
	    try {
		System.out.println(Array.closest_values(array)[0] + " " + Array.closest_values(array)[1]);
	    } catch(ArrayIndexOutOfBoundsException exception) {
		System.out.println("Error");
	    }
	}
}
