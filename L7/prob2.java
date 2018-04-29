// CS265 Lab 7
// Problem 2 
// 
// Auther: Yongchang Cai
//
// Date: 11/5/2016
//
import java.io.*;

public class prob2{
	public static void main(String[] args)  throws Exception{
		int num = Integer.parseInt(args[0]);
		if (num%2 == 1) {
			System.out.println("Odd");
		}
		else {
			System.out.println("Even");
		}
	}
}
