// CS265 Lab 7
// Problem 4 
// 
// Auther: Yongchang Cai
//
// Date: 11/5/2016
//

import java.io.*;
import java.util.Date;

public class prob4{
	public static void main(String[] args) throws Exception{
		Date today = new Date();
		long milli = today.getTime();
		long seconds = milli/1000;
		long days = seconds/86400;
		switch( Integer.parseInt(args[0]))
		{
			case 0:
				System.out.println("milliseconds since January 1, 1970: " + milli);
				break;
			case 1:
				System.out.println("seconds since January 1, 1970: " + seconds);
				break;
			case 2:
				System.out.println("days since January 1, 1970: " + days);
				break;
			case 3:
				System.out.println("Current date and time: " + today.toString());
				break;
			default:
				break;
		}
	}
}
