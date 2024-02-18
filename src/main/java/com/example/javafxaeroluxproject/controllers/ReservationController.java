package com.example.javafxaeroluxproject.controllers;
import com.example.javafxaeroluxproject.models.Reservation;
import com.example.javafxaeroluxproject.services.ReservationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.O;

public class ReservationController {


    @FXML
    private TableView<Reservation> reservation_table;

    @FXML
    private TableColumn<Reservation, String> action;

    @FXML
    private TableColumn<Reservation, String> agency_name;

    @FXML
    private TableColumn<Reservation, Integer> id_reservation;

    @FXML
    private TableColumn<Reservation, Integer> id_trip;

    @FXML
    private TableColumn<Reservation, Integer> nb_seat;

    @FXML
    private TableColumn<Reservation, Float> price;

    @FXML
    private TableColumn<Reservation, Date> reservation_date;

    @FXML
    private TableColumn<Reservation, String> status;
    private ReservationService reservationService = new ReservationService();

    @FXML
    void initialize() {
        ReservationService reservationService1 = new ReservationService();
        try {
            List<Reservation> reservations = reservationService1.recuperer();
            ObservableList<Reservation> observableList = FXCollections.observableList(reservations);
            reservation_table.setItems(observableList);

            // Set cell value factories for each column
            id_reservation.setCellValueFactory(new PropertyValueFactory<>("id"));
            agency_name.setCellValueFactory(new PropertyValueFactory<>("agency_name"));
            id_trip.setCellValueFactory(new PropertyValueFactory<>("trip_id"));
            nb_seat.setCellValueFactory(new PropertyValueFactory<>("nb_seat"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));
            reservation_date.setCellValueFactory(new PropertyValueFactory<>("reservation_date"));
            status.setCellValueFactory(new PropertyValueFactory<>("status"));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


}
