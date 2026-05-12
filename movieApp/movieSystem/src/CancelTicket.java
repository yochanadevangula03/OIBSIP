import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CancelTicket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            System.out.print("Enter Movie ID : ");
            int id = sc.nextInt();

            System.out.print("Enter Number Of Tickets To Cancel : ");
            int cancelTickets = sc.nextInt();

            String query =
                    "SELECT available_seats "
                            + "FROM movies WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int seats =
                        rs.getInt("available_seats");

                int updatedSeats =
                        seats + cancelTickets;

                String updateQuery =
                        "UPDATE movies "
                                + "SET available_seats=? "
                                + "WHERE id=?";

                PreparedStatement updatePs =
                        con.prepareStatement(updateQuery);

                updatePs.setInt(1, updatedSeats);
                updatePs.setInt(2, id);

                updatePs.executeUpdate();

                System.out.println(
                        "Ticket Cancelled Successfully");

                System.out.println(
                        "Updated Seats : " + updatedSeats);

            } else {

                System.out.println("Movie Not Found");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}