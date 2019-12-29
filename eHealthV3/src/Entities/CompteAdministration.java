package Entities;

import Enumeration.EtatCompte;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class CompteAdministration implements Serializable {


    /*-----------------
     Declaration
    ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDPersonneMedical ;


    @Column(name = "login", unique = true)
    @NotNull
    private String login;


    @Column(name = "mot_de_passe")
    @Size(min = 8 , max = 20)
    @NotNull
    private String motDePasse;



    @OneToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin ;



     /*------------
    Getters & Setters
    -------------*/

    public int getIdDPersonneMedical() {
        return idDPersonneMedical;
    }

    public void setIdDPersonneMedical(int idDPersonneMedical) {
        this.idDPersonneMedical = idDPersonneMedical;
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


/*------------
    Constructeur
    -------------*/

    public CompteAdministration(String login, @Size(min = 8, max = 20) String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public CompteAdministration() {
    }

}
