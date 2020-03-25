package com.cg.backgroundverification.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.util.Dbconn;

public class LoginDaoImpl implements LoginDao {

	@Override
	public LoginDto validateUser(LoginDto loginDetails) {
			try {
				
				Connection connect = Dbconn.getConnection();
				PreparedStatement pst = connect.prepareStatement("select * from employee where empid=? and password=?");
		        pst.setInt(1,loginDetails.getEmpid());    
		        pst.setString(2,loginDetails.getPassword());
		        ResultSet rs = pst.executeQuery();
		        if(rs.next())
		        {
		            loginDetails.setEname(rs.getString(2));
		            loginDetails.setRole(rs.getString(4).charAt(0)); 
		        } 
			}
		catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return loginDetails;
  
	}

}
