package evaluation_scale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import javax.swing.JComboBox;

public class studentdetails extends JFrame {

	private JPanel contentPane;
	private JTextField sid;
	private JTextField sname;
	private JTextField scourse;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentdetails frame = new studentdetails();
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
	public studentdetails() {
		setTitle("Add student detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student Information");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		lblNewLabel.setBounds(210, 148, 267, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_1.setBounds(187, 266, 60, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_2.setBounds(187, 312, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_3.setBounds(187, 348, 92, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(new Color(0, 128, 128));
		lblNewLabel_4.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_4.setBounds(187, 379, 110, 28);
		contentPane.add(lblNewLabel_4);
		
		sid = new JTextField();
		sid.setBounds(338, 267, 200, 29);
		contentPane.add(sid);
		sid.setColumns(10);
		
		sname = new JTextField();
		sname.setBounds(338, 306, 200, 28);
		contentPane.add(sname);
		sname.setColumns(10);
		
		scourse = new JTextField();
		scourse.setBounds(338, 342, 200, 28);
		contentPane.add(scourse);
		scourse.setColumns(10);
		
		JRadioButton gmale = new JRadioButton("Male");
		gmale.setBackground(new Color(255, 255, 255));
		gmale.setForeground(new Color(0, 0, 0));
		buttonGroup.add(gmale);
		gmale.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		gmale.setBounds(343, 383, 103, 21);
		contentPane.add(gmale);
		
		JRadioButton gfemale = new JRadioButton("Female");
		gfemale.setBackground(new Color(255, 255, 255));
		gfemale.setForeground(new Color(0, 0, 0));
		buttonGroup.add(gfemale);
		gfemale.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		gfemale.setBounds(451, 383, 92, 21);
		contentPane.add(gfemale);
		
		JButton insertbtn = new JButton("Insert");
		insertbtn.setForeground(new Color(255, 255, 255));
		insertbtn.setBackground(new Color(64, 128, 128));
		insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					String query ="insert into studentdetails value(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, sid.getText());
					ps.setString(2, sname.getText());
					ps.setString(3, scourse.getText());
					if(gmale.isSelected())
						ps.setString(4,gmale.getText());
					else
						ps.setString(4, gfemale.getText());
//					ps.setString(5,dsscore.getText());
//					ps.setString(6, javascore.getText());
//					ps.setString(7, dbmsscore.getText());
//					
//					
//					 String dsscoreText = dsscore.getText();
//				        String javascoreText = javascore.getText();
//				        String dbmsscoreText = dbmsscore.getText();

				        
//				        String sqlUpdate = "UPDATE studentdetails SET total = ?";
//
//				            int totalScore = Integer.parseInt(dsscoreText) + Integer.parseInt(javascoreText) + Integer.parseInt(dbmsscoreText);
//
//				           
//				            ps.setInt(8, totalScore);
//
//				            
//					        String sqlUpdate2 = "UPDATE studentdetails SET total = ?";
//					        float average=(Float.parseFloat(dsscoreText)+Float.parseFloat(javascoreText)+Float.parseFloat(dbmsscoreText))/3;
//					        
//					        ps.setFloat(9, average);
//					        
//					        String result;
//							if(average>=40)
//								result="PASS";
//							else
//								result="FAIL";
//							ps.setString(10, result);
//							
							int rowsAffected = ps.executeUpdate();
							
								
				            
				        
					JOptionPane.showMessageDialog(insertbtn,rowsAffected +"Student details Added successfully");
					
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
		insertbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		insertbtn.setBounds(187, 454, 142, 40);
		contentPane.add(insertbtn);
		
		JButton resetbtn = new JButton("Reset");
		resetbtn.setForeground(new Color(255, 255, 255));
		resetbtn.setBackground(new Color(64, 128, 128));
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sid.setText("");
				sname.setText("");
				scourse.setText("");
				
				
				
			}
		});
		resetbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		resetbtn.setBounds(366, 454, 142, 40);
		contentPane.add(resetbtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 709, 109);
		contentPane.add(panel);
		
		JButton addbtn = new JButton("Add Student");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		addbtn.setForeground(new Color(0, 128, 128));
		addbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		addbtn.setBackground(Color.WHITE);
		addbtn.setBounds(266, 33, 168, 42);
		panel.add(addbtn);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage mp =new Mainpage();
				mp.setVisible(true);
			}
		});
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(34, 33, 168, 42);
		panel.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		comboBox.setBounds(489, 33, 180, 42);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Check Score ", "By Id", "all details"}));

		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(4);
		
		 comboBox.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e) {
		          String value = (String) comboBox.getSelectedItem(); // get the selected item in the combobox
		        switch(value){
		        case "By Id":
		        	Byid b1 = new Byid(); // call the class
		            b1.setVisible(true);    // set the jframe to visible 
		            break;
		        
		        case "all details":
		            alldetail b3 = new alldetail();
		            b3.setVisible(true);
		            break;
		        }          
		      }
		    });
		
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Add Marks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addmarks am=new Addmarks();
				am.setVisible(true);
			}
		});
		btnNewButton.setBounds(574, 133, 103, 28);
		contentPane.add(btnNewButton);
	}
}
