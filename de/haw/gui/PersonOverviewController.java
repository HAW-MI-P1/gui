package de.haw.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import de.haw.gui.model.Person;

public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;
	
	@FXML
	private TextField filterTextField;
	@FXML
	private Button addFilterButton;

	// Reference to the main application
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PersonOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table
		firstNameColumn.setCellValueFactory(
				new PropertyValueFactory<Person, String>("firstName"));
		lastNameColumn.setCellValueFactory(
				new PropertyValueFactory<Person, String>("lastName"));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}

	public void handleFilter() {
		String filterString = filterTextField.getText();
		 ObservableList<Person> personData = FXCollections.observableArrayList();

        personData = showMockUpData(filterString);
        //personData = Controller.getDataByFilter(filterString);
        mainApp.setPersonData(personData);
        mainApp.showPersonOverview();
	}
	
	 private ObservableList<Person> showMockUpData(String searchString) {
	        ObservableList<Person> personData = FXCollections.observableArrayList();
	        personData.add(new Person("Ruth", "Mueller"));
	        personData.add(new Person("Cornelia", "Meier"));
	        personData.add(new Person("Lydia", "Kunz"));
	        personData.add(new Person("Anna", "Best"));
	        return personData;
	    }


}