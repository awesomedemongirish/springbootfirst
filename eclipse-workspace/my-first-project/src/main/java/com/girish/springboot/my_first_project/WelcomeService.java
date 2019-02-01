package com.girish.springboot.my_first_project;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

		public String welcome()
		{
		return "Oh! I got it updated";
		}
}
