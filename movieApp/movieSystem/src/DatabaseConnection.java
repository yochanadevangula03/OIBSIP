import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static final String URL =
            "jdbc:mysql://localhost:3306/movieticketbookingsystem";

    static final String USER = "root";

    static final String PASSWORD = "pass123";

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            System.out.println(e);
        }

        return con;
    }
}