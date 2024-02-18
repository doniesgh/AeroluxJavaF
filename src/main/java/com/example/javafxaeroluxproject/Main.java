package com.example.javafxaeroluxproject;

import com.example.javafxaeroluxproject.models.Reservation;
import com.example.javafxaeroluxproject.services.ReservationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Date;
import java.sql.SQLException;

import java.util.List;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Reservation reservationToAdd = new Reservation();
        reservationToAdd.setTrip_id(1);
        reservationToAdd.setAgency_name("Example Agency");
        reservationToAdd.setStatus("Confirmed");
        reservationToAdd.setNb_seat(2);
        reservationToAdd.setPrice(100.00f);
        Date reservationDate = new Date(2024 - 1900, 1, 18);
        reservationToAdd.setReservation_date(reservationDate);

        try {
            ReservationService rs = new ReservationService();
            rs.ajouter(reservationToAdd);
            // Retrieve reservations
            List<Reservation> reservations = rs.recuperer();

            // Print retrieved reservations
            System.out.println("Retrieved reservations:");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while adding reservation: " + e.getMessage());
        }
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("reservation.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
