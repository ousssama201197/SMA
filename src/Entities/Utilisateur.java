/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author oussama_arch
 */
public class Utilisateur implements Serializable{
    public String Nom;
    public String Prenom;
    public String Motdepasse;
    public String centreInt;

    public Utilisateur(String Nom, String Prenom, String centreInt,String motdepasse) {
        this.Motdepasse=motdepasse;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.centreInt = centreInt;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getCentreInt() {
        return centreInt;
    }

    public void setCentreInt(String centreInt) {
        this.centreInt = centreInt;
    }
    
    
    
    
    
}
