/*
 * CS 265 Lab 8 Interface
 * 
 * Author: Yongchang Cai
 * 
 * Date: 11/13/2016
 * 
 */
 
import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Csv {
	
	private String LINE;
	private ArrayList<String> FIELD;
	private int NFIELD;
	private static String FIELDSEP;
	private BufferedReader INPUT;
	
	public Csv(String fileName, String fieldSep) throws Exception{
		FIELDSEP = fieldSep;
		FileReader input_file= new FileReader(fileName);
		INPUT = new BufferedReader(input_file) ;
	}
	
	public String getline(String line) throws Exception{
		LINE = INPUT.readLine();
		if (LINE== null)
			return LINE;
		
		FIELD = split(LINE);
		return LINE;
	}
	
	public String getfield(int n) throws Exception{
		if (n<0 || n >= NFIELD) 
			return "";
		else 
			return FIELD.get(n);
	}
	
	public int getnfield() throws Exception {
		return NFIELD;
	}
	
	private ArrayList split(String line) throws Exception{
		ArrayList field_list = new ArrayList();
		int i,j;
		String fld = "";
		NFIELD = 0;
		if (line.length()==0)
			return field_list;
		i = 0;
		
		do {
			if (i<LINE.length() && LINE.charAt(i) =='"'){
				j = advquoted(line, ++i, fld);
				field_list.add(fld);
			}
				
			else{
				j = advplain(line, i, fld);
				field_list.add(fld);
			}
			NFIELD++;
			i = j+1;
		} while (j < line.length());
		
		return field_list;
			
	}
	
	private static int advquoted(String s, int i, String fld) throws Exception {
		int j;

		fld = "";
		StringBuilder string_builder = new StringBuilder();
		for (j = i; j < s.length(); j++) {
			if (s.charAt(j)== '"' && s.charAt(++j) != '"') {
				int k = s.indexOf(FIELDSEP, j);
				if (k > s.length())	// no separator found
					k = s.length();
				for (k -= j; k-- > 0; )
					string_builder.append(s.charAt(j++));
				break;
			}
			string_builder.append(s.charAt(j));
		}
		fld = string_builder.toString();
		return j;
	}
	
	private static int advplain(String s, int i, String fld) throws Exception {
		int j;

		j = s.indexOf(FIELDSEP, i); // look for separator
		if (j > s.length())               // none found
			j = s.length();
		fld = s.substring(i,j);
		return j;
	}
	
	public static void main(String args[]) throws Exception{
		String line = "";
		Csv csv = new Csv("test.csv",",");
		
		while (csv.getline(line) != null){
			System.out.println("line = `" + line + "'");
			for (int i = 0; i < csv.getnfield();i++)
				System.out.println("filed[" + i + "] = `" + csv.getfield(i) + "'");
		}
	}
}