package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service  implements Serializable {


    /*-----------------
      Declaration
     ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idService;

    @NotNull
    @Size(max = 25)
    @Column(name = "nom", unique = true)
    private String nom;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "service",  orphanRemoval = true)
    private Set<Medecin> lesMedecins = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "service",  orphanRemoval = true)
    private Set<Operation> lesOperations = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "service",  orphanRemoval = true)
    private Set<Consultation> lesConsultations=new HashSet<>();


     /*------------
    Getters & Setters
    -------------*/

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Medecin> getLesMedecins() {
        return lesMedecins;
    }

    public void setLesMedecins(Set<Medecin> lesMedecins) {
        this.lesMedecins = lesMedecins;
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

    /*------------
    Constructeur
    -------------*/

    public Service() {
    }

    public Service(@NotNull @Size(max = 25) String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
