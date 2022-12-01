
package tt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class GUIBanking {
	// Declaring GUI variables
	private JFrame frmBankingA;
	JButton btnAdd;
	static GUIBanking window;
	ArrayList <BankAccount> alAccounts; //List of bank accounts
	private JList list; 
	private JButton btnEdit;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GUIBanking();
					window.frmBankingA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIBanking() { //Initialize GUI Bank;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alAccounts = new ArrayList<BankAccount>();  //Initialize list of bank accounts
		
		frmBankingA = new JFrame();//Set up GUI Frame
		frmBankingA.setTitle("Banking");
		frmBankingA.setBounds(100, 100, 450, 300);
		frmBankingA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankingA.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");//Add Button
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccount addAccount = new AddAccount(window);
				addAccount.setVisible(true);
			}
		});
		btnAdd.setBounds(36, 64, 89, 23);
		frmBankingA.getContentPane().add(btnAdd);
	
		list = new JList();
		list.setBounds(253, 42, 147, 185);
		frmBankingA.getContentPane().add(list);
		
		btnEdit = new JButton("Edit");//Edit Button
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditAccount ea = new EditAccount(alAccounts.get(list.getSelectedIndex()));
				ea.setVisible(true);
			}
		});
		btnEdit.setBounds(36, 117, 89, 23);
		frmBankingA.getContentPane().add(btnEdit);
	}
	public void updateAccountData (BankAccount ba) {//Set up list of bank accounts
		alAccounts.add(ba);
		
		DefaultListModel <BankAccount> dlmAccount  = new DefaultListModel<BankAccount>();
		alAccounts.forEach((account)->{
			dlmAccount.addElement(account);
		});
		list.setModel(dlmAccount);

	}
}
