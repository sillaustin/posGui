package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.*;

public class OrderController {
	@FXML
	private TextField pntsSpent;
	@FXML
	private TextField minBox;
	@FXML
	private RadioButton olBtn;
	@FXML
	private Label timePromt;
	@FXML
	private Label pntCount;
	@FXML
	private Label peLbl;
	@FXML
	private Label stLbl;
	@FXML
	private Label dcLbl;
	@FXML
	private Label txLbl;
	@FXML
	private Label toLbl;
	@FXML
	private CheckBox cb1;
	@FXML
	private CheckBox cb2;
	@FXML
	private CheckBox cb3;
	@FXML
	private CheckBox cb4;
	@FXML
	private CheckBox cb5;
	@FXML
	private CheckBox cb6;
	
	InfoPasser ip = InfoPasser.getInstance("");
	user current;
	ticket tick;
	menu curMen = new menu();
	food myFood;
	boolean ol = false;
	
	public void strtBtn(ActionEvent event) throws Exception {
		if (olBtn.isSelected() == true) {
			ol = true;
		}			
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturant_data", "root", "cs380");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBERINFO");
			
			while(rs.next()) {
				if (ip.getInfo().equals( Integer.toString( rs.getInt(1) ))) {
					current = new user(rs.getInt(1),rs.getInt(2),rs.getBoolean(4),rs.getDouble(4));
					ip.setInfo("");
				}
			}
						
		} catch (SQLException e) {
			System.out.println("Error while connectiong to database");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturant_data", "root", "cs380");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FOODTABLE");
			
			while(rs.next()) {
				myFood = new food(rs.getBoolean(2),rs.getBoolean(3),rs.getDouble(4),rs.getString(1));
				curMen.addToList(myFood);
			}
						
		} catch (SQLException e) {
			System.out.println("Error while connectiong to database");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if (ol == true) {
			tick = new onlineTicket(Double.parseDouble(minBox.getText()));
		}else {
			tick = new onSiteTicket("kisok");
		}
		pntCount.setText("You have " + Double.toString(current.getPoints()) + " points.");
		cb1.setText(curMen.foodName(0)+"..........."+curMen.foodCost(0));
		cb2.setText(curMen.foodName(1)+"..........."+curMen.foodCost(1));
		cb3.setText(curMen.foodName(2)+"..........."+curMen.foodCost(2));
		cb4.setText(curMen.foodName(3)+"..........."+curMen.foodCost(3));
		cb5.setText(curMen.foodName(4)+"..........."+curMen.foodCost(4));
		cb6.setText(curMen.foodName(5)+"..........."+curMen.foodCost(5));
		
		cb1.setVisible(true);
		cb2.setVisible(true);
		cb3.setVisible(true);
		cb4.setVisible(true);
		cb5.setVisible(true);
		cb6.setVisible(true);
		
	}
	public void olAct(ActionEvent event) throws Exception {
		if (olBtn.isSelected()) {
			timePromt.setVisible(true);
			minBox.setVisible(true);
		}else {
			timePromt.setVisible(false);
			minBox.setVisible(false);
		}
		
	}
	
	public void cb1Act(ActionEvent event) throws Exception {
		if(Double.parseDouble(pntsSpent.getText()) > current.getPoints()){
			pntsSpent.setText("0");
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}else{
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}
		if (cb1.isSelected()) {
			tick.addToOrder(curMen.getItem(0));
		}else {
			tick.removeFromOrder(curMen.getItem(0));
		}
		peLbl.setText("Points Earned:   " + tick.getPointsEarned());
		stLbl.setText("Subtotal:   " + tick.getSubTotal());
		dcLbl.setText("Discount:   " + tick.getDiscount());
		txLbl.setText("Tax:   " + tick.getTax());
		toLbl.setText("Total:   " + tick.getTotal());
	}
	public void cb2Act(ActionEvent event) throws Exception {
		if(Double.parseDouble(pntsSpent.getText()) > current.getPoints()){
			pntsSpent.setText("0");
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}else{
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}
		if (cb2.isSelected()) {
			tick.addToOrder(curMen.getItem(1));
		}else {
			tick.removeFromOrder(curMen.getItem(1));
		}
		peLbl.setText("Points Earned:   " + tick.getPointsEarned());
		stLbl.setText("Subtotal:   " + tick.getSubTotal());
		dcLbl.setText("Discount:   " + tick.getDiscount());
		txLbl.setText("Tax:   " + tick.getTax());
		toLbl.setText("Total:   " + tick.getTotal());
	}
	public void cb3Act(ActionEvent event) throws Exception {
		if(Double.parseDouble(pntsSpent.getText()) > current.getPoints()){
			pntsSpent.setText("0");
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}else{
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}
		if (cb3.isSelected()) {
			tick.addToOrder(curMen.getItem(2));
		}else {
			tick.removeFromOrder(curMen.getItem(2));
		}
		peLbl.setText("Points Earned:   " + tick.getPointsEarned());
		stLbl.setText("Subtotal:   " + tick.getSubTotal());
		dcLbl.setText("Discount:   " + tick.getDiscount());
		txLbl.setText("Tax:   " + tick.getTax());
		toLbl.setText("Total:   " + tick.getTotal());
	}
	public void cb4Act(ActionEvent event) throws Exception {
		if(Double.parseDouble(pntsSpent.getText()) > current.getPoints()){
			pntsSpent.setText("0");
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}else{
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}
		if (cb4.isSelected()) {
			tick.addToOrder(curMen.getItem(3));
		}else {
			tick.removeFromOrder(curMen.getItem(3));
		}
		peLbl.setText("Points Earned:   " + tick.getPointsEarned());
		stLbl.setText("Subtotal:   " + tick.getSubTotal());
		dcLbl.setText("Discount:   " + tick.getDiscount());
		txLbl.setText("Tax:   " + tick.getTax());
		toLbl.setText("Total:   " + tick.getTotal());
	}
	public void cb5Act(ActionEvent event) throws Exception {
		if(Double.parseDouble(pntsSpent.getText()) > current.getPoints()){
			pntsSpent.setText("0");
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}else{
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}
		if (cb5.isSelected()) {
			tick.addToOrder(curMen.getItem(4));
		}else {
			tick.removeFromOrder(curMen.getItem(4));
		}
		peLbl.setText("Points Earned:   " + tick.getPointsEarned());
		stLbl.setText("Subtotal:   " + tick.getSubTotal());
		dcLbl.setText("Discount:   " + tick.getDiscount());
		txLbl.setText("Tax:   " + tick.getTax());
		toLbl.setText("Total:   " + tick.getTotal());
	}
	public void cb6Act(ActionEvent event) throws Exception {
		if(Double.parseDouble(pntsSpent.getText()) > current.getPoints()){
			pntsSpent.setText("0");
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}else{
			tick.setDiscount(Double.parseDouble(pntsSpent.getText()));
		}
		if (cb6.isSelected()) {
			tick.addToOrder(curMen.getItem(5));
		}else {
			tick.removeFromOrder(curMen.getItem(5));
		}
		peLbl.setText("Points Earned:   " + tick.getPointsEarned());
		stLbl.setText("Subtotal:   " + tick.getSubTotal());
		dcLbl.setText("Discount:   " + tick.getDiscount());
		txLbl.setText("Tax:   " + tick.getTax());
		toLbl.setText("Total:   " + tick.getTotal());
	}
	
	
	public void finBtn(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}