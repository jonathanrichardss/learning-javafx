package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.entities.Seller;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerListController implements Initializable {
	
	
	private SellerService sellerService; 
	
	@FXML
	private TableView<Seller> tbSeller;
	
	@FXML
	private TableColumn<Seller, Integer> tbColumnId;
	
	@FXML
	private TableColumn<Seller, String> tbColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Seller> obsList;
	
	@FXML
	private void onBtNewAction() {
		System.out.println("Clicou no new!");
	}
	
	public SellerListController() {
		
	}
	
	private void initializeNodes() {
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tbSeller.prefHeightProperty().bind(stage.heightProperty());
		
		tbColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
	}
	
	public void updateTableView() {
		if (sellerService == null) {
			throw new IllegalStateException("Service was null!");
		}
		
		List<Seller> list = sellerService.findAll();
		obsList = FXCollections.observableArrayList(list);
		tbSeller.setItems(obsList);
	}
	

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

}
