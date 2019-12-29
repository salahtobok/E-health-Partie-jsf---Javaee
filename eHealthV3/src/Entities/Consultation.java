package Entities;

import Entities.Embeddable.KeyConsultation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consultation implements Serializable {

     /*-----------------
      Declaration
     ---------------*/
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idConsultation ;

    @NotNull
    private String type;


    @ManyToOne
    @JoinColumn(name="idService")
    private Service service;

    @ManyToOne
    @JoinColumn(name="idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="idMedecin")
    private Medecin medecin;

    @Embedded
    private KeyConsultation keyConsultation ;




/*------------
    Getters & Setters
    -------------*/

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public KeyConsultation getKeyConsultation() {
        return keyConsultation;
    }

    public void setKeyConsultation(KeyConsultation keyConsultation) {
        this.keyConsultation = keyConsultation;
    }



/*------------
    Constructeur
    -------------*/

    public Consultation() {
    }




    public Consultation(Date date,Service service, Patient patient, Medecin medecin, @NotNull String type) {
        this.service = service;
        this.patient = patient;
        this.medecin = medecin;
        this.keyConsultation = new KeyConsultation(date);
        this.type = type;
    }
}
