package Entities.Embeddable;

import Entities.Medecin;
import Entities.Patient;
import Entities.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class KeyOperation implements Serializable {

     /*-----------------
      Declaration
     ---------------*/



    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;

     /*------------
    Getters & Setters
    -------------*/


    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

   /*------------
    Constructeur
    -------------*/

    public KeyOperation() {
    }

//    public KeyOperation(Service service, Patient patient, Medecin medecin, Date dateOperation) {
//        this.service = service;
//        this.patient = patient;
//        this.medecin = medecin;
//        this.dateOperation = dateOperation;
//    }


    public KeyOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }
}
