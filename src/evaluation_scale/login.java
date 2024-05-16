package evaluation_scale;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusAdapter;
public class login extends JFrame {

	private JPanel contentPane;
	private JTextField logemail;
	private JPasswordField logpassword;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		lblNewLabel.setBounds(115, 51, 118, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_1.setBounds(61, 118, 108, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_2.setBounds(61, 198, 108, 33);
		contentPane.add(lblNewLabel_2);
		
		logemail = new JTextField();
		logemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(logemail.getText().equals("Enter your email"))
				{
					logemail.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(logemail.getText().equals(""))
				{
					logemail.setText("Enter your email");
				}
			}
		});
		
		
		logemail.setBounds(61, 161, 233, 27);
		contentPane.add(logemail);
		logemail.setColumns(10);
		
		
		logpassword = new JPasswordField();
		logpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(logpassword.getText().equals("Enter password"))
				{
					logpassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(logpassword.getText().equals(""))
				{
					logpassword.setText("Enter password");
				}
			}
		});
		logpassword.setBounds(61, 241, 233, 27);
		contentPane.add(logpassword);
		
		JButton logbtn = new JButton("Login");
		logbtn.setForeground(new Color(0, 0, 0));
		logbtn.setBackground(new Color(0, 128, 128));
		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from registration where email='"+logemail.getText()+"'and password='"+logpassword.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login succesfully...");
						Mainpage mp = new Mainpage();
						mp.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		logbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		logbtn.setBounds(61, 308, 233, 33);
		contentPane.add(logbtn);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(372, 0, 487, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Thank You");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_3.setBounds(174, 128, 140, 51);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Enter your personal details ");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(101, 187, 289, 24);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("and start journey with us");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_4_1.setBounds(111, 210, 289, 24);
		panel.add(lblNewLabel_4_1);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup su = new signup();
				su.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(174, 246, 128, 33);
		panel.add(btnNewButton);
	}
}
