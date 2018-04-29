import java.util.*;

/**
 * 
 * @author Yongchang Cai
 * 
 * Description: account class that use for the assignment4. It include account name, account number, account balance and lists of transaction date, type and amount,
 *
 */
public class account {
	protected String AccountName;
	protected int AccountNumber;
	protected Double AccountBalance = 0.0;
	protected List<String> AccountDate = new ArrayList<String>();
	protected List<String> AccountType = new ArrayList<String>();
	protected List<Double> AccountAmount = new ArrayList<Double>();
	
	
	/**
	 * create account object by set number and name. 
	 * @param Number
	 * @param Name
	 * @throws Exception
	 */
	public account( int Number, String Name) throws Exception{
		AccountName = Name;
		AccountNumber = Number;
	}
	
	/**
	 * 
	 * @return Account name
	 * @throws Exception
	 */
	public String getName() throws Exception{
		return AccountName;
	}
	
	/**
	 * 
	 * @return AccountNumber
	 * @throws Exception
	 */
	public int getNumber() throws Exception{
		return AccountNumber;
	}
	
	/**
	 * add a transaction date to the date list
	 * @param Date
	 * @throws Exception
	 */
	public void setDate(String Date) throws Exception{
		AccountDate.add(Date);
	}
	
	/**
	 * 
	 * @return AccountDate
	 * @throws Exception
	 */
	public List<String> getDate() throws Exception{
		return AccountDate;
	}
	
	/**
	 * add a transaction type to the type list
	 * @param Date
	 * @throws Exception
	 */
	public void setType(String Type) throws Exception{
		AccountType.add(Type);
	}
	
	/**
	 * 
	 * @return AccountType
	 * @throws Exception
	 */
	public List<String> getType() throws Exception{
		return AccountType;
	}
	
	/**
	 * add a transaction amount to the amount list
	 * @param Amount
	 * @throws Exception
	 */
	public void setAmount(Double Amount) throws Exception{
		AccountAmount.add(Amount);
	}
	
	/**
	 * 
	 * @return AccountAmount
	 * @throws Exception
	 */
	public List<Double> getAmount() throws Exception{
		return AccountAmount;
	}
	
	/**
	 * 
	 * @return AccountBalance
	 * @throws Exception
	 */
	public Double getBalance() throws Exception{
		return AccountBalance;
	}
	
	/**
	 * 
	 * Calculated the balance and record new date type and amount to the list
	 * @param date
	 * @param type
	 * @param amount
	 * @throws Exception
	 */
	public void transition(String date, String type, Double amount) throws Exception{
		if (type.equalsIgnoreCase("D")){
			AccountBalance += amount;
			setType("deposit");
		}
		else if (type.equalsIgnoreCase("W")){
			AccountBalance -= amount;
			setType("withdrawal");
		}
		setAmount(amount);
		setDate(date);
	}
	
	/**
	 * Print required info of account
	 * @throws Exception
	 */
	public void printInfo() throws Exception{
		System.out.println("   account #:  " + AccountNumber +
				"\n        name:  " + AccountName + 
				"\n     balance:  $" + AccountBalance);
	}
	
	/**
	 * Print required history of account
	 * @throws Exception
	 */
	public void printHist() throws Exception{
		for (int i=0;i<AccountAmount.size();i++){
			System.out.println(AccountDate.get(i) + " " + AccountType.get(i) + " $" + AccountAmount.get(i));
		}
	}
}
