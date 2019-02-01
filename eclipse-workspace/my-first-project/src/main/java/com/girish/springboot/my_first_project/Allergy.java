package com.girish.springboot.my_first_project;
import com.girish.springboot.my_first_project.Severity;
public class Allergy {
	private String name;
	private Severity sevr;
	public Allergy(String name, Severity sevr)
	{
		this.name=name;
		this.sevr=sevr;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return this.name;
	}
	public void setseverity(Severity sevr)
	{
		this.sevr=sevr;
	}
	public Severity getseverity()
	{
		return this.sevr;
	}
	@Override
	public String toString()
	{
		return("Name="+this.getname()+"Severity="+this.getseverity());
	}
}