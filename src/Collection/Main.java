package src.Collection;

import src.Collection.classesConcrete.PretEtudiant;
import src.Collection.classesConcrete.PretImmobilier;
import src.Collection.classesConcrete.PretPersonnel;

public class Main {

    public static void main(String[] args) {
        GestionnaireDePrets<Pret> gestionnaire = new GestionnaireDePrets<>();


        gestionnaire.ajouterPret(new PretImmobilier("P1", 60000, 0.03, 20));
        gestionnaire.ajouterPret(new PretEtudiant("P2", 55000, 0.02, true));
        gestionnaire.ajouterPret(new PretPersonnel("P3", 30000, 0.05, "Achter une maison"));


        System.out.println("Liste des prêts :");
        for (Pret pret : gestionnaire.listerPrets()) {
            System.out.println(pret);
        }


        System.out.println("Nombre total de prêts : " + gestionnaire.compterPrets());



        Pret pretRetire = gestionnaire.retirerPret();
        System.out.println("Prêt retiré : " + pretRetire);


        System.out.println("Liste mise à jour :");
        for (Pret pret : gestionnaire.listerPrets()) {
            System.out.println(pret);
        }
    }
}
