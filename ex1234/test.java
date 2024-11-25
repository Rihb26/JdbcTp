package ex1234;

;

public class test {
    public static void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");
            System.out.println("Driver PostgreSQL chargé avec succès !");
        } catch (ClassNotFoundException e) {
            System.err.println("Le driver PostgreSQL n'est pas installé ou mal configuré !");
        }
    }
}
