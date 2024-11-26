package src.jdbc.exe1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStatus {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JdbcDataBase";
        String user = "postgres";
        String password = "rihab";

        Scanner scanner = new Scanner(System.in);


        System.out.print("Entrez l'ID de la ligne à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le nouveau statut : ");
        String newStatus = scanner.nextLine();


        String sql = "UPDATE Acces SET statut = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, newStatus);
            statement.setInt(2, id);


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le statut a été mis à jour avec succès !");
            } else {
                System.out.println("Aucune ligne trouvée avec l'ID " + id + ".");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }
}
