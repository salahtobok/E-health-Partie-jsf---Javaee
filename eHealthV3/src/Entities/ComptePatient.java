package Entities;

import Enumeration.EtatCompte;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class ComptePatient implements Serializable {


    /*-----------------
     Declaration
    ---------------*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;

    @Column(name = "login", unique = true)
    @NotNull
    private String login;


    @Column(name = "mot_de_passe")
    @Size(min = 8 , max = 20)
    @NotNull
    private String motDePasse;

    @Column(name = "code_activation")
    @Size(min = 4 , max = 8)
    @NotNull
    private String code_activation;



    @NotNull
    @Enumerated(EnumType.STRING)
    private EtatCompte etatCompte;

    @OneToOne
    @JoinColumn(name = "idPatient")
    private Patient patient ;


     /*------------
    Getters & Setters
    -------------*/


    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public EtatCompte getEtatCompte() {
        return etatCompte;

    }

    public void setEtatCompte(EtatCompte etatCompte) {
        this.etatCompte = etatCompte;
    }



     /*------------
    Constructeur
    -------------*/

    public ComptePatient(String login, @Size(min = 8, max = 20) String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.etatCompte = EtatCompte.NONACTIF;
    }

    public ComptePatient() {
    }

    public String getCode_activation() {
        return code_activation;
    }

    public void setCode_activation(String code_activation) {
        this.code_activation = code_activation;
    }
}
