import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Dashboard extends JFrame {
	
	private JPanel contentPane;
	private JTabbedPane dashboardTP;
	private JPanel panelInventory, panelAddItems, panelPurchase;
	
	private JMenuBar menuBar;
	private JMenu mnOtherOptions;
	private JMenuItem mntmLogout;
	
	//copy the hashmap from the data storage
	private HashMap<String, String> loginCredentials;

	public Dashboard() {
		setUndecorated(false);
		setTitle("Sister Store | Inventory");
		DataStorage storeInfo = new DataStorage();
		loginCredentials = storeInfo.getPeopleInfo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dashboardTP = new JTabbedPane(JTabbedPane.TOP);
		dashboardTP.setBounds(10, 50, 880, 440);
		contentPane.add(dashboardTP);
		
		panelPurchase = new JPanel();
		dashboardTP.addTab("Purchase", null, panelPurchase, null);
		panelPurchase.setLayout(null);
		
		JLabel lblSelectCategory = new JLabel("Select Category:");
		lblSelectCategory.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblSelectCategory.setBounds(425, 14, 125, 19);
		panelPurchase.add(lblSelectCategory);
		
		JScrollPane scrollPaneListPurchased = new JScrollPane();
		scrollPaneListPurchased.setBounds(10, 10, 405, 366);
		panelPurchase.add(scrollPaneListPurchased);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Montserrat", Font.PLAIN, 15));
		scrollPaneListPurchased.setViewportView(textArea);
		
		JList listItems = new JList();
		listItems.setBounds(425, 51, 440, 253);
		panelPurchase.add(listItems);
		
		JComboBox cbCategorySelection = new JComboBox();
		cbCategorySelection.setBounds(560, 15, 305, 21);
		panelPurchase.add(cbCategorySelection);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Montserrat", Font.PLAIN, 15));
		btnAdd.setBounds(425, 314, 85, 52);
		panelPurchase.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Montserrat", Font.PLAIN, 11));
		btnUpdate.setBounds(520, 314, 85, 52);
		panelPurchase.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Montserrat", Font.PLAIN, 12));
		btnDelete.setBounds(615, 314, 85, 52);
		panelPurchase.add(btnDelete);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnPurchase.setBounds(780, 314, 85, 52);
		panelPurchase.add(btnPurchase);
		
		panelAddItems = new JPanel();
		dashboardTP.addTab("Add Item", null, panelAddItems, null);
		panelAddItems.setLayout(null);
		
		panelInventory = new JPanel();
		dashboardTP.addTab("Inventory", null, panelInventory, null);
		panelInventory.setLayout(null);
		
		JPanel panelSales = new JPanel();
		dashboardTP.addTab("Sales", null, panelSales, null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 47, 22);
		contentPane.add(menuBar);
		
		mnOtherOptions = new JMenu("Others");
		menuBar.add(mnOtherOptions);
		
		mntmLogout = new JMenuItem("Log Out");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage moveToLogin = new LoginPage();
				moveToLogin.setVisible(true);
				dispose();
			}
		});
		mntmLogout.setMnemonic(KeyEvent.VK_O);
		mnOtherOptions.add(mntmLogout);
		
		setLocationRelativeTo(null);
	}
}
