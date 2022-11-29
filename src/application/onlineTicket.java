package application;

public class onlineTicket extends ticket {
	private double eTA = 0;
	
	public onlineTicket(double time) {
		eTA = time;
	}
	
	public double getETA() {
		return eTA;
	}
}
