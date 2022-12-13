package FFSSM;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.time.LocalDate;

public class TestFFSSM {

    Personne bastide;

    Club Bayonne;

    Club Biarritz;

    Licence licence;

    Embauche embauche;

    Moniteur moniteur;

    Moniteur moniteur2;

    @BeforeEach
    public void setUp() {
        bastide = new Personne("1 05 36 47", "Bastide", "Rémis", "568 Rue des Voilliers", null, null);
        Bayonne = new Club(null, "Bayonne", null, null);
        Biarritz = new Club(null, "Biarritz", null, null);
        licence = new Licence(bastide, "10", LocalDate.of(2022, 5, 10), Bayonne);
        embauche = new Embauche(LocalDate.of(2022, 10, 14), moniteur, Bayonne);
        moniteur = new Moniteur("1 88 66 51", "Martin", "Jérôme", null, null, null, 5, 26024);
        moniteur2 = new Moniteur("1 86 67 55", "Leroy", "Guillaume", null, null, null, 3, 10256);
    }

    @Test
    public void testLicenceValide() {
        LocalDate date = LocalDate.of(2022, 12, 13);
        assertTrue(licence.estValide(date));
    }

    @Test
    public void testEmployeurActuel() {
        LocalDate date = LocalDate.of(2022, 12, 13);
        assertFalse(moniteur.employeurActuel().isPresent());
        moniteur.nouvelleEmbauche(Biarritz, date);
        moniteur.nouvelleEmbauche(Bayonne, date);
        assertSame(Bayonne, moniteur.employeurActuel().get());
    }




}
