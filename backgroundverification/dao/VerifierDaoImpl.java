package com.cg.backgroundverification.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cg.backgroundverification.util.Dbconn;
public class VerifierDaoImpl implements VerifierDao 
{
   public ArrayList<String[]> getAllPendingDocs()
   {
	   ArrayList<String[]> dlist = new ArrayList<>();
	   try 
       {	
			Connection connect = Dbconn.getConnection();
			PreparedStatement pst = connect.prepareStatement("select u.upload_id,empid,upload_date from uploaddocs u,verification v where v.status = 'P'");
	        ResultSet rs = pst.executeQuery();
	        while(rs.next())
	        {
	        	dlist.add(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
	        }
		}
	    catch(SQLException e)
       {
		  e.printStackTrace();
	    }
       catch (Exception e) 
       {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	    }
	   return dlist;
   }
   public boolean updatePendingStatus(int uploadId,char status)
	{
		int count = 0;
		try 
       {	
			Connection connect = Dbconn.getConnection();
			PreparedStatement pst = connect.prepareStatement("update verification set status=? where upload_id=?");
	        pst.setString(1, String.valueOf(status));   pst.setInt(2, uploadId);
	        count = pst.executeUpdate();
		}
	    catch(SQLException e)
       {
		  e.printStackTrace();
	    }
       catch (Exception e) 
       {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	    }
		return count > 0;
	}
}
