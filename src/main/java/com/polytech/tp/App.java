package com.polytech.tp;

public class App {
    public static void main(String[] args) {

        // === Exercice 1 – Builder ===
        ICours coursBase = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("mr mazari ")
                .setSalle("Amphi BP03")
                .setDate("25/11/2025")
                .setHeureDebut("13h00")
                .setNecessiteProjecteur(true)
                .build();

        // === Exercice 3 – Decorator (cumulable) ===
        ICours coursOnlineAnglais = new CoursEnAnglais(new CoursEnLigne(coursBase));
        System.out.println("\nDescription décorée : " + coursOnlineAnglais.getDescription());
        // → sortie attendue : Cours de Génie Logiciel avec Mme Dupont (Amphi B) (En ligne) (En anglais)

        // === Exercice 2 – Observer ===
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        Observer ayoub = new Etudiant("ayoub");
        Observer issam = new Etudiant("issam");
        Observer resp = new Responsable("mr. harbi");

        gestionnaire.attach(ayoub);
        gestionnaire.attach(issam);
        gestionnaire.attach(resp);

        gestionnaire.ajouterCours(coursBase);
        gestionnaire.ajouterCours(coursOnlineAnglais);

        gestionnaire.modifierCours(coursBase, "Changement de salle : S102 pour Génie Logiciel");

        // Résultat affiché dans la console :
        // Notification pour l'étudiant Alice : ...
        // Notification pour l'étudiant Bob : ...
        // Notification pour le responsable Dr. Martin : ...
    }
}