package com.cg.backgroundverification.dto;

public class LoginDto {
	  int empid;
	  String ename;
	  String password;
	  char role;
	  public void Login()
	  {
		  
	  }
	  public void Login(int empid,String password)
	  {
	      this.empid=empid;   this.password=password;
	  }
	public LoginDto(int empid, String ename, String password, char role) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.password = password;
		this.role = role;
	}
	public LoginDto() {
		// TODO Auto-generated constructor stub
	}
	public LoginDto(int id, String pass) 
	{
		this.empid=id;
		this.password=pass;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}

}
