package Entities;

import Enumeration.EtatDossierMedical;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DossierMedical implements Serializable {

     /*-----------------
     Declaration
    ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDossierMedical ;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "date_enregistrement")
    private Date dateEnregistrement ;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EtatDossierMedical etatDossierMedical;

    @OneToOne
    @JoinColumn(name = "idPatient")
    private Patient patient ;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dossierMedical" , cascade = CascadeType.ALL)
    private Set<FicheMedical> lesFichesMedicals = new HashSet<>();


     /*------------
    Getters & Setters
    -------------*/

    public int getIdDossierMedical() {
        return idDossierMedical;
    }

    public void setIdDossierMedical(int idDossierMedical) {
        this.idDossierMedical = idDossierMedical;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public EtatDossierMedical getEtatDossierMedical() {
        return etatDossierMedical;
    }

    public void setEtatDossierMedical(EtatDossierMedical etatDossierMedical) {
        this.etatDossierMedical = etatDossierMedical;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<FicheMedical> getLesFichesMedicals() {
        return lesFichesMedicals;
    }

    public void setLesFichesMedicals(Set<FicheMedical> lesFichesMedicals) {
        this.lesFichesMedicals = lesFichesMedicals;
    }


       /*------------
    Constructeur
    -------------*/

    public DossierMedical(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
        this.etatDossierMedical = EtatDossierMedical.ENCOURS;

    }

    public DossierMedical() {
    }
}
