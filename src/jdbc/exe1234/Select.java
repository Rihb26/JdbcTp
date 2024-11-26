package src.jdbc.exe1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JdbcDataBase";
        String user = "postgres";
        String password = "rihab";


        String sql = "SELECT prenom, login, statut, age FROM Acces";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {


            System.out.println("Liste des personnes :");
            while (resultSet.next()) {
                String prenom = resultSet.getString("prenom");
                String login = resultSet.getString("login");
                String statut = resultSet.getString("statut");
                int age = resultSet.getInt("age");

                System.out.println("Prénom: " + prenom +
                        ", Login: " + login +
                        ", Statut: " + statut +
                        ", Âge: " + age);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la lecture des données : " + e.getMessage());
        }
    }
}
