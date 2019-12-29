package Entities;

import Entities.Embeddable.KeyAlerte;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Alerte implements Serializable {


    /*-----------------
    Declaration
   ---------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlerte;


    @ManyToOne
    @JoinColumn(name="idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="idServiceUrgence")
    private ServiceUrgence serviceUrgence;



    @Embedded
    private KeyAlerte keyAlerte;


    @Column(nullable = false,length = 25)
    private String lieu;



    /*------------
    Getters & Setters
    -------------*/

    public int getIdAlerte() {
        return idAlerte;
    }

    public void setIdAlerte(int idAlerte) {
        this.idAlerte = idAlerte;
    }

    public KeyAlerte getKeyAlerte() {
        return keyAlerte;
    }

    public void setKeyAlerte(KeyAlerte keyAlerte) {
        this.keyAlerte = keyAlerte;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }



/*------------
    Constructeur
    -------------*/

    public Alerte() {
    }



    public Alerte(Patient patient, ServiceUrgence serviceUrgence,  String lieu,Date dateAlerte) {
        this.patient = patient;
        this.serviceUrgence = serviceUrgence;
        this.keyAlerte = new KeyAlerte(dateAlerte);
        this.lieu = lieu;
    }
}
