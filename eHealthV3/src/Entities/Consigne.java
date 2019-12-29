package Entities;

import Enumeration.Periode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consigne implements Serializable {

     /*-----------------
      Declaration
     ---------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsigne;

    @NotNull
    private  String contenu;

    @NotNull
    @Enumerated
    private Periode periode ;


    @Column(name = "date_consigne")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateConsigne;

    @ManyToOne
    @JoinColumn(name = "idOperation")
    private Operation operation ;

     /*------------
    Getters & Setters
    -------------*/

    public int getIdConsigne() {
        return idConsigne;
    }

    public void setIdConsigne(int idConsigne) {
        this.idConsigne = idConsigne;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateConsigne() {
        return dateConsigne;
    }

    public void setDateConsigne(Date dateConsigne) {
        this.dateConsigne = dateConsigne;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    /*------------
    Constructeur
    -------------*/

    public Consigne() {
    }

    public Consigne(@NotNull String contenu, @NotNull Periode periode, Date dateConsigne, Operation operation) {
        this.contenu = contenu;
        this.periode = periode;
        this.dateConsigne = dateConsigne;
        this.operation = operation;
    }
}

