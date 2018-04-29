// Private.java -- outer class for static nested classes
//
// Kurt Schmidt
// 7/16
//
// Java 7
//

public class Private
{
	public abstract static class Base
	{
		public abstract void talk() ;
	} // class Inner1

	private static class Inner1 extends Base
	{
		public void talk()
		{	System.out.println( "In Private.Inner1.talk" ) ; }
	} // class Inner1

	private static class Inner2 extends Base
	{
		public void talk()
		{	System.out.println( "In Private.Inner2.talk" ) ; }
	} // class Inner1

	public static Base factory( int i )
	{
		switch( i )
		{
			case 1 : return new Inner1() ;
			case 2 : return new Inner2() ;
		}
		return null ;
	}

} // class Private

