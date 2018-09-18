package com.stewartNinjaGold;

import java.util.Date;

public class Activity {
	private String location;
	private int goldGain;
	private String color;
	private String text;
	private Date date;
	
	public Activity() {	}
	
	public Activity(String location) {
		this.location = location;
		this.date = new Date();
	}
	
	public void calculate() {
		if(location.equals("farm")) {
//			System.out.println(location);
			randomize(10, 20);
//			System.out.println(getGoldGain());
		} else if(location.equals("cave")) {
//			System.out.println(location);
			randomize(5, 10);
//			System.out.println(getGoldGain());
		} else if(location.equals("house")) {
//			System.out.println(location);
			randomize(2, 5);
//			System.out.println(getGoldGain());
		} else if(location.equals("casino")) {
//			System.out.println(location);
			randomize(-50, 50);
//			System.out.println(getDate());
//			System.out.println(getGoldGain());
		}
		
		generate();
	}
	
	public void generate() {
		this.text = "You went to the ";
		
		if(getGoldGain() == 0) {
			this.text += location + " and broke even (" + date + ")";
			this.color = "black";
		} else if(getGoldGain() > 0) {
			this.text += location + " and gained " + goldGain + " gold (" + date + ")";
			this.color = "green";
		} else if(getGoldGain() < 0) {
			this.text += location + " and lost " + goldGain + " gold (" + date + ")";
			this.color = "red";
		}
	}
	
	public void randomize(int min, int max) {
		setGoldGain((int) Math.floor((Math.random() * (max - min) + 1) + min));
	}
	
	public String getLocation() { return this.location;	}
	public int getGoldGain() { return this.goldGain; }
	public String getColor() { return this.color; }
	public String getText() { return this.text; }
	public Date getDate() { return this.date; }
	
	public void setLocation(String location) { this.location = location; }
	public void setGoldGain(int goldGain) { this.goldGain = goldGain; }
	public void setColor(String color) { this.color = color; }
	public void setText(String text) { this.text = text; }
	public void setDate(Date date) { this.date = date; }
}
