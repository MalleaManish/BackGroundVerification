package com.cg.backgroundverification.dao;

import com.cg.backgroundverification.dto.LoginDto;

public interface LoginDao {

	LoginDto validateUser(LoginDto loginDetails);
	


}
