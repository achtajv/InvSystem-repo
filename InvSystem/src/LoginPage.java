import java.awt.Font;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogin, lblPassword;
	private JTextField txtUser;
	private JPasswordField pwdPassword;
	private JButton btnSignIn;
	
	private HashMap<String, String> loginCredentials = new HashMap<>();

	public LoginPage() {
		setResizable(false);
		setTitle("Java Inventory System | Log-in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) { //constantly checks if the textfield is changing
				btnSignIn.setEnabled(true);
				pwdPassword.setEnabled(true);
				if(txtUser.getText().isEmpty()) {
					btnSignIn.setEnabled(false);
					pwdPassword.setEnabled(false);
				}
			}
		});
		txtUser.setFont(new Font("Montserrat", Font.PLAIN, 15));
		txtUser.setBounds(53, 138, 261, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setEnabled(false);
		pwdPassword.setFont(new Font("Montserrat", Font.PLAIN, 15));
		pwdPassword.setBounds(53, 237, 261, 26);
		contentPane.add(pwdPassword);
		
		lblLogin = new JLabel("LOG IN");
		lblLogin.setFont(new Font("Montserrat", Font.PLAIN, 19));
		lblLogin.setBounds(53, 98, 102, 26);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Montserrat", Font.PLAIN, 19));
		lblPassword.setBounds(53, 201, 126, 26);
		contentPane.add(lblPassword);
		
		btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("I'm clicked");
			}
		});
		btnSignIn.setEnabled(false);
		btnSignIn.setFont(new Font("Montserrat", Font.PLAIN, 15));
		btnSignIn.setBounds(127, 290, 102, 21);
		contentPane.add(btnSignIn);

		setLocationRelativeTo(null);
		
	}
}
