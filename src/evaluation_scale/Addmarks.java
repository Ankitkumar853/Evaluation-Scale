package evaluation_scale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Addmarks extends JFrame {

	private JPanel contentPane;
	private JTextField ds;
	private JTextField java;
	private JTextField dbms;
	private JTextField studentid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addmarks frame = new Addmarks();
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
	public Addmarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 841, 109);
		contentPane.add(panel);
		
		JButton addbtn = new JButton("Add Student");
		addbtn.setForeground(new Color(0, 128, 128));
		addbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		addbtn.setBackground(Color.WHITE);
		addbtn.setBounds(342, 33, 168, 42);
		panel.add(addbtn);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(36, 33, 168, 42);
		panel.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Check Score ", "By Id", "By Query", "all details"}));

		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(4);
		
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		comboBox.setBounds(626, 33, 180, 42);
		 comboBox.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e) {
		          String value = (String) comboBox.getSelectedItem(); // get the selected item in the combobox
		        switch(value){
		        case "By Id":
		        	Byid b1 = new Byid(); // call the class
		            b1.setVisible(true);    // set the jframe to visible 
		            break;
		        case "By Query":
		            byquery b2 = new byquery();
		            b2.setVisible(true);
		            break;
		        case "all details":
		            alldetail b3 = new alldetail();
		            b3.setVisible(true);
		            break;
		        }          
		      }
		    });
		
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Data Structure");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(76, 243, 134, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblJava = new JLabel("Java");
		lblJava.setFont(new Font("Calibri", Font.BOLD, 18));
		lblJava.setBounds(378, 243, 134, 32);
		contentPane.add(lblJava);
		
		JLabel lblDbms = new JLabel("DBMS");
		lblDbms.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDbms.setBounds(644, 243, 134, 32);
		contentPane.add(lblDbms);
		
		ds = new JTextField();
		ds.setBounds(51, 286, 159, 32);
		contentPane.add(ds);
		ds.setColumns(10);
		
		java = new JTextField();
		java.setColumns(10);
		java.setBounds(314, 285, 159, 32);
		contentPane.add(java);
		
		dbms = new JTextField();
		dbms.setColumns(10);
		dbms.setBounds(590, 285, 159, 32);
		contentPane.add(dbms);
		
		JButton submitmarks = new JButton("Submit");
		submitmarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					String query ="insert into marks value(?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, studentid.getText());
					ps.setString(2, ds.getText());
					ps.setString(3, java.getText());
					ps.setString(4,dbms.getText());
					 String dsscoreText = ds.getText();
				        String javascoreText = java.getText();
				        String dbmsscoreText = dbms.getText();

				        String sqlUpdate = "UPDATE marks SET total = ?";
//
				            int totalScore = Integer.parseInt(dsscoreText) + Integer.parseInt(javascoreText) + Integer.parseInt(dbmsscoreText);
//
//				           
				            ps.setInt(5, totalScore);
//
//				            
					        String sqlUpdate2 = "UPDATE marks SET average = ?";
					        float average=(Float.parseFloat(dsscoreText)+Float.parseFloat(javascoreText)+Float.parseFloat(dbmsscoreText))/3;
					        
					        ps.setFloat(6, average);
					        
					        String result;
							if(average>=40)
								result="PASS";
							else
								result="FAIL";
							ps.setString(7, result);
//							
							int rowsAffected = ps.executeUpdate();
							JOptionPane.showMessageDialog(submitmarks,rowsAffected +"Student marks Added successfully");
					
					Mainpage mp=new Mainpage();
					mp.setVisible(true);
					ps.close();
					con.close();
				
									
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submitmarks.setFont(new Font("Tahoma", Font.PLAIN, 17));
		submitmarks.setBounds(197, 350, 126, 32);
		contentPane.add(submitmarks);
		
		JButton clearmarks = new JButton("Clear");
		clearmarks.setFont(new Font("Tahoma", Font.PLAIN, 17));
		clearmarks.setBounds(504, 350, 126, 32);
		contentPane.add(clearmarks);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblStudentId.setBounds(339, 119, 134, 32);
		contentPane.add(lblStudentId);
		
		studentid = new JTextField();
		studentid.setColumns(10);
		studentid.setBounds(314, 148, 159, 32);
		contentPane.add(studentid);
	}
}
