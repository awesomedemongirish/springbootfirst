package com.girish.springboot.my_first_project;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControler {
	List<String> arr=new ArrayList<String>();
	@Autowired
	practice serv;
	@RequestMapping("/welcome")
	public String disp()
	{
		return serv.disp();
	}
}
