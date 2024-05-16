package evaluation_scale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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

public class byquery extends JFrame {

	private JPanel contentPane;
	private JTable querytbl;
	private JTextField queryf;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton addbtn;
	private JButton btnHome;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					byquery frame = new byquery();
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
	public byquery() {
		setTitle("Display using Query");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 132, 789, 192);
		contentPane.add(scrollPane);
		
		querytbl = new JTable();
		scrollPane.setViewportView(querytbl);
		
		queryf = new JTextField();
		queryf.setToolTipText("");
		queryf.setFont(new Font("Kristen ITC", Font.PLAIN, 14));
		queryf.setBounds(23, 351, 794, 31);
		contentPane.add(queryf);
		queryf.setColumns(10);
		
		JButton showbtn = new JButton("Display");
		showbtn.setForeground(new Color(192, 192, 192));
		showbtn.setBackground(new Color(0, 128, 128));
		showbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					Statement st= con.createStatement();
					String query=queryf.getText();
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					
					int cols=rsmd.getColumnCount();
					DefaultTableModel model=(DefaultTableModel) querytbl.getModel();
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
		showbtn.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		showbtn.setBounds(161, 404, 141, 27);
		contentPane.add(showbtn);
		
		btnNewButton = new JButton("Clear");
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querytbl.setModel(new DefaultTableModel());
			}
		});
		btnNewButton.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		btnNewButton.setBounds(521, 404, 141, 27);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 841, 109);
		contentPane.add(panel);
		
		addbtn = new JButton("Add Student");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentdetails sd =new studentdetails();
				sd.setVisible(true);
			}
		});
		addbtn.setForeground(new Color(0, 128, 128));
		addbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		addbtn.setBackground(Color.WHITE);
		addbtn.setBounds(342, 33, 168, 42);
		panel.add(addbtn);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage mp =new Mainpage();
				mp.setVisible(true);
			}
		});
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(36, 33, 168, 42);
		panel.add(btnHome);
		
		comboBox = new JComboBox();
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
	}

}
