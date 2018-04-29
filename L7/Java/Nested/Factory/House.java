// House.java - base class, containing subclasses and factory method
//
// Kurt Schmidt
// 7/16
//
// Java 7
//

public abstract class House {

	public abstract void represent() ;

	private static class Gryffyndor extends House {
		@Override
		public void represent()
		{ System.out.println( "Gryffyndor!" ) ; }
	}

	private static class Slytherin extends House {
		@Override
		public void represent()
		{ System.out.println( "Slytherin!" ) ; }
	}

	private static class RavenClaw extends House {
		@Override
		public void represent()
		{ System.out.println( "RavenClaw!" ) ; }
	}

	public static House SortingHat( int i )
	{
		House rv = null ;
		switch( i%3 ) {
			case 0 : rv = new Gryffyndor() ; break ;
			case 1 : rv = new Slytherin() ; break ;
			case 2 : rv = new RavenClaw() ; break ;
		}
		return rv ;
	}

	public static void main( String [] args )
	{
		House h = House.SortingHat( 27 ) ;
		h.represent() ;
	}

}	// class House
