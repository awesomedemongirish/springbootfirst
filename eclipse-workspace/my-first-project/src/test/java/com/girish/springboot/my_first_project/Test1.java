package com.girish.springboot.my_first_project;

import static org.junit.Assert.*;
import com.girish.springboot.my_first_project.*;
import org.junit.Test;
public class Test1 {
	@Test
	public void addtest()
	{
		WelcomeControler wc=new WelcomeControler();
		assertEquals("Girish",wc.disp());
	}
}
