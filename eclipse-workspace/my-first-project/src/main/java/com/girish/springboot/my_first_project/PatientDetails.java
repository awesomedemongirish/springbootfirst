package com.girish.springboot.my_first_project;

public class PatientDetails {
	private String name;
	private String phone;
	private String address;
	public PatientDetails(String name,String phone,String address)
	{
		this.name=name;
		this.phone=phone;
		this.address=address;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return this.name;
	}
	public void setphone(String phone)
	{
		this.phone=phone;
	}
	public String getphone()
	{
		return this.phone;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return this.address;
	}
}
