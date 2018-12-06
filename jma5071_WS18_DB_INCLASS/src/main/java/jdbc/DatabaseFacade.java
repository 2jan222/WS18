package jdbc;

import jdbc.ReservationBroker;
import model.Reservierung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Janik Mayr on 06.12.2018
 */
public class DatabaseFacade {
    ReservationBroker resavationBroker = null;
    public Connection getConnection(String url, String user, String password ) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Reservierung> getAllReservations() {
        if (resavationBroker == null) resavationBroker = new ReservationBroker();
        return resavationBroker.getAllReservations();
    }
}
