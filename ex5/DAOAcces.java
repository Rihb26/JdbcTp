package ex5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOAcces {
    private Connection connection;


    public DAOAcces(String url, String user, String password) throws SQLException {
        try {

            Class.forName("org.postgresql.Driver");

            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie avec succès !");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Le driver PostgreSQL est introuvable.", e);
        }
    }


    public void fermerConnexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connexion fermée.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }
    }

    // ex5

   /* public void lister() {
        String sql = "SELECT id, prenom, login, statut, age FROM Acces";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Liste des accès :");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Prénom: " + resultSet.getString("prenom") +
                        ", Login: " + resultSet.getString("login") +
                        ", Statut: " + resultSet.getString("statut") +
                        ", Âge: " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des données : " + e.getMessage());
        }
    }


    public void ajouter(int id, String prenom, String login, String password, String statut, int age) {
        String sql = "INSERT INTO Acces (id, prenom, login, password, statut, age) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, prenom);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.setString(5, statut);
            statement.setInt(6, age);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Enregistrement ajouté avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'enregistrement : " + e.getMessage());
        }
    }


    public void supprimer(int id) {
        String sql = "DELETE FROM Acces WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Enregistrement supprimé avec succès !");
            } else {
                System.out.println("Aucun enregistrement trouvé avec l'ID " + id + ".");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }*/

    //EXE6


    public ArrayList<Acces> listerDAO() {
        ArrayList<Acces> accesList = new ArrayList<>();
        String sql = "SELECT id, prenom, login, password, statut, age FROM Acces";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                Acces acces = new Acces(
                        resultSet.getInt("id"),
                        resultSet.getString("prenom"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("statut"),
                        resultSet.getInt("age")
                );
                accesList.add(acces);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des données : " + e.getMessage());
        }
        return accesList;
    }


    public void ajouterDAO(Acces acces) {
        String sql = "INSERT INTO Acces (id, prenom, login, password, statut, age) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Associer les données de l'objet Acces aux paramètres
            statement.setInt(1, acces.getId());
            statement.setString(2, acces.getPrenom());
            statement.setString(3, acces.getLogin());
            statement.setString(4, acces.getPassword());
            statement.setString(5, acces.getStatut());
            statement.setInt(6, acces.getAge());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("L'objet Acces a été ajouté avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }


    public void supprimerDAO(Acces acces) {
        String sql = "DELETE FROM Acces WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, acces.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("L'objet Acces avec l'ID " + acces.getId() + " a été supprimé avec succès !");
            } else {
                System.out.println("Aucun objet trouvé avec l'ID " + acces.getId());
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
