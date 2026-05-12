import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewMovies {

    public static void main(String[] args) {

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM movies");

            System.out.println(
                    "ID\tNAME\tPRICE\tSEATS");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t"
                                + rs.getString("movie_name") + "\t"
                                + rs.getInt("ticket_price") + "\t"
                                + rs.getInt("available_seats"));
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}