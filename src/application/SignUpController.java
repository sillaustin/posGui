package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.*;

public class SignUpController {
	@FXML
	private Label headerID;
	@FXML
	private TextField numField;
	@FXML
	private TextField ageField;
	@FXML
	private RadioButton milBtn;
	
	private static final String SQL_INSERT = "INSERT INTO memberinfo(phoneNumber, age, military, points) VALUES(?,?,?,?)";
	
	public void signEnter(ActionEvent event) throws Exception {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturant_data", "root", "cs380");
			PreparedStatement preparedstatemnt = connection.prepareStatement(SQL_INSERT);
			try {
			preparedstatemnt.setInt(1, Integer.parseInt(numField.getText()));
			preparedstatemnt.setInt(2, Integer.parseInt(ageField.getText()));
			preparedstatemnt.setBoolean(3, milBtn.isSelected());
			preparedstatemnt.setInt(4, 0);
			int row = preparedstatemnt.executeUpdate();
			
			System.out.println(row);
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/EarnYN.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			}catch (SQLException e) {
				headerID.setText("invalid entry. Try again.");
			} 
						
		} catch (SQLException e) {
			System.out.println("Error while connectiong to database");
		}
		
		
	}
}