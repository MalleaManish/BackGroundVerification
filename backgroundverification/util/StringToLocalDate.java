package com.cg.backgroundverification.util;

import java.time.LocalDate;

public class StringToLocalDate 
{
    public static LocalDate convert(String d)
    {
    	String[] s = d.split("-");
    	return LocalDate.of(Integer.parseInt(s[2]),Integer.parseInt(s[1]), Integer.parseInt(s[0]));
    }
}
