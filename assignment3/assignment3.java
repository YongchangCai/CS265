// assignment3.java 
// CS265 Assignment3
// Parsing Infix Expressions
// 
// Author: Yongchang Cai
//
// Date: 11/20/2016
//
// Version: 7 Update 79

import java.util.*;
import java.io.*;

/**
 * 
 * @author Yongchang Cai
 * 
 * The Main Class that parses infix expressions (described below) into appropriate Tokens
 *  (operator or operand), stored in some linear container (ArrayList ?), passes the infix
 *   expression to a function that returns the expression to postfix form, then passes it
 *    to a function which evaluates the postfix expression, returns an integer
 *
 */
public class assignment3 {
	
	/**
	 * 
	 * @param string_array
	 * @return List<Token> infix expression
	 * @throws Exception
	 */
	public static List<Token> string2infix(String[] string_array) throws Exception {
		List<Token> list_tk = new LinkedList<Token>();
		for (int i = 0; i < string_array.length; i++){
			if (string_array[i].matches("^-?\\d+$"))
				list_tk.add(new Operand(Integer.parseInt(string_array[i])));
			else if (string_array[i].equals("+"))
				list_tk.add(new Operator(opType.ADD));
			else if (string_array[i].equals("-"))
				list_tk.add(new Operator(opType.SUB));
			else if (string_array[i].equals("*"))
				list_tk.add(new Operator(opType.MULT));
			else if (string_array[i].equals("%"))
				list_tk.add(new Operator(opType.MOD));
			else if (string_array[i].equals("/"))
				list_tk.add(new Operator(opType.DIV));
			else if (string_array[i].equals("("))
				list_tk.add(new Operator(opType.LPAR));
			else if (string_array[i].equals(")"))
				list_tk.add(new Operator(opType.RPAR));
		}
		return list_tk;
	}
	
	/**
	 * 
	 * @param in_fix expression
	 * @return postfix expression
	 * @throws Exception
	 */
	public static List<Token> infix2postfix(List<Token> in_fix) throws Exception {
		List<Token> list_tk = new LinkedList<Token>();
		in_fix.add(new Operator(opType.RPAR));
		Stack post_fix_stack = new Stack();
		post_fix_stack.push(new Operator(opType.LPAR));
		while (!in_fix.isEmpty()){
			Token tk = in_fix.remove(0);
			if (tk.isOperand())
				list_tk.add(tk);
			else if(tk.isOperator()){
				Operator op = (Operator) tk;
				if (op.getVal() == opType.LPAR )
					post_fix_stack.push(tk);
				else if (op.getVal() == opType.RPAR){
					Operator next_op = (Operator) post_fix_stack.pop();
					while (next_op.getVal() != opType.LPAR){
						list_tk.add((Token) next_op);
						next_op = (Operator) post_fix_stack.pop();
					}
				}
				else{
					if( Operator.compare((Operator)tk,(Operator)post_fix_stack.peek())>=0){
						list_tk.add((Token) post_fix_stack.pop());
					}
					post_fix_stack.push(tk);
				}
					
			}
		}
		return list_tk;
	}
	
	/**
	 * 
	 * @param post_fix expression
	 * @return int result of the calculation
	 * @throws Exception
	 */
	public static int evalPostfix(List<Token> post_fix ) throws Exception{
		Stack result_stack = new Stack();
		String outputString;
		while(!post_fix.isEmpty()){
			Token tk = post_fix.remove(0);
			if (tk.isOperator()){
				Operator op = (Operator) tk;
				int y = (int)result_stack.pop();
				int x = (int)result_stack.pop();
				if (op.getVal().getName() == "Add"){
					result_stack.push(x + y);
					System.out.print("+ ");
				}
				else if (op.getVal().getName() == "Sub"){
					result_stack.push(x - y);
					System.out.print("- ");
				}
				else if (op.getVal().getName() == "Mult"){
					result_stack.push(x * y);
					System.out.print("* ");
				}
				else if (op.getVal().getName() == "Div"){
					result_stack.push(x / y);
					System.out.print("/ ");
				}
				else if (op.getVal().getName() == "Mod"){
					result_stack.push(x % y);
					System.out.print("% ");
				}
			}
			else if(tk.isOperand()){
				Operand op = (Operand) tk;
				result_stack.push(op.getVal());
				System.out.print(op.getVal()+ " ");
			}
		}
		return (int) result_stack.pop(); 
	}
	
	/**
	 * Main method to get input from input.infix 
	 * Do the calculation and print postfix expression and result
	 * @param arvg
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception{
		// The name of the file to open.
        String fileName = "input.infix";
        try {
        	FileReader input_file= new FileReader(fileName);
        	BufferedReader input = new BufferedReader(input_file) ;
        	String line = input.readLine();
        	String[] split_line;
    		while (line!=null){
    			
    			split_line = line.split(" ");
    			//System.out.println(Arrays.toString(split_line));
    			List<Token> infix = string2infix(split_line);
    			List<Token> postfix = infix2postfix(infix);
    			int result = evalPostfix(postfix);
    			System.out.println( "= " + result);
    			line = input.readLine();
    		}
          } catch (FileNotFoundException e) {
           e.printStackTrace();
          } 	
	}
}
