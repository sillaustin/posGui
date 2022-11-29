package application;

import java.util.ArrayList;

public class menu {
	private ArrayList<food> list = new ArrayList<>();
	
	public menu(){
	}
	public food[] getFood() {
		return (food[]) list.toArray();
	}
	public void addToList(food adding) {
		list.add(adding);
	}
	public String foodName(int r) {
		return list.get(r).getID();
	}
	public Boolean foodDF(int r) {
		return list.get(r).getDF();
	}
	public Boolean foodGF(int r) {
		return list.get(r).getGF();
	}
	public double foodCost(int r) {
		return list.get(r).getCost();
	}
	public food getItem(int r) {
		return list.get(r);
	}
	public void removeFromList(food removing) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getID() == removing.getID()) {
				list.remove(i);
			}
		}
	}
	
}
