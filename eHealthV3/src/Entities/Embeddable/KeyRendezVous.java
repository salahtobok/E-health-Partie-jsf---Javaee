package Entities.Embeddable;

import Entities.Medecin;
import Entities.Patient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class KeyRendezVous implements Serializable {

     /*-----------------
      Declaration
     ---------------*/

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_RendezVous")
    private Date dateRendezVous;

      /*------------
    Getters & Setters
    -------------*/

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }


  /*------------
    Constructeur
    -------------*/

    public KeyRendezVous(@NotNull Date dateRendezVous) {

        this.dateRendezVous = dateRendezVous;
    }

    public KeyRendezVous() {
    }
}
