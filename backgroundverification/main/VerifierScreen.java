package com.cg.backgroundverification.main;
import java.util.ArrayList;
import java.util.Scanner;
import com.cg.backgroundverification.dao.VerifierDao;
import com.cg.backgroundverification.dao.VerifierDaoImpl;
public class VerifierScreen 
{
   static Scanner sc = new Scanner(System.in);	
   static VerifierDao vdao = new VerifierDaoImpl();	
   public static void getScreen()
   {
	   ArrayList<String[]> docsList = vdao.getAllPendingDocs(); 
	   System.out.println("-------------------------Pending Documents List----------------------------");
	   System.out.println("---------------------------------------------------------------------------");
	   System.out.println("Upload Id      | Employee Id      | Uploaded Date");
	   System.out.println("---------------------------------------------------------------------------");
	   for(String[] ss : docsList)
	   {
		   for(String s : ss)
			   System.out.print(s+"                 ");
		   System.out.println();
	   }
	   System.out.print("\nEnter Upload Id to Verify and Modify pending Status");
	   int uploadId = sc.nextInt();
	   sc.nextLine();
	   System.out.print("Modify Pending Status (A Accept/ R Reject) ");
	   char status = sc.nextLine().charAt(0);
	   if(vdao.updatePendingStatus(uploadId, status))
		   System.out.println("Status Updated Successfully");
	   else
		   System.out.println("Updation Failed");   
   }
}
