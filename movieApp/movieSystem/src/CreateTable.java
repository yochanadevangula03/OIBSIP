import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            String query =
                    "CREATE TABLE IF NOT EXISTS movies ("
                            + "id INT PRIMARY KEY AUTO_INCREMENT,"
                            + "movie_name VARCHAR(100),"
                            + "ticket_price INT,"
                            + "available_seats INT)";

            st.executeUpdate(query);

            System.out.println("Table Created Successfully");

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}