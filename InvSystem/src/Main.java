import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogin, lblPassword;
	private JTextField txtUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("Java Inventory System | Log-in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(53, 138, 261, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(53, 237, 261, 26);
		contentPane.add(passwordField);
		
		lblLogin = new JLabel("LOG IN");
		lblLogin.setFont(new Font("Montserrat", Font.PLAIN, 19));
		lblLogin.setBounds(53, 98, 102, 26);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Montserrat", Font.PLAIN, 19));
		lblPassword.setBounds(53, 201, 126, 26);
		contentPane.add(lblPassword);
		setLocationRelativeTo(null);
	}
}
