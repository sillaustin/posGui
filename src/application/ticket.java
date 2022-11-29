package application;

import java.util.ArrayList;

public class ticket {
	private double subtotal = 0;
	private double tax = 0;
	private double pointsEarned = 0;
	private double discount = 0;
	private double total = 0;
	private ArrayList<food> order = new ArrayList<>();
	
	public double getSubTotal() {
		subtotal = 0;
		for(int i=0; i<order.size(); i++) {
			subtotal += order.get(i).getCost();
		}
		return subtotal;
	}
	
	public double getTax() {
		tax = 0;
		subtotal = 0;
		for(int i=0; i<order.size(); i++) {
			subtotal += order.get(i).getCost();
		}
		tax = subtotal * .08;
		return tax;
	}
	
	public void setDiscount(double points) {
		discount = points;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public double getPointsEarned() {
		return pointsEarned;
	}
	
	public double getTotal() {
		tax = 0;
		subtotal = 0;
		total = 0;
		for(int i=0; i<order.size(); i++) {
			subtotal += order.get(i).getCost();
		}
		tax = subtotal * .08;
		total = (tax + subtotal)-discount;
		pointsEarned = total * 0.05;
		return total;
	}
	
	public void addToOrder(food adding) {
		order.add(adding);
	}
	
	public void addToOrder(food adding, int quant) {
		for (int i=1; i<= quant; i++) {
			order.add(adding);
		}
	}
	
	public void removeFromOrder(food removing) {
		for (int i=0; i<order.size(); i++) {
			if (order.get(i).getID() == removing.getID()) {
				order.remove(i);
			}
		}
	}
	public void removeFromOrder(food removing, int quant) {
		int j=0;
		for (int i=0; i<order.size(); i++) {
			if (j == quant) {
				break;
			}else if (order.get(i).getID() == removing.getID()) {
				order.remove(i);
				j++;
			}
		}
	}
		

}
