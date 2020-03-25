package com.cg.backgroundverification.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.backgroundverification.dao.LoginDao;
import com.cg.backgroundverification.dto.LoginDto;

public class Junit {
	
    private LoginDao m;
    @Before
    public void setUp()throws Exception
    {
    	
    }
    @After
    public void tearDown() throws Exception{
    	
    }
	@Test
	public void testUserDetails()
	{
         LoginDto a=new LoginDto(101,"Manish","1011",'v');
		//assertTrue(m.login(a)==true);   
 	}
	public void n(){
		
	}

}
