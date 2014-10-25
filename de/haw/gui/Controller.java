package de.haw.gui;

import de.haw.gui.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Fenja on 25.10.2014.
 */
public class Controller {

    public ObservableList<Person> getDataBySearchString (String searchString){
        return FXCollections.observableArrayList();
    }

    public ObservableList<Person> getDataByFilter (List<String> filterStrings){
        return FXCollections.observableArrayList();
    }
}
