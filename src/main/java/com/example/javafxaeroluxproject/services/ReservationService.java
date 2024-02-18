package com.example.javafxaeroluxproject.services;
import com.example.javafxaeroluxproject.models.Reservation;
import com.example.javafxaeroluxproject.utils.MyDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IService<Reservation> {
    private Connection connection;

    public ReservationService() {
        connection = MyDatabase.getInstance().getConnection();

    }

    public void ajouter(Reservation reservation) throws SQLException {
        String req = "INSERT INTO reservation (agency_name, trip_id, status, nb_seat, price) VALUES " +
                "('"
                + reservation.getAgency_name() + "','"
                + reservation.getTrip_id() + "','"
                + reservation.getStatus() + "',"
                + reservation.getNb_seat() + ",'"
                + reservation.getPrice() + "')";
        Statement st = connection.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Reservation reservation) {
    }

    @Override
    public void supprimer(int id) {

    }

    @Override
    public List<Reservation> recuperer() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String req = "SELECT * FROM reservation";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            Reservation reservation = new Reservation();
            reservation.setId(rs.getInt("id"));
            reservation.setReservation_date(rs.getDate("reservation_date"));
        }

return  reservations;
    }
}
