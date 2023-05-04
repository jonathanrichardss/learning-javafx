package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmenListController implements Initializable {
	
	
	@FXML
	private TableView<Department> tbDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tbColumnId;
	
	@FXML
	private TableColumn<Department, String> tbColumnName;
	
	@FXML
	private Button btNew;
	
	@FXML
	private void onBtNewAction() {
		System.out.println("Clicou no new!");
	}
	
	private void initializeNodes() {
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tbDepartment.prefHeightProperty().bind(stage.heightProperty());
		
		tbColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

}
