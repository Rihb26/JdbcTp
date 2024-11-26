package src.jdbc.exe1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JdbcDataBase";
        String user = "postgres";
        String password = "rihab";


        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de la ligne à supprimer : ");
        int id = scanner.nextInt();


        String sql = "DELETE FROM Acces WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setInt(1, id);


            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("La ligne avec l'ID " + id + " a été supprimée avec succès !");
            } else {
                System.out.println("Aucune ligne trouvée avec l'ID " + id + ".");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
