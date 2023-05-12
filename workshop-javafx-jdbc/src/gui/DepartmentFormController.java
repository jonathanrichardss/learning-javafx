package gui;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.SpringLayout.Constraints;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {
	
	
	private Department entity;
	
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
	
	
	public void setDepartmentEntity(Department entity) {
		this.entity = entity;
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		gui.util.Constraints.setTextFieldInteger(txId);
		gui.util.Constraints.setTextFieldMaxLength(txName, 30);
	}
	
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		txId.setText(String.valueOf(entity.getId()));
		txName.setText(entity.getName());
		
	}

}
