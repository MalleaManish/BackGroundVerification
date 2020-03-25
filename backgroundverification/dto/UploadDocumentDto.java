package com.cg.backgroundverification.dto;
import java.util.ArrayList;
import java.util.Date;
public class UploadDocumentDto 
{
	private int uploadedId;
	private ArrayList<DocumentDto> list = new ArrayList<>();
    private Date uploadedDate;
    private char status;
    LoginDto logindto;  //employee
	public UploadDocumentDto() {   }
	public UploadDocumentDto(int uploadedId, ArrayList<DocumentDto> list, Date uploadedDate, LoginDto logindto,char status) {
		super();
		this.uploadedId = uploadedId;
		this.list = list;
		this.uploadedDate = uploadedDate;
		this.logindto = logindto;
		this.status=status;
	}
	public int getUploadedId() {
		return uploadedId;
	}
	public void setUploadedId(int uploadedId) {
		this.uploadedId = uploadedId;
	}
	public ArrayList<DocumentDto> getList() {
		return list;
	}
	public void setList(ArrayList<DocumentDto> list) {
		this.list = list;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public LoginDto getLogindto() {
		return logindto;
	}
	public void setLogindto(LoginDto logindto) {
		this.logindto = logindto;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}  
	
}
