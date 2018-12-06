import jdbc.DatabaseFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Janik Mayr on 06.12.2018
 */
public class DbTester {
    @Test
    @DisplayName("Main Entry Point")
    void main() {
        //"jdbc:postgresql://localhost:65432/carrental", "carrentaladmin", "carrentaladmin"
        try {
            Connection connection = new DatabaseFacade().getConnection("jdbc:postgresql://localhost/carrental", "postgre", "postgre");
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM Auto;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
