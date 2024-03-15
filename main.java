package YT;

import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) {
        // Création de quelques objets stagiaire
        stagiaire stagiaire1 = null;
        stagiaire stagiaire2 = null;
        try {
            stagiaire1 = new stagiaire("123456789012", "John Doe");
            stagiaire2 = new stagiaire("987654321098", "Jane Smith");
        } catch (Exception e) {
            System.out.println("Erreur lors de la création d'un stagiaire : " + e.getMessage());
        }

        // Création d'un club
        club clubDeLecture = new club();

        // Ajout des stagiaires au club
        clubDeLecture.ajouter(stagiaire1);
        clubDeLecture.ajouter(stagiaire2);

        // Affichage du club
        System.out.println("Club de lecture avant enregistrement :");
        System.out.println(clubDeLecture);

        // Enregistrement du club
        clubDeLecture.enregistrer();

        // Création d'un nouveau club
        club nouveauClub = new club();

        // Chargement du club depuis le fichier
        try {
            nouveauClub.charger();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du club : " + e.getMessage());
        }

        // Affichage du nouveau club après chargement
        System.out.println("Nouveau club de lecture après chargement :");
        System.out.println(nouveauClub);

        // Suppression d'un stagiaire du nouveau club
        try {
            nouveauClub.supprimer(stagiaire1);
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression d'un stagiaire : " + e.getMessage());
        }

        // Affichage du nouveau club après suppression
        System.out.println("Nouveau club de lecture après suppression :");
        System.out.println(nouveauClub);
    }
}
