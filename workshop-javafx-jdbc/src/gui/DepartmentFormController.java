package gui;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.SpringLayout.Constraints;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {
	
	
	@FXML
	private TextField txId;
	
	@FXML
	private TextField txName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Label lblError;
	
	@FXML
	private void onBtnSaveAction() {
		
	}
	
	@FXML
	private void onBtnCancelAction() {
		
	}
	
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		gui.util.Constraints.setTextFieldInteger(txId);
		gui.util.Constraints.setTextFieldMaxLength(txName, 30);
	}

}
