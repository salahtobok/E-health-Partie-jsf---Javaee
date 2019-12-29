package Entities;

import Entities.Embeddable.KeyRendezVous;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RendezVous implements Serializable {

    /*-----------------
     Declaration
    ---------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRendezVous;


    @ManyToOne
    @JoinColumn(name="idMedecin")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name="idPatient")
    private Patient patient;



   @Embedded
    private KeyRendezVous keyRendezVous;


     /*------------
    Getters & Setters
    -------------*/

    public int getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(int idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public KeyRendezVous getKeyRendezVous() {
        return keyRendezVous;
    }

    public void setKeyRendezVous(KeyRendezVous keyRendezVous) {
        this.keyRendezVous = keyRendezVous;
    }


     /*------------
    Constructeur
    -------------*/

    public RendezVous() {
    }


    public RendezVous(Medecin medecin, Patient patient, Date dateRendezVous) {
        this.medecin = medecin;
        this.patient = patient;
        this.keyRendezVous = new KeyRendezVous(dateRendezVous);
    }
}
