// GestionnaireEmploiDuTemps.java
package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {

    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        notifyObservers("Nouveau cours ajouté → " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        // Ici on suppose que la logique de modification existe déjà ailleurs
        System.out.println("Cours modifié : " + message);
        notifyObservers("Modification de l'emploi du temps → " + message);
    }

    // Méthode léguée, on la garde pour compatibilité mais on la redirige
    public void setChangement(String message) {
        notifyObservers(message);
    }
}