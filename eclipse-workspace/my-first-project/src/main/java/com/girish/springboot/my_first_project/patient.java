package com.girish.springboot.my_first_project;
import java.util.*;
import com.girish.springboot.my_first_project.PatientDetails;
public class patient extends PatientDetails{
	private List<Allergy> allrg;
	private List<medication> medi;
	public patient(String name, String phone, String address,List<Allergy> allrg,List<medication> medi) {
		super(name, phone, address);
		this.allrg=allrg;
		this.medi=medi;
	}
	public void setAller(List<Allergy> allrg)
	{
		this.allrg=allrg;
	}
	public List<Allergy> getAller()
	{
		return allrg;
	}
	public void setMedi(List<medication> medi)
	{
		this.medi=medi;
	}
	public List<medication> getMedi()
	{
		return this.medi;
	}
	@Override
	public String toString()
	{
		return ("Name="+this.getAller()+this.getMedi());
		
	}
}
