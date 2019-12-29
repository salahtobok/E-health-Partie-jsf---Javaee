package Entities;

import Enumeration.EtatCompte;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class ComptePersonneMedical implements Serializable {


    /*-----------------
     Declaration
    ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComptePersonneMedical ;


    @Column(name = "login", unique = true)
    @NotNull
    private String login;


    @Column(name = "mot_de_passe")
    @Size(min = 8 , max = 20)
    @NotNull
    private String motDePasse;




    @NotNull
    @Enumerated(EnumType.STRING)
    private EtatCompte etatCompte;

    @OneToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin ;


     /*------------
    Getters & Setters
    -------------*/

    public int getIdComptePersonneMedical() {
        return idComptePersonneMedical;
    }

    public void setIdComptePersonneMedical(int idComptePersonneMedical) {
        this.idComptePersonneMedical = idComptePersonneMedical;
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

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
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



    public ComptePersonneMedical() {
    }

}
