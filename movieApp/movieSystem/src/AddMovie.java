import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddMovie {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con =
                    DatabaseConnection.getConnection();

            System.out.print("Enter Movie Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Ticket Price : ");
            int price = sc.nextInt();

            System.out.print("Enter Available Seats : ");
            int seats = sc.nextInt();

            String query =
                    "INSERT INTO movies(movie_name,ticket_price,available_seats)"
                            + " VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, seats);

            ps.executeUpdate();

            System.out.println("Movie Added Successfully");

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}