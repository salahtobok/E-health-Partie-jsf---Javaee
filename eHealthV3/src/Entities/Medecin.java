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
public class Medecin implements Serializable {

     /*-----------------
      Declaration
     ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedecin;


    @NotNull
    @Column(name = "numero_assurance", unique = true, nullable = false)
    private String numeroAssurance ;

    @NotNull
    @Size(min = 3, max = 20)
    private String nom;

    @NotNull
    @Size(min = 3,max = 20)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance")
    private Date dateNaissance;

    @NotNull
    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @NotNull
    private String grade;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Civility Sexe;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "numero_telephone", unique = true, nullable = false)
    private String numeroTelephone;

    @Embedded
    private Adresse adresse ;

    @OneToOne(mappedBy = "medecin" , cascade = CascadeType.ALL)
    private ComptePersonneMedical comptePersonneMedical ;


    @ManyToOne
    @JoinColumn(name = "idService")
    private Service service;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "medecin",  orphanRemoval = true)
    private Set<Operation> lesOperations = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "medecin" ,  cascade = CascadeType.ALL )
    private Set<Consultation> lesConsultations = new HashSet<>() ;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "medecin" ,  cascade = CascadeType.ALL )
    private Set<Message> lesMessages = new HashSet<>() ;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "medecin" ,  cascade = CascadeType.ALL )
    private Set<RendezVous> lesRendezVous = new HashSet<>() ;

     /*------------
    Getters & Setters
    -------------*/

    public ComptePersonneMedical getComptePersonneMedical() {
        return comptePersonneMedical;
    }

    public void setComptePersonneMedical(ComptePersonneMedical comptePersonneMedical) {
        this.comptePersonneMedical = comptePersonneMedical;
    }

    public String getNumeroAssurance() {
        return numeroAssurance;
    }

    public void setNumeroAssurance(String numeroAssurance) {
        this.numeroAssurance = numeroAssurance;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Civility getSexe() {
        return Sexe;
    }

    public void setSexe(Civility sexe) {
        Sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    /*------------
    Constructeur
    -------------*/

    public Medecin() {
    }

    public Medecin(@NotNull @Size(min = 3, max = 20) String nom, @NotNull @Size(min = 3, max = 20) String prenom, Date dateNaissance, @NotNull String lieuNaissance, @NotNull String grade, @NotNull Civility sexe, @Email String email, String numeroTelephone, Service service) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.grade = grade;
        Sexe = sexe;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.service = service;
    }
}
