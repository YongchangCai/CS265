// a4.java 
// CS265 Assignment3
// Bank Transactions
// 
// Author: Yongchang Cai
//
// Date: 12/4/2016
//
// Version: 8 Update 111

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Assignment 4 Bank Transaction
 * @author Yongchang Cai
 * Date: 12/4/2016
 * Description: The main class to excute the bank transactions options and return value to user
 * It will read a log file from $ACCT_LIST and store accounts object to a hash map with account number as the key.
 * 
 *  Version: 8 Update 111
 */
public class a4 {
	protected static Map<Integer,account> AccountMap = new HashMap<Integer,account>(); 
	protected static List<Integer> KeyList = new ArrayList<Integer>(); //A list of account number to help find the user choose account
	
	/**
	 * Method use to read the log file then create and store unique Account into Hashmap.
	 * @return
	 * @throws Exception
	 */
	public static Map<Integer,account> readLog(String fileName) throws Exception{
		//String fileName = System.getenv("ACCT_LIST");
		//String fileName = "sample.db"; 
		FileReader input_file= new FileReader(fileName);
    	BufferedReader input = new BufferedReader(input_file) ;
    	String line = input.readLine();
    	String [] split_line;
    	while (line !=null){
    		split_line = line.split(":");
    		int account_number = Integer.parseInt(split_line[0]);
    		account the_account = AccountMap.get(account_number);
    		if (the_account != null) {
    			the_account.transition(split_line[2], split_line[3], Double.parseDouble(split_line[4]));
    			AccountMap.put(account_number, the_account);
    		}
    		else{
    			account new_account = new account(account_number,split_line[1]);
    			new_account.transition(split_line[2], split_line[3], Double.parseDouble(split_line[4]));
    			AccountMap.put(account_number, new_account);
    			KeyList.add(account_number);
    		}
    		line = input.readLine();
    	}
    	input.close();
		return AccountMap;
	}
	
	/**
	 * Method use to print the account choice that used for option (info and hist) 
	 * @return
	 * @throws Exception
	 */
	public static String printAccount() throws Exception{
		for (int i=1;i<=AccountMap.size();i++){
			System.out.println("  "+ i +  ") " + AccountMap.get(KeyList.get(i-1)).getName()+ "  "+ KeyList.get(i-1) );
		}
		String choice = null;
		System.out.println("  q) uit\n\n");
		System.out.println("  Enter choice =>");
		Scanner scan = new Scanner(System.in);
			choice = scan.nextLine();
		return choice;
	}
	
	/**
	 * Method used for option -t. First print the account choice and based on the choice let the user to add transaction to the account. 
	 * @param fileName
	 * @throws Exception
	 */
	public static void addTransaction(String fileName) throws Exception{
		String choice = null;
		while(true){
			for (int i=1;i<=AccountMap.size();i++){
				System.out.println("  "+ i +  ") " + AccountMap.get(KeyList.get(i-1)).getName()+ "  "+ KeyList.get(i-1) );
			}
			System.out.println("  n) ew Account");
			System.out.println("  q) uit\n\n");
			System.out.println("  Enter choice =>");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextLine();
			if (choice.equals("q")){
				break;
			}
			else if(Integer.parseInt(choice) <=AccountMap.size() ){
				System.out.println("Input Transaction Type w or d, followed by [enter]");
				String type = scan.nextLine();
				System.out.println("Input Transaction amount");
				Double amount = Double.parseDouble(scan.nextLine());
				Date date = new Date();
				String current_date = new SimpleDateFormat("yy.mm.dd").format(date);
				account trans_account = AccountMap.get(KeyList.get(Integer.parseInt(choice)-1));
				trans_account.transition(current_date, type, amount);
				String[] a = new String[] {Integer.toString(trans_account.getNumber()),trans_account.getName(),current_date,type.toUpperCase(),Double.toString(amount)};
				String new_string = String.join(":",a);
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
				bw.write(new_string);
				bw.close();
			}
			else if(choice.equals("n")){
				System.out.println("Input Account Number follow by [enter]");
				//Scanner scan_number = new Scanner(System.in);
				String number = scan.nextLine();
				if (AccountMap.containsKey(Integer.parseInt(number))){
					System.out.println("Account number already exits, try again.");
					continue;
				}
				System.out.println("Input Account name follow by [enter]");
				//Scanner scan_name = new Scanner(System.in);
				String name = scan.nextLine();
				
				account new_account = new account(Integer.parseInt(number),name);
				System.out.println("Input Transaction Type w or d, followed by [enter]");
				String type = scan.nextLine();
				System.out.println("Input Transaction amount");
				Double amount = Double.parseDouble(scan.nextLine());
				Date date = new Date();
				String current_date = new SimpleDateFormat("yy.mm.dd").format(date);
				new_account.transition(current_date, type, amount);
				String[] a = new String[] {number,name,current_date,type.toUpperCase(),Double.toString(amount)};
				String new_string = String.join(":",a);
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
				bw.write(new_string);
				bw.close();
			}
			else{System.out.println("Invalid input. Try again");}
		}
	}
	
	/**
	 * The main method that run the program and read user options.
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String arg[]) throws Exception{
		readLog(arg[1]);
		if (arg.length<1){
			System.out.println("Usage message");
			System.out.println("-i ！ Account info\n-h ！ History\n-t ！ Insert transaction\n-? ！ Show usage msg and quit");
		}
		else{
			if (arg[0].equals("-i")){
				
				while(true){
					System.out.println("Info\n----");
					String choice = printAccount();
					if (choice.equals("q")){
						System.exit(0);
					}
					else if(Integer.parseInt(choice) <=AccountMap.size() ){
						AccountMap.get(KeyList.get(Integer.parseInt(choice)-1)).printInfo();
					}
					else{
						System.out.println("Invalid input. Try again");
					}

				}
			}
			else if(arg[0].equals("-h")){
				while(true){
					System.out.println("History\n----");
					String choice = printAccount();
					if (choice.equals("q")){
						
						System.exit(0);
					}
					else if(Integer.parseInt(choice) <=AccountMap.size() ){
						AccountMap.get(KeyList.get(Integer.parseInt(choice)-1)).printInfo();
					}
					else{
						System.out.println("Invalid input. Try again");
					}
				}
			}
			else if(arg[0].equals("-t")){
				addTransaction(arg[1]);
			}
			else if(arg[0].equals("-?")){
				System.out.println("Usage message");
				System.exit(1);
			}
		}
		
		
		
		
	}
}
