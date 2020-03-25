package com.cg.backgroundverification.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.cg.backgroundverification.dao.UploadDocumentDao;
import com.cg.backgroundverification.dao.UploadDocumentImpl;
import com.cg.backgroundverification.dto.DocumentDto;
import com.cg.backgroundverification.util.StringToLocalDate;

public class EmployeeScreen {
	static UploadDocumentDao udao = new UploadDocumentImpl();
	public static void employeeScreen(int empid)
	{
		Scanner scan=new Scanner(System.in);
		char opt=' ';
		ArrayList<DocumentDto> dlist = new ArrayList<>();
		//System.out.println("***You are in Employee screen****");
		System.out.println("Enter you are uploaded ID");//Doubt
		int uploadId=scan.nextInt();
		while(opt!='n')
		{
		System.out.println("Enter document ID ");
		int id=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter document type");
		String docType=scan.nextLine();
		System.out.println("Enter document issused authority");
		String docAuthority=scan.nextLine();
		System.out.println("Enter issused date");
		String date=scan.nextLine();
		System.out.println("Enter file path");
		String filePath=scan.nextLine();
		DocumentDto documentDto=new DocumentDto();
		documentDto.setDocId(id);
		documentDto.setDoctype(docType);
		documentDto.setIssueAuthority(docAuthority);
		documentDto.setIssueDate(StringToLocalDate.convert(date));
		documentDto.setFilePath(filePath);
		documentDto.setUploadId(uploadId);
		dlist.add(documentDto);
	    System.out.print("Do you want to Continue ");
	    opt = scan.nextLine().charAt(0);
	    System.out.println(opt);
		}//end of while
		udao.insertDocument(dlist);
		udao.insertUploadDetails(uploadId,empid,java.sql.Date.valueOf(LocalDate.now()));
		/*for(DocumentDto d : dlist)
		{
			System.out.println(d.getDoctype()+"     "+d.getIssueAuthority()+"  "+d.getIssueDate());
		}*/
	}
	public static void viewStatus(int empid)
	{
		//get list of documents upload by a particular employee using upload id.
		System.out.println(udao.getUploadedDocsStatus(empid));
	}
}
