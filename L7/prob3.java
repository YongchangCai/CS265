// CS265 Lab 7
// Problem 3
// 
// Auther: Yongchang Cai
//
// Date: 11/5/2016
//

import java.io.*;

public class prob3{
	public static void main(String[] args ) throws Exception{
			int year = Integer.parseInt(args[0]);
			if (year%4 == 0){
				if (year%100 != 0){
					System.out.println("Leap year!");
				}
				else if (year%400 == 0) {
					System.out.println("Leap year!");
				}
				else {
					System.out.println("Not leap year");
				}
					
			}
			else{
				System.out.println("Not leap year");
			}
	}
}
