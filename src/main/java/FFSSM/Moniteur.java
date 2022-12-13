/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    private int numeroDiplome;

    private ArrayList<Embauche> lesEmbauches;


    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
        lesEmbauches = new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Optional<Club> op;
        if (!lesEmbauches.isEmpty()) {
            op = Optional.empty();
        }
        else {
            op = Optional.ofNullable(lesEmbauches.get(lesEmbauches.size() - 1).getEmployeur());
        }
        return op;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        this.lesEmbauches.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
         return lesEmbauches;
    }

}
