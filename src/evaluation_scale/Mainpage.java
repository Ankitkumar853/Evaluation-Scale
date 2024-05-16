package evaluation_scale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Mainpage extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
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
	public Mainpage() {
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Sir");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 26));
		lblNewLabel.setBounds(323, 213, 201, 69);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 865, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton addbtn = new JButton("Add Student");
		addbtn.setForeground(new Color(0, 128, 128));
		addbtn.setBounds(371, 33, 168, 42);
		panel.add(addbtn);
		addbtn.setBackground(new Color(255, 255, 255));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentdetails sd =new studentdetails();
				sd.setVisible(true);
			}
		});
		addbtn.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(0, 128, 128));
		btnHome.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBounds(59, 33, 168, 42);
		panel.add(btnHome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		comboBox.setForeground(new Color(0, 128, 128));
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
		comboBox.setBounds(661, 33, 180, 42);
		panel.add(comboBox);
	}
}
