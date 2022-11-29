package application;

public class user {
	private int age = 0;
	private int phoneNumber = 0;
	private boolean military = false;
	private double points = 0;
	
	public user(int ag, int num, boolean mil, double pnts) {
		age = ag;
		phoneNumber = num;
		military = mil;
		points = pnts;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public boolean getMilitary() {
		return military;
	}
	
	public double getPoints() {
		return points;
	}
	
	public void setPoints(int pnts) {
		points=pnts;
	}
}
