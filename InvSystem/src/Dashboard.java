import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {
	
	private JPanel contentPane;
	private JButton btnNewButton;
	
	private HashMap<String, String> loginCredentials;

	public Dashboard() {
		DataStorage storeInfo = new DataStorage();
		loginCredentials = storeInfo.getPeopleInfo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(loginCredentials.toString());
			}
		});
		btnNewButton.setBounds(185, 98, 85, 21);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
	}
}
