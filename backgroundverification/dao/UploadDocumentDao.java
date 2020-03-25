package com.cg.backgroundverification.dao;
import java.util.ArrayList;
import com.cg.backgroundverification.dto.DocumentDto;
import com.cg.backgroundverification.dto.UploadDocumentDto;
public interface UploadDocumentDao {
	public DocumentDto  insertDocument(ArrayList<DocumentDto> docs);
	//public UploadDocumentDto insertUploadDetails(UploadDocumentDto uploadDocument);
	void insertUploadDetails(int uploadId,int empid,java.sql.Date udate);
    String getUploadedDocsStatus(int empid);
}
