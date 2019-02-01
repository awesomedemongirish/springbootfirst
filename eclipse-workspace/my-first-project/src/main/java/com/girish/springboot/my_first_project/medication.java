package com.girish.springboot.my_first_project;
import java.util.Date;
public class medication {
	private String dosage;
	private int qty,duration;
	private Date start;
	private Date end;
	public medication(String dosage,int qty,int duration, Date start, Date end)
	{
		this.dosage=dosage;
		this.qty=qty;
		this.duration=duration;
		this.start=start;
		this.end=end;
	}
	public void setdose(String dosage)
	{
		this.dosage=dosage;
	}
	public String getdose()
	{
		return this.dosage;
	}
	public void setqty(int qty)
	{
		this.qty=qty;
	}
	public int getqty()
	{
		return this.qty;
	}
	public void setDuration(int duration)
	{
		this.duration=duration;
	}
	public int getDuration()
	{
		return this.duration;
	}
	public void setstart(Date start)
	{
		this.start=start;
	}
	public Date getStart()
	{
		return this.start;
	}
	public void setend(Date end)
	{
		this.end=end;
	}
	public Date getDate()
	{
		return this.end;
	}
	@Override
	public String toString()
	{
		return ("Dosage="+this.getdose()+" Quantity="+this.getqty()+" Duration="+this.getDuration()+" Start date="+this.getStart()+"End dae="+this.getDate());
	}
}
