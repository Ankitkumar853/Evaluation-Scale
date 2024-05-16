package evaluation_scale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JComboBox;

public class Byid extends JFrame {

	private JPanel contentPane;
	private JTable newtbldata;
	private JTextField uid;
	private JTextField namesearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Byid frame = new Byid();
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
	public Byid() {
		setTitle("Display using ID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 821, 220);
		contentPane.add(scrollPane);
		
		newtbldata = new JTable();
		scrollPane.setViewportView(newtbldata);
		
		JButton showbtn = new JButton("DISPLAY");
		showbtn.setBackground(new Color(0, 128, 128));
		showbtn.setForeground(new Color(192, 192, 192));
		showbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement st= con.createStatement();

					 String query = "SELECT s.usn,s.name,s.course,s.gender,m.ds,m.java,m.dbms,m.total,m.average,m.result FROM studentdetails s inner JOIN marks m ON s.usn = m.usn where s.usn= ? ";
					 String id = uid.getText();
					 int idn=Integer.parseInt(id);
					 PreparedStatement statement = con.prepareStatement(query);
					 statement.setInt(1,idn);

					ResultSet rs=statement.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
					
					int cols=rsmd.getColumnCount();
					DefaultTableModel model=(DefaultTableModel) newtbldata.getModel();
					model.setRowCount(0);
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					String usn,name,course,gender,ds,java,dbms,total,average,result;
					
					while(rs.next())
					{
						usn=rs.getString(1);
						name=rs.getString(2);
						course=rs.getString(3);
						gender=rs.getString(4);
						ds=rs.getString(5);
						java=rs.getString(6);
						dbms=rs.getString(7);
						total=rs.getString(8);
						average=rs.getString(9);
						result=rs.getString(10);
						
						String[] row= {usn,name,course,gender,ds,java,dbms,total,average,result};
						model.addRow(row);
					}
					rs.close();
					statement.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		showbtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		showbtn.setBounds(328, 379, 132, 27);
		contentPane.add(showbtn);
		
		JButton clearbtn = new JButton("CLEAR");
		clearbtn.setBackground(new Color(0, 128, 128));
		clearbtn.setForeground(new Color(192, 192, 192));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newtbldata.setModel(new DefaultTableModel());
			}
		});
		clearbtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		clearbtn.setBounds(609, 379, 183, 50);
		contentPane.add(clearbtn);
		
		JLabel lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 375, 148, 38);
		contentPane.add(lblNewLabel);
		
		uid = new JTextField();
		uid.setBounds(151, 382, 163, 27);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 423, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		namesearch = new JTextField();
		namesearch.setBounds(151, 413, 163, 31);
		contentPane.add(namesearch);
		namesearch.setColumns(10);
		
		JButton nameshow = new JButton("DISPLAY");
		nameshow.setBackground(new Color(0, 128, 128));
		nameshow.setForeground(new Color(192, 192, 192));
		nameshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement st= con.createStatement();

					 String query = "SELECT s.usn,s.name,s.course,s.gender,m.ds,m.java,m.dbms,m.total,m.average,m.result FROM studentdetails s inner JOIN marks m ON s.usn = m.usn where name= ? ";
					 String sname = namesearch.getText();
					
					 PreparedStatement statement = con.prepareStatement(query);
					 statement.setString(1,sname);

					ResultSet rs=statement.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
					
					int cols=rsmd.getColumnCount();
					DefaultTableModel model=(DefaultTableModel) newtbldata.getModel();
					model.setRowCount(0);
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					String usn,name,course,gender,ds,java,dbms,total,average,result;
					
					while(rs.next())
					{
						usn=rs.getString(1);
						name=rs.getString(2);
						course=rs.getString(3);
						gender=rs.getString(4);
						ds=rs.getString(5);
						java=rs.getString(6);
						dbms=rs.getString(7);
						total=rs.getString(8);
						average=rs.getString(9);
						result=rs.getString(10);
						
						String[] row= {usn,name,course,gender,ds,java,dbms,total,average,result};
						model.addRow(row);
					}
					rs.close();
					statement.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		nameshow.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		nameshow.setBounds(328, 416, 132, 27);
		contentPane.add(nameshow);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 841, 109);
		contentPane.add(panel);
		
		JButton addbtn = new JButton("Add Student");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentdetails sd=new studentdetails();
				sd.setVisible(true);
			}
		});
		addbtn.setForeground(new Color(0, 128, 128));
		addbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		addbtn.setBackground(Color.WHITE);
		addbtn.setBounds(342, 33, 168, 42);
		panel.add(addbtn);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage mp=new Mainpage();
				mp.setVisible(true);
				
			}
		});
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(36, 33, 168, 42);
		panel.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Check Score ", "By Id",  "all details"}));

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
		   
		        case "all details":
		            alldetail b3 = new alldetail();
		            b3.setVisible(true);
		            break;
		        }          
		      }
		    });
		panel.add(comboBox);
	}
}
