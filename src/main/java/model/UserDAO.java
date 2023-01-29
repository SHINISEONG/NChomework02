package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import jw.common.pool.OracleConnectionPool;

public class UserDAO {
	///field
	///constructor
	public UserDAO() {
	}
	
	///method
	public boolean addUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		boolean addUserResult = false;
		
try {
			
			con = OracleConnectionPool.getInstance().getConnection();
			
			pr = con.prepareStatement("INSERT INTO user_info\r\n"
					+ "(\r\n"
					+ "	user_name,\r\n"
					+ "	sex,\r\n"
					+ "	birth_day,\r\n"
					+ "	jobs,\r\n"
					+ "	cell_num,\r\n"
					+ "	addr\r\n"
					+ ")\r\n"
					+ "VALUES\r\n"
					+ "(\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	?,\r\n"
					+ "	?\r\n"
					+ ")");
			pr.setString(1, userVO.getUserName());
			pr.setString(2, userVO.getSex());
			pr.setString(3, userVO.getBirthDay());
			pr.setString(4, userVO.getJobs());
			pr.setString(5, userVO.getCellNum());
			pr.setString(6, userVO.getAddr());
			
			
			
			if(pr.executeUpdate() == 1) {
				addUserResult = true;
			} else {
				System.out.println("Insert ½ÇÆÐ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
				}
			}
			if (pr != null) {
				try {
					pr.close();
				} catch (SQLException e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e3) {
				}
			}
		}
		return addUserResult;
	}//end of userAdd()
	
	public boolean findUser(String userName, UserVO userVO) {
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		boolean findUserResult = false;
try {
			
			con = OracleConnectionPool.getInstance().getConnection();
			
			pr = con.prepareStatement("SELECT * FROM user_info\r\n"
					+ "WHERE\r\n"
					+ "user_name=?");
			pr.setString(1, userName);
			
			
			
			rs=pr.executeQuery();
			
			if(rs.next()) {
				String sex = rs.getString("sex");
				String birthDay = rs.getString("birth_day");
				String jobs = rs.getString("jobs");
				String cellNum = rs.getString("cell_num");
				String addr = rs.getString("addr");
				userVO.setAllInfo(userName, sex, birthDay, jobs, cellNum, addr);
				findUserResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
				}
			}
			if (pr != null) {
				try {
					pr.close();
				} catch (SQLException e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e3) {
				}
			}
		}
		return findUserResult;
	}//end of userAdd()
}
