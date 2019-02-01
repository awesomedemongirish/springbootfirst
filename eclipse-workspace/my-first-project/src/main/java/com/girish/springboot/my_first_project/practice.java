package com.girish.springboot.my_first_project;

import java.util.ArrayList;
import com.girish.springboot.my_first_project.medication;
import com.girish.springboot.my_first_project.Allergy;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class practice {
	private List<Allergy> al2=new ArrayList<Allergy>();
	private List<String> ml2;
	String res="";
	//private String res="My name";
	@SuppressWarnings("deprecation")
	 public practice() {
		Allergy a=new Allergy("Girish",Severity.Low);
		Allergy b=new Allergy("Girish",Severity.High);
		Allergy c=new Allergy("Girish",Severity.Medium);
		medication m=new medication("BD",10,10,new Date(1992,03,20),new Date(1992,03,22));
		medication m2=new medication("OD",10,10,new Date(1992,20,04),new Date(1992,22,04));
		medication m3=new medication("TD",10,10,new Date(1992,20,04),new Date(1992,22,04));
		List<Allergy> al=new ArrayList<Allergy>();
		al.add(a);
		al.add(b);
		al.add(c);
		List<medication> ml=new ArrayList<medication>();
		ml.add(m);
		ml.add(m2);
		ml.add(m3);
		patient p=new patient("Girish","7904721808","nagavara",al,ml);
		//List<Allergy> al2=new ArrayList();
		al2=p.getAller();
		System.out.println(al2);
		ml2=ml.stream().map(Object::toString).collect(Collectors.toList());
		//res=ml2.get(0);
	}
		public String disp()
		{
			for(int i=0;i<ml2.size();i++)
				res=res+" "+ml2.get(i);
			return res;
		}
	}
