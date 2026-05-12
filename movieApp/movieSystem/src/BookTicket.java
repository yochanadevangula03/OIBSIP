import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookTicket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            System.out.print("Enter Movie ID : ");
            int id = sc.nextInt();

            System.out.print("Enter Number Of Tickets : ");
            int tickets = sc.nextInt();

            String checkQuery =
                    "SELECT available_seats,ticket_price "
                            + "FROM movies WHERE id=?";

            PreparedStatement checkPs =
                    con.prepareStatement(checkQuery);

            checkPs.setInt(1, id);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                int seats =
                        rs.getInt("available_seats");

                int price =
                        rs.getInt("ticket_price");

                if (seats >= tickets) {

                    int remaining = seats - tickets;

                    int total = tickets * price;

                    String updateQuery =
                            "UPDATE movies "
                                    + "SET available_seats=? "
                                    + "WHERE id=?";

                    PreparedStatement updatePs =
                            con.prepareStatement(updateQuery);

                    updatePs.setInt(1, remaining);
                    updatePs.setInt(2, id);

                    updatePs.executeUpdate();

                    System.out.println(
                            "Booking Successful");

                    System.out.println(
                            "Total Amount : " + total);

                } else {

                    System.out.println(
                            "Seats Not Available");
                }

            } else {

                System.out.println("Movie Not Found");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}