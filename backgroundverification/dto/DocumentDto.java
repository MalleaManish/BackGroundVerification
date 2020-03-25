package com.cg.backgroundverification.dto;

import java.time.LocalDate;

public class DocumentDto {
	private int docId;
	private  String doctype;
	private String issueAuthority;
	private LocalDate issueDate;
	private  String filePath;
	private int uploadId;
	public DocumentDto() {    }
	public DocumentDto(int docId, String doctype, String issueAuthority, LocalDate issueDate, String filePath) {
		super();
		this.docId = docId;
		this.doctype = doctype;
		this.issueAuthority = issueAuthority;
		this.issueDate = issueDate;
		this.filePath = filePath;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public String getIssueAuthority() {
		return issueAuthority;
	}
	public void setIssueAuthority(String issueAuthority) {
		this.issueAuthority = issueAuthority;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate date) {
		this.issueDate = date;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getUploadId() {
		return uploadId;
	}
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}
}
