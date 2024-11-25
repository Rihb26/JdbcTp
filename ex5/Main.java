package ex5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/JdbcDataBase";
        String user = "postgres";
        String password = "rihab";

        /* EX5try {

            DAOAcces dao = new DAOAcces(url, user, password);


            dao.ajouter(6, "Alice", "alice123", "securepass", "Etudiant", 22);


            dao.lister();


            dao.supprimer(6);


            dao.lister();


            dao.fermerConnexion();

        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());

        }*/

        try {
            DAOAcces dao = new DAOAcces(url, user, password);

            Acces nouvelAcces = new Acces(8, "Rabeb", "Rabeb2024", "pass123", "Etudiant", 25);
            dao.ajouterDAO(nouvelAcces);


            ArrayList<Acces> accesList = dao.listerDAO();
            System.out.println("Liste des accès :");
            for (Acces acces : accesList) {
                System.out.println(acces);
            }


            dao.supprimerDAO(nouvelAcces);


            dao.fermerConnexion();

        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
    }

