// PublicDriver.java -- test main for class Public
//
// Kurt Schmidt
// 7/16
//
// Java 7
//

public class PublicDriver
{
	public static void main( String [] args )
	{
		Public.Inner1 i1 = new Public.Inner1() ;
		Public.Inner2 i2 = new Public.Inner2() ;

		i1.talk() ;
		i2.talk() ;

	} // class Inner1

} // class Public

