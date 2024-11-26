package src.Collection;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireDePrets<T> {
    private ArrayList<T> prets;


    public GestionnaireDePrets() {
        this.prets = new ArrayList<>();
    }


    public void ajouterPret(T pret) {
        prets.add(pret);
    }


    public T retirerPret() {
        if (!prets.isEmpty()) {
            return prets.remove(0);
        }
        return null;
    }


    public List<T> listerPrets() {
        return new ArrayList<>(prets);
    }


    public int compterPrets() {
        return prets.size();
    }
}
