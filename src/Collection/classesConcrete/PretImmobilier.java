package src.Collection.classesConcrete;

import src.Collection.Pret;

public class PretImmobilier extends Pret {
    private int duree;


    public PretImmobilier(String id, double montant, double tauxInteret, int duree) {
        super(id, montant, tauxInteret);
        this.duree = duree;
    }


    @Override
    public double calculerInteret() {
        return montant * tauxInteret * duree;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", duree=" + duree +
                ", interet=" + calculerInteret();
    }
}

