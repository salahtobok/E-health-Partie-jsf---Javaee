package Entities.Embeddable;

import Entities.Medecin;
import Entities.Patient;
import Entities.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class KeyConsultation implements Serializable {

     /*-----------------
      Declaration
     ---------------*/


    @Temporal(TemporalType.TIMESTAMP)
    private Date dateConsultation;

     /*------------
    Getters & Setters
    -------------*/



    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

   /*------------
    Constructeur
    -------------*/

    public KeyConsultation() {
    }

    public KeyConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }
}
