package com.example.guiproject;

import com.example.guiproject.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;
    @FXML
    private ListView<Person> listView;
    @FXML
    private Button btnAll;

    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        if (listView.getItems().size() < comboBoxPerson.getItems().size()) {
            listView.getItems().add(person);
        }
        System.out.println(person);
    }

    private void onBtnAllAction() {
        btnAll.setOnAction(actionEvent -> {
            if (listView.getItems().isEmpty()) {
                for (Person person : comboBoxPerson.getItems()) {
                    listView.getItems().add(person);
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        onBtnAllAction();

        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Sherlock", "holmes@mail.com"));
        list.add(new Person(1, "Max", "steel@mail.com"));
        list.add(new Person(1, "Harry", "potter@mail.com"));
        list.add(new Person(1, "Spider", "man@mail.com"));

        obsList = FXCollections.observableList(list);
        comboBoxPerson.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? " " : item.getName());
            }
        };

        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }
}
