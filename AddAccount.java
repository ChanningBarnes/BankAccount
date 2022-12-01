
package tt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddAccount extends JDialog {


	// Declare private variables
	private final JPanel contentPanel = new JPanel();
	private GUIBanking gb;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtBalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddAccount dialog = new AddAccount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddAccount(GUIBanking window) { //Pass through GUI Bank 
		gb = window;
		init();
	}
	public AddAccount() {
		init();
	}
	private void init() {
		setTitle("Add Account");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{// Name Label
			JLabel lblNewLabel_2 = new JLabel("Name");
			lblNewLabel_2.setBounds(28, 37, 27, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{// ID Label
			JLabel lblNewLabel_1 = new JLabel("ID");
			lblNewLabel_1.setBounds(28, 80, 11, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{// Balance
			JLabel lblNewLabel = new JLabel("Balance");
			lblNewLabel.setBounds(28, 132, 37, 14);
			contentPanel.add(lblNewLabel);
		}
		// Name text field
		txtName = new JTextField();
		txtName.setBounds(86, 34, 86, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		// ID text field
		txtID = new JTextField();
		txtID.setBounds(86, 77, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		// Balance text field
		txtBalance = new JTextField();
		txtBalance.setBounds(86, 129, 86, 20);
		contentPanel.add(txtBalance);
		txtBalance.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");// OK Button
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BankAccount account = new BankAccount(txtName.getText(), txtID.getText()); 
						account.setCustomerName(txtName.getText()); //Reads in customer name
						account.setCustomerId(txtID.getText()); //Reads in customer Id
						account.setBalance(Integer.parseInt(txtBalance.getText())); //Reads in customer balance
						gb.updateAccountData(account); //Sends account data to main GUI bank program
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");// Cancel Button
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); //Closes window once cancel button is pressed
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				}
			}
		}
	}

