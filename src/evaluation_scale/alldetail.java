package evaluation_scale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class alldetail extends JFrame {

	private JPanel contentPane;
	private JTable tbldata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alldetail frame = new alldetail();
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
	public alldetail() {
		setTitle("Display details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 840, 318);
		contentPane.add(scrollPane);
		
		tbldata = new JTable();
		scrollPane.setViewportView(tbldata);
		
		JButton displaybtn = new JButton("DISPLAY");
		displaybtn.setForeground(new Color(192, 192, 192));
		displaybtn.setBackground(new Color(0, 128, 128));
		displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement st= con.createStatement();
String query="SELECT s.usn,s.name,s.course,s.gender,m.ds,m.java,m.dbms,m.total,m.average,m.result FROM studentdetails s inner JOIN marks m ON s.usn = m.usn;";
					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tbldata.getModel();
					
					int cols=rsmd.getColumnCount();
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
					st.close();
					con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		displaybtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		displaybtn.setBounds(32, 485, 183, 35);
		contentPane.add(displaybtn);
		
		JButton clearbtn = new JButton("CLEAR");
		clearbtn.setBackground(new Color(0, 128, 128));
		clearbtn.setForeground(new Color(192, 192, 192));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbldata.setModel(new DefaultTableModel());
			}
		});
		clearbtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		clearbtn.setBounds(648, 485, 183, 35);
		contentPane.add(clearbtn);
		
		JButton pass = new JButton("PASS");
		pass.setBackground(new Color(0, 128, 128));
		pass.setForeground(new Color(192, 192, 192));
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement st= con.createStatement();

String query = "SELECT s.usn,s.name,s.course,s.gender,m.ds,m.java,m.dbms,m.total,m.average,m.result FROM studentdetails s inner JOIN marks m ON s.usn = m.usn where result= 'pass' ";
					

					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					
					int cols=rsmd.getColumnCount();
					DefaultTableModel model=(DefaultTableModel) tbldata.getModel();
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
					st.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		pass.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		pass.setBounds(241, 487, 183, 33);
		contentPane.add(pass);
		
		JButton fail = new JButton("FAIL");
		fail.setBackground(new Color(0, 128, 128));
		fail.setForeground(new Color(192, 192, 192));
		fail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement st= con.createStatement();

					 String query = "SELECT s.usn,s.name,s.course,s.gender,m.ds,m.java,m.dbms,m.total,m.average,m.result FROM studentdetails s inner JOIN marks m ON s.usn = m.usn where result= 'fail' ";
					

					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					
					int cols=rsmd.getColumnCount();
					DefaultTableModel model=(DefaultTableModel) tbldata.getModel();
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
					st.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fail.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		fail.setBounds(449, 485, 170, 35);
		contentPane.add(fail);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 865, 109);
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
		addbtn.setBounds(371, 33, 168, 42);
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
		btnHome.setBounds(59, 33, 168, 42);
		panel.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Check Score ", "By Id", "all details"}));

		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(4);
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.setFont(new Font("Kristen ITC", Font.BOLD, 14));

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
		comboBox.setBounds(661, 33, 180, 42);
		panel.add(comboBox);
	}
}
