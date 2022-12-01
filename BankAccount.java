package tt;


public class BankAccount {
	private int _balance;						// Defining private values
	private String _customerId;
	private String _customerName;
	private int _previousTransaction;

												
	public int getBalance() {//Method to get balance
		return _balance;
	}
	public void setBalance(int _balance) {//Method to set balance
		this._balance= _balance;
	}
	
	public String getCustomerId() {//Method to get customerID
		return _customerId;
	}
	public void setCustomerId(String _customerId) {//Method to set balance
		this._customerId = _customerId;
	}
	
	public String getCustomerName() {//Method to get customer name
		return _customerName;
	}
	public void setCustomerName(String _customerName) {//Method to set customer name
		this._customerName = _customerName;
	}
	
	public int getPreviousTransaction() {//Method to get previous transaction
		return _previousTransaction;
	}
	public void setPreviousTransaction(int _previousTransaction) {//Method to set previous transaction
		this._previousTransaction = _previousTransaction;
	}

	public BankAccount(String CustomerName, String CustomerID) {// Constructor that will set Customer Name and ID
		
		getCustomerName();
		setCustomerName(_customerName);
		getCustomerId();
		setCustomerId(_customerId);
	}
	public void withdraw(int amount) {//Method to withdraw money
		setBalance(_balance-amount);
		setPreviousTransaction(amount);
		
	}

	public void deposit(int amount) {//Method to deposit money

		setBalance(_balance+amount);
		setPreviousTransaction(amount);
	}
}


