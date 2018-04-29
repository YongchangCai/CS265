// arraysd.java - built-in arrays - display
// Demonstrates:	array.length, resizing, bounds checking
//
// Kurt Schmidt
// 5/16
//
// javac 1.8.0_91
//

import java.io.*;

public class arraysd {

  public static int[] resize( int [] a, int newsize )
	{
		int [] rv = new int[newsize] ;

		for( int i=0; i<a.length; ++i )
			rv[i] = a[i] ;

		return rv ;
	}

	public static void main( String[] args ) throws Exception
	{
			// they are much like C-arrays.  They do NOT resize themselves

			// Here is one way to declare/initialise an array:
		int [] a = { 74, 011, 23, 0xff };

			// Want to add more items.  Get bigger array
		
		int [] t = resize( a, 2*a.length ) ;

		a = t;	// the old array is now marked for deletion
		t = null;

		// Now, we can add another element
		a[4] = 99 ;

	}	// main

}	// class Arr

