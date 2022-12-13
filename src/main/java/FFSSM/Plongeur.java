package FFSSM;

import java.time.LocalDate;
import java.util.TreeSet;

public class Plongeur extends Personne {

    private int niveau;

    private TreeSet<Licence> lesLicences;
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.lesLicences = new TreeSet<Licence>();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", niveau = " + niveau +
                '}';
    }

    public void ajouterLicence(Licence l) {
        lesLicences.add(l);
    }

    public Licence derniereLicence() {
        Licence derniereLicence = lesLicences.last();
        return derniereLicence;
    }


}
