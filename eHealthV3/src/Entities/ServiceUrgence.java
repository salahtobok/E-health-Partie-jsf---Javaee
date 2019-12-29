package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceUrgence implements Serializable {


    /*-----------------
    Declaration
   ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiceUrgence;

    @Column(nullable = false,length = 20)
    private String nom ;

    @Column(unique = true)
    private String telephone;

    @OneToMany(mappedBy = "serviceUrgence" ,  cascade = CascadeType.ALL )
    private Set<Alerte> lesAlertes = new HashSet<>() ;


    /*------------
    Getters & Setters
    -------------*/

    public int getIdServiceUrgence() {
        return idServiceUrgence;
    }

    public void setIdServiceUrgence(int idServiceUrgence) {
        this.idServiceUrgence = idServiceUrgence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Alerte> getLesAlertes() {
        return lesAlertes;
    }

    public void setLesAlertes(Set<Alerte> lesAlertes) {
        this.lesAlertes = lesAlertes;
    }

    /*------------
   Constructeur
   -------------*/

    public ServiceUrgence() {
    }

    public ServiceUrgence(String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }
}
