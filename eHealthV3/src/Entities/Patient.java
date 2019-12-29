package Entities;

import Entities.Embeddable.Adresse;
import Enumeration.Civility;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient implements Serializable {

    /*-----------------
      Declaration
     ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatient ;

    @NotNull
    @Column(name = "numero_assurance", unique = true, nullable = false)
    private String numeroAssurance ;

    @NotNull
    @Size(min = 3, max = 20)
    private String nom ;

    @NotNull
    @Size(min = 3, max = 50)
    private String prenom ;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "date_naissance")
    private Date dateNaissance ;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "lieu_naissance")
    private String lieuNaissance ;

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private Civility sexe;

    @Column(name = "numero_telephone", unique = true)
    @NotNull
    private String numeroTelephone;

    @Email
    @Column(unique = true)
    private String email;

    @Embedded
    private Adresse adresse ;

    @Transient
    private int age;


    @OneToOne(mappedBy = "patient" , cascade = CascadeType.ALL)
    private ComptePatient compte ;

    @OneToOne(mappedBy = "patient" , cascade = CascadeType.ALL )
    private DossierMedical dossierMedical ;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient" ,  orphanRemoval = true)
    private Set<Operation> lesOperations = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient" ,  cascade = CascadeType.ALL )
    private Set<Consultation> lesConsultations = new HashSet<>() ;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient" ,  cascade = CascadeType.ALL )
    private Set<Message> lesMessages = new HashSet<>() ;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient" ,  cascade = CascadeType.ALL )
    private Set<RendezVous> lesRendezVous = new HashSet<>() ;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient" ,  cascade = CascadeType.ALL )
    private Set<Alerte> lesAlertes = new HashSet<>() ;

     /*------------
    Getters & Setters
    -------------*/

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getNumeroAssurance() {
        return numeroAssurance;
    }

    public void setNumeroAssurance(String numeroAssurance) {
        this.numeroAssurance = numeroAssurance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Civility getSexe() {
        return sexe;
    }

    public void setSexe(Civility sexe) {
        this.sexe = sexe;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ComptePatient getCompte() {
        return compte;
    }

    public void setCompte(ComptePatient compte) {
        this.compte = compte;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }



    public Set<Alerte> getLesAlertes() {
        return lesAlertes;
    }

    public void setLesAlertes(Set<Alerte> lesAlertes) {
        this.lesAlertes = lesAlertes;
    }

    public Set<Operation> getLesOperations() {
        return lesOperations;
    }

    public void setLesOperations(Set<Operation> lesOperations) {
        this.lesOperations = lesOperations;
    }

    public Set<Consultation> getLesConsultations() {
        return lesConsultations;
    }

    public void setLesConsultations(Set<Consultation> lesConsultations) {
        this.lesConsultations = lesConsultations;
    }

    public Set<Message> getLesMessages() {
        return lesMessages;
    }

    public void setLesMessages(Set<Message> lesMessages) {
        this.lesMessages = lesMessages;
    }

    public Set<RendezVous> getLesRendezVous() {
        return lesRendezVous;
    }

    public void setLesRendezVous(Set<RendezVous> lesRendezVous) {
        this.lesRendezVous = lesRendezVous;
    }

    /*------------
    Constructeur
    -------------*/

    public Patient() {
    }

    public Patient(@NotNull String numeroAssurance, @NotNull @Size(min = 3, max = 20) String nom, @NotNull @Size(min = 3, max = 50) String prenom, @NotNull Date dateNaissance, @NotNull @Size(min = 3, max = 20) String lieuNaissance, Civility sexe, @NotNull String numeroTelephone, @Email String email, Adresse adresse, ComptePatient compte, DossierMedical dossierMedical) {
        this.numeroAssurance = numeroAssurance;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.sexe = sexe;
        this.numeroTelephone = numeroTelephone;
        this.email = email;
        this.adresse = adresse;
        this.compte = compte;
        this.dossierMedical = dossierMedical;
    }
}
