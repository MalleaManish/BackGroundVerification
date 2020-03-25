package com.cg.backgroundverification.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.backgroundverification.dto.DocumentDto;
import com.cg.backgroundverification.dto.UploadDocumentDto;
import com.cg.backgroundverification.util.ConvertDate;
import com.cg.backgroundverification.util.Dbconn;
import com.cg.backgroundverification.util.StringToLocalDate;

public class UploadDocumentImpl implements UploadDocumentDao {

	@Override
	public DocumentDto insertDocument(ArrayList<DocumentDto> docs) {
		int rows=0;
		try {
			
			Connection connect = Dbconn.getConnection();
			PreparedStatement pst = connect.prepareStatement("insert into document values(?,?,?,?,?,?)");
			for(DocumentDto dd : docs)
			{	
	           pst.setInt(1,dd.getDocId());    
	           pst.setString(2,dd.getDoctype());
	           pst.setString(3,dd.getIssueAuthority());
	           java.time.LocalDate d = dd.getIssueDate();
	           StringToLocalDate stdte=new StringToLocalDate();
	           pst.setDate(4,Date.valueOf(dd.getIssueDate()));
	           pst.setString(5,dd.getFilePath());
	           pst.setInt(6,dd.getUploadId());
	           rows=pst.executeUpdate();
			}  
		}
	catch(SQLException e){
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return docs.get(0);
		
		
	}

	//@Override
	public void insertUploadDetails(int uploadId,int empid,java.sql.Date udate)
    {
		int rows=0;
		try {
			
			Connection connect = Dbconn.getConnection();
			PreparedStatement pst = connect.prepareStatement("insert into uploaddocs values(?,?,?)");
	        pst.setInt(1,uploadId);    
	        pst.setInt(2,empid);
	        pst.setDate(3, udate);
	        rows=pst.executeUpdate();
	        PreparedStatement pst1=connect.prepareStatement("insert into verification values(?,?)");
	        pst1.setInt(1,uploadId);
	        pst1.setString(2,"P");
	       rows = pst1.executeUpdate();
		}
	catch(SQLException e){
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //return uploadDocument;
		
	}
	public String getUploadedDocsStatus(int empid)
	{
		String s="No Pending uploaded documents Found";
        try 
        {	
			Connection connect = Dbconn.getConnection();
			PreparedStatement pst = connect.prepareStatement("select v.upload_id,status from verification v,uploaddocs where  empid=? and status='P'");
	        pst.setInt(1, empid);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next())
	        	s="Uploaded Id is "+rs.getString(1)+"\n Status is "+rs.getString(2);
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
		return s;
	}
}
