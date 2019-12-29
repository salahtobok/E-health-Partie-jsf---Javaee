package Entities.Embeddable;

import Entities.Patient;
import Entities.ServiceUrgence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class KeyAlerte implements Serializable {

    /*-----------------
      Declaration
     ---------------*/

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAlerte;

    /*------------
    Getters & Setters
    -------------*/



    public Date getDateAlerte() {
        return dateAlerte;
    }

    public void setDateAlerte(Date dateAlerte) {
        this.dateAlerte = dateAlerte;
    }


     /*------------
    Constructeur
    -------------*/

    public KeyAlerte(Date dateAlerte) {
        this.dateAlerte = dateAlerte;
    }

    public KeyAlerte() {
    }
}
