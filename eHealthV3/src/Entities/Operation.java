package Entities;

import Entities.Embeddable.KeyOperation;
import Enumeration.Periode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operation implements Serializable {

     /*-----------------
      Declaration
     ---------------*/



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOperation ;


    @Embedded
    private KeyOperation keyOperation ;


    @NotNull
    private String type;

    @NotNull
    @Enumerated
    private Periode periode ;




    @ManyToOne
    @JoinColumn(name="idService")
    private Service service;

    @ManyToOne
    @JoinColumn(name="idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="idMedecin")
    private Medecin medecin;



    @OneToMany(fetch = FetchType.EAGER,mappedBy = "operation" ,  orphanRemoval = true)
    private Set<Consigne> lesConsignes =new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "operation" ,  orphanRemoval = true)
    private Set<Questionnaire> lesQuestionnaire =new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "operation" ,  orphanRemoval = true)
    private Set<Rapport> lesRapports =new HashSet<>();




     /*------------
    Getters & Setters
    -------------*/


    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public KeyOperation getKeyOperation() {
        return keyOperation;
    }

    public void setKeyOperation(KeyOperation keyOperation) {
        this.keyOperation = keyOperation;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Consigne> getLesConsignes() {
        return lesConsignes;
    }

    public void setLesConsignes(Set<Consigne> lesConsignes) {
        this.lesConsignes = lesConsignes;
    }

    public Set<Questionnaire> getLesQuestionnaire() {
        return lesQuestionnaire;
    }

    public void setLesQuestionnaire(Set<Questionnaire> lesQuestionnaire) {
        this.lesQuestionnaire = lesQuestionnaire;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Set<Rapport> getLesRapports() {
        return lesRapports;
    }

    public void setLesRapports(Set<Rapport> lesRapports) {
        this.lesRapports = lesRapports;
    }

    /*------------
    Constructeur
    -------------*/

    public Operation() {
    }
//
//    public Operation(Date date, @NotNull String type,Service service, Patient patient, Medecin medecin) {
//        this.idOperation= new KeyOperation( service, patient, medecin, date);
//        this.type = type;
//        this.periode= Periode.PRES;
//    }

    public Operation(Date date, @NotNull String type, @NotNull Periode periode, Service service, Patient patient, Medecin medecin) {
        this.keyOperation = new KeyOperation(date);
        this.type = type;
        this.periode = periode;
        this.service = service;
        this.patient = patient;

        this.medecin = medecin;
    }
}
