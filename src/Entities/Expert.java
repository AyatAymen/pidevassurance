/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author may islem
 */
public class Expert {
    private int idExpert;
    private String nomExpert;
    private String prenomExpert;
    private String compteRendu;
    private String localisation;
    private String disponibilité;
   
    public Expert (String nomExpert, String prenomExpert, String compteRendu, String localisation, String disponibilité){
    
    this.nomExpert=nomExpert;
    this.prenomExpert=prenomExpert;
    this.compteRendu=compteRendu;
    this.localisation=localisation;
    this.disponibilité=disponibilité;
    }
    public Expert (){}

    public int getIdExpert() {
        return idExpert;
    }

    public void setIdExpert(int idExpert) {
        this.idExpert = idExpert;
    }

    public String getNomExpert() {
        return nomExpert;
    }

    public void setNomExpert(String nomExpert) {
        this.nomExpert = nomExpert;
    }

    public String getPrenomExpert() {
        return prenomExpert;
    }

    public void setPrenomExpert(String prenomExpert) {
        this.prenomExpert = prenomExpert;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDisponibilité() {
        return disponibilité;
    }

    public void setDisponibilité(String disponibilité) {
        this.disponibilité = disponibilité;
    }
    
}
