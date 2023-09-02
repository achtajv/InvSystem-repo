import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class Main extends JFrame {
	
	public static void main(String[] args) {
		
		//TRIAL ADDED COMMENT
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage beginLoginPage = new LoginPage();
					beginLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
