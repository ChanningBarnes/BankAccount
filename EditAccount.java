
package tt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class EditAccount extends JDialog {
	
	private final JPanel contentPanel = new JPanel(); //Declaring GUI Panel and TextField
	private JTextField txtAmount;
	
	JLabel lblName; //Declaring Labels for Name, ID, and Balance
	JLabel lblID;
	JLabel lblBalance;
	
	private JList list; //Declaring variables for GUI List
	DefaultListModel <String> dlmAmount  = new DefaultListModel<String>();
	public int firstbal;
	BankAccount ba; //Initialize bank account class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		try {
			EditAccount dialog = new EditAccount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditAccount(BankAccount ba) {//Constructor for Edit Account with bank account parameter
		this.ba = ba;
		init();
		
		lblName.setText(ba.getCustomerName()); //Sets label text for customer name
		lblID.setText(ba.getCustomerId()); //Sets label text for customer Id
		firstbal = ba.getBalance();
		lblBalance.setText(Integer.toString(ba.getBalance())); //Sets label text for customer balance
	}
	public EditAccount() {// Constructor for Edit Account to test Edit Account without running full GUI program
		ba = new BankAccount("Test User" ,"Test ID");
		ba.setBalance(100);
		init();
		
		lblName.setText(ba.getCustomerName()); //Sets label text for customer name
		lblID.setText(ba.getCustomerId()); //Sets label text for customer Id
		lblBalance.setText(Integer.toString(ba.getBalance())); //Sets label text for customer balance
		
	}
	private void init() {
		setTitle("Edit Account");

		setBounds(100, 100, 450, 300); //Set border for window
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("New label"); //Label for Name header
		lblName.setBounds(130, 22, 86, 14);
		contentPanel.add(lblName);
		
		JLabel lblName1 = new JLabel("Name"); //Label to store Customer Name Value
		lblName1.setBounds(35, 22, 46, 14);
		contentPanel.add(lblName1);
		
		lblID = new JLabel("New label"); //Label for ID header
		lblID.setBounds(130, 60, 86, 14);
		contentPanel.add(lblID);
		
		JLabel lblID1 = new JLabel("ID"); //Label to store Customer ID Value
		lblID1.setBounds(35, 60, 46, 14);
		contentPanel.add(lblID1);
		
		lblBalance = new JLabel("New label"); //Label for Balance header
		lblBalance.setBounds(130, 96, 86, 14);
		contentPanel.add(lblBalance);
		
		JLabel lblBalance1 = new JLabel("Balance"); //Label to store Customer Balance Value
		lblBalance1.setBounds(35, 96, 46, 14);
		contentPanel.add(lblBalance1);
		
		txtAmount = new JTextField(); //Set text field for user to enter deposit or withdraw value
		txtAmount.setBounds(62, 131, 86, 20);
		contentPanel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {// Action listener for deposit
			public void actionPerformed(ActionEvent e) {
				ba.deposit(Integer.parseInt(txtAmount.getText())); //Get deposit amount from user input
				lblBalance.setText(Integer.toString(ba.getBalance())); //Set balance after user deposit
				int amount = ba.getPreviousTransaction(); //Get previous transaction and add it to list
				dlmAmount.addElement("Deposited $"+amount);
				txtAmount.setText("");
			}
			
			
		});
		btnDeposit.setBounds(62, 162, 89, 23);
		contentPanel.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {// Action listener for withdraw
			public void actionPerformed(ActionEvent e) {
				ba.withdraw(Integer.parseInt(txtAmount.getText()));//Get withdraw amount from user input
				lblBalance.setText(Integer.toString(ba.getBalance()));//Set balance after user withdraw
				int amount = ba.getPreviousTransaction(); //Get previous transaction and add it to list
				dlmAmount.addElement("Withdrawn $"+ amount); 
				txtAmount.setText("");
			}
		});
		btnWithdraw.setBounds(62, 194, 89, 23);
		contentPanel.add(btnWithdraw);
		
		list = new JList(); //Initialize list of previous transactions
		list.setBounds(245, 57, 164, 146);
		contentPanel.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Previous transactions");//Set previous transactions label
		lblNewLabel_2.setBounds(245, 22, 179, 14);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {// Action listener for OK button
					public void actionPerformed(ActionEvent e) {
						dispose(); 
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() { //Action listener for Cancel Button
					public void actionPerformed(ActionEvent e) {
						ba.setBalance(firstbal);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
	
		list.setModel(dlmAmount); 
		}

}

