package com.example.javafxaeroluxproject.controllers;

import com.example.javafxaeroluxproject.models.Vol;
import com.example.javafxaeroluxproject.services.VolService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DashboardController {
    //@FXML
    //private GridPane grid; // Inject the GridPane from FXML
    private VolService volService = new VolService();

    @FXML
    void initialize() {
        try {
            List<Vol> vols = volService.recuperer();
            int row = 0;
            for (Vol vol : vols) {
                // Create labels for each field and add them to the grid
                Label idLabel = new Label("ID: " + vol.getId());
                Label descriptionLabel = new Label("Description: " + vol.getDescription());
                Label lieuDepartLabel = new Label("Departure Location: " + vol.getLieuDepart());
                Label lieuArriveeLabel = new Label("Arrival Location: " + vol.getLieuArrivee());
                Label placeDispoLabel = new Label("Available Seats: " + vol.getPlaceDispo());
                Label dateDepartLabel = new Label("Departure Date: " + vol.getDateDepart().toString());
                Label piloteIdLabel = new Label("Pilot ID: " + vol.getPiloteId());

                grid.addRow(row++, idLabel, descriptionLabel, lieuDepartLabel, lieuArriveeLabel, placeDispoLabel, dateDepartLabel, piloteIdLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private GridPane grid;

    private List<Vol> volList; // Assuming you have a list of Vol objects

    // Load and display Vol items in the grid
    public void displayVolItems() {
        try {
            // Clear existing children from the grid
            grid.getChildren().clear();

            // Load the FXML file for the Vol item
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vol.fxml"));
            AnchorPane volItem = loader.load();

            // Iterate over the list of Vols and add each item to the grid
            for (int i = 0; i < volList.size(); i++) {
                // Set data for the Vol item
                VolItemController controller = loader.getController();
                controller.setData(volList.get(i));

                // Add the Vol item to the grid
                grid.add(volItem, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

