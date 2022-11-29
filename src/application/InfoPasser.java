package application;

public class InfoPasser {
	private static InfoPasser instance;
	private String data;
	
	private InfoPasser(String data) {
		this.data = data;
	}
	
	public static InfoPasser getInstance(String data) {
		if (instance == null) {
			instance = new InfoPasser(data);
		}
		return instance;
	}
	
	public String getInfo() {
		return data;
	}
	public void setInfo(String data) {
		this.data = data;
	}

}
