import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Dashboard extends JFrame {
	
	private JPanel contentPane, panelInventory, panelAddItems, panelPurchase, panelSales;
	private JTabbedPane dashboardTP;
	private JButton btnAdd, btnUpdate, btnDelete, btnPurchase;
	
	private JMenuBar menuBar;
	private JMenu mnOtherOptions;
	private JMenuItem mntmLogout;
	
	private JLabel lblSelectCategory;
	private JScrollPane scrollPaneListPurchased;
	private JTextArea textArea;
	private JList listItems;
	private JComboBox cbCategorySelection;
	
	//copy the hashmap from the data storage
	private HashMap<String, String> loginCredentials;
	private JLabel lblSearch;
	private JTextField textField;

	public Dashboard() {
		setUndecorated(false);
		setTitle("Sister Store | Inventory");
		DataStorage storeInfo = new DataStorage();
		loginCredentials = storeInfo.getPeopleInfo();
		
		//get the max width and height of the device
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Rectangle bounds = environment.getMaximumWindowBounds();
	    GraphicsDevice device = environment.getDefaultScreenDevice();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, bounds.width, bounds.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dashboardTP = new JTabbedPane(JTabbedPane.TOP);
		dashboardTP.setBounds(10, 50, 1516, 790);
		contentPane.add(dashboardTP);
		
		//<=======Purchase Panel=======>
		panelPurchase = new JPanel();
		dashboardTP.addTab("Purchase", null, panelPurchase, null);
		panelPurchase.setLayout(null);
		
		lblSelectCategory = new JLabel("Select Category:");
		lblSelectCategory.setBounds(435, 15, 125, 19);
		lblSelectCategory.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panelPurchase.add(lblSelectCategory);
		
		scrollPaneListPurchased = new JScrollPane();
		scrollPaneListPurchased.setBounds(10, 43, 405, 648);
		panelPurchase.add(scrollPaneListPurchased);
		
		textArea = new JTextArea();
		scrollPaneListPurchased.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Montserrat", Font.PLAIN, 15));
		
		listItems = new JList();
		listItems.setBounds(435, 113, 440, 577);
		panelPurchase.add(listItems);
		
		cbCategorySelection = new JComboBox();
		cbCategorySelection.setBounds(564, 16, 315, 21);
		panelPurchase.add(cbCategorySelection);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(425, 699, 85, 52);
		btnAdd.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panelPurchase.add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(520, 701, 85, 52);
		btnUpdate.setFont(new Font("Montserrat", Font.PLAIN, 11));
		panelPurchase.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(615, 700, 85, 52);
		btnDelete.setFont(new Font("Montserrat", Font.PLAIN, 12));
		panelPurchase.add(btnDelete);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(330, 701, 85, 52);
		btnPurchase.setFont(new Font("Montserrat", Font.PLAIN, 10));
		panelPurchase.add(btnPurchase);
		
		JLabel lblItemList = new JLabel("ITEMS LIST");
		lblItemList.setFont(new Font("Montserrat ExtraLight", Font.PLAIN, 20));
		lblItemList.setBounds(10, 10, 216, 25);
		panelPurchase.add(lblItemList);
		
		JButton btnDecrease = new JButton("-");
		btnDecrease.setFont(new Font("Montserrat", Font.PLAIN, 35));
		btnDecrease.setBounds(263, 699, 52, 52);
		panelPurchase.add(btnDecrease);
		
		JButton btnIncrease = new JButton("+");
		btnIncrease.setFont(new Font("Montserrat", Font.PLAIN, 35));
		btnIncrease.setBounds(191, 699, 52, 52);
		panelPurchase.add(btnIncrease);
		
		JLabel lblItemPreview = new JLabel("ITEM PREVIEW");
		lblItemPreview.setFont(new Font("Montserrat ExtraLight", Font.PLAIN, 20));
		lblItemPreview.setBounds(1119, 9, 216, 25);
		panelPurchase.add(lblItemPreview);
		
		lblSearch = new JLabel("SEARCH:");
		lblSearch.setFont(new Font("Montserrat", Font.PLAIN, 15));
		lblSearch.setBounds(436, 55, 125, 19);
		panelPurchase.add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(565, 57, 312, 21);
		panelPurchase.add(textField);
		textField.setColumns(10);
		
		//<=======Add Items=======>
		panelAddItems = new JPanel();
		dashboardTP.addTab("Add Item", null, panelAddItems, null);
		panelAddItems.setLayout(null);
		
		//<=======Inventory=======>
		panelInventory = new JPanel();
		dashboardTP.addTab("Inventory", null, panelInventory, null);
		panelInventory.setLayout(null);
		
		//<=======Sales=======>
		panelSales = new JPanel();
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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
