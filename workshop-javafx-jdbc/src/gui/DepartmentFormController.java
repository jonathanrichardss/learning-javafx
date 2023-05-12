package gui;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.SpringLayout.Constraints;

import db.DbException;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	
	
	private Department entity;
	
	private DepartmentService service;
	
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
	private void onBtnSaveAction(ActionEvent event) {
		
		try {
			
			if (entity == null) {
				throw new IllegalStateException("Entity was null!");
			}
			
			if (service == null) {
				throw new IllegalStateException("Service was null!");
			}
			
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.currentStage(event).close();
			
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txId.getText()));
		obj.setName(txName.getText());
		
		return obj;
	}
	
	@FXML
	private void onBtnCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	
	public void setDepartmentEntity(Department entity) {
		this.entity = entity;
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
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
