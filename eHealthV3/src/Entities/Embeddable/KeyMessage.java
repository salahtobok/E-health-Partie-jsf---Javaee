package Entities.Embeddable;

import Entities.Medecin;
import Entities.Patient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class KeyMessage implements Serializable {

     /*-----------------
      Declaration
     ---------------*/


    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_envoie")
    private Date dateEnvoie;

      /*------------
    Getters & Setters
    -------------*/


    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

     /*------------
    Constructeur
    -------------*/

    public KeyMessage() {
    }

    public KeyMessage(@NotNull Date dateEnvoie) {

        this.dateEnvoie = dateEnvoie;
    }
}
