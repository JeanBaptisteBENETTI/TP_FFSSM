package FFSSM;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.time.LocalDate;

public class TestFFSSM {

    Personne bastide;

    Club Bayonne;

    Licence licence;

    @BeforeEach
    public void setUp() {
        bastide = new Personne("1 05 36 47", "Bastide", "Rémis", "568 Rue des Voilliers", null, null);
        Bayonne = new Club(null, "Bayonne", null, null);
        licence = new Licence(bastide, "10", LocalDate.of(2022, 5, 10), Bayonne);
    }

    @Test
    public void testLicenceValide() {
        LocalDate date = LocalDate.of(2022, 12, 13);
        assertTrue(licence.estValide(date));
    }

    //@Test
    //public void test


}
