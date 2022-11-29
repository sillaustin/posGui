package application;

public class onSiteTicket extends ticket {
	private String location = "";
	
	public onSiteTicket(String loc) {
		location = loc;
	}
	public String getLocation() {
		return location;
	}
}
