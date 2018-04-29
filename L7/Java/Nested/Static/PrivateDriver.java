// PrivateDriver.java -- test main for class Public
//
// Kurt Schmidt
// 7/16
//
// Java 7
//

public class PrivateDriver
{
	public static void main( String [] args )
	{
		Private.Base i1 = Private.factory( 1 ) ;
		Private.Base i2 = Private.factory( 2 ) ;

		i1.talk() ;
		i2.talk() ;

	} // class Inner1

} // class Public

