package com.cg.backgroundverification.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.backgroundverification.dao.LoginDaoImpl;
import com.cg.backgroundverification.dto.LoginDto;
import com.cg.backgroundverification.exception.UserNotFoundException;

public class LoginMain 
{
	public static void main(String[] args) throws Exception
	{
	 Login(null)	;
	}
	
	public static void Login(LoginDto loginDto)
	{
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter employee id");
			int id=sc.nextInt();
			System.out.println("Enter password");
			sc.nextLine();
			String pass=sc.nextLine();
			LoginDto loginDto1= new LoginDto(id,pass);
			LoginDaoImpl log = new LoginDaoImpl();
			if(log.validateUser(loginDto1).getEname()!=null)
			{
			 System.out.println("Successfully logged in");
				if(log.validateUser(loginDto1).getRole()=='e')
				{	System.out.println("===============You are in employee section================"); 
					System.out.println("1. Upload Documents");
					System.out.println("2. View Uploaded Documents Status");
					System.out.println("3. E X I T");
					int opt=sc.nextInt();
					sc.nextLine();
					switch(opt)
					{
					  case 1:
						  EmployeeScreen.employeeScreen(id);
						  break;
					  case 2:
						  EmployeeScreen.viewStatus(id);
						  break;
					  case 3:
						  System.exit(1);
					  default:
						  System.out.println("Invalid Option");
					}  
				}
				else 
					//display verification screen
					{
						System.out.println("===============You are in  verification screen===========");
					    VerifierScreen.getScreen();
					}
			}
			else
				try{
					throw new UserNotFoundException();
					}catch(UserNotFoundException e)
					{
						System.out.println(e.getMessage());
					}
    }
}


