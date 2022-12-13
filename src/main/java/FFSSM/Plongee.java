/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Plongee {

	private Site lieu;

	private Moniteur chefDePalanquee;

	private LocalDate date;

	private int profondeur;

	private int duree;

	private ArrayList<Licence> lesLicences;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
		this.lesLicences = new ArrayList<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Plongee plongee = (Plongee) o;
		return profondeur == plongee.profondeur && duree == plongee.duree && Objects.equals(lieu, plongee.lieu) && Objects.equals(chefDePalanquee, plongee.chefDePalanquee) && Objects.equals(date, plongee.date) && Objects.equals(lesLicences, plongee.lesLicences);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lieu, chefDePalanquee, date, profondeur, duree, lesLicences);
	}

	public void ajouteParticipant(Plongeur participant) {
		lesLicences.add(participant.derniereLicence());
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		boolean licenceEstValide = true;
		for (Licence lic : lesLicences) {
			if (!lic.estValide(LocalDate.now())) {
				licenceEstValide = false;
			}
		}
		return licenceEstValide;
	}
}
