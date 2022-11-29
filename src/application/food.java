package application;

public class food {
	private boolean dairyFree = false;
	private boolean glutenFree = false;
	private double cost = 0;
	private String id = "";
	
	public food(boolean df, boolean gf, double cst, String name) {
		dairyFree = df;
		glutenFree = gf;
		cost = cst;
		id = name;
	}
	
	public boolean getDF() {
		return dairyFree;
	}
	
	public boolean getGF() {
		return glutenFree;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getID() {
		return id;
	}
}
