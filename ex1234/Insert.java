package ex1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JdbcDataBase";
        String user = "postgres";
        String password = "rihab";

        String sql = "INSERT INTO Acces (prenom, login, password, statut, age) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, "rihab");
            statement.setString(2, "rihab123");
            statement.setString(3, "rihab");
            statement.setString(4, "Etudiant");
            statement.setInt(5, 20);


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Le tuple a été inséré avec succès !");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }
}
