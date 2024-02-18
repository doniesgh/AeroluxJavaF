package com.example.javafxaeroluxproject.controllers;
import com.example.javafxaeroluxproject.models.Reservation;
import com.example.javafxaeroluxproject.services.ReservationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ReservationController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
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

    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToReservation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("landing.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
