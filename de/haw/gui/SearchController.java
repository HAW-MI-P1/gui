package de.haw.gui;

import de.haw.gui.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Fenja on 25.10.2014.
 */
public class SearchController {

    @FXML
    private TextField searchStringField;
    @FXML
    private Button newSearchButton;

    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

        /**
         * Called when the user clicks on the New Search button.
         */
    @FXML
    private void handleNewSearch() {
        String searchString = searchStringField.getText();
        ObservableList<Person> personData = FXCollections.observableArrayList();

        personData = showMockUpData(searchString);
        //personData = Controller.getDataBySearchString(searchString);
        mainApp.setPersonData(personData);
        mainApp.showPersonOverview();
    }

    private ObservableList<Person> showMockUpData(String searchString) {
        ObservableList<Person> personData = FXCollections.observableArrayList();
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
        return personData;
    }
}
