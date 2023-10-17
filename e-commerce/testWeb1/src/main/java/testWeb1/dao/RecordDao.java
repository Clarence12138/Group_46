package testWeb1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import testWeb1.vo.RecordInfo;

public class RecordDao {
	 private Connection getConnection() throws SQLException {
		 	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String url = "jdbc:mysql://127.0.0.1:3306/javawebdb";
	        String username = "root";
	        String password = "111111";
	        return DriverManager.getConnection(url, username, password);
	    }
	 public void saveImagePath(int recordId, String imagePath) {
	        try (Connection connection = getConnection()) {
	        	 connection.setAutoCommit(true);
	            String query = "INSERT INTO image_paths (record_id, path) VALUES (?, ?)";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setInt(1, recordId);
	                statement.setString(2, imagePath);
	                statement.executeUpdate();
	               // connection.commit(); 
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	       
	    }
	 public void saveRecord(int id ,double time,int num,int robotid) {
	        try (Connection connection = getConnection()) {
	        	 connection.setAutoCommit(true);
	            String query = "INSERT INTO record (record_id,time,treasure_num,robot_id) VALUES (?,?,?,?) ";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	            	statement.setInt(1, id);
	            	statement.setDouble(2, time);
	                statement.setInt(3, num);
	                statement.setInt(4, robotid);
	                statement.executeUpdate();
	               // connection.commit(); 
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	       
	    }
	
	
	 public List<RecordInfo> getAllRecords() {
		    List<RecordInfo> records = new ArrayList<>();
		   
		    try (Connection connection = getConnection()) {
		        String query = "SELECT r.record_id, r.time, r.treasure_num, r.robot_id, i.path\r\n"
		        		+ "FROM record r\r\n"
		        		+ "INNER JOIN image_paths i\r\n"
		        		+"ON r.record_id = i.record_id";
		        try (PreparedStatement statement = connection.prepareStatement(query)) {
		            ResultSet resultSet = statement.executeQuery();
		            while (resultSet.next()) {
		            	RecordInfo record = new RecordInfo();
		                record.setId(resultSet.getInt("record_id"));
		                record.setTime(resultSet.getFloat("time"));
		                record.setTreasure_num(resultSet.getInt("treasure_num"));
		                record.setRobot_id(resultSet.getInt("robot_id"));
		                record.addImagePath(resultSet.getString("path"));
		                records.add(record);
		               
		            }
		           
		            
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Handle exception
		    }
		    return records;
		}
		
	
}

