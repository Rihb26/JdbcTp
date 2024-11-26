package src.Collection.classesConcrete;

import src.Collection.Pret;

public class PretEtudiant extends Pret {
    private boolean differe;
    public PretEtudiant(String id, double montant, double tauxInteret, boolean differe) {
        super(id, montant, tauxInteret);
        this.differe = differe;
    }


    @Override
    public double calculerInteret() {
        if (differe) {
            return montant * tauxInteret;
        } else {
            return montant * tauxInteret * 5;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", differe=" + differe +
                ", interet=" + calculerInteret();
    }
}
