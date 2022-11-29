package application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.*;

public class ReEnterNumController {
	@FXML
	private TextField numID;
	private boolean member = false;
	public void numEnter(ActionEvent event) throws Exception {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resturant_data", "root", "cs380");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBERINFO");
			
			while(rs.next()) {
				if (numID.getText().equals( Integer.toString( rs.getInt(1) ))) {
					member = true;
				}
			}
						
		} catch (SQLException e) {
			System.out.println("Error while connectiong to database");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if (member == true) {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}else {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/NewMemberYN.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		
	}
}