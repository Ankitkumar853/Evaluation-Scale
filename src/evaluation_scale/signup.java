package evaluation_scale;

import java.awt.EventQueue;

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
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtemail;
	
	private JTextField signname;
	private JPasswordField signpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		setTitle("Signup\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		lblNewLabel.setBounds(587, 32, 187, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_1.setBounds(536, 83, 130, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_2.setBounds(536, 160, 110, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_3.setBounds(536, 233, 110, 16);
		contentPane.add(lblNewLabel_3);
		
		
		txtemail = new JTextField();
		txtemail.setBounds(536, 195, 295, 28);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		
		
		
		
		JButton signbtn = new JButton("Signup");
		signbtn.setBackground(new Color(0, 128, 128));
		signbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					String query ="insert into registration value(?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, signname.getText());
					ps.setString(2, txtemail.getText());
					ps.setString(3, signpassword.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(signbtn, i+"Record Added successfully");
					login ln=new login();
					ln.setVisible(true);
					ps.close();
					con.close();
					
					
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		signbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		signbtn.setBounds(581, 342, 85, 21);
		contentPane.add(signbtn);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signname.setText("");
				txtemail.setText("");
				signpassword.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.BOLD, 14) );
		btnNewButton_1.setBounds(708, 342, 85, 21);
		contentPane.add(btnNewButton_1);
		
		signname = new JTextField();
		signname.setBounds(536, 122, 295, 28);
		contentPane.add(signname);
		signname.setColumns(10);
		
		signpassword = new JPasswordField();
		signpassword.setBounds(536, 259, 295, 28);
		contentPane.add(signpassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 466, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(161, 176, 108, 35);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login li=new login();
				li.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Kristen ITC", Font.BOLD, 14));
	}
}
