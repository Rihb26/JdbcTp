package src.Collection.classesConcrete;

import src.Collection.Pret;

public class PretPersonnel extends Pret {
    private String motif;


    public PretPersonnel(String id, double montant, double tauxInteret, String motif) {
        super(id, montant, tauxInteret);
        this.motif = motif;
    }


    @Override
    public double calculerInteret() {
        return montant * tauxInteret * 3;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", motif='" + motif + '\'' +
                ", interet=" + calculerInteret();
    }
}
