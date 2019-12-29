package Entities;

import Entities.Embeddable.KeyMessage;
import Enumeration.TypeMessage;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message implements Serializable {

    /*-----------------
     Declaration
    ---------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;

    @ManyToOne
    @JoinColumn(name="idMedecin")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name="idPatient")
    private Patient patient;


    @Embedded
    private KeyMessage keyMessage;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type_message")
    private TypeMessage typeMessage;

    @NotNull
    private String contenu;


     /*------------
    Getters & Setters
    -------------*/

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
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

    public KeyMessage getKeyMessage() {
        return keyMessage;
    }

    public void setKeyMessage(KeyMessage keyMessage) {
        this.keyMessage = keyMessage;
    }

    public TypeMessage getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(TypeMessage typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

/*------------
    Constructeur
    -------------*/


    public Message(@NotNull Date dateEnvoie,Medecin medecin, Patient patient, @NotNull TypeMessage typeMessage, @NotNull String contenu) {
        this.medecin = medecin;
        this.patient = patient;
        this.keyMessage = new KeyMessage(dateEnvoie);
        this.typeMessage = typeMessage;
        this.contenu = contenu;
    }

    public Message() {
    }



}
