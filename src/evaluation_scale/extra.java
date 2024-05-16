//package evaluation_scale;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import javax.swing.JOptionPane;
//
//public class extra {
//
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
//		String query ="insert into studentdetails value(?,?,?,?,?,?,?,?,?,?)";
//		PreparedStatement ps=con.prepareStatement(query);
//		ps.setString(1, sid.getText());
//		ps.setString(2, sname.getText());
//		ps.setString(3, scourse.getText());
//		if(gmale.isSelected())
//			ps.setString(4,gmale.getText());
//		else
//			ps.setString(4, gfemale.getText());
//		ps.setString(5,dsscore.getText());
//		ps.setString(6, javascore.getText());
//		ps.setString(7, dbmsscore.getText());
//		
//		
//		 String dsscoreText = dsscore.getText();
//	        String javascoreText = javascore.getText();
//	        String dbmsscoreText = dbmsscore.getText();
//
//	        
//	        String sqlUpdate = "UPDATE studentdetails SET total = ?";
//
//	            int totalScore = Integer.parseInt(dsscoreText) + Integer.parseInt(javascoreText) + Integer.parseInt(dbmsscoreText);
//
//	           
//	            ps.setInt(8, totalScore);
//
//	            
//		        String sqlUpdate2 = "UPDATE studentdetails SET total = ?";
//		        float average=(Float.parseFloat(dsscoreText)+Float.parseFloat(javascoreText)+Float.parseFloat(dbmsscoreText))/3;
//		        
//		        ps.setFloat(9, average);
//		        
//		        String result;
//				if(average>=40)
//					result="PASS";
//				else
//					result="FAIL";
//				ps.setString(10, result);
//				
//				int rowsAffected = ps.executeUpdate();
//				
//					
//	            
//	        
//		JOptionPane.showMessageDialog(insertbtn,rowsAffected +"Student details Added successfully");
//		
//		Mainpage mp=new Mainpage();
//		mp.setVisible(true);
//		ps.close();
//		con.close();
//	
//						
//	} catch (Exception e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//}
//});
//}
