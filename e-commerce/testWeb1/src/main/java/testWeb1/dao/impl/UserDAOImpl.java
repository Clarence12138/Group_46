package testWeb1.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb1.db.DBConnect;
import testWeb1.dao.UserDAO;
import testWeb1.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserDAOImpl implements UserDAO {

	/**
	* Query whether the user exists according to the user information
	 * @param userinfo User information object, including the user name and password
	 * @return Returns 1 and 0 if not
	 * @throws Exception Exception that may be thrown during the query
	 */
	
	public int queryByUserInfo(UserInfo userinfo) throws Exception {
		int flag = 0;
		String sql = "select * from userinfo where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;

		try {
			// Create a database connection
			dbc = new DBConnect();
			// Create a precompiled SQL statement
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, userinfo.getUsername());

			// Perform query operation
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// Check whether the password in the query result is the same as that in the user information object
				if (rs.getString("password").equals(userinfo.getPassword())) {
					// If yes, the flag bit is set to 1, indicating that the user exists
					flag = 1;
				}
				userinfo.setUserId(rs.getInt("userinfoid"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setGender(rs.getString("gender"));
				userinfo.setProfession(rs.getString("profession"));
				userinfo.setFavor(rs.getString("favor"));
				userinfo.setDescription(rs.getString("description"));
				userinfo.setRobotid(rs.getInt("robotid"));				
			}
			
		    /**
		     * Handle GET requests
		     */
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// Close database connection
			dbc.close();
		}
		return flag;
	}
}
