package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	private void onMenuItemSellerAction() {
		
	}
	
	@FXML
	private void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}
	
	@FXML
	private void onMenuItemAboutAction() {
		loadView("/gui/AboutView.fxml", x -> {});
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	public synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox newVBox = fxmlLoader.load();
			
			Scene ms = Main.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) ms.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVBox.getChildren());
			
			T controller = fxmlLoader.getController();
			initializingAction.accept(controller);
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
}
